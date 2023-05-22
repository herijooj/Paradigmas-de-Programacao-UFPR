package Board;

import Sector.*;

public class Board {
    private int size;
    private Sector[][] board;

    public Board(int size) {
        this.setSize(size);
        this.setBoard(new Sector[size][size]);
    }

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
        this.board = new Sector[size][size];
    }

    public void drawBoard() {
        for (int i = 0; i < this.getSize(); i++) {
            if (i == 0)
                System.out.print("+----+");
            for (int j = 0; j < this.getSize(); j++) {
                System.out.print("\t+----+");
            }
            System.out.println();
            
            for (int j = 0; j < this.getSize(); j++) {
                if (j == 0)
                    System.out.print("|    |");
                else
                    System.out.print("\t|");
            }

            System.out.print("+----+");
            System.out.println();
        }
    }

}
