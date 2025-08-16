package com.ibrahni.tennis.domain.score;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibrahni.tennis.domain.Player;

class IncrementalScoreTest {

    @Test
    void givenScoreOfTwoPlayer_whenPlayerWinsFourConsecutiveRound_incrementShouldReturnFinalScoreWithThatPlayerAsWinner() {
        final Player player1 = new Player("A");
        final Player player2 = new Player("B");

        GameScore result = new IncrementalScore(player1, player2);
        for (int i = 0; i < 4; i++) {
            result = result.increment(player1);
        }

        assertInstanceOf(FinalScore.class, result);
        assertEquals(player1, ((FinalScore) result).getWinner());
    }

}