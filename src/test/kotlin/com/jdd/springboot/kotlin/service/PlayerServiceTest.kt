package com.jdd.springboot.kotlin.service

import com.jdd.springboot.kotlin.model.Player
import com.jdd.springboot.kotlin.repository.PlayerRepository
import com.jdd.springboot.kotlin.service.impl.PlayerServiceImpl
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.doNothing
import org.mockito.BDDMockito.given
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(SpringExtension::class, MockitoExtension::class)
class PlayerServiceTest {

    private lateinit var subject: PlayerServiceImpl

    @MockBean(name = "playerRepository")
    private lateinit var playerRepository: PlayerRepository

    private val testPlayer1 = Player(
        playerId = "TrevorLawrence16",
        playerFirstName = "Trevor",
        playerLastName = "Lawrence",
        playerNumber = "16",
        playerPosition = "QB",
        playerTeam = "JAX",
    )
    private val testPlayer2 = Player(
        playerId = "NajeeHarris22",
        playerFirstName = "Najee",
        playerLastName = "Harris",
        playerNumber = "22",
        playerPosition = "RB",
        playerTeam = "PIT",
    )
    private val testPlayer3 = Player(
        playerId = "CalvinRidley18",
        playerFirstName = "Calvin",
        playerLastName = "Ridley",
        playerNumber = "18",
        playerPosition = "WR",
        playerTeam = "ATL",
    )

    @BeforeEach
    fun setup() {
        subject = PlayerServiceImpl(playerRepository)
    }

    @Test
    fun listPlayersTest1() {
        given(playerRepository.findAll()).willReturn(listOf(testPlayer1, testPlayer2, testPlayer3))
        val expectedResult = listOf(testPlayer1, testPlayer2, testPlayer3)
        val actualResult = subject.listPlayers()
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun readPlayerTest1() {
        given(playerRepository.findById(testPlayer1.playerId)).willReturn(Optional.of(testPlayer1))
        val expectedResult = testPlayer1
        val actualResult = subject.readPlayer(testPlayer1.playerId)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun createPlayerTest1() {
        given(playerRepository.existsById(testPlayer2.playerId)).willReturn(false)
        given(playerRepository.save(testPlayer1)).willReturn(testPlayer1)
        val expectedResult = testPlayer1
        val actualResult = subject.createPlayer(testPlayer1)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun updatePlayerTest1() {
        given(playerRepository.existsById(testPlayer2.playerId)).willReturn(true)
        doNothing().`when`(playerRepository).deleteById(testPlayer2.playerId)
        given(playerRepository.save(testPlayer2)).willReturn(testPlayer2)
        val expectedResult = testPlayer2
        val actualResult = subject.updatePlayer(testPlayer2)
        assertEquals(expectedResult, actualResult)
    }

    @Test
    fun deletePlayerTest() {
        given(playerRepository.existsById(testPlayer3.playerId)).willReturn(true)
        doNothing().`when`(playerRepository).deleteById(testPlayer3.playerId)
        val expectedResult = testPlayer3
        val actualResult = subject.deletePlayer(testPlayer3)
        assertEquals(expectedResult, actualResult)
    }
}