package org.petproject;

import org.petproject.entity.Entity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RenderMap {

    public static final int LIMIT_X = 20;
    public static final int LIMIT_Y = 20;

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

    public void printMap() {
        String result = map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getKey().x,
                        TreeMap::new,
                        Collectors.mapping(
                                entry -> entry.getValue().toString(),
                                Collectors.joining("")
                        )
                ))
                .values().stream()
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }
}
