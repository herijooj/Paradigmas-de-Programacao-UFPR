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
        size = this.getSize();
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size) {
                System.out.print("+----+");
                for (int j = 0; j < size; j++) {
                    System.out.print("----+");
                }
                System.out.println();
            }
            System.out.print("|    |");
            for (int j = 0; j < size; j++) {
                System.out.print("    |");
            }
            System.out.println();
            System.out.print("+----+");
            for (int j = 0; j < size; j++) {
                System.out.print("----+");
            }
            System.out.println();

        }
    }
}
