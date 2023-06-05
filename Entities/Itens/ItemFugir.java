package Entities.Itens;

import java.util.Scanner;
import Entities.Coordinate;
import Entities.Beings.Player;
import Board.Sector;

// class
public class ItemFugir extends ItemCharacteristics {

    // attributes

    // constructor
    public ItemFugir(Coordinate position) {
        super(position);
    }

    // getters

    // setters

    // methods
    public void itemAbility(Sector[][] board, Player player) {
        // Move o jogador para uma posição da E/S
        Scanner input = new Scanner(System.in);

        System.out.println("move to wich position? (i, j)");
        int i = input.nextInt();
        int j = input.nextInt();

        player.move(board, i, j);

        input.close();
    }

    public void draw() {
        // TODO
    }
}