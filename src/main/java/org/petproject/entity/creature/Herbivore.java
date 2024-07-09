package org.petproject.entity.creature;

import org.petproject.SimulationMap;

public class Herbivore extends Creature {
    public Herbivore(){
        this.hp = 10;
    }

    public void eatGrass(SimulationMap simulationMap) {
        simulationMap.deleteEntity(getRouteToDestination().getFirst());
    }

    @Override
    public void makeMove(SimulationMap simulationMap) {
        findPathToDestination(simulationMap);
        if (getRouteToDestination().size() == 1) {
            eatGrass(simulationMap);
        } else if (getRouteToDestination().size() > 1) {
            setCoordinate(getRouteToDestination().pollFirst());
            simulationMap.changeCoordinateForCreature();
        }
    }

    @Override
    public String toString() {
        return "🐇";
    }
}
