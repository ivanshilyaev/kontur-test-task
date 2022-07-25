package com.ivanshilyaev.kontur.service;

import com.ivanshilyaev.kontur.entity.Cat;
import com.ivanshilyaev.kontur.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public List<Cat> findHungryCats() {
        return catRepository.findHungryCats();
    }
}
