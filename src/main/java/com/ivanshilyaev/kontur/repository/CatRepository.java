package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query(value = "select * from cat join cat_volunteer on cat.id = cat_volunteer.cat_id where" +
        " cat_volunteer.feed_time < (now() - cast ('4 hours' as interval))",
    nativeQuery = true)
    List<Cat> findAllHungryCats();
}
