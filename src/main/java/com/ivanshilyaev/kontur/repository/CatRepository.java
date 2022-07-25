package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query(value = "select * from cats c join feed_statistics on c.id = feed_statistics.cat_id " +
        "where feed_statistics.feed_time = (select max(feed_time) from feed_statistics where cat_id = c.id) " +
        "and feed_statistics.feed_time < (now() - cast ('4 hours' as interval))", nativeQuery = true)
    // edge case when there is no statistics at all, hence all cats are hungry
    List<Cat> findHungryCats();
}
