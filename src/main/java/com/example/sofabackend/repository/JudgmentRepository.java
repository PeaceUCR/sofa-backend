package com.example.sofabackend.repository;

import com.example.sofabackend.domain.Judgment;
import com.example.sofabackend.dto.JudgmentSearchRequestDto;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public interface JudgmentRepository extends JpaRepository<Judgment, String>, JpaSpecificationExecutor<Judgment> {

    default Page<Judgment> findAll(JudgmentSearchRequestDto requestDto) {
        PageRequest pageRequest = PageRequest.of(
            requestDto.getPage(),
            requestDto.getSize(),
            Sort.by(Sort.Direction.DESC, "date")
        );

        return findAll((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Strings.isNotEmpty(requestDto.getSearchValue())) {
                predicates.add(
                    cb.or(
                        cb.like(root.get("title"), "%" + requestDto.getSearchValue() + "%"),
                        cb.like(root.get("opinion"), "%" + requestDto.getSearchValue() + "%")
                    )
                );
            }
            if (Strings.isNotEmpty(requestDto.getCause())) {
                predicates.add(cb.equal(root.get("cause"), requestDto.getCause()));
            }
            if (!CollectionUtils.isEmpty(requestDto.getTags())) {
                requestDto.getTags().stream().forEach(tag -> {
                    predicates.add(cb.equal(
                        cb.function(
                            "JSON_CONTAINS",
                            String.class,
                            root.get("tags"),
                            cb.literal("\"" + tag + "\"")
                        ), "1"));
                });
            }
            return predicates.stream().reduce(cb.conjunction(), cb::and);
        }, pageRequest);

    }

    Judgment findByRowKey(String rowKey);
}
