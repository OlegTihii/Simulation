package org.petproject;

public class Main {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.startSimulation();
    }

    /*TODO
     *  1. Есть баг когда волк и зайя находятся на одной оси, они не сближаются, а ходят по соседним клеткам туда сюда.
     */
}