package com.ivanshilyaev.kontur.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "cat_volunteer")
public class CatVolunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Cat cat;

    @ManyToOne
    @JoinColumn(name = "volunteer_id", referencedColumnName = "id")
    private Volunteer volunteer;

    private LocalDateTime feedTime;
}
