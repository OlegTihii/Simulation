package org.petproject;

public class RenderMap {

    public static final int LIMIT_X = 15;
    public static final int LIMIT_Y = 15;

    public void printMap(SimulationMap simulationMap, int moveCounter) {
        StringBuilder result = new StringBuilder();

        for (int y = 0; y < LIMIT_Y; y++) {
            for (int x = 0; x < LIMIT_X; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                result.append(simulationMap.getMap().get(coordinate));
                if (x == LIMIT_X - 1) {
                    result.append("\n");
                }
            }
        }

        System.out.println("\u001B[1m Ход: " + moveCounter + "\u001B[0m");
        System.out.println(result);
    }
}
