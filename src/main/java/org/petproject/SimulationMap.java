package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Hunter;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Ground;
import org.petproject.entity.staticEntity.Rock;
import org.petproject.entity.staticEntity.Tree;

import java.util.*;

public class SimulationMap {
    private RenderMap renderMap;
    private List<Entity> entityList;
    private Map<Coordinate, Entity> map = new TreeMap<>();


    //todo добавить существ
    public void addEntityToList() {
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

    public void addEntityOnMap() {
      //  long seed = 12346L;
        //  Random random = new Random(seed);
        Collections.shuffle(entityList);
        int count = 0;
        for (int i = 0; i < RenderMap.LIMIT_X; i++) {
            for (int j = 0; j < RenderMap.LIMIT_Y; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                map.put(coordinate, entityList.get(count));
                entityList.get(count).setCoordinate(coordinate);
                // todo есть ли тут проблемы? Нужно ли убрать строчку 23 и заменить ее
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
