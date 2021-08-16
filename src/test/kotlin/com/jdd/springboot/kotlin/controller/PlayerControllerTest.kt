package com.jdd.springboot.kotlin.controller

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.service.impl.PlayerServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
class PlayerControllerTest {

    private lateinit var subject: PlayerController

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var playerService: PlayerServiceImpl

    @BeforeEach
    fun setUp() {
        subject = PlayerController()
    }

    @Test
    fun listPlayersTest1() {
        mockMvc.perform(MockMvcRequestBuilders.get("/players/list/"))
            .andExpect(MockMvcResultMatchers.status().isAccepted)
    }

    @Test
    fun readPlayerTest1() {
        val testPlayer = Player(
            playerId = "TrevorLawrence16",
            playerFirstName = "Trevor",
            playerLastName = "Lawrence",
            playerNumber = "16",
            playerPosition = "QB",
            playerTeam = "JAX",
        )
        given(playerService.readPlayer(testPlayer.playerId)).willReturn(testPlayer)
        mockMvc.perform(
            MockMvcRequestBuilders.get("/players/read/${testPlayer.playerId}")
        )
            .andExpect(MockMvcResultMatchers.status().isAccepted)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(testPlayer)))
    }

    @Test
    fun createPlayerTest1() {
        val testPlayer = Player(
            playerId = "NajeeHarris22",
            playerFirstName = "Najee",
            playerLastName = "Harris",
            playerNumber = "22",
            playerPosition = "RB",
            playerTeam = "PIT"
        )
        given(playerService.createPlayer(testPlayer)).willReturn(testPlayer)
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/players/create")
                .content(objectMapper.writeValueAsString(testPlayer))
                .contentType("application/json")
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(testPlayer)))
    }

    @Test
    fun updatePlayerTest1() {
        val testPlayer = Player(
            playerId = "CalvinRidley18",
            playerFirstName = "Calvin",
            playerLastName = "Ridley",
            playerNumber = "18",
            playerPosition = "WR",
            playerTeam = "ATL"
        )
        given(playerService.updatePlayer(testPlayer)).willReturn(testPlayer)
        mockMvc.perform(
            MockMvcRequestBuilders
                .put("/players/update")
                .content(objectMapper.writeValueAsString(testPlayer))
                .contentType("application/json")
        )
            .andExpect(MockMvcResultMatchers.status().isAccepted)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(testPlayer)))
    }

    @Test
    fun deletePlayerTest1() {
        val testPlayer = Player(
            playerId = "JaylenWaddle17",
            playerFirstName = "Jaylen",
            playerLastName = "Waddle",
            playerNumber = "17",
            playerPosition = "WR",
            playerTeam = "MIA"
        )
        given(playerService.deletePlayer(testPlayer)).willReturn(testPlayer)
        mockMvc.perform(
            MockMvcRequestBuilders
                .delete("/players/delete")
                .content(objectMapper.writeValueAsString(testPlayer))
                .contentType("application/json")
        )
            .andExpect(MockMvcResultMatchers.status().isGone)
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(testPlayer)))
    }

    @Test
    fun testNullBoolean1() {
        val testPlayer = Player(
            playerId = "CalvinRidley18",
            playerFirstName = "Calvin",
            playerLastName = "Ridley",
            playerNumber = "18",
            playerPosition = "WR",
            playerTeam = "ATL",
            isBoolean = null
        )
        println(objectMapper.writeValueAsString(testPlayer))
        val mapper2 = JsonMapper.builder()
            .build()
            .setSerializationInclusion(JsonInclude.Include.USE_DEFAULTS)
        println(mapper2.writeValueAsString(testPlayer))
    }

    @Test
    fun testNullBoolean2() {
        val testPlayer = Player(
            playerId = "CalvinRidley18",
            playerFirstName = "Calvin",
            playerLastName = "Ridley",
            playerNumber = "18",
            playerPosition = "WR",
            playerTeam = "ATL",
            isBoolean = null
        )
        mockMvc.perform(MockMvcRequestBuilders.get("/players/boolean/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(testPlayer)))
    }
}