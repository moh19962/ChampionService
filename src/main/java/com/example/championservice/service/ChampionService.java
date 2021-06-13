package com.example.championservice.service;

import com.example.championservice.entity.Champion;
import com.example.championservice.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    public Champion saveChampion(Champion champion) {
        return championRepository.save(champion);
    }

    public Champion findChampionById(Long championId) {
        return championRepository.findByChampionId(championId);
    }

    public List<Champion> getAllChampions() {
        return championRepository.findAll();
    }

    public void deleteChampionById(Long championId) {
        championRepository.deleteById(championId);
    }
}
