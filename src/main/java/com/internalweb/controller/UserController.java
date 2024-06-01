package com.internalweb.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.internalweb.model.User;
import com.internalweb.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {

 @Autowired
 private UserService userService;
 
 @GetMapping("/users/staff/search")
 public List<User> searchStaff(@RequestParam String query) {
     return userService.searchStaff(query);
 }
 
 @GetMapping("/users/staff")
 public List<User> getAllStaff(){
	 return userService.findAllByRole("Staff");
 }
 
 @DeleteMapping("/users/{userId}")
 public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
     User existingUser = userService.findById(userId);
     if (existingUser == null) {
         return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.NOT_FOUND);
     }

     userService.deleteById(existingUser.getUserId());

     return new ResponseEntity<>("Người dùng đã được xóa thành công", HttpStatus.OK);
 }
 
 @PostMapping("/users/create")
 public ResponseEntity<String> createUser(@RequestBody User newUser) {
     if(newUser == null ) {
         return new ResponseEntity<>("Dữ liệu người dùng không hợp lệ", HttpStatus.BAD_REQUEST);
     }

     User existingUser = userService.findByUsername(newUser.getUsername());
     if (existingUser != null) {
         return new ResponseEntity<>("Username đã tồn tại", HttpStatus.CONFLICT);
     }

     userService.save(newUser);

     return new ResponseEntity<>("Người dùng đã được tạo thành công", HttpStatus.CREATED);
 }



 @PutMapping("/users/{userId}")
 public ResponseEntity<String> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
     User existingUser = userService.findById(userId);
     if (existingUser == null) {
         return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.NOT_FOUND);
     }

     existingUser.setFullName(updatedUser.getFullName());
     existingUser.setPhone(updatedUser.getPhone());
     existingUser.setEmail(updatedUser.getEmail());
     existingUser.setPosition(updatedUser.getPosition());
     existingUser.setDepartment(updatedUser.getDepartment());
     existingUser.setAvatar(updatedUser.getAvatar());

     userService.save(existingUser);

     return new ResponseEntity<>("Thông tin cá nhân đã được cập nhật thành công", HttpStatus.OK);
 }
 
 @PatchMapping("/users/{userId}")
 public ResponseEntity<String> patchUser(@PathVariable Long userId, @RequestBody Map<String, Object> updates) {
     User existingUser = userService.findById(userId);
     if (existingUser == null) {
         return new ResponseEntity<>("Người dùng không tồn tại", HttpStatus.NOT_FOUND);
     }
     updates.forEach((key, value) -> {
         switch (key) {
             case "fullName":
                 existingUser.setFullName((String) value);
                 break;
             case "phone":
                 existingUser.setPhone((String) value);
                 break;
             case "email":
                 existingUser.setEmail((String) value);
                 break;
             case "position":
                 existingUser.setPosition((String) value);
                 break;
             case "department":
                 existingUser.setDepartment((String) value);
                 break;
             case "avatar":
                 existingUser.setAvatar((String) value);
                 break;
         }
     });

     userService.save(existingUser);

     return new ResponseEntity<>("Thông tin cá nhân đã được cập nhật thành công", HttpStatus.OK);
 }
 
 
 @PostMapping("/users/update-avatar")
 public ResponseEntity<String> updateAvatar(@RequestParam("avatar") MultipartFile avatarFile, HttpSession session) {
     User loggedInUser = (User) session.getAttribute("loggedInUser");
     if (loggedInUser == null) {
         return new ResponseEntity<>("Người dùng không được xác thực", HttpStatus.UNAUTHORIZED);
     }

     try {

         String avatarPath = saveAvatarFile(avatarFile);
         loggedInUser.setAvatar(avatarPath);

         userService.save(loggedInUser);
         session.setAttribute("loggedInUser", loggedInUser);

         return new ResponseEntity<>("Avatar đã được cập nhật thành công", HttpStatus.OK);
     } catch (IOException e) {
         return new ResponseEntity<>("Lỗi khi lưu tệp avatar", HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }

 private String saveAvatarFile(MultipartFile file) throws IOException {

     String uploadsDir = "./images/";
     String originalFilename = file.getOriginalFilename();
     String filePath = uploadsDir + originalFilename;

     java.nio.file.Path path = java.nio.file.Paths.get(filePath);
     java.nio.file.Files.createDirectories(path.getParent());
     java.nio.file.Files.write(path, file.getBytes());

     return filePath;
 }
 

 
 


}

