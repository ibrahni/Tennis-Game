package com.ibrahni.tennis.domain;

public record Player(String name) {

    public String displayName() {
        return "Player %s".formatted(this.name);
    }
}
