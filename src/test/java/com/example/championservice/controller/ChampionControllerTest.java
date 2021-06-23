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
        Champion champion = new Champion(1L,"Peer","Support", false,"https://cdn.webshopapp.com/shops/32068/files/11883478/kunst-peer-groen-11cm.jpg","Lorem Ipsum is simply dummy text of the printing and typesetting industry");

        String ChampionAsString = mapper.writeValueAsString(champion);

        mvc.perform(post("/champions/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ChampionAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.championId").value(1L))
                .andExpect(jsonPath("$.championName").value("Peer"))
                .andExpect(jsonPath("$.championType").value("Support"))
                .andExpect(jsonPath("$.featured").value(false))
                .andExpect(jsonPath("$.championImage").value("https://cdn.webshopapp.com/shops/32068/files/11883478/kunst-peer-groen-11cm.jpg"))
                .andExpect(jsonPath("$.championDescription").value("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));

    }

    @Test
    void findChampionById() throws Exception {
        mvc.perform(get("/champions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.championId").value(1))
                .andExpect(jsonPath("$.championName").value("Appel"))
                .andExpect(jsonPath("$.championType").value("Marksman"))
                .andExpect(jsonPath("$.featured").value(false))
                .andExpect(jsonPath("$.championImage").value("https://www.foodandfriends.nl/app/uploads/2020/12/appel-artikel.jpg"))
                .andExpect(jsonPath("$.championDescription").value("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
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
                .andExpect(jsonPath("$[0].championName").value("Appel"))
                .andExpect(jsonPath("$[0].championType").value("Marksman"))
                .andExpect(jsonPath("$[0].featured").value(false))
                .andExpect(jsonPath("$[0].championImage").value("https://www.foodandfriends.nl/app/uploads/2020/12/appel-artikel.jpg"))
                .andExpect(jsonPath("$[0].championDescription").value("Lorem Ipsum is simply dummy text of the printing and typesetting industry"));
    }
}

