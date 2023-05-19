package jogo.Board;

import jogo.Sector.Sector;

public class Board {
    private int size;
    private Sector board[][];

    public Board(int size) {
        this.setSize(size);
        this.setBoard(new Sector[size][size]);

    // getters
    public int getSize() {
        return this.size;
    }

    public Sector[][] getBoard() {
        return this.board;
    }

    // setters

    public void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be positive");
        this.size = size;
        return;
    }

    public void setBoard(Sector[][] board) {
        this.board = board;
    }

    public void desenhaTabuleiro() {
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++)
                System.out.print(this.getBoard()[i][j].draw());
            System.out.println();
    }
}
