package com.example.sofabackend.controller;


import com.example.sofabackend.domain.CivilSimilarCase;
import com.example.sofabackend.repository.CivilSimilarCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/civil-similar-case")
@RequiredArgsConstructor
public class CivilSimilarCaseController {

    private final CivilSimilarCaseRepository civilSimilarCaseRepository;
    @GetMapping("/{uniqid}")
    public CivilSimilarCase findByRowKey(@PathVariable("uniqid") String uniqid) {
        return civilSimilarCaseRepository.findByUniqid(uniqid);
    }

    @GetMapping
    public List<CivilSimilarCase> findAllByCasecause(@RequestParam(name = "casecause") String casecause) {
        return civilSimilarCaseRepository.findAllByCasecause(casecause);
    }
}
