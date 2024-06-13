package org.petproject;

public class Simulation {
    int moveCounter = 0;
    RenderMap renderMap = new RenderMap();

    public class Actions {

        public void initActions() {
            renderMap.addEntityOnMap();
            renderMap.printMap();
        }

        public void turnActions() {

        }
    }

    public void startSimulation() {
        new Actions().initActions();
    }

    public void pauseSimulation() {

    }

    public void nextTurn() {

    }


}
