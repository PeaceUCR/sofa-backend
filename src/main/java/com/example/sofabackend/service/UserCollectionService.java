package com.example.sofabackend.service;

import com.example.sofabackend.domain.UserCollection;
import com.example.sofabackend.dto.UserCollectionRequestDto;
import com.example.sofabackend.repository.UserCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserCollectionService {
    private final UserCollectionRepository userCollectionRepository;

    public UserCollection collect(UserCollectionRequestDto requestDto) {
        UserCollection userCollection = UserCollection.builder()
                .id(UUID.randomUUID().toString())
                .openid(requestDto.getOpenid())
                .collectionid(requestDto.getCollectionid())
                .title(requestDto.getTitle())
                .type(requestDto.getType())
                .time(LocalDateTime.now())
                .build();
        return userCollectionRepository.save(userCollection);
    }

    public List<UserCollection> getCollections(String openid) {
        return userCollectionRepository.findAllByOpenid(openid);
    }

    @Transactional
    public void deleteCollection(UserCollectionRequestDto requestDto) {
        userCollectionRepository
                .deleteByCollectionidAndOpenid(requestDto.getCollectionid(), requestDto.getOpenid());
    }

    public boolean isCollected(String collectionid, String openid) {
        return userCollectionRepository
                .existsByCollectionidAndOpenid(collectionid, openid);
    }
}
