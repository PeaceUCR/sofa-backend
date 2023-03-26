package com.example.sofabackend.dto;

import lombok.Data;

import java.util.List;

@Data
public class JudgmentSearchRequestDto {
    private String searchValue;
    private String cause;

    private String location;
    private String civilLaws;

    private List<String> tags;

    private Integer page = 0;
    private Integer size = 20;

}
