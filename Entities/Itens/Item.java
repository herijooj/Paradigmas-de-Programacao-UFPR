package Entities.Itens;

import Entities.Coordinate;
import Entities.Entity;
import Entities.Beings.*;
import Board.*;

// class
public abstract class Item extends Entity {
    // attributes
    protected Coordinate position;

    // constructor
    public Item(Coordinate position) {
        super(position);
    }

    // getters
    public Coordinate getPosition() {
        return this.position;
    }

    // setters
    public void setPosition(Coordinate position) {
        this.position = position; // não precisa fazer nenhuma verificação pois a classe 'Coordenada' já verifica
    }

    // methods
    public abstract void itemAbility(Board board, Player player);

}
