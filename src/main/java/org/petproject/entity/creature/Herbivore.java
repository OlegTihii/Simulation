package org.petproject.entity.creature;

public class Herbivore extends Creature {

    public void eatGrass() {

    }

    @Override
    public void makeMove() {
        if (getRouteToDestination().size() == 1) {
            eatGrass();
        } else {
            setCoordinate(getRouteToDestination().pollFirst());
        }
    }


    @Override
    public String toString() {
        return "🐇";
    }

}
