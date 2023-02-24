package com.example.sofabackend.service;

import com.example.sofabackend.domain.Example;
import com.example.sofabackend.dto.ExampleSimpleDto;
import com.example.sofabackend.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final ExampleRepository exampleRepository;

    public Example findById(String id) {
        return exampleRepository.findById(id).orElse(null);
    }

    public List<ExampleSimpleDto> findByTypeAndKeyword(String type, String keyword) {
        return exampleRepository.findByTypeAndText(type, keyword);
    }

    public List<ExampleSimpleDto> findByTypeAndNumber(String type, Integer number) {
        return exampleRepository.findByTypeAndNumber(type, number);
    }
}
