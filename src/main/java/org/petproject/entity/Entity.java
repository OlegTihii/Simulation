package org.petproject.entity;

import org.petproject.Coordinate;

public abstract class Entity {
    Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
