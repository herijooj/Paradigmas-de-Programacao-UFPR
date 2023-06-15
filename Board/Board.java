package Board;

// imports 
import java.util.*;
import Cores.Cores;

import Entities.*;
import Entities.Beings.*;
import Entities.Itens.*;

// class
public class Board {

    // attributes =============================================
    private int size;
    private Sector[][] board;

    private LinkedList<Coordinate> listaRestrictedSectors;
    private int restrictedSectorsMax;

    private LinkedList<FakeNews> listaFakeNews;
    private int fakeNewsMax;

    private LinkedList<Item> listaItens;
    private int itemMax;

    private LinkedList<Player> listaPlayers;

    // constructor ============================================
    /**
     * Constructor for Board
     * 
     * @param size
     * @param playerCount
     * @return Board
     */
    public Board(int size, int playerCount, int restrictedSectorMax, int fakeNewsMax, int itemMax) {
        this.setSize(size);
        this.setPlayers(playerCount);
        this.setRestrictedSectorsMax(restrictedSectorMax);
        this.setfakeNewsMax(fakeNewsMax);
        this.setItemMax(itemMax);
        this.setRestrictedSectors();
        this.setFakeNews();
        this.setItens();
        this.setBoard();
    }

    // getters ================================================
    public int getSize() {
        return this.size;
    }

    public Sector[][] getBoard() {
        return this.board;
    }

    public LinkedList<Player> getPlayers() {
        return this.listaPlayers;
    }

    public LinkedList<Coordinate> getRestrictedSectors() {
        return this.listaRestrictedSectors;
    }

    public LinkedList<FakeNews> getFakeNews() {
        return this.listaFakeNews;
    }

    public LinkedList<Item> getItens() {
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

    // setters =================================================
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

    public void setfakeNewsMax(int fakeNewsMax) {
        if (fakeNewsMax < 0)
            throw new IllegalArgumentException("Fake news Max must be positive");
        this.fakeNewsMax = fakeNewsMax;
    }

    public void setItemMax(int itemMax) {
        if (itemMax < 0)
            throw new IllegalArgumentException("Item max must be positive");
        this.itemMax = itemMax;
    }

    /**
     * Will create a List of players with their respective positions.
     * <br>
     * <br>
     * A list of restricted sectors, FakeNews and Itens will also be created
     * 
     * @param playerCount
     */
    public void setPlayers(int playerCount) {
        this.listaPlayers = new LinkedList<Player>();
        this.listaRestrictedSectors = new LinkedList<Coordinate>();
        this.listaFakeNews = new LinkedList<FakeNews>();
        this.listaItens = new LinkedList<Item>();

        int iC, jC, i;
        Coordinate newCoordinate;

        for (i = 0; i < playerCount; i++) {
            // player 1
            if (i == 0) {
                iC = 0;
                jC = 4;
                // player 2
            } else if (i == 1) {
                iC = 4;
                jC = 8;
                // player 3
            } else if (i == 2) {
                iC = 8;
                jC = 4;
                // player 4
            } else {
                iC = 4;
                jC = 0;
            }

            newCoordinate = new Coordinate(iC, jC);

            // Doesn't need to verify repeteated position for
            // player, it's a static position and the first to be generated
            this.listaPlayers.add(new Player(i + 1, newCoordinate));
        }
    }

    /**
     * Will randomly create a list of Restricted Sectors and add it to the
     * respective list
     * 
     */
    public void setRestrictedSectors() {
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

    /**
     * Will create a list of Fake News and add it to the respective list
     */
    public void setFakeNews() {
        int i, iC, jC;
        Coordinate newCoordinate;
        int F1Quantity = 0, F2Quantity = 0;

        // Create the Fake News
        for (i = 0; i < this.fakeNewsMax; i++) {
            // randomnly generate two coordinates
            iC = (int) (Math.random() * 9);
            jC = (int) (Math.random() * 9);
            newCoordinate = new Coordinate(iC, jC);

            // if the coordinate is not equal to any other
            if (!onBorder(newCoordinate) && !hasEqualCoordinate(newCoordinate)) {
                if (F1Quantity < 2) {
                    this.listaFakeNews.add(new F1(newCoordinate, "alive"));
                    F1Quantity++;
                } else if (F1Quantity == 2 && F2Quantity < 2) {
                    this.listaFakeNews.add(new F2(newCoordinate, "alive"));
                    F2Quantity++;
                } else {
                    this.listaFakeNews.add(new F3(newCoordinate, "alive"));
                }
            } else
                i--;
        }
    }

    /**
     * check if a coordinate is on the border of the board
     * 
     * @param coordinate
     * @return boolean
     */
    public boolean onBorder(Coordinate coordinate) {
        if (coordinate.getI() == 0 || coordinate.getI() == 8 || coordinate.getJ() == 0
                || coordinate.getJ() == 8)
            return true;
        return false;
    }

    /**
     * Adds a singular item to the board
     * returns true if succeeded or false if the coordinate
     * generated for it was already occupied
     * 
     * @return boolean
     */
    public boolean addItemToBoard() {
        int iC, jC, itemNum;
        Coordinate newCoordinate;

        // Generates random coordinate
        iC = (int) (Math.random() * 9);
        jC = (int) (Math.random() * 9);
        newCoordinate = new Coordinate(iC, jC);

        // See if coordinate generated isn't already occupied
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

            return true;
        } else
            return false;
    }

    /**
     * Sets itens to the board
     * 
     * @param itemQuantity
     */
    public void setItens() {
        int i;

        for (i = 0; i < this.itemMax; i++)
            if (!addItemToBoard())
                i--;
    }

    /**
     * Adds a singular item to the board and sets it's entity
     * <br>
     * <br>
     * if the coordinate generated for it was already occupied
     * it will return false
     *
     * 
     * @return boolean
     */
    public boolean addItemToBoardAndSetEntity() {
        int iC, jC, itemNum;
        Coordinate newCoordinate;

        // Generates random coordinate
        iC = (int) (Math.random() * 9);
        jC = (int) (Math.random() * 9);
        newCoordinate = new Coordinate(iC, jC);

        // See if coordinate generated isn't already occupied
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

            setEntityToSector(iC, jC);

            return true;
        } else
            return false;
    }

