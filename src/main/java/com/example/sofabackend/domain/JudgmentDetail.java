package com.example.sofabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "judgment_detail")
public class JudgmentDetail {

    @Id
    private String rowKey;
    private String textHead;
    private String textPartner;
    private String textMain;
    private String textDecide;
    private String textJudge;

}
