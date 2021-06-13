package com.example.championservice.repository;

import com.example.championservice.entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {

    Champion findByChampionId(Long championId);
}
