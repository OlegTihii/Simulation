package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.staticEntity.Ground;

import java.util.Map;
import java.util.TreeMap;

public class RenderMap {

    public static final int LIMIT_X = 20;
    public static final int LIMIT_Y = 20;

    public Map<Coordinate, Entity> map = new TreeMap<>();

    public void fullingMap() {
        for (int i = 0; i < RenderMap.LIMIT_X; i++) {
            for (int j = 0; j < RenderMap.LIMIT_Y; j++) {
                map.put(new Coordinate(i, j), new Ground());
            }
        }
    }

    public void printMap() {
        System.out.println(map.keySet());
    }
}
