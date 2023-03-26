package com.example.sofabackend.repository;

import com.example.sofabackend.domain.JudgmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgmentDetailRepository extends JpaRepository<JudgmentDetail, String> {
    JudgmentDetail findByRowKey(String rowKey);
}
