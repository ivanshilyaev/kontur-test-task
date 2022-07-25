package com.ivanshilyaev.kontur.repository;

import com.ivanshilyaev.kontur.entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {
}
