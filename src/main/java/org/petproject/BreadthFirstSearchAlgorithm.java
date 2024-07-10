package org.petproject;

import org.petproject.entity.Entity;
import org.petproject.entity.creature.Creature;
import org.petproject.entity.creature.Herbivore;
import org.petproject.entity.creature.Predator;
import org.petproject.entity.staticEntity.Grass;
import org.petproject.entity.staticEntity.Ground;

import java.util.*;

public class BreadthFirstSearchAlgorithm {

    //todo нормально ли возвращать Optional или можно оставить List.
    public Optional<ArrayDeque<Coordinate>> findPath(Map<Coordinate, Entity> map, Creature creature) {
        Queue<Coordinate> queue = new LinkedList<>();
        Set<Coordinate> visited = new HashSet<>();
        Map<Coordinate, Coordinate> parent = new HashMap<>();

        queue.add(creature.getCoordinate());
        visited.add(creature.getCoordinate());

        int[] arrX = {-1, 1, 0, 0};
        int[] arrY = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            Entity entity = map.get(current);

            if (creature instanceof Herbivore && entity instanceof Grass) {
                return Optional.of(constructPath(parent, creature.getCoordinate(), current));
            } else if (creature instanceof Predator && entity instanceof Herbivore) {
                return Optional.of(constructPath(parent, creature.getCoordinate(), current));
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + arrX[i];
                int newY = current.y + arrY[i];
                Coordinate newCoordinate = new Coordinate(newX, newY);

                //todo По мне выглядит коряво
                if (isFirstCoordinate(entity, creature) || (
                        isValidCoordinate(newX, newY)
                                && canMoveTo(entity, creature)
                                && !visited.contains(newCoordinate))) {
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
            path.removeFirst(); //todo костыль, чтобы путь начинался не со своей нынешней координаты
            return path;
        }

        return new ArrayDeque<>();
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < RenderMap.LIMIT_X
                && y >= 0 && y < RenderMap.LIMIT_Y;
    }

    private boolean isFirstCoordinate(Entity entity, Creature creature) {
        //  return entity == creature;
          /*todo почему не работает с методом equals(), хотя я его не переопределил, он должен сравнивать ссылки.
          '==' отрабатывает
        */
        if (entity == null) {
            return false;
        }
        return entity.equals(creature);
    }

    public boolean canMoveTo(Entity entity, Creature creature) {
        if (creature instanceof Herbivore) {
            return (entity instanceof Ground);
        } else if (creature instanceof Predator) {
            return entity instanceof Ground || entity instanceof Grass;
        } else {
            return false;
        }
    }
}