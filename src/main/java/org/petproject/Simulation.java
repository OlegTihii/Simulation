package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;

public class Simulation {
    int moveCounter = 1;
    SimulationMap simulationMap = new SimulationMap();
    RenderMap renderMap = new RenderMap();
    Actions actions = new Actions();

    public class Actions {

        public void initActions() {
            simulationMap.addEntityToList();
            simulationMap.addEntityOnMap();
            renderMap.printMap(simulationMap, moveCounter++);
            nextTurn();
        }

        public void turnActions() {
            for (Entity entity : simulationMap.getEntityList()) {
                if (entity instanceof Creature) {
                    ((Creature) entity).makeMove(simulationMap);
                }
            }
        }
    }

    public void startSimulation() {
        actions.initActions();
    }

    public void pauseSimulation() {
    }

    public void nextTurn() {

        while (true) {
            try {
                Thread.sleep(1000);
                actions.turnActions();
                renderMap.printMap(simulationMap, moveCounter++ );
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
