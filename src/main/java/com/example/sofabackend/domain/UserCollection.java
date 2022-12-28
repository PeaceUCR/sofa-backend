package com.example.sofabackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "user_collections")
public class UserCollection {
    @Id
    private String id;
    private String openId;
    private String collectionId;
    private String type;
    private String title;
    private LocalDateTime time;
}
