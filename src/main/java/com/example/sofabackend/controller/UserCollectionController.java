package com.example.sofabackend.controller;

import com.example.sofabackend.domain.UserCollection;
import com.example.sofabackend.dto.UserCollectionRequestDto;
import com.example.sofabackend.service.UserCollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/user-collection")
@RequiredArgsConstructor
public class UserCollectionController {

    private final UserCollectionService userCollectionService;

    @PostMapping
    @ResponseStatus(CREATED)
    public UserCollection collect(
            @RequestBody UserCollectionRequestDto dto) {
        return userCollectionService.collect(dto);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void delete(
            @RequestBody UserCollectionRequestDto dto) {
        userCollectionService.deleteCollection(dto);
    }

    @GetMapping("/list")
    public List<UserCollection> getList(@RequestParam String openId) {
        return userCollectionService.getCollections(openId);
    }

    @GetMapping
    public boolean isCollected(
            @RequestParam String collectionId, @RequestParam String openId) {
        return userCollectionService.isCollected(collectionId, openId);
    }
}
