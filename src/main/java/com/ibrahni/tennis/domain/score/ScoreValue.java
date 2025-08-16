package com.ibrahni.tennis.domain.score;

public enum ScoreValue {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40");

    private final String value;

    ScoreValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
