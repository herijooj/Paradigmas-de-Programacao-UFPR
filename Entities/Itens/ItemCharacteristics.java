package Entities.Itens;

import Entities.Coordinate;
import Entities.Entity;

// class
public abstract class ItemCharacteristics extends Entity {

    // attributes

    // constructor
    public ItemCharacteristics(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    public abstract void itemAbility();

}