package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.FeedStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface FeedStatisticsRepository extends JpaRepository<FeedStatistics, Long> {

    @Query(value = "select max(feed_time) from feed_statistics where cat_id = ?", nativeQuery = true)
    LocalDateTime getLastFeedTime(Long catId);
}