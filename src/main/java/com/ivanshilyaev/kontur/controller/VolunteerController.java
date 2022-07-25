package com.ivanshilyaev.kontur.controller;

import com.ivanshilyaev.kontur.entity.CatVolunteer;
import com.ivanshilyaev.kontur.repository.CatRepository;
import com.ivanshilyaev.kontur.repository.CatVolunteerRepository;
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

    private final CatVolunteerRepository catVolunteerRepository;

    @PostMapping("/{volunteerId}/feed/{catId}")
    public void feed(@PathVariable Long volunteerId, @PathVariable Long catId) {
        if (catVolunteerRepository.getLastFeedTime(catId)
            .isBefore(LocalDateTime.now().minus(4, ChronoUnit.HOURS))) {
            CatVolunteer catVolunteer = new CatVolunteer();
            catVolunteer.setCat(catRepository.findById(catId).orElse(null));
            catVolunteer.setVolunteer(volunteerRepository.findById(volunteerId).orElse(null));
            catVolunteer.setFeedTime(LocalDateTime.now());
            catVolunteerRepository.save(catVolunteer);
        }
    }
}
