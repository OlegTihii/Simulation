package org.petproject.entity.creature;

public class Herbivore extends Creature {

    public Herbivore(){
       hp = 10;
       speed = 1;
    }

    public void eatGrass() {

    }

    @Override
    public void makeMove() {
    }

    @Override
    public String toString() {
        return "🐇";
    }

}
