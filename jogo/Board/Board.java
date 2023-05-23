package Board;

import Coordinate.Coordinate;
import Sector.Sector;

public class Board {
    private int size;
    private Sector[][] board;
    private Coordinate[] restrictedSectors;

    public Board(int size) {
        this.setSize(size);
        this.setRestrictedSectors();
        this.setBoard();
    }

    // getters
    public int getSize() {
        return this.size;
    }

    public Sector[][] getBoard() {
        return this.board;
    }

    public int getRestrictedSectors() {
        return this.restrictedSectorsCount;
    }
    // setters

    public void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be positive");
        this.size = size;
        return;
    }

    public void setRestrictedSectors() {
        this.restrictedSectorsCount = (int) Math.floor(Math.pow(this.getSize(), 2) / 3);
        return;
    }

    public void setBoard() {
        size = this.getSize();
        this.board = new Sector[size][size];

        // create the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isRestricted = false;
                this.board[i][j] = new Sector(i, j, isRestricted);
            }
        }
    }
    // methods

    public void drawBoard() {
        size = this.getSize();
        board = this.getBoard();

        // draw the board
        for (int i = 0; i < size; i++) {
            // draw the top and bottom of the board
            if (i == 0 || i == size) {
                System.out.print("+----+");
                for (int j = 1; j < size; j++) {
                    System.out.print("----+");
                }
                System.out.println();
            }

            // draw the first side of the board
            System.out.printf("| %s |", board[i][0].isRestricted() ? "XX" : "  ");

            // draw the rest of the board
            for (int j = 1; j < size; j++) {
                System.out.printf(" %s |", board[i][j].isRestricted() ? "XX" : "  ");
            }

            System.out.println();
            System.out.print("+----+");

            // draw the bottom of the board
            for (int j = 1; j < size; j++) {
                System.out.print("----+");
            }
            System.out.println();

        }
    }

}
