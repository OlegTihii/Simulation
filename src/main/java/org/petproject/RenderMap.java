package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.staticEntity.Ground;

import java.util.*;

public class RenderMap {

    public static final int LIMIT_X = 10;
    public static final int LIMIT_Y = 10;

    public Map<Coordinate, Entity> map = new TreeMap<>();

    public void addEntityOnMap(List<Entity> entityList) {
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

    public void changeCoordinateForCreature() {
        for(Map.Entry<Coordinate,Entity> mapEntry : map.entrySet()){
          if(mapEntry.getValue() instanceof Creature creature){
              map.put(mapEntry.getKey(), new Ground());
              map.put(creature.getCoordinate(), creature);
          }
        }
    }

    public void printMap() {
        StringBuilder result = new StringBuilder();

        for (int y = 0; y < LIMIT_Y; y++) {
            for (int x = 0; x < LIMIT_X; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                result.append(map.get(coordinate));
                if (x == LIMIT_X - 1) {
                    result.append("\n");
                }
            }
        }
        System.out.println(result);
        System.out.println("==========");
    }

    public Map<Coordinate, Entity> getRenderMap() {
        return map;
    }

    public void setRenderMap(Map<Coordinate, Entity> map) {
        this.map = map;
    }
}
