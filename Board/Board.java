package Board;

// imports 
import java.util.*;
import Entities.*;
import Entities.Beings.*;
import Entities.Itens.*;
import Board.Sector;
import Entities.Beings.*;

import java.awt.Component;
import java.awt.event.KeyEvent;

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
        this.setItens();
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
            } else
                i--;
        }
    }

    public void setItens() {
        int i, itemNum, iC, jC;
        Coordinate newCoordinate;

        for (i = 0; i < this.itemMax; i++) {
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            if (!hasEqualCoordinate(newCoordinate)) {
                itemNum = (int) (Math.random() * 4);

                if (itemNum == 0)
                    this.listaItens.add(new ItemBoato(newCoordinate));
                else if (itemNum == 1)
                    this.listaItens.add(new ItemDenunciar(newCoordinate));
                else if (itemNum == 2)
                    this.listaItens.add(new ItemFugir(newCoordinate));
                else
                    this.listaItens.add(new ItemLer(newCoordinate));
            } else
                i--;
        }
    }

    public void setBoard() {
        this.board = new Sector[this.size][this.size];

        // Set the restricted ones to the board
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < this.size; j++)
                setEntityToSector(i, j);
    }

    // methods

    // Helper method used to define the entities positions
    private boolean hasEqualCoordinate(Coordinate coordinate) {
        // this method checks if the coordinate is already in use
        // by another entity
        // if it is, it returns true

        int j;

        // Check if it has the same coordinate as a restricted sector
        for (j = 0; j < this.listaRestrictedSectors.size(); j++)
            if (coordinate.getI() == this.listaRestrictedSectors.get(j).getI()
                    && coordinate.getJ() == this.listaRestrictedSectors.get(j).getJ())
                return true;

        // Check if it has the same coordinate as a fake news
        for (j = 0; j < this.listaFakeNews.size(); j++)
            if (coordinate.getI() == this.listaFakeNews.get(j).getPosition().getI()
                    && coordinate.getJ() == this.listaFakeNews.get(j).getPosition().getJ())
                return true;

        // And check if it has the same coordinate as an item
        for (j = 0; j < this.listaItens.size(); j++)
            if (coordinate.getI() == this.listaItens.get(j).getPosition().getI()
                    && coordinate.getJ() == this.listaItens.get(j).getPosition().getJ())
                return true;

        // If it got here, means there's no repeated coordinate so far
        return false;
    }

    // Helper method used in the setBoard method
    private void setEntityToSector(int i, int j) {
        String sectorState = "";

        // Verify if it is restricted
        for (int x = 0; x < this.restrictedSectorsMax; x++) {
            if (i == this.listaRestrictedSectors.get(x).getI() && j == this.listaRestrictedSectors.get(x).getJ()) {
                sectorState = "Restricted";
                break;
            }
        }

        // Verify if it is a FakeNews
        if (sectorState == "") {
            for (int x = 0; x < this.fakeNewsMax; x++) {
                int iFakeNews = this.listaFakeNews.get(x).getPosition().getI();
                int jFakeNews = this.listaFakeNews.get(x).getPosition().getJ();
                if (i == iFakeNews && j == jFakeNews) {
                    if (this.listaFakeNews.get(x) instanceof F1)
                        sectorState = "F1";
                    else if (this.listaFakeNews.get(x) instanceof F2)
                        sectorState = "F2";
                    else
                        sectorState = "F3";

                    break;
                }
            }
        }

        // Verify if it is an item
        if (sectorState == "") {
            for (int x = 0; x < this.itemMax; x++) {
                int iItem = this.listaItens.get(x).getPosition().getI();
                int jItem = this.listaItens.get(x).getPosition().getJ();
                if (i == iItem && j == jItem) {
                    if (this.listaItens.get(x) instanceof ItemBoato)
                        sectorState = "Item Boato";
                    else if (this.listaItens.get(x) instanceof ItemDenunciar)
                        sectorState = "Item Denunciar";
                    else if (this.listaItens.get(x) instanceof ItemFugir)
                        sectorState = "Item Fugir";
                    else if (this.listaItens.get(x) instanceof ItemLer)
                        sectorState = "Item Ler";
                    break;
                }
            }
        }

        // If it is none of the 4, them it assings the sector with
        // sectorState == NULL meaning there's nothing there
        this.board[i][j] = new Sector(i, j, sectorState);
    }

    public void moveFakeNews() {
        // iterate through the list of fake news
        // and move them

        LinkedList<FakeNews> fakeNews = getFakeNews();

        // calls the move method for each fake news
        for (int i = 0; i < fakeNews.size(); i++) {
            // passing a blank keyEvent because it's not used
            // non-null component source and keyChar of ' ' because it's not used
            Component source = new Component() {
            };
            KeyEvent e = new KeyEvent(source, 0, 0, 0, 0, ' ');
            fakeNews.get(i).move(e);
        }
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
            else if (board[i][0].getSectorState().contains("Item"))
                System.out.printf("| ?? |");
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
                else if (board[i][j].getSectorState().contains("Item"))
                    System.out.printf(" ?? |");
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
