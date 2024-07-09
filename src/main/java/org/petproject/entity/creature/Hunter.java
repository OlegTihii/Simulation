package org.petproject.entity.creature;

import org.petproject.SimulationMap;
import org.petproject.entity.Entity;

public class Hunter extends Creature {
    public int attackToHerbivore = 5;

    public Hunter() {
        this.hp = 30;
    }

    public void attackHerbivore(SimulationMap simulationMap) {
        Entity entity = simulationMap.getMap().get(getRouteToDestination().getFirst());
        if (entity instanceof Herbivore herbivore) {
            herbivore.hp = herbivore.hp - attackToHerbivore;
            if (herbivore.hp <= 0) {
                simulationMap.deleteEntity(getRouteToDestination().getFirst());
            }
        }
    }

    @Override
    public void makeMove(SimulationMap simulationMap) {
        findPathToDestination(simulationMap);
        if (getRouteToDestination().size() == 1) {
            attackHerbivore(simulationMap);
        } else if (getRouteToDestination().size() > 1) {
            setCoordinate(getRouteToDestination().pollFirst());
            simulationMap.changeCoordinateForCreature();
        }
    }

    @Override
    public String toString() {
        return "🐺";
    }
}
