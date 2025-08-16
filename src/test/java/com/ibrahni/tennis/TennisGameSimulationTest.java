package com.ibrahni.tennis;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibrahni.tennis.domain.Player;
import com.ibrahni.tennis.domain.score.GameScore;
import com.ibrahni.tennis.main.OutputStreamDisplayer;
import com.ibrahni.tennis.main.TennisGameSimulation;

@ExtendWith(MockitoExtension.class)
class TennisGameSimulationTest {

    @Mock
    private OutputStreamDisplayer gameDisplayer;

    private TennisGameSimulation tennisGameSimulation;

    @BeforeEach
    void setup() {
        tennisGameSimulation = new TennisGameSimulation(gameDisplayer, new Player("A"), new Player("B"));
    }

    @Test
    void givenTheSequenceOfPlayersWins_whenSimulatingTennisGame_shouldDisplayWinsSteps() {
        doCallRealMethod().when(gameDisplayer)
            .display(any(GameScore.class));
        doCallRealMethod().when(gameDisplayer)
            .display(anyMap());
        doCallRealMethod().when(gameDisplayer)
            .displayWinner(any());

        tennisGameSimulation.simulate("ABABAA");

        InOrder inOrder = Mockito.inOrder(gameDisplayer);

        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 15 / Player B : 0");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 15 / Player B : 15");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 30 / Player B : 15");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 30 / Player B : 30");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 40 / Player B : 30");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A wins the game");
    }

    @Test
    void givenTheSequenceOfPlayersWins_whenSimulatingTennisGameWinWithDeuceAndAdvantage_shouldDisplayWinsSteps() {
        doCallRealMethod().when(gameDisplayer)
            .display(any(GameScore.class));
        doCallRealMethod().when(gameDisplayer)
            .display(anyMap());
        doCallRealMethod().when(gameDisplayer)
            .displayWinner(any());
        doCallRealMethod().when(gameDisplayer)
            .display(anyString());

        tennisGameSimulation.simulate("ABABABBB");

        InOrder inOrder = Mockito.inOrder(gameDisplayer);

        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 15 / Player B : 0");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 15 / Player B : 15");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 30 / Player B : 15");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 30 / Player B : 30");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player A : 40 / Player B : 30");
        inOrder.verify(gameDisplayer, times(2))
            .display("Player A : 40 / Player B : 40");
        inOrder.verify(gameDisplayer, times(1))
            .display("Player B wins the game");
    }
}

