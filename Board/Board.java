package Board;

// imports 
import java.util.List;
import Entities.*; // adicionei pra importar as entidades - amaral
//import Entities.Beings.F1;
//import Entities.Beings.FakeNews;
import Entities.Beings.*;
import Board.Sector;

// class
public class Board {
    private int size;
    private Sector[][] board;
    private Coordinate[] restrictedSectors;
    private FakeNews[] fakeNews;
    private int restrictedSectorsCount;

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

    public Coordinate[] getRestrictedSectors() {
        return this.restrictedSectors;
    }

    public FakeNews[] getFakeNews() {
        return this.fakeNews;
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
        int iC, jC, i, j;
        boolean hasEqualCoordinate = false;
        Coordinate newCoordinate;

        // create the restricted sectors
        for (i = 0; i < restrictedSectorsCount; i++) {
            // randomnly generate two numbers between 0 and 8
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set
            for (j = 0; j < i; j++) {
                if (newCoordinate.getI() == this.restrictedSectors[j].getI()
                        && newCoordinate.getJ() == this.restrictedSectors[j].getJ()) {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            if (!hasEqualCoordinate)
                this.restrictedSectors[i] = newCoordinate;
            else
                i--;

            hasEqualCoordinate = false;
        }
    }

    public void setFakeNews() {
        int i, j, iC, jC;
        boolean hasEqualCoordinate = false;
        Coordinate newCoordinate;
        this.fakeNews = new FakeNews[6];
        int F1Qnt = 0, F2Qnt = 0, F3Qnt = 0;

        // Create the F1
        for (i = 0; i < 6; i++) {
            // randomnly generate two coordinates
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set
            for (j = 0; j < this.getRestrictedSectorsCount(); j++) {
                if (newCoordinate.getI() == this.restrictedSectors[j].getI()
                        && newCoordinate.getJ() == this.restrictedSectors[j].getJ()) {
                    hasEqualCoordinate = true;
                    // System.out.println("equal");
                    break;
                }

                // AINDA PRECISA CHECAR SE A COORDENADA N É A MESMA POSICAO DE OUTRA FAKE NEWS
            }

            if (!hasEqualCoordinate) {
                if (F1Qnt < 2) {
                    this.fakeNews[i] = new F1(newCoordinate);
                    F1Qnt++;
                } else if (F1Qnt == 2 && F2Qnt < 2) {
                    this.fakeNews[i] = new F2(newCoordinate);
                    F2Qnt++;
                } else {
                    this.fakeNews[i] = new F3(newCoordinate);
                    F3Qnt++;
                }
            } else
                i--;

            hasEqualCoordinate = false;
        }
    }

    public void setBoard() {
        size = this.getSize();
        this.board = new Sector[size][size];
        boolean isRestricted = false;
        String whichFN = "";

        // Set the restricted ones to the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Set the restricted sectors
                for (int x = 0; x < this.restrictedSectorsCount; x++) {
                    if (i == this.restrictedSectors[x].getI() && j == this.restrictedSectors[x].getJ()) {
                        isRestricted = true;
                        break;
                    }
                }

                // Set the Fake News
                for (int x = 0; x < 6; x++) {
                    if (i == this.fakeNews[x].getPosition().getI() && j == this.fakeNews[x].getPosition().getJ()) {
                        if (this.fakeNews[x] instanceof F1)
                            whichFN = "F1";
                        else if (this.fakeNews[x] instanceof F2)
                            whichFN = "F2";
                        else
                            whichFN = "F3";

                        break;
                    }
                }

                this.board[i][j] = new Sector(i, j, isRestricted, whichFN);
                isRestricted = false;
                whichFN = "";
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
            // System.out.printf("| %s |", board[i][0].isRestricted() ? "XX" : " ");

            if (board[i][0].isRestricted())
                System.out.printf("| XX |");
            else if (board[i][0].getWhichFN() == "F1")
                System.out.printf("| F1 |");
            else if (board[i][0].getWhichFN() == "F2")
                System.out.printf("| F2 |");
            else if (board[i][0].getWhichFN() == "F3")
                System.out.printf("| F3 |");
            else
                System.out.printf("|    |");

            // draw the rest of the board
            for (int j = 1; j < size; j++) {
                if (board[i][j].isRestricted())
                    System.out.printf(" XX |");
                else if (board[i][j].getWhichFN() == "F1")
                    System.out.printf(" F1 |");
                else if (board[i][j].getWhichFN() == "F2")
                    System.out.printf(" F2 |");
                else if (board[i][j].getWhichFN() == "F3")
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
