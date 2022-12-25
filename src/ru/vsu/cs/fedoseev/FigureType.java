package ru.vsu.cs.fedoseev;

public enum FigureType {

    PAWN        ("\u2659", "\u265F", 1),
    BISHOP      ("\u2657", "\u265D", 2),
    KNIGHT      ("\u2658", "\u265E", 2),
    ROOK        ("\u2656", "\u265C", 3),
    VIZIER      ("\uFFE0", "\uFFE0", 4),
    WAR_MACHINE ("\uFFE6", "\uFFE6", 5),
    QUEEN       ("\u2655", "\u265B", 6),
    GIRAFFE     ("\uFFE5", "\uFFE5", 7),
    KING        ("\u2654", "\u265A", 100);

    private final String white;
    private final String black;
    private final int value;

    FigureType(String white, String black, int value) {
        this.white = white;
        this.black = black;
        this.value = value;
    }

    public String getWhite() {
        return white;
    }

    public String getBlack() {
        return black;
    }

    public int getValue() {
        return value;
    }
}
