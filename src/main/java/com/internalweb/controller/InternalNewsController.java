package com.internalweb.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internalweb.model.InternalNews;
import com.internalweb.repository.InternalNewsRepository;
import com.internalweb.service.InternalNewsService;

@RestController
@RequestMapping("/api/internal-news")
public class InternalNewsController {

    @Autowired
    private InternalNewsRepository internalNewsRepository;
    @Autowired
    private InternalNewsService internalNewsService;
    
    @GetMapping
    public Page<InternalNews> getNotificationsByPage(@RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "19") int size) {
        PageRequest pageable = PageRequest.of(page - 1, size);

        return internalNewsRepository.findAll(pageable);
    }
    
    
    
    @GetMapping("/{newsId}")
    public ResponseEntity<InternalNews> getNewsById(@PathVariable Long newsId) {
        Optional<InternalNews> news = internalNewsRepository.findById(newsId);
        return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public List<InternalNews> searchStaff(@RequestParam String query) {
        return internalNewsService.findByTitleContaining(query);
    }
    
    
    
    @PostMapping("/create")
    public ResponseEntity<String> createNews(@RequestBody InternalNews news) {
        
            internalNewsService.save(news);
            return new ResponseEntity<>("Một thông báo đã được tạo thành công!", HttpStatus.CREATED);
    }
    
    @PutMapping("/{newsId}")
    public ResponseEntity<String> updateNews(@PathVariable Long newsId, @RequestBody InternalNews updatedNews) {
        Optional<InternalNews> newsOptional = internalNewsRepository.findById(newsId);
        if (newsOptional.isPresent()) {
            InternalNews existingNews = newsOptional.get();
            internalNewsService.save(existingNews);
            return ResponseEntity.ok("Thông báo đã được cập nhật thành công!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{newsId}")
    public ResponseEntity<String> partialUpdateNews(@PathVariable Long newsId, @RequestBody Map<String, Object> updates) {
        Optional<InternalNews> newsOptional = internalNewsRepository.findById(newsId);
        if (newsOptional.isPresent()) {
            InternalNews existingNews = newsOptional.get();
            
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                
                switch (key) {
                    case "title":
                        existingNews.setTitle((String) value);
                        break;
                    case "content":
                        existingNews.setContent((String) value);
                        break;
                    default:
                        break;
                }
            }
            
            internalNewsService.save(existingNews);
            
            if (!updates.isEmpty()) {
                return ResponseEntity.ok("Thông báo đã được cập nhật một phần thành công!");
            } else {
                return ResponseEntity.ok("Không có cập nhật nào được thực hiện.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{newsId}")
    public ResponseEntity<String> deleteNews(@PathVariable Long newsId) {
        Optional<InternalNews> newsOptional = internalNewsRepository.findById(newsId);
        if (newsOptional.isPresent()) {
            internalNewsRepository.deleteById(newsId);
            return ResponseEntity.ok("Thông báo đã được xóa thành công!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}


