package com.example.championservice.controller;

import com.example.championservice.entity.Champion;
import com.example.championservice.repository.ChampionRepository;
import com.example.championservice.service.ChampionService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class ChampionControllerTestUnit {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ChampionService championService;

    @MockBean
    private ChampionRepository championRepository;

    @Test
    void constructorTest() throws Exception {
        //Arrange
        Champion champ = new Champion(1L, "Zed", "Midlaner", true,"www.zedjpg.nl", "Zed description");
        assertThat(champ.getChampionId()).isEqualTo(1);
        assertThat(champ.getChampionName()).isEqualTo("Zed");

    }

    @Test
    void nameNotEqual() throws Exception {
        //Arrange
        Champion champ = new Champion(1L, "Zed", "Midlaner", true, "www.zedjpg.nl", "Zed description");
        assertThat(champ.getChampionId()).isNotEqualTo(2L);
        assertThat(champ.getChampionName()).isEqualTo("Zed");

    }
}
