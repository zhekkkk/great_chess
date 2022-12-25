package ru.vsu.cs.fedoseev;

public class Figure {

    private final FigureType type;

    private final FigureColor color;

    public Figure(FigureType type, FigureColor color) {
        this.type = type;
        this.color = color;
    }

    public FigureType getType() {
        return type;
    }

    public FigureColor getColor() {
        return color;
    }

    /*KING("\u2654"),
    QUEEN("\u2655"),
    ROOK("\u2656"),
    BISHOP("\u2657"),
    KNIGHT("\u2658"),
    PAWN("\u2659"),
    GIRAFFE("\u2659"),

    private final String uiString;

    ChessPiece(String uiString) {
        this.uiString = uiString;
    }

    public String getUiString() {
        return uiString;
    }*/
}
