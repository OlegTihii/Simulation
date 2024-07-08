package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Rock;
import org.petproject.entity.staticEntity.Tree;

import java.util.*;

public class BreadthFirstSearchAlgorithm {

    //todo нормально ли возвращать Optional или можно оставить List.
    public Optional<ArrayDeque<Coordinate>> findPath(RenderMap map, Creature creature) {
        Queue<Coordinate> queue = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parent = new HashMap<>();

        queue.add(creature.getCoordinate());
        visited.add(creature.getCoordinate());

        int[] arrX = {-1, 1, 0, 0};
        int[] arrY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            Entity entity = map.getRenderMap().get(current);

            if (entity instanceof Grass) {
                return Optional.of(constructPath(parent, creature.getCoordinate(), current));
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + arrX[i];
                int newY = current.y + arrY[i];
                Coordinate newCoordinate = new Coordinate(newX, newY);

                if (newX >= 0 && newX < RenderMap.LIMIT_X
                        && newY >= 0 && newY < RenderMap.LIMIT_Y
                        && !(entity instanceof Rock)
                        && !(entity instanceof Tree)
//                        && !(entity instanceof Herbivore)
//                        && !(entity instanceof Hunter)
                        && !visited.contains(newCoordinate)) {
                    queue.add(newCoordinate);
                    visited.add(newCoordinate);
                    parent.put(newCoordinate, current);
                }
            }
        }

        return Optional.empty();
    }

    //todo может стоит возвращать null вместо new ArrayDeque<>()
    private ArrayDeque<Coordinate> constructPath(Map<Coordinate, Coordinate> parent, Coordinate start, Coordinate end) {
        ArrayDeque<Coordinate> path = new ArrayDeque<>();
        Coordinate temp = end;
        while (temp != null) {
            path.addFirst(temp);
            temp = parent.get(temp);
        }

        if (path.getFirst().equals(start)) {
            return path;
        }

        return new ArrayDeque<>();
    }
}