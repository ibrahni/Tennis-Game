package com.ibrahni.tennis;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TennisGameSimulationTest {

    @Mock
    private GameDisplayer gameDisplayer;

    @InjectMocks
    private TennisGameSimulation simulation;

    @Test
    void givenTheSequenceOfPlayersWins_whenSimulatingTennisGame_shouldDisplayWinsSteps() {

        simulation.simulate("ABABAA");

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
}

