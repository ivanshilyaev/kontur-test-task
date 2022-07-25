package com.ivanshilyaev.kontur.service;

import com.ivanshilyaev.kontur.entity.FeedStatistics;
import com.ivanshilyaev.kontur.entity.Volunteer;
import com.ivanshilyaev.kontur.repository.CatRepository;
import com.ivanshilyaev.kontur.repository.FeedStatisticsRepository;
import com.ivanshilyaev.kontur.repository.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VolunteerService {

    private final CatRepository catRepository;

    private final VolunteerRepository volunteerRepository;

    private final FeedStatisticsRepository feedStatisticsRepository;

    public List<Volunteer> findAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public void feedCat(Long volunteerId, Long catId) {
        LocalDateTime lastFeedTime = feedStatisticsRepository.getLastFeedTime(catId);
        boolean isHungry = lastFeedTime == null ||
            lastFeedTime.isBefore(LocalDateTime.now().minus(4, ChronoUnit.HOURS));
        if (isHungry) {
            FeedStatistics feedStatistics = new FeedStatistics();
            feedStatistics.setCat(catRepository.findById(catId).orElse(null));
            feedStatistics.setVolunteer(volunteerRepository.findById(volunteerId).orElse(null));
            feedStatistics.setFeedTime(LocalDateTime.now());
            feedStatisticsRepository.save(feedStatistics);
        }
    }

    public Integer catsFedInLastWeek(Long id) {
        return feedStatisticsRepository.catsFedInLastWeek(id);
    }
}
