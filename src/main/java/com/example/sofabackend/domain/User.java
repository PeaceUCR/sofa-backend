package com.example.sofabackend.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "user")
public class User {
    @Id
    private String openId;
    private Integer collectionLimit;
    private Integer score;
    private String nickname;
    private String avatarUrl;
    private LocalDateTime lastTimeLogin;
}
