package ru.vsu.cs.fedoseev.figure;

import ru.vsu.cs.fedoseev.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BishopStepService implements IFigureStepService{

    @Override
    public FigureType getType() {
        return FigureType.BISHOP;
    }

    @Override
    public Map<Boolean, List<Cell>> process(Figure figure, Game game) {
        if(figure.getType() != getType()) {
            throw new RuntimeException();
        }
        Cell cell = game.getFigureCellMap().get(figure);
        Map<Boolean, List<Cell>> cellsForStep = new HashMap<>();
        List<Cell> trues = new ArrayList<>();
        List<Cell> falses = new ArrayList<>();

        List<Cell> res = new ArrayList<>();
        findAvailableCellsDiagonal(cell, game, res);

        for(Cell c: res) {
            if(game.getCellToFigureMap().get(c) == null) {
                falses.add(c);
            } else {
                if(game.getCellToFigureMap().get(c).getColor() != figure.getColor()) {
                    trues.add(c);
                }
            }
        }

        cellsForStep.put(true, trues);
        cellsForStep.put(false, falses);

        return cellsForStep;
    }

    private void findAvailableCellsDiagonal(Cell cell, Game game, List<Cell> result) {
        Cell start = cell;
        while(upRightCell(cell) != null) {
            if(game.getCellToFigureMap().get(upRightCell(cell)) != null) {
                result.add(upRightCell(cell));
                break;
            }
            result.add(upRightCell(cell));
            cell = upRightCell(cell);
        }
        cell = start;
        while(upLeftCell(cell) != null) {
            if(game.getCellToFigureMap().get(upLeftCell(cell)) != null) {
                result.add(upLeftCell(cell));
                break;
            }
            result.add(upLeftCell(cell));
            cell = upLeftCell(cell);
        }
        cell = start;
        while(downLeftCell(cell) != null) {
            if(game.getCellToFigureMap().get(downLeftCell(cell)) != null) {
                result.add(downLeftCell(cell));
                break;
            }
            result.add(downLeftCell(cell));
            cell = downLeftCell(cell);
        }
        cell = start;
        while(downRightCell(cell) != null) {
            if(game.getCellToFigureMap().get(downRightCell(cell)) != null) {
                result.add(downRightCell(cell));
                break;
            }
            result.add(downRightCell(cell));
            cell = downRightCell(cell);
        }
    }

    private Cell upRightCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.UP_RIGHT);
    }

    private Cell downLeftCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.DOWN_LEFT);
    }

    private Cell downRightCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.DOWN_RIGHT);
    }

    private Cell upLeftCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.UP_LEFT);
    }

    /*private void findAvailableCellsUpLeft(Cell cell, Game game, List<Cell> result) {
        if(cell.getDirectionsMap().get(Directions.UP_LEFT) == null) {
            return;
        } else {
            Cell upCell = cell.getDirectionsMap().get(Directions.UP_LEFT);
            if(game.getCellToFigureMap().get(upCell) == null) {
                result.add(upCell);
                findAvailableCellsUpLeft(upCell, game, result);
            } else {
                result.add(upCell);
            }
        }
        return;
    }

    private void findAvailableCellsDownLeft(Cell cell, Game game, List<Cell> result) {
        if(cell.getDirectionsMap().get(Directions.DOWN_LEFT) == null) {
            return;
        } else {
            Cell upCell = cell.getDirectionsMap().get(Directions.DOWN_LEFT);
            if(game.getCellToFigureMap().get(upCell) == null) {
                result.add(upCell);
                findAvailableCellsDownLeft(upCell, game, result);
            } else {
                result.add(upCell);
            }
        }
        return;
    }

    private void findAvailableCellsUpRight(Cell cell, Game game, List<Cell> result) {
        if(cell.getDirectionsMap().get(Directions.UP_RIGHT) == null) {
            return;
        } else {
            Cell upCell = cell.getDirectionsMap().get(Directions.UP_RIGHT);
            if(game.getCellToFigureMap().get(upCell) == null) {
                result.add(upCell);
                findAvailableCellsUpRight(upCell, game, result);
            } else {
                result.add(upCell);
            }
        }
        return;
    }

    private void findAvailableCellsDownRight(Cell cell, Game game, List<Cell> result) {
        if(cell.getDirectionsMap().get(Directions.DOWN_RIGHT) == null) {
            return;
        } else {
            Cell upCell = cell.getDirectionsMap().get(Directions.DOWN_RIGHT);
            if(game.getCellToFigureMap().get(upCell) == null) {
                result.add(upCell);
                findAvailableCellsDownRight(upCell, game, result);
            } else {
                result.add(upCell);
            }
        }
        return;
    }*/

}
