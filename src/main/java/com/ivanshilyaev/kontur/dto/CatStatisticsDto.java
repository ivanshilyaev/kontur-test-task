package com.ivanshilyaev.kontur.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CatStatisticsDto {

    private LocalDateTime feedTime;

    private Long volunteerId;

    private String volunteerName;
}
