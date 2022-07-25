package com.ivanshilyaev.kontur.controller;

import com.ivanshilyaev.kontur.entity.Cat;
import com.ivanshilyaev.kontur.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping
    public List<Cat> findAllCats() {
        return catService.findAllCats();
    }

    @GetMapping("/hungry")
    public List<Cat> findHungryCats() {
        return catService.findHungryCats();
    }
}
