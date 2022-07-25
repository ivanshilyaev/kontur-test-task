package com.ivanshilyaev.kontur.controller;

import com.ivanshilyaev.kontur.entity.Volunteer;
import com.ivanshilyaev.kontur.service.VolunteerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
@RequiredArgsConstructor
public class VolunteerController {

    private final VolunteerService volunteerService;

    @GetMapping
    public List<Volunteer> findAllVolunteers() {
        return volunteerService.findAllVolunteers();
    }

    @PostMapping("/{volunteerId}/feed/{catId}")
    public void feedCat(@PathVariable Long volunteerId, @PathVariable Long catId) {
        volunteerService.feedCat(volunteerId, catId);
    }
}
