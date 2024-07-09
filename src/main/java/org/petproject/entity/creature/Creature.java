package org.petproject.entity.creature;

import org.petproject.BreadthFirstSearchAlgorithm;
import org.petproject.Coordinate;
import org.petproject.SimulationMap;
import org.petproject.entity.Entity;

import java.util.ArrayDeque;

public abstract class Creature extends Entity {
    private BreadthFirstSearchAlgorithm BFS = new BreadthFirstSearchAlgorithm();
    private ArrayDeque<Coordinate> routeToDestination;

    abstract public void makeMove(SimulationMap simulationMap);

    public void findPathToDestination(SimulationMap simulationMap) {
        routeToDestination = BFS.findPath(simulationMap.getMap(), getCoordinate()).get();
    }

    public ArrayDeque<Coordinate> getRouteToDestination() {
        return routeToDestination;
    }

    public void setRouteToDestination(ArrayDeque<Coordinate> routeToDestination) {
        this.routeToDestination = routeToDestination;
    }
}
