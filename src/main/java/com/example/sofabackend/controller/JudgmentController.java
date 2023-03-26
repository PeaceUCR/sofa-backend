package com.example.sofabackend.controller;

import com.example.sofabackend.domain.Judgment;
import com.example.sofabackend.dto.JudgmentResponseDto;
import com.example.sofabackend.dto.JudgmentSearchRequestDto;
import com.example.sofabackend.repository.JudgmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/judgment")
@RequiredArgsConstructor
public class JudgmentController {

    private final JudgmentRepository judgmentRepository;
    @PostMapping("/list")
    public List<JudgmentResponseDto> getList(@RequestBody JudgmentSearchRequestDto requestDto) {
        Page<Judgment> judgments = judgmentRepository.findAll(requestDto);
        return judgments.getContent().stream().map(JudgmentResponseDto::from).collect(Collectors.toList());
    }
}
