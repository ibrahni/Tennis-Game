package com.ibrahni.tennis.domain;

import static com.ibrahni.tennis.domain.TennisGame.GAME_FINISHED_ERROR_MESSAGE;
import static com.ibrahni.tennis.domain.TennisGame.PLAYER_NOT_IN_THE_GAME_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TennisGameTest {

    @Test
    void givenAFinishedTennisGame_whenInvokeRoundWinForAPlayer_shouldThrowException() {
        final Player player1 = new Player("1");
        final Player player2 = new Player("2");

        final TennisGame tennisGame = new TennisGame(player1, player2);
        for (int i = 0; i < 4; i++) {
            tennisGame.roundWin(player1);
        }

        final TennisGameException exception = assertThrows(TennisGameException.class, () -> tennisGame.roundWin(player1));

        assertEquals(GAME_FINISHED_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void givenATennisGame_whenInvokeRoundWinForAPlayer_shouldThrowExceptionIfPlayerNotInTheGame() {
        final Player player1 = new Player("1");
        final Player player2 = new Player("2");
        final Player player3 = new Player("3");

        final TennisGame tennisGame = new TennisGame(player1, player2);

        final TennisGameException exception = assertThrows(TennisGameException.class, () -> tennisGame.roundWin(player3));

        assertEquals(PLAYER_NOT_IN_THE_GAME_ERROR_MESSAGE, exception.getMessage());
    }
}