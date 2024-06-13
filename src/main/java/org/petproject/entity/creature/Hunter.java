package org.petproject.entity.creature;

public class Hunter extends Creature {
    public int attackPower = 5;

    public Hunter() {
        hp = 20;
        speed = 2;
    }

    public void attack() {

    }

    @Override
    public void makeMove() {

    }

    @Override
    public String toString() {
        return "🐺";
    }
}
