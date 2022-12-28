package com.example.sofabackend.controller;

import com.example.sofabackend.domain.User;
import com.example.sofabackend.dto.UserRequestDto;
import com.example.sofabackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(CREATED)
    public User addUser(@RequestBody UserRequestDto requestDto) {
        return userService.addUser(requestDto);
    }

    @GetMapping("/{id}")
    public User findByOpenId(@PathVariable String id) {
        return userService.findByOpenId(id);
    }

    @PutMapping("/record/{id}")
    public User record(@PathVariable String openId) {
        return userService.record(openId);
    }

    @PutMapping("/add/{id}")
    public User add(@PathVariable String openId) {
        return userService.addScore(openId);
    }

}
