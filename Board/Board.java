package Board;

// imports 
import java.util.*;
import Entities.*;
import Entities.Beings.*;
import Entities.Itens.*;
import Board.Sector;

// class
public class Board {
    private int size;
    private Sector[][] board;

    private LinkedList<Coordinate> listaRestrictedSectors;
    private int restrictedSectorsMax = 4;

    private LinkedList<FakeNews> listaFakeNews;
    private int fakeNewsMax = 6;

    private LinkedList<ItemCharacteristics> listaItens;
    private int itemMax = 2;

    public Board(int size) {
        this.setSize(size);
        this.setRestrictedSectorsMax(4);
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
        return this.listaRestrictedSectors;
    }

    public LinkedList<FakeNews> getFakeNews() {
        return this.listaFakeNews;
    }

    public LinkedList<ItemCharacteristics> getItens() {
        return this.listaItens;
    }

    public int getRestrictedSectorsMax() {
        return this.restrictedSectorsMax;
    }

    public int getFakeNewsMax() {
        return this.fakeNewsMax;
    }

    public int getItensMax() {
        return this.itemMax;
    }

    // setters
    public void setSize(int size) {
        if (size < 0)
            throw new IllegalArgumentException("Size must be positive");
        this.size = size;
        return;
    }

    public void setRestrictedSectorsMax(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Restricted sectors count must be positive");
        this.restrictedSectorsMax = number;
        return;
    }

    public void setRestrictedSectors() {
        this.listaRestrictedSectors = new LinkedList<Coordinate>();
        this.listaFakeNews = new LinkedList<FakeNews>();
        this.listaItens = new LinkedList<ItemCharacteristics>();

        int iC, jC, i;
        Coordinate newCoordinate;

        // create the restricted sectors
        for (i = 0; i < this.restrictedSectorsMax; i++) {
            // randomnly generate two numbers between 0 and 8
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            if (!hasEqualCoordinate(newCoordinate))
                this.listaRestrictedSectors.add(newCoordinate);
            else
                i--;
        }
    }

    public void setFakeNews() {
        int i, iC, jC;
        Coordinate newCoordinate;
        int F1Quantity = 0, F2Quantity = 0, F3Quantity = 0;

        // Create the Fake News
        for (i = 0; i < this.fakeNewsMax; i++) {
            // randomnly generate two coordinates
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            if (!hasEqualCoordinate(newCoordinate)) {
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
            } 
            else
                i--;
        }
    }

    /*
    public void setItens()
    {
        int i, x, j, iC, jC;
        boolean hasEqualCoordinate = false;
        Coordinate newCoordinate;
        this.listaItens = new LinkedList<ItemCharacteristics>();

        for (i = 0; i < this.itemMax; i++) 
        {
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // To check if the coordinate it's not already set as a restricted sector
            /*
            for (j = 0; j < this.getRestrictedSectorsCount(); j++) 
            {
                if (newCoordinate.getI() == this.restrictedSectors.get(j).getI() && newCoordinate.getJ() == this.restrictedSectors.get(j).getJ()) 
                {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            // Now as an fake news
            for (j = 0; j < i; j++) 
            {
                if (newCoordinate.getI() == this.listaFakeNews.get(j).getPosition().getI() 
                && newCoordinate.getJ() == this.listaFakeNews.get(j).getPosition().getJ()) 
                {
                    hasEqualCoordinate = true;
                    break;
                }
            }

            // And as an Item

            if (!hasEqualCoordinate(newCoordinate)) {

                // TODO - GERAR UM NUMERO ALEATORIO DE 0 A 3, DEPENDENDO
                // DO RESULTADO, VAI GERAR O ITEM RELACIONADO A ESSE 
                // NUMERO, COMO DAS FAKE NEWS (F1, F2, F3), fui pra otimizacao
            } 
            else
                i--;
        }
    }
    */

    public void setBoard() {
        this.board = new Sector[this.size][this.size];
        String sectorState = "";

        // Set the restricted ones to the board
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                // Set the restricted sectors
                for (int x = 0; x < this.restrictedSectorsMax; x++) {
                    if (i == this.listaRestrictedSectors.get(x).getI() && j == this.listaRestrictedSectors.get(x).getJ()) {
                        sectorState = "Restricted";
                        break;
                    }
                }

                // Set the Fake News
                for (int x = 0; x < this.fakeNewsMax; x++) {
                    if (i == this.listaFakeNews.get(x).getPosition().getI() && j == this.listaFakeNews.get(x).getPosition().getJ()) {
                        if ( this.listaFakeNews.get(x) instanceof F1)
                           sectorState = "F1";
                        else if ( this.listaFakeNews.get(x) instanceof F2)
                            sectorState = "F2";
                        else
                            sectorState = "F3";

                        break;
                    }
                }

                this.board[i][j] = new Sector(i, j, sectorState);
                sectorState = "";
            }
        }
    }

    // methods

    private boolean hasEqualCoordinate(Coordinate coordinate)
    {
        int j;

        // Check if it has the same coordinate as a restricted sector
        for (j = 0; j < this.listaRestrictedSectors.size(); j++) 
            if (coordinate.getI() == this.listaRestrictedSectors.get(j).getI() && coordinate.getJ() == this.listaRestrictedSectors.get(j).getJ()) 
                return true;

        // Check if it has the same coordinate as a fake news
            for (j = 0; j < this.listaFakeNews.size(); j++) 
                if (coordinate.getI() == this.listaFakeNews.get(j).getPosition().getI() && coordinate.getJ() == this.listaFakeNews.get(j).getPosition().getJ()) 
                    return true;

        // And check if it has the same coordinate as an item
            for (j = 0; j < this.listaItens.size(); j++) 
                if (coordinate.getI() == this.listaItens.get(j).getPosition().getI() && coordinate.getJ() == this.listaItens.get(j).getPosition().getJ()) 
                    return true;

        // If it got here, means there's no repeated coordinate so far
        return false;
    }

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
