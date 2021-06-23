package com.example.championservice.controller;

import com.example.championservice.entity.Champion;
import com.example.championservice.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/champions")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @PostMapping("/create")
    public Champion saveChampion(@RequestBody Champion champion){
        return championService.saveChampion(champion);
    }

    @GetMapping("/{id}")
    public Champion findChampionById(@PathVariable("id") Long championId) {
        return championService.findChampionById(championId);
    }

    @GetMapping("/all")
    public List<Champion> getAllChampions() {
        return championService.getAllChampions();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChampionById(@PathVariable("id") Long championId) {
         championService.deleteChampionById(championId);
    }
}
