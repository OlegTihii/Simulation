package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Hunter;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Ground;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    int moveCounter = 0;
    RenderMap renderMap = new RenderMap();

    public class Actions {
        private List<Entity> entityList;

        public void initActions() {
            createEntityToList();
            renderMap.addEntityOnMap(entityList);
            renderMap.printMap();


        }

        //todo добавить существ
        private void createEntityToList() {
            int limitEntity = RenderMap.LIMIT_X * RenderMap.LIMIT_Y;
            entityList = new ArrayList<>(limitEntity);
            entityList.add(new Herbivore());
            entityList.add(new Hunter());
            entityList.add(new Grass());
            while (limitEntity - entityList.size() != 0) {
                entityList.add(new Ground());
            }
        }

        public void turnActions() {

        }

        public List<Entity> getEntityList() {
            return entityList;
        }

        public void setEntityList(List<Entity> entityList) {
            this.entityList = entityList;
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
