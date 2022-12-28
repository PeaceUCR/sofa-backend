package com.example.sofabackend.service;

import com.example.sofabackend.domain.User;
import com.example.sofabackend.domain.UserCollection;
import com.example.sofabackend.dto.UserCollectionRequestDto;
import com.example.sofabackend.repository.UserCollectionRepository;
import com.example.sofabackend.repository.UserRepository;
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
    private final UserRepository userRepository;

    public UserCollection collect(UserCollectionRequestDto requestDto) {
        User user = userRepository.findByOpenId(requestDto.getOpenId());
        if (user != null) {
            List<UserCollection> collections = getCollections(requestDto.getOpenId());
            Integer limit = user.getCollectionLimit() == null ? 20 : user.getCollectionLimit();
            if (collections.size() < limit) {
                UserCollection userCollection = UserCollection.builder()
                        .id(UUID.randomUUID().toString())
                        .openId(requestDto.getOpenId())
                        .collectionId(requestDto.getCollectionId())
                        .title(requestDto.getTitle())
                        .type(requestDto.getType())
                        .time(LocalDateTime.now())
                        .build();
                return userCollectionRepository.save(userCollection);
            }
        }
        throw new IllegalArgumentException("Collection limit exceed");
    }

    public List<UserCollection> getCollections(String openId) {
        return userCollectionRepository.findAllByOpenId(openId);
    }

    @Transactional
    public void deleteCollection(UserCollectionRequestDto requestDto) {
        userCollectionRepository
                .deleteByCollectionIdAndOpenId(requestDto.getCollectionId(), requestDto.getOpenId());
    }

    public boolean isCollected(String collectionId, String openId) {
        return userCollectionRepository
                .existsByCollectionIdAndOpenId(collectionId, openId);
    }
}
