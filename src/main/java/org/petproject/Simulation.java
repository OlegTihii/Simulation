package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Hunter;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Ground;
import org.petproject.entity.staticEntity.Rock;
import org.petproject.entity.staticEntity.Tree;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    int moveCounter = 0;
    RenderMap renderMap = new RenderMap();

    Actions actions = new Actions();
    private List<Entity> entityList;
    BreadthFirstSearchAlgorithm BFS = new BreadthFirstSearchAlgorithm();

    public class Actions {

        public void initActions() {
            addEntityToList();
            renderMap.addEntityOnMap(entityList);
            findPathToDestination();
            renderMap.printMap();
            nextTurn();
        }

        private void findPathToDestination() {
            for (Entity entity : entityList) {
                if (entity instanceof Creature) {
                    ((Creature) entity).setRouteToDestination(BFS.findPath(renderMap, (Creature) entity).get());
                }
            }
        }

        //todo добавить существ
        private void addEntityToList() {
            int limitEntity = RenderMap.LIMIT_X * RenderMap.LIMIT_Y;
            entityList = new ArrayList<>(limitEntity);
            entityList.add(new Herbivore());
            entityList.add(new Hunter());
            entityList.add(new Grass());
            entityList.add(new Rock());
            entityList.add(new Tree());
            while (limitEntity - entityList.size() != 0) {
                entityList.add(new Ground());
            }
        }

        public void turnActions() {
            for (Entity entity : entityList) {
                if (entity instanceof Creature) {
                    ((Creature) entity).makeMove();
                }
            }
        }
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
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
                renderMap.changeCoordinateForCreature();
                renderMap.printMap();


            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
