package com.internalweb.model;

public class UserAvatarResponse {

	  private Long userId;
      private String avatarUrl;

      public UserAvatarResponse(Long userId, String avatarUrl) {
          this.userId = userId;
          this.avatarUrl = avatarUrl;
      }

      public Long getUserId() {
          return userId;
      }

      public String getAvatarUrl() {
          return avatarUrl;
      }
}
