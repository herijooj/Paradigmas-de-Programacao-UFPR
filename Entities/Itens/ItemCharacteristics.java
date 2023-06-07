package Entities.Itens;

import Entities.Coordinate;
import Entities.Entity;
import Entities.Beings.*;
import Board.*;

// class
public abstract class ItemCharacteristics extends Entity {
    // attributes
    protected Coordinate position;

    // constructor
    public ItemCharacteristics(Coordinate position) {
        super(position);
    }

    // getters
    public Coordinate getPosition() {
        return this.position;
    }

    // setters
    // não precisa fazer nenhuma verificação pois a classe 'Coordenada' já verifica
    public void setPosition(Coordinate position) {
        this.position = position;
    }

    // methods
    public abstract void itemAbility(Board board, Player player);

}
