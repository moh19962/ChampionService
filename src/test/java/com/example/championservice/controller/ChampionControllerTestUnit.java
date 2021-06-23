package com.example.championservice.controller;

import com.example.championservice.entity.Champion;
import com.example.championservice.repository.ChampionRepository;
import com.example.championservice.service.ChampionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Champion champ = new Champion(1L, "Zed", "Midlaner", false, "www.zedjpg.nl", "Zed description");
        assertThat(champ.getChampionId()).isEqualTo(1);
        assertThat(champ.getChampionName()).isEqualTo("Zed");

    }

    @Test
    void nameNotEqual() throws Exception {
        //Arrange
        Champion champ = new Champion(1L, "Zed", "Midlaner", false, "www.zedjpg.nl", "Zed description");
        assertThat(champ.getChampionId()).isNotEqualTo(2L);
        assertThat(champ.getChampionName()).isEqualTo("Zed");

    }

}
