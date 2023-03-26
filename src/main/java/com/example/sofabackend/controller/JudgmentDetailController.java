package com.example.sofabackend.controller;


import com.example.sofabackend.domain.JudgmentDetail;
import com.example.sofabackend.repository.JudgmentDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/judgment-detail")
@RequiredArgsConstructor
public class JudgmentDetailController {

    private final JudgmentDetailRepository judgmentDetailRepository;

    @GetMapping("/{rowKey}")
    public JudgmentDetail findByRowKey(@PathVariable("rowKey") String rowKey) {
        return judgmentDetailRepository.findByRowKey(rowKey);
    }

}
