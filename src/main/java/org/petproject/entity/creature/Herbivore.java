package org.petproject.entity.creature;

import org.petproject.Coordinate;

import java.util.ArrayDeque;
import java.util.Optional;

public class Herbivore extends Creature {

    public void eatGrass() {

    }

    @Override
    public void makeMove() {
        /*
         * 1. Получаем свою координату (Она у нас есть в очереди)
         * 2. Берем следующую координату из очереди
         * 3. Переписываем Координату:
         *   -Entity.coordinate
         * 4. Заполниться освободившуюся координату Ground
         *
         *
         *  */


    }


    @Override
    public String toString() {
        return "🐇";
    }

}
