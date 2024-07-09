package org.petproject.entity.creature;

import org.petproject.SimulationMap;

public class Herbivore extends Creature {

    public void eatGrass(SimulationMap simulationMap) {

    }

    //todo При каждом движении, вычислять маршрут до цели не рационально (ИМХО)
    @Override
    public void makeMove(SimulationMap simulationMap) {
        findPathToDestination(simulationMap);
        if (getRouteToDestination().size() == 1) {
            eatGrass(simulationMap);
        } else {
            setCoordinate(getRouteToDestination().pollFirst());
            simulationMap.changeCoordinateForCreature();
        }
    }

    @Override
    public String toString() {
        return "🐇";
    }

}
