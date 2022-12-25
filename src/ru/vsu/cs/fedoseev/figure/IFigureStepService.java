package ru.vsu.cs.fedoseev.figure;

import ru.vsu.cs.fedoseev.Cell;
import ru.vsu.cs.fedoseev.Figure;
import ru.vsu.cs.fedoseev.FigureType;
import ru.vsu.cs.fedoseev.Game;

import java.util.List;
import java.util.Map;

public interface IFigureStepService {

    FigureType getType();

    Map<Boolean, List<Cell>> process(Figure figure, Game game);
}
