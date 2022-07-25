package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.Cat;
import com.ivanshilyaev.kontur.entity.FeedStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface FeedStatisticsRepository extends JpaRepository<FeedStatistics, Long> {

    @Query(value = "select max(feed_time) from feed_statistics where cat_id = ?", nativeQuery = true)
    LocalDateTime getLastFeedTime(Long catId);

    List<FeedStatistics> findAllByCat(Cat cat);

    @Query(value = "select count(distinct cat_id) from feed_statistics " +
        "where volunteer_id = ? and feed_time > (now() - cast ('1 week' as interval));", nativeQuery = true)
    Integer catsFedInLastWeek(Long volunteerId);
}
