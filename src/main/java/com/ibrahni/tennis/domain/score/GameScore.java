package com.ibrahni.tennis.domain.score;

import com.ibrahni.tennis.domain.GameDisplayer;
import com.ibrahni.tennis.domain.Player;

public interface GameScore {

    GameScore increment(Player player);

    void display(GameDisplayer displayer);
}
