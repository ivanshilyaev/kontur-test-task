package com.ivanshilyaev.kontur.service;

import com.ivanshilyaev.kontur.dto.CatStatisticsDto;
import com.ivanshilyaev.kontur.entity.Cat;
import com.ivanshilyaev.kontur.entity.FeedStatistics;
import com.ivanshilyaev.kontur.repository.CatRepository;
import com.ivanshilyaev.kontur.repository.FeedStatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    private final FeedStatisticsRepository feedStatisticsRepository;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public List<Cat> findHungryCats() {
        return catRepository.findHungryCats();
    }

    public List<CatStatisticsDto> getCatStatistics(Long id) {
        List<FeedStatistics> statistics = feedStatisticsRepository
            .findAllByCat(catRepository.findById(id).orElse(null));
        return statistics.stream().map(record -> CatStatisticsDto.builder()
                .feedTime(record.getFeedTime())
                .volunteerId(record.getVolunteer().getId())
                .volunteerName(record.getVolunteer().getName())
                .build())
            .collect(Collectors.toList());
    }
}
