package org.petproject.entity.creature;

import org.petproject.Coordinate;
import org.petproject.entity.Entity;

import java.util.ArrayDeque;

public abstract class Creature extends Entity {

    private ArrayDeque<Coordinate> routeToDestination = new ArrayDeque<>();

    abstract public void makeMove();

    public ArrayDeque<Coordinate> getRouteToDestination() {
        return routeToDestination;
    }

    public void setRouteToDestination(ArrayDeque<Coordinate> routeToDestination) {
        this.routeToDestination = routeToDestination;
    }
}
