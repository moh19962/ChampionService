package com.example.championservice.controller;

import com.example.championservice.entity.Champion;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional


public class ChampionControllerTest {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @Test
    void saveChampion() throws Exception {
        Champion champion = new Champion(1L,"Ragger","Support","www.malphite.jpg","malphiteDescription");

        String ChampionAsString = mapper.writeValueAsString(champion);

        mvc.perform(post("/champions/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ChampionAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.championId").value(1L))
                .andExpect(jsonPath("$.championName").value("Ragger"))
                .andExpect(jsonPath("$.championType").value("Support"))
                .andExpect(jsonPath("$.championImage").value("www.malphite.jpg"))
                .andExpect(jsonPath("$.championDescription").value("malphiteDescription"));

    }

    @Test
    void findChampionById() throws Exception {
        mvc.perform(get("/champions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.championId").value(1))
                .andExpect(jsonPath("$.championName").value("Ashe"))
                .andExpect(jsonPath("$.championType").value("ADC"))
                .andExpect(jsonPath("$.championImage").value("www.asheImage.nl"))
                .andExpect(jsonPath("$.championDescription").value("Description"));
    }

    @Test
    void deleteChampionById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .delete("/champions/delete/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllChampions()  throws Exception{
        mvc.perform(get("/champions/all")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].championId").value(1L))
                .andExpect(jsonPath("$[0].championName").value("Ashe"))
                .andExpect(jsonPath("$[0].championType").value("ADC"))
                .andExpect(jsonPath("$[0].championImage").value("www.asheImage.nl"))
                .andExpect(jsonPath("$[0].championDescription").value("Description"));
    }
}

