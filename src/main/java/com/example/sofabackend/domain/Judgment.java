package com.example.sofabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "judgment")
public class Judgment {
    @Id
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

    // TODO is it working?
    // https://stackoverflow.com/questions/67848833/getting-jsonarray-from-mysql-database-using-spring-boot-jpa
    @Lob
    @Column
    @Convert(converter = JSONArrayConverter.class)
    private JSONArray tags;
}
