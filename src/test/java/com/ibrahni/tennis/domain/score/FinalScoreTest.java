package com.ibrahni.tennis.domain.score;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.TennisGameException;

class FinalScoreTest {

    @Test
    void givenFinalScoreOfTwoPlayers_whenInvokingIncrement_shouldThrowExceptionWithMessageForGameEnded() {

        final Player player1 = new Player("A");
        final Player player2 = new Player("B");

        final GameScore finalScore = new FinalScore(Map.of(player1, ScoreValue.FORTY, player2, ScoreValue.LOVE), player1);

        TennisGameException exception = Assertions.assertThrows(TennisGameException.class, () -> finalScore.increment(player1));

        assertEquals(FinalScore.GAME_ENDED_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void givenFinalScoreOfTwoPlayers_whenDisplayingScore_shouldDisplayWinner() {
        final Player player1 = new Player("A");
        final Player player2 = new Player("B");
        final GameDisplayer displayer = mock(GameDisplayer.class);

        final GameScore finalScore = new FinalScore(Map.of(player1, ScoreValue.FORTY, player2, ScoreValue.LOVE), player1);

        finalScore.display(displayer);

        verify(displayer, times(1)).displayWinner(player1);
    }
}