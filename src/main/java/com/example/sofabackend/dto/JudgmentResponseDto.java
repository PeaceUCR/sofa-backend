package com.example.sofabackend.dto;

import com.example.sofabackend.domain.Judgment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgmentResponseDto {
    private String id;
    private String rowKey;
    private String cause;
    private String title;
    private String courtName;
    private String caseNumber;
    private String opinion;
    private String date;
    private String civilLaws;
    private String criminalLaws;
    private String type;

    private List<String> tags;

    public static JudgmentResponseDto from(Judgment judgment) {
        JudgmentResponseDto dto = new JudgmentResponseDto();
        BeanUtils.copyProperties(judgment, dto);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String[] tags = mapper.readValue(judgment.getTags().toString(), String[].class);
            dto.setTags(Arrays.asList(tags));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }
}
