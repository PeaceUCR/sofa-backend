package com.example.sofabackend.dto;

import lombok.Data;

@Data
public class UserCollectionRequestDto {
    private String openId;
    private String collectionId;
    private String type;
    private String title;
}
