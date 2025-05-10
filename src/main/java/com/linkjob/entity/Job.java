package com.linkjob.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int career;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String salary; //기본 VARCHAR(255) 로 매핑

    @Column(columnDefinition = "TEXT")
    private String skill;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}