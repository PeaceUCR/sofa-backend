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

    @GetMapping("/{openId}")
    public User findByOpenId(@PathVariable("openId") String openId) {
        return userService.findByOpenId(openId);
    }

    @PutMapping("/record/{openId}")
    public User record(@PathVariable("openId") String openId) {
        return userService.record(openId);
    }

    @PutMapping("/add/{openId}")
    public User add(@PathVariable("openId") String openId) {
        return userService.addScore(openId);
    }

    @PutMapping("/checkBeforeCopy/{openId}")
    public User checkBeforeCopy(@PathVariable("openId") String openId) {
        return userService.checkBeforeCopy(openId);
    }

}
