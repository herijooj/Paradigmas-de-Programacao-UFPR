package Board;

// imports 
import java.util.*;
import Entities.*;
import Entities.Beings.*;
import Board.Sector;

// class
public class Board {
    private int size;
    private Sector[][] board;

    private LinkedList<Coordinate> restrictedSectors;
    private int restrictedSectorsCount;

    private LinkedList<FakeNews> listaFakeNews;
    private int fakeNewsMax = 6;

    public Board(int size) {
        this.setSize(size);
        this.setRestrictedSectorsCount(4);
        this.setRestrictedSectors();
        this.setFakeNews();
        this.setBoard();
    }

    // getters
    public int getSize() {
        return this.size;
    }

    public Sector[][] getBoard() {
        return this.board;
    }

    public LinkedList<Coordinate> getRestrictedSectors() {
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
        this.restrictedSectors = new LinkedList<Coordinate>();
        int iC, jC, i, j;
        boolean hasEqualCoordinate = false;
        Coordinate newCoordinate;

        // create the restricted sectors
        for (i = 0; i < this.restrictedSectorsCount; i++) {
            // randomnly generate two numbers between 0 and 8
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set
            for (j = 0; j < i; j++) 
            {
                if (newCoordinate.getI() == this.restrictedSectors.get(j).getI() && newCoordinate.getJ() == this.restrictedSectors.get(j).getJ()) 
                {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            if (!hasEqualCoordinate)
                this.restrictedSectors.add(newCoordinate);
            else
                i--;

            hasEqualCoordinate = false;
        }
    }

    public void setFakeNews() {
        int i, x, j, iC, jC;
        boolean hasEqualCoordinate = false;
        Coordinate newCoordinate;
        this.listaFakeNews = new LinkedList<FakeNews>();
        int F1Quantity = 0, F2Quantity = 0, F3Quantity = 0;

        // Create the F1
        for (i = 0; i < this.fakeNewsMax; i++) {
            // randomnly generate two coordinates
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set as a restricted sector
            for (j = 0; j < this.getRestrictedSectorsCount(); j++) 
            {
                if (newCoordinate.getI() == this.restrictedSectors.get(j).getI() && newCoordinate.getJ() == this.restrictedSectors.get(j).getJ()) 
                {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            // Now as a fake news
            for (j = 0; j < i; j++) 
            {
                if (newCoordinate.getI() == this.listaFakeNews.get(j).getPosition().getI() 
                && newCoordinate.getJ() == this.listaFakeNews.get(j).getPosition().getJ()) 
                {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            if (!hasEqualCoordinate) {
                if (F1Quantity < 2) {
                    this.listaFakeNews.add(new F1(newCoordinate));
                    F1Quantity++;
                } else if (F1Quantity == 2 && F2Quantity < 2) {
                    this.listaFakeNews.add(new F2(newCoordinate));
                    F2Quantity++;
                } else {
                    this.listaFakeNews.add(new F3(newCoordinate));
                    F3Quantity++;
                }
            } else
                i--;

            hasEqualCoordinate = false;
        }
    }

    public void setBoard() {
        this.board = new Sector[this.size][this.size];
        //boolean isRestricted = false;
        //String whichFN = "";
        String sectorState = "";

        // Set the restricted ones to the board
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                // Set the restricted sectors
                for (int x = 0; x < this.restrictedSectorsCount; x++) {
                    if (i == this.restrictedSectors.get(x).getI() && j == this.restrictedSectors.get(x).getJ()) {
                        //isRestricted = true;
                        sectorState = "Restricted";
                        break;
                    }
                }

                // Set the Fake News
                for (int x = 0; x < this.fakeNewsMax; x++) {
                    if (i == this.listaFakeNews.get(x).getPosition().getI() && j == this.listaFakeNews.get(x).getPosition().getJ()) {
                        if ( this.listaFakeNews.get(x) instanceof F1)
                           //whichFN = "F1";
                           sectorState = "F1";
                        else if ( this.listaFakeNews.get(x) instanceof F2)
                            //whichFN = "F2";
                            sectorState = "F2";
                        else
                            //whichFN = "F3";
                            sectorState = "F3";

                        break;
                    }
                }

                this.board[i][j] = new Sector(i, j, sectorState);
                //isRestricted = false;
                sectorState = "";
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
            if (board[i][0].getSectorState() == "Restricted")
                System.out.printf("| XX |");
            else if (board[i][0].getSectorState() == "F1")
                System.out.printf("| F1 |");
            else if (board[i][0].getSectorState() == "F2")
                System.out.printf("| F2 |");
            else if (board[i][0].getSectorState() == "F3")
                System.out.printf("| F3 |");
            else
                System.out.printf("|    |");

            // draw the rest of the board
            for (int j = 1; j < size; j++) {
                if (board[i][j].getSectorState() == "Restricted")
                    System.out.printf(" XX |");
                else if (board[i][j].getSectorState() == "F1")
                    System.out.printf(" F1 |");
                else if (board[i][j].getSectorState() == "F2")
                    System.out.printf(" F2 |");
                else if (board[i][j].getSectorState() == "F3")
                    System.out.printf(" F3 |");
                else
                    System.out.printf("    |");
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
