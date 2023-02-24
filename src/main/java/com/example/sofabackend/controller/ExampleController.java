package com.example.sofabackend.controller;


import com.example.sofabackend.domain.Example;
import com.example.sofabackend.dto.ExampleSimpleDto;
import com.example.sofabackend.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping("/{id}")
    public Example findById(@PathVariable("id") String id) {
        return exampleService.findById(id);
    }

    @GetMapping
    public List<ExampleSimpleDto> searchExample(
            @RequestParam(name = "type") String type,
            @RequestParam(name = "number", required = false) Integer number,
            @RequestParam(name = "keyword", required = false) String keyword) {
        if (number != null) {
            return exampleService.findByTypeAndNumber(type, number);
        }
        return exampleService.findByTypeAndKeyword(type, keyword);
    }
}
