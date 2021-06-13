package com.example.championservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long championId;
    private String championName;
    private String championType;
    private String championImage;
    private String championDescription;
}
