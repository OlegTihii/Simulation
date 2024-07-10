package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Predator;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Ground;
import org.petproject.entity.staticEntity.Rock;
import org.petproject.entity.staticEntity.Tree;

import java.util.*;

public class SimulationMap {
    private List<Entity> entityList;
    private Map<Coordinate, Entity> map = new TreeMap<>();

    public void addEntityToList() {
        int limitEntity = RenderMap.LIMIT_X * RenderMap.LIMIT_Y;
        entityList = new ArrayList<>(limitEntity);
        for (int i = 0; i < limitEntity / 20; i++) {
            entityList.add(new Herbivore());
        }
        for (int i = 0; i < limitEntity / 80; i++) {
            entityList.add(new Predator());
        }
        for (int i = 0; i < limitEntity / 10; i++) {
            entityList.add(new Grass());
        }
        for (int i = 0; i < limitEntity / 40; i++) {
            entityList.add(new Rock());
        }
        for (int i = 0; i < limitEntity / 5; i++) {
            entityList.add(new Tree());
        }
        while (limitEntity - entityList.size() != 0) {
            entityList.add(new Ground());
        }
    }

    public void addEntityOnMap() {
        Collections.shuffle(entityList);
        int count = 0;
        for (int i = 0; i < RenderMap.LIMIT_X; i++) {
            for (int j = 0; j < RenderMap.LIMIT_Y; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                map.put(coordinate, entityList.get(count));
                entityList.get(count).setCoordinate(coordinate);
                // todo есть ли тут проблемы? Нужно ли убрать строчку 46 и заменить ее
                //  map.put(new Coordinate(i,j), entityList.get(count));
                count++;
            }
        }
    }

    public void deleteEntity(Coordinate coordinate) {
        Entity deletedEntity = map.put(coordinate, new Ground());
        entityList.set(entityList.indexOf(deletedEntity), new Ground());
    }

    public void changeCoordinateForCreature() {
        for (Map.Entry<Coordinate, Entity> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() instanceof Creature creature) {
                map.put(mapEntry.getKey(), new Ground());
                map.put(creature.getCoordinate(), creature);
            }
        }
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public Map<Coordinate, Entity> getMap() {
        return map;
    }
}
