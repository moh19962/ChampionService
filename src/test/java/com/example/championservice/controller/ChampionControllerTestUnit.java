package com.example.championservice.controller;

import com.example.championservice.entity.Champion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChampionControllerTestUnit {

    @Test
    void saveChampions() {
//        //Arrange
//        ChampionController champion = new ChampionController();
//        Champion champs = new Champion(1L, "Zed", "Midlaner", "www.zedjpg.nl", "Zed description");
//
//        //Act
//        Champion response = champion.saveChampion(champs);
//
//        //Assert
//        assertEquals(champs, response);
    }
    @Test
    void saveChampion() {
        //Arrange
        ChampionController champion = new ChampionController();
        Champion champs = new Champion(1L, "Zed", "Midlaner", "www.zedjpg.nl", "Zed description");

        //Act
        Champion response = champion.saveChampion(champs);

        //Assert
        assertEquals(champs, response);
    }

    @Test
    void findChampionById() {
    }

    @Test
    void getAllChampions() {
    }
}
