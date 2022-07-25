package com.ivanshilyaev.kontur.controller;

import com.ivanshilyaev.kontur.entity.FeedStatistics;
import com.ivanshilyaev.kontur.repository.CatRepository;
import com.ivanshilyaev.kontur.repository.FeedStatisticsRepository;
import com.ivanshilyaev.kontur.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/volunteers")
@RequiredArgsConstructor
public class VolunteerController {

    private final CatRepository catRepository;

    private final VolunteerRepository volunteerRepository;

    private final FeedStatisticsRepository feedStatisticsRepository;

    @PostMapping("/{volunteerId}/feed/{catId}")
    public void feed(@PathVariable Long volunteerId, @PathVariable Long catId) {
        if (feedStatisticsRepository.getLastFeedTime(catId)
            .isBefore(LocalDateTime.now().minus(4, ChronoUnit.HOURS))) {
            FeedStatistics feedStatistics = new FeedStatistics();
            feedStatistics.setCat(catRepository.findById(catId).orElse(null));
            feedStatistics.setVolunteer(volunteerRepository.findById(volunteerId).orElse(null));
            feedStatistics.setFeedTime(LocalDateTime.now());
            feedStatisticsRepository.save(feedStatistics);
        }
    }
}
