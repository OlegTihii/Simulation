package org.petproject.entity.creature;

import org.petproject.entity.Entity;

public abstract class Creature extends Entity {
    public int hp;
    public int speed;

    abstract public void makeMove();

}
