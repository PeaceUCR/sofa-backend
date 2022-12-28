package com.example.sofabackend.repository;

import com.example.sofabackend.domain.UserCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCollectionRepository extends JpaRepository<UserCollection, String> {
    List<UserCollection> findAllByOpenId(String openId);

    boolean existsByCollectionIdAndOpenId(String collectionId, String openId);

    @Modifying
    @Query(value = "delete from user_collections where collectionId = :collectionId and openId = :openId",
            nativeQuery = true)
    void deleteByCollectionIdAndOpenId(@Param("collectionId") String collectionId, @Param("openId") String openId);
}
