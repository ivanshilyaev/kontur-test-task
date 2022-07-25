package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query(value = "select * from cats join feed_statistics on cats.id = feed_statistics.cat_id " +
        "where feed_statistics.feed_time < (now() - cast ('4 hours' as interval))", nativeQuery = true)
    List<Cat> findHungryCats();
}
