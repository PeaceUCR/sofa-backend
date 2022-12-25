package com.example.sofabackend.dto;

import lombok.Data;

@Data
public class UserCollectionRequestDto {
    private String openid;
    private String collectionid;
    private String type;
    private String title;
}
