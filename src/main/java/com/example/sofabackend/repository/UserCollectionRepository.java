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
    List<UserCollection> findAllByOpenid(String openid);

    boolean existsByCollectionidAndOpenid(String collectionid, String openid);

    @Modifying
    @Query(value = "delete from user_collections where collectionid = :collectionid and openid = :openid",
            nativeQuery = true)
    void deleteByCollectionidAndOpenid(@Param("collectionid") String collectionid, @Param("openid") String openid);
}
