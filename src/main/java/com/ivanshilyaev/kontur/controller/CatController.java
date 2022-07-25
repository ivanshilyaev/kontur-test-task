package com.ivanshilyaev.kontur.controller;

import com.ivanshilyaev.kontur.entity.Cat;
import com.ivanshilyaev.kontur.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatRepository catRepository;

    @GetMapping("/hungry")
    public List<Cat> findHungryCats() {
        return catRepository.findHungryCats();
    }
}
