package ru.vsu.cs.fedoseev.figure;

import ru.vsu.cs.fedoseev.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarMachineStepService implements IFigureStepService {

    @Override
    public FigureType getType() {
        return FigureType.WAR_MACHINE;
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
        findAvailableCellsDirectAndDiagonal(cell, game, res);

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

    private void findAvailableCellsDirectAndDiagonal(Cell cell, Game game, List<Cell> result) {
        Cell start = cell;
        while(upCell(cell) != null) {
            if(game.getCellToFigureMap().get(upCell(cell)) != null) {
                result.add(upCell(cell));
                break;
            }
            result.add(upCell(cell));
            cell = upCell(cell);
        }
        cell = start;
        while(downCell(cell) != null) {
            if(game.getCellToFigureMap().get(downCell(cell)) != null) {
                result.add(downCell(cell));
                break;
            }
            result.add(downCell(cell));
            cell = downCell(cell);
        }
        cell = start;
        while(rightCell(cell) != null) {
            if(game.getCellToFigureMap().get(rightCell(cell)) != null) {
                result.add(rightCell(cell));
                break;
            }
            result.add(rightCell(cell));
            cell = rightCell(cell);
        }
        cell = start;
        while(leftCell(cell) != null) {
            if(game.getCellToFigureMap().get(leftCell(cell)) != null) {
                result.add(leftCell(cell));
                break;
            }
            result.add(leftCell(cell));
            cell = leftCell(cell);
        }
        cell = start;
        if(upCell(cell) != null) {
            if (upRightCell(upCell(cell)) != null) {
                result.add(upRightCell(upCell(cell)));
            }
            if (upLeftCell(upCell(cell)) != null) {
                result.add(upLeftCell(upCell(cell)));
            }
        }
        if(downCell(cell) != null) {
            if (downRightCell(downCell(cell)) != null) {
                result.add(downRightCell(downCell(cell)));
            }
            if (downLeftCell(downCell(cell)) != null) {
                result.add(downLeftCell(downCell(cell)));
            }
        }
        if(rightCell(cell) != null) {
            if(upRightCell(rightCell(cell)) != null) {
                result.add(upRightCell(rightCell(cell)));
            }
            if(downRightCell(rightCell(cell)) != null) {
                result.add(downRightCell(rightCell(cell)));
            }
        }
        if(leftCell(cell) != null) {
            if(upLeftCell(leftCell(cell)) != null) {
                result.add(upLeftCell(leftCell(cell)));
            }
            if(downLeftCell(leftCell(cell)) != null) {
                result.add(downLeftCell(leftCell(cell)));
            }
        }
    }

    private Cell upCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.UP);
    }

    private Cell downCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.DOWN);
    }

    private Cell rightCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.RIGHT);
    }

    private Cell leftCell(Cell cell) {
        return cell.getDirectionsMap().get(Directions.LEFT);
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
}
