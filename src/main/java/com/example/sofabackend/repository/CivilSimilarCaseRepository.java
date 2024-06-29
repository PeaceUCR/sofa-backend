package com.example.sofabackend.repository;

import com.example.sofabackend.domain.CivilSimilarCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CivilSimilarCaseRepository  extends JpaRepository<CivilSimilarCase, String> {
    CivilSimilarCase findByUniqid(String uniqid);
    List<CivilSimilarCase> findAllByCasecause(String casecause);
}
