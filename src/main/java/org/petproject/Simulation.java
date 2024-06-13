package org.petproject;

import org.petproject.entity.creature.Hunter;
import org.petproject.entity.staticEntity.Ground;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Simulation {
    int moveCounter = 0;
    RenderMap renderMap = new RenderMap();

    public class Actions {

        public void initActions() {
            renderMap.fullingMap();
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
