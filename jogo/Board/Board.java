package Board;

import Sector.Sector;

public class Board {
    private int size;
    private Sector[][] board;

    public Board(int size) {
        this.setSize(size);
        this.setBoard();
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

    public void setBoard() {
        size = this.getSize();
        System.out.println(size);
        this.board = new Sector[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s %s\n", i, j);
                this.board[i][j] = new Sector(i, j);
            }
        }
    }

    public void drawBoard() {
        size = this.getSize();
        board = this.getBoard();
        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size) {
                System.out.print("+----+");
                for (int j = 0; j < size; j++) {
                    System.out.print("----+");
                }
                System.out.println();
            }

            // if the sector is restricted draw a restricted sector
            // else draw the player inside it

            System.out.printf("| %s |", board[i][0].isRestricted() ? "XX" : "JJ");
            for (int j = 0; j < size; j++) {
                System.out.printf(" %s |", board[i][j].isRestricted() ? "XX" : "JJ");
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
