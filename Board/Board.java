package Board;

// imports 
import java.util.List;
import Entities.*; // adicionei pra importar as entidades - amaral
import Board.Sector;

// class
public class Board {
    private int size;
    private Sector[][] board;
    // creates a List of coordinates

    //private List<Coordinate> restrictedSectors;

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

    public void setRestrictedSectors() 
    {
        int restrictedSectorsCount = this.getRestrictedSectorsCount();
        this.restrictedSectors = new Coordinate[restrictedSectorsCount];
        int iC, jC, i, j;
        boolean hasEqualC = false;
        Coordinate newC;

        // create the restricted sectors
        for (i = 0; i < restrictedSectorsCount; i++) 
        {
            // randomnly generate two numbers between 0 and 8
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newC = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set
            for (j = 0; j < i; j++)
            {
                if (newC.getI() == this.restrictedSectors[j].getI() && newC.getJ() == this.restrictedSectors[j].getJ())
                {
                    hasEqualC = true;
                    break;
                }
            }

            if (!hasEqualC)
                this.restrictedSectors[i] = newC;
            else
                i--;

            hasEqualC = false;
        }
    }

    public void setBoard() {
        size = this.getSize();
        this.board = new Sector[size][size];
        boolean isRestricted = false;

        // create the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                for (int x = 0; x < this.restrictedSectorsCount; x++) {
                    if (i == this.restrictedSectors[x].getI() && j == this.restrictedSectors[x].getJ()) {
                        isRestricted = true;
                        break;
                    }
                }
                this.board[i][j] = new Sector(i, j, isRestricted);
                isRestricted = false;
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
