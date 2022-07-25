package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.CatVolunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface CatVolunteerRepository extends JpaRepository<CatVolunteer, Long> {

    @Query(value = "select max(feed_time) " +
        "from cat_volunteer " +
        "where cat_id = ?", nativeQuery = true)
    LocalDateTime getLastFeedTime(Long catId);
}
