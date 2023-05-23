package Board;

import java.util.List;

import Coordinate.Coordinate;
import Sector.Sector;

public class Board {
    private int size;
    private Sector[][] board;
    // creates a List of coordinates

    private List<Coordinate> restrictedSectors;

    private Coordinate[] restrictedSectors;
    private int restrictedSectorsCount;

    public Board(int size) {
        this.setSize(size);
        this.setRestrictedSectorsCount(4);
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

    public Coordinate[] getRestrictedSectors() {
        return this.restrictedSectors;
    }

    public int getRestrictedSectorsCount() {
        return this.restrictedSectorsCount;
    }

    // setters
    public void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be positive");
        this.size = size;
        return;
    }

    public void setRestrictedSectorsCount(int restrictedSectorsCount) {
        if (restrictedSectorsCount < 0)
            throw new IllegalArgumentException("Restricted sectors count must be positive");
        this.restrictedSectorsCount = restrictedSectorsCount;
        return;
    }

    public void setRestrictedSectors() {
        int restrictedSectorsCount = this.getRestrictedSectorsCount();
        this.restrictedSectors = new Coordinate[restrictedSectorsCount];

        // create the restricted sectors
        for (int i = 0; i < restrictedSectorsCount; i++) {
            // randomnly generate two numbers between 0 and 9
            int iCoordinate = (int) (Math.random() * 10);
            int jCoordinate = (int) (Math.random() * 10);
            this.restrictedSectors[i] = new Coordinate(iCoordinate, jCoordinate);
        }
        return;
    }

    public void setBoard() {
        size = this.getSize();
        this.board = new Sector[size][size];

        // create the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                
                if ()

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
