package com.example.sofabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "civil_similar_case")
public class CivilSimilarCase {
    @Id
    public String uniqid;
    public String casetype;
    public String procedure;
    public String referencetype;
    public String courtlevel;
    public String court;
    public String province;
    public String casecause;
    // JSON string of array
    public String casecausefull;

    // JSON string of array
    public String multicasecause;
    public String judgedate;
    public String judgeyear;
    // JSON string of array
    public String features;
    public String title;

    // JSON string of array
    public String paragraphs;
}
