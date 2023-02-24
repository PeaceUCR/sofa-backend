package com.example.sofabackend.repository;

import com.example.sofabackend.domain.Example;
import com.example.sofabackend.dto.ExampleSimpleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExampleRepository extends JpaRepository<Example, String> {

    //https://stackoverflow.com/questions/1341104/parameter-in-like-clause-jpql
    @Query(value = "select e.id, e.number, e.title, e.type from example e where e.type = :type and e.text like %:keyword%", nativeQuery = true)
    List<ExampleSimpleDto> findByTypeAndText(@Param("type")String type, @Param("keyword")String keyword);


    @Query(value = "select e.id, e.number, e.title, e.type from example e where e.type = :type and e.number = :number", nativeQuery = true)
    List<ExampleSimpleDto> findByTypeAndNumber(@Param("type")String type, @Param("number")Integer number);
}
