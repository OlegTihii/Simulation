package org.petproject;

public class RenderMap {

    public static final int LIMIT_X = 10;
    public static final int LIMIT_Y = 10;

    public void printMap(SimulationMap simulationMap) {
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
        System.out.println(result);
        System.out.println("==========");
    }
}
