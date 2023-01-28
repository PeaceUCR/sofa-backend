package com.example.sofabackend.service;

import com.example.sofabackend.domain.User;
import com.example.sofabackend.dto.UserRequestDto;
import com.example.sofabackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(UserRequestDto requestDto) {
        User user = User.builder()
                .openId(requestDto.getOpenId())
                .nickname(requestDto.getNickname())
                .avatarUrl(requestDto.getAvatarUrl())
                .collectionLimit(20)
                .score(3)
                .lastTimeLogin(LocalDateTime.now())
                .build();
        return userRepository.save(user);
    }

    public User findByOpenId(String openid) {
        return userRepository.findByOpenId(openid);
    }

    public User record(String openid) {
        User user = userRepository.findByOpenId(openid);
        user.setLastTimeLogin(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User addScore(String openid) {
        User user = userRepository.findByOpenId(openid);
        user.setScore(user.getScore() + 1);
        return userRepository.save(user);
    }

    public User checkBeforeCopy(String openid) {
        User user = userRepository.findByOpenId(openid);
        if (user.getScore() < 1) {
            throw new IllegalArgumentException("No score to copy");
        }
        user.setScore(user.getScore() - 1);
        return userRepository.save(user);
    }
}