    public void addItens(int itemQuantity) {
        int i;

        for (i = 0; i < itemQuantity; i++) {
            if (!addItemToBoardAndSetEntity())
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

    // methods ==================================================================

    /**
     * this method checks if the coordinate is already in use
     * by another entity, if it is, it returns true
     * 
     * @param coordinate
     * @return boolean
     */
    private boolean hasEqualCoordinate(Coordinate coordinate) {
        int j;

        // Check if it has the same coordinate as a player
        int playerSize = this.listaPlayers.size();
        for (j = 0; j < playerSize; j++) {
            // extracting for better readability
            int playerI = this.listaPlayers.get(j).getPosition().getI();
            int playerJ = this.listaPlayers.get(j).getPosition().getJ();

            // if it has the same coordinate as a player, return true
            if (coordinate.getI() == playerI && coordinate.getJ() == playerJ)
                return true;
        }

        // Check if it has the same coordinate as a restricted sector
        int RestrictedSectorsSize = this.listaRestrictedSectors.size();
        for (j = 0; j < RestrictedSectorsSize; j++) {
            // extracting for better readability
            int restrictedI = this.listaRestrictedSectors.get(j).getI();
            int restrictedJ = this.listaRestrictedSectors.get(j).getJ();

            // if it has the same coordinate as a restricted sector, return true
            if (coordinate.getI() == restrictedI && coordinate.getJ() == restrictedJ)
                return true;
        }

        // Check if it has the same coordinate as a Fake News
        int listaFakeNewsSize = this.listaFakeNews.size();
        for (j = 0; j < listaFakeNewsSize; j++) {
            // extracting for better readability
            int fakeNewsI = this.listaFakeNews.get(j).getPosition().getI();
            int fakeNewsJ = this.listaFakeNews.get(j).getPosition().getJ();

            // if it has the same coordinate as an item, return true
            if (coordinate.getI() == fakeNewsI && coordinate.getJ() == fakeNewsJ)
                return true;
        }

        // And check if it has the same coordinate as an item
        int listaItensSize = this.listaItens.size();
        for (j = 0; j < listaItensSize; j++) {
            // extracting for better readability
            int itemI = this.listaItens.get(j).getPosition().getI();
            int itemJ = this.listaItens.get(j).getPosition().getJ();

            // if it has the same coordinate as an item, return true
            if (coordinate.getI() == itemI && coordinate.getJ() == itemJ)
                return true;
        }

        // If it got here, means there's no repeated coordinate so far
        return false;
    }

    /*
     * Helper method used in the setBoard method
     */
    private void setEntityToSector(int i, int j) {
        String sectorState = "";

        // Vefiry if it is a Player
        for (int x = 0; x < this.listaPlayers.size(); x++) {
            int iPlayer = this.listaPlayers.get(x).getPosition().getI();
            int jPlayer = this.listaPlayers.get(x).getPosition().getJ();
            if (i == iPlayer && j == jPlayer) {
                if (this.listaPlayers.get(x).getPlayerNum() == 1)
                    sectorState = "Player 1";
                else if (this.listaPlayers.get(x).getPlayerNum() == 2)
                    sectorState = "Player 2";
                else if (this.listaPlayers.get(x).getPlayerNum() == 3)
                    sectorState = "Player 3";
                else
                    sectorState = "Player 4";

                break;
            }
        }

        // Verify if it is restricted
        for (int x = 0; x < this.restrictedSectorsMax; x++) {
            int iRestricted = this.listaRestrictedSectors.get(x).getI();
            int jRestricted = this.listaRestrictedSectors.get(x).getJ();
            if (i == iRestricted && j == jRestricted) {
                sectorState = "Restricted";
                break;
            }
        }

        // Verify if it is a FakeNews
        if (sectorState == "") {
            for (int x = 0; x < this.listaFakeNews.size(); x++) {
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
            for (int x = 0; x < this.listaItens.size(); x++) {
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
        Coordinate coordinate = new Coordinate(i, j);
        this.board[i][j] = new Sector(coordinate, sectorState);
    }

    /*
     * This method is used to move the fake news
     * 
     * @param index the index of the fake news to be moved
     */
    public void moveIndividualFakeNews(int index) {
        LinkedList<FakeNews> fakeNews = getFakeNews();

        if (fakeNews.get(index) == null)
            return;

        // get the current coordinates
        int iFakeNews = fakeNews.get(index).getPosition().getI();
        int jFakeNews = fakeNews.get(index).getPosition().getJ();

        // clear the old position
        this.board[iFakeNews][jFakeNews].setSectorState("");

        // goes up, down, left or right one position randomly
        int direction = (int) (Math.random() * 4) + 1;

        String movementWorked = fakeNews.get(index).move(this, direction);

        // if the movement worked, update the board
        if (movementWorked == "moved") {
            // get the new coordinates
            iFakeNews = fakeNews.get(index).getPosition().getI();
            jFakeNews = fakeNews.get(index).getPosition().getJ();

            // checking if the movement killed a player
            Player playerOnSector = checkIfSectorHasPlayer(new Coordinate(iFakeNews, jFakeNews));
            if (playerOnSector != null)
                playerOnSector.setState("dead");

            // update the board
            this.board[iFakeNews][jFakeNews].setSectorState(fakeNews.get(index).toString());
        } else if (movementWorked == "dead")
            fakeNews.get(index).setState("dead");
    }

    /**
     * This method is used to check if a sector has a player
     * 
     * @param position
     * @return
     */
    public Player checkIfSectorHasPlayer(Coordinate position) {
        LinkedList<Player> players = getPlayers();

        for (int i = 0; i < players.size(); i++) {
            // if the player is dead, it doesn't count
            if (players.get(i).getState() != "alive")
                continue;

            // if the player is in the same position as the sector
            if (players.get(i).getPosition().getI() == position.getI()
                    && players.get(i).getPosition().getJ() == position.getJ())
                return players.get(i);
        }
        return null;
    }

    /**
     * This method is used to move the players
     * it iterates through the list of players
     **/
    public void movePlayer(int i, int direction) {
        // if the direction is 0, don't move
        if (direction == 0)
            return;

        LinkedList<Player> players = getPlayers();

        // get the current coordinates
        int iPlayer = players.get(i).getPosition().getI();
        int jPlayer = players.get(i).getPosition().getJ();

        // clear the old position
        this.board[iPlayer][jPlayer].setSectorState("");

        String movementWorked = players.get(i).move(this, direction);

        // if the movement worked, update the board
        if (movementWorked == "moved") {
            // get the new coordinates
            iPlayer = players.get(i).getPosition().getI();
            jPlayer = players.get(i).getPosition().getJ();

            // update the board
            this.board[iPlayer][jPlayer].setSectorState(players.get(i).toString());
        } else if (movementWorked == "dead")
            players.get(i).setState("dead");
        else // BOATO
        {
            int randomDirection = (int) (Math.random() * 4) + 1;
            Coordinate newCoordinate;

            // Get the new coordinates
            iPlayer = players.get(i).getPosition().getI();
            jPlayer = players.get(i).getPosition().getJ();

            newCoordinate = new Coordinate(iPlayer, jPlayer);

            // Player is in the item boato area
            this.board[iPlayer][jPlayer].setSectorState(players.get(i).toString());

            // Move again, but randomly
            this.movePlayer(i, randomDirection);
        }
    }

    /**
     * this is a wrapper method for the item ability method
     * 
     * @param playerIndex the index of the player using the item
     * @param itemIndex   the index of the item being used
     */
    public void useItem(int playerIndex, int itemIndex) {
        Player player = this.listaPlayers.get(playerIndex - 1);
        Item item = player.getInventory().get(itemIndex);

        item.itemAbility(this, player);

        player.getInventory().remove(itemIndex);
    }

    /**
     * Returns a string indicating the player state
     * Can be, dead, alive or outOfGame
     * 
     * @param playerNum
     * @return "dead" | "Alive" | "OutOfGame"
     */
    public String checkPlayerState(int playerNum) {
        if (this.listaPlayers.size() >= 0 && this.listaPlayers.size() <= playerNum)
            return "outOfGame";
        Player player = this.listaPlayers.get(playerNum);

        if (player.getState() == "dead") {
            player.setState("outOfGame");
            return "dead";
        } else if (player.getState() == "alive")
            return "alive";
        else
            return "outOfGame";

    }

    /**
     * Returns a string indicating the fakeNews state
     * Can be, dead, alive or outOfGame
     */
    public String checkFakeNewsState(int fakeNewsIndex) {
        FakeNews fakeNews = this.listaFakeNews.get(fakeNewsIndex);

        if (fakeNews.getState() == "dead") {
            fakeNews.setState("outOfGame");
            return "dead";
        } else if (fakeNews.getState() == "alive")
            return "alive";
        else if (fakeNews.getState() == "RecentlyAdded")
            return "RecentlyAdded";
        else
            return "outOfGame";
    }

    public boolean allPlayersDead() {
        LinkedList<Player> players = this.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getState() == "alive")
                return false;
        }
        return true;
    }

    /**
     * This method is used to draw the board
     **/
    public void drawBoard() {
        size = this.getSize();
        board = this.getBoard();
        int i;

        // draw the board
        for (i = 0; i < size; i++) {
            // draw the top and bottom of the board
            if (i == 0 || i == size) {
                System.out.print("  +----+");
                for (int j = 1; j < size; j++) {
                    System.out.print("----+");
                }
                System.out.println();
            }

            // draw the first side of the board
            String currentSectorState = board[i][0].getSectorState();
            if (currentSectorState == "Player 1")
                System.out.printf(i + " |" + Cores.ANSI_GREEN + " J1 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "Player 2")
                System.out.printf(i + " |" + Cores.ANSI_GREEN + " J2 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "Player 3")
                System.out.printf(i + " |" + Cores.ANSI_GREEN + " J3 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "Player 4")
                System.out.printf(i + " |" + Cores.ANSI_GREEN + " J4 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "Restricted")
                System.out.printf(i + " |" + Cores.ANSI_WHITE + " XX " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "F1")
                System.out.printf(i + " |" + Cores.ANSI_RED + " F1 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "F2")
                System.out.printf(i + " |" + Cores.ANSI_RED + " F2 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState == "F3")
                System.out.printf(i + " |" + Cores.ANSI_RED + " F3 " + Cores.ANSI_RESET + "|");
            else if (currentSectorState.contains("Item"))
                System.out.printf(i + " |" + Cores.ANSI_YELLOW + " ?? " + Cores.ANSI_RESET + "|");
            else
                System.out.printf(i + " |    |");

            // draw the rest of the board
            for (int j = 1; j < size; j++) {
                currentSectorState = board[i][j].getSectorState();
                if (currentSectorState == "Player 1")
                    System.out.printf(Cores.ANSI_GREEN + " J1 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "Player 2")
                    System.out.printf(Cores.ANSI_GREEN + " J2 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "Player 3")
                    System.out.printf(Cores.ANSI_GREEN + " J3 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "Player 4")
                    System.out.printf(Cores.ANSI_GREEN + " J4 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "Restricted")
                    System.out.printf(Cores.ANSI_WHITE + " XX " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "F1")
                    System.out.printf(Cores.ANSI_RED + " F1 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "F2")
                    System.out.printf(Cores.ANSI_RED + " F2 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState == "F3")
                    System.out.printf(Cores.ANSI_RED + " F3 " + Cores.ANSI_RESET + "|");
                else if (currentSectorState.contains("Item"))
                    System.out.printf(Cores.ANSI_YELLOW + " ?? " + Cores.ANSI_RESET + "|");
                else
                    System.out.printf("    |");
            }

            System.out.println();
            System.out.print("  +----+");

            // draw the bottom of the board
            for (int j = 1; j < size; j++) {
                System.out.print("----+");
            }
            System.out.println();
        }
        for (i = 0; i < 9; i++)
            System.out.print("    " + i);
        System.out.println("\n");
    }

    /**
     * Function to draw the player inventory on screen,
     * return player's inventory size
     **/
    public int drawPlayerInventory(int playerNum) {
        int i;
        Player player = listaPlayers.get(playerNum - 1);

        if (player.getInventory().size() == 0)
            System.out.println("Player " + playerNum + ", you have no items in your inventory, press 5 to return");
        else {
            System.out.println("Player " + playerNum + ", this is your inventory");
            System.out.println("Choose the item you want to use, or 5 to return");
            System.out.println("==================INVENTORY===================\n");

            for (i = 0; i < player.getInventory().size(); i++) {
                System.out.print((i + 1) + " - " + player.getInventory().get(i).toString() + " - ");

                if (player.getInventory().get(i).toString() == "Item Ler")
                    System.out.println("Ler uma noticia real, elimina uma FN aleatória do tabuleiro.");
                else if (player.getInventory().get(i).toString() == "Item Denunciar")
                    System.out.println("Denunciar FN, elimina todas as FN ao redor do jogador.");
                else if (player.getInventory().get(i).toString() == "Item Fugir")
                    System.out.println("Fuja para uma posição do tabuleiro que será escolhida ao utilizar o item.");
            }
        }

        return player.getInventory().size();
    }

    /**
     * Function to check if there are enemies alive
     * return true if there are no enemies alive
     **/
    public boolean allEnemiesDead() {
        int i;

        // check the state of all fake news
        for (i = 0; i < listaFakeNews.size(); i++) {
            if (listaFakeNews.get(i).getState() == "alive")
                return false;
        }
        return true;
    }
}
