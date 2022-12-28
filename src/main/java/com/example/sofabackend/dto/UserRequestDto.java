package com.example.sofabackend.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String openId;
    private String nickname;
    private String avatarUrl;
}
