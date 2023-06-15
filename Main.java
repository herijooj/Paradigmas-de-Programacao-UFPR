
import java.util.Scanner;

// import custom classes
import Board.*;

import Cores.*;
import Entities.Coordinate;

public class Main {

    // function to generate random number
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    // ascii art title screen
    public static void titleScreen() {
        String[] pattern = {
                ".........................................................................",
                ".######...####...##..##..######..........##..##..######..##...##...####..",
                ".##......##..##..##.##...##..............###.##..##......##...##..##.....",
                ".####....######..####....####............##.###..####....##.#.##...####..",
                ".##......##..##..##.##...##..............##..##..##......#######......##.",
                ".##......##..##..##..##..######..........##..##..######...##.##....####..",
                "........................................................................."
        };
        for (int i = 0; i < pattern.length; i++) {
            System.out.println(pattern[i]);
        }
    }

    public static void gameOver() {
        String[] pattern = {
                "   _____                         ____                 ",
                "  / ____|                       / __ \\                ",
                " | |  __  __ _ _ __ ___   ___  | |  | |_   _____ _ __ ",
                " | | |_ |/ _` | '_ ` _ \\ / _ \\ | |  | \\ \\ / / _ \\ '__|",
                " | |__| | (_| | | | | | |  __/ | |__| |\\ V /  __/ |   ",
                "  \\_____|\\__,_|_| |_| |_|\\___|  \\____/  \\_/ \\___|_|   "
        };
        for (int i = 0; i < pattern.length; i++) {
            System.out.println(pattern[i]);
        }
        // Exit program
        System.exit(1);
    }

    public static void gameWin() {
        String pattern = " __     __          __          _______ _   _ _ \n" +
                " \\ \\   / /          \\ \\        / /_   _| \\ | | |\n" +
                "  \\ \\_/ /__  _   _   \\ \\  /\\  / /  | | |  \\| | |\n" +
                "   \\   / _ \\| | | |   \\ \\/  \\/ /   | | | . ` | |\n" +
                "    | | (_) | |_| |    \\  /\\  /   _| |_| |\\  |_|\n" +
                "    |_|\\___/ \\__,_|     \\/  \\/   |_____|_| \\_(_)\n" +
                "                                                ";

        System.out.println(pattern);
    }

    // Stops time for the given seconds
    public static void sleep(int seconds) {
        try {
            // in milliseconds
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    // Function to clear screen
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // This function receives a key and returns the corresponding direction
    public static int keyToDirection(String key) {
        // touppercase
        key = key.toUpperCase();

        // 1 = down, 2 = up, 3 = right, 4 = left
        // 0 = don't move
        switch (key) {
            case "W":
                return 2;
            case "A":
                return 4;
            case "S":
                return 1;
            case "D":
                return 3;
            default:
                return -1;
        }
    }

    /**
     * This function turns the turn
     * it clears the screen, prints the turn number and draws the board
     * it should be called at the start of each turn
     * 
     * @param turn  the current turn
     * @param board the board object
     */
    public static void increaseTurnAndDrawBoard(int turn, Board board) {
        flushScreen();
        System.out.println("Turn " + (turn + 1) + " of 20");
        board.drawBoard();
    }

    // Choose a direction to move
    public static int chooseDirection(Scanner scanner) {
        String input;

        System.out.println("Choose a direction to move [WASD]");

        input = scanner.nextLine();

        // while the input is invalid
        while (input.length() != 1 || keyToDirection(input) == -1) {
            // clear 2 lines
            System.out.print("\033[2A");
            System.out.println("Invalid input, choose a direction to move [WASD]");
            input = scanner.nextLine();
        }

        return keyToDirection(input);
    }

    public static void checkForPlayersDeaths(Board board, int i, int j) {
        // Check for player deaths
        if (board.checkPlayerState(j) == "dead") {
            increaseTurnAndDrawBoard(i, board);
            System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "died! :(\n", j + 1);
            sleep(1);
        }
    }

    public static void printPositionUpdate(Board board, int index, String entityType) {
        Coordinate position;

        if (entityType == "player") {
            if (board.getPlayers().get(index).getState() == "alive") {
                position = board.getPlayers().get(index).getPosition();

                System.out.printf(
                        "Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved to position: %d-%d\n",
                        index + 1, position.getI(), position.getJ());
            }
        }

        // "fakeNews"
        else {
            if (board.getFakeNews().get(index).getState() == "alive") {
                position = board.getFakeNews().get(index).getPosition();

                System.out.println("--> " + Cores.ANSI_RED + " Fake news " + (index + 1) + Cores.ANSI_RESET
                        + " moved to position: " + position.getI() + "-" + position.getJ());
            }
        }
    }

    // main function ====================================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount, input, inventorySize, j = 0, previousJ;
        boolean itemUsed = false;
        String placeholder;

        // title screen ------------------------------------
        flushScreen();
        titleScreen();
        System.out.println("Welcome to the game!");

        // configuration screen ----------------------------
        System.out.println("Choose a number of players [1-4]");
        placeholder = scanner.nextLine();
        while (!placeholder.matches("[1-4]")) {
            System.out.print("\033[2A");
            System.out.println("Invalid input, choose a number of players [1-4]");
            placeholder = scanner.nextLine();
        }
        playerCount = Integer.parseInt(placeholder);

        // game start --------------------------------------
        flushScreen();
        titleScreen();
        System.out.println(playerCount + " player game starting...");
        sleep(2);
        flushScreen();

        // game loop ---------------------------------------

        // create board
        Board board = new Board(9, playerCount, 4, 6, 2);

        // 20 turns
        for (int i = 0; i < 20; i++) {

            // if it is the last turn, game over
            if (i == 19 || board.allPlayersDead()) {
                flushScreen();
                gameOver();
                break;
            }

            // if there are no enemies left, game win
            if (board.allEnemiesDead()) {
                flushScreen();
                gameWin();
                break;
            }

            // player turn ==================================

            // for loop between players
            int playersQuantity = board.getPlayers().size();
            for (j = 0; j < playersQuantity; j++) {

                // If player died last round or before, skip
                if (board.checkPlayerState(j) == "outOfGame" || board.checkPlayerState(j) == "dead")
                    continue;

                previousJ = j;
                // Getting action
                if (!itemUsed) {
                    flushScreen();
                    System.out.println("Turn " + (i + 1) + " of 20");
                    board.drawBoard();
                    System.out.printf("--> " + Cores.ANSI_GREEN + "Player %d " + Cores.ANSI_RESET + "turn\n", j + 1);
                    System.out.println("Press action desired [1 -> move / 2 -> use itens]");

                    // input validation
                    placeholder = scanner.nextLine();
                    while (!placeholder.matches("[1-2]+")) {
                        System.out.print("\033[2A");
                        System.out.println("invalid entry, Try again. [1 -> move / 2 -> use itens]");
                        placeholder = scanner.nextLine();
                    }
                    input = Integer.parseInt(placeholder);

                    // Action
                    if (input == 2) {
                        increaseTurnAndDrawBoard(i, board);
                        inventorySize = board.drawPlayerInventory(j + 1);

                        // input validation
                        placeholder = scanner.nextLine();
                        while (!placeholder.matches("[1-5]")) {
                            System.out.print("\033[2A");
                            System.out.println("invalid entry, Try again. [1 -> move / 2 -> use itens]");
                            placeholder = scanner.nextLine();
                        }
                        input = Integer.parseInt(placeholder);

                        if (input > 0 && input < 5) {
                            // USE ITEM --------------------
                            increaseTurnAndDrawBoard(i, board);
                            System.out.println("Item used!");
                            // j+1 because the player number is 1,2,3,4 and the array is 0,1,2,3
                            // input-1 because the item number is 1,2,3,4 and the array is 0,1,2,3
                            board.useItem(j + 1, input - 1); // PODE RETORNAR UM BOOLEANO
                            itemUsed = true;
                            sleep(1);
                        } else
                            itemUsed = false;

                        j--;
                    }

                    // moving
                    else if (input == 1) {
                        increaseTurnAndDrawBoard(i, board);
                        input = chooseDirection(scanner);

                        board.movePlayer(j, input);
                        increaseTurnAndDrawBoard(i, board);
                        //System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                        printPositionUpdate(board, j, "player");
                        checkForPlayersDeaths(board, i, j);
                    }
                }
                // If item was used, only thing player can do now is move
                else {
                    increaseTurnAndDrawBoard(i, board);

                    input = chooseDirection(scanner);

                    board.movePlayer(j, input);
                    increaseTurnAndDrawBoard(i, board);
                    //System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                    printPositionUpdate(board, j, "player");
                    itemUsed = false;
                    checkForPlayersDeaths(board, i, j);
                }
                sleep(2);
            }

            // Check if players died during movement
            if (board.allPlayersDead()) {
                flushScreen();
                gameOver();
                break;
            }

            // Enemy turn ===================================
            increaseTurnAndDrawBoard(i, board);
            System.out.println("--> " + Cores.ANSI_RED + "Fake news " + Cores.ANSI_RESET + "turn");

            sleep(1);

            // Enemy movement
            for (int x = 0; x < board.getFakeNews().size(); x++) {
                // Ignore outOfGame fakeNews
                if (board.checkFakeNewsState(x) == "outOfGame")
                    continue;

                // To not move the recently added fakeNews
                else if (board.checkFakeNewsState(x) == "RecentlyAdded") {
                    board.getFakeNews().get(x).setState("alive");
                    increaseTurnAndDrawBoard(i, board);
                    continue;
                } else
                    board.moveIndividualFakeNews(x);

                increaseTurnAndDrawBoard(i, board);
                //System.out.println("--> " + Cores.ANSI_RED + " Fake news " + (x + 1) + Cores.ANSI_RESET + " moved");
                printPositionUpdate(board, x, "fakeNews");

                // Check for fakeNews deaths
                if (board.checkFakeNewsState(x) == "dead")
                    System.out.printf("Fake news " + Cores.ANSI_RED + "%d " + Cores.ANSI_RESET + "died! :)\n", x + 1);

                // Check for player deaths
                for (int k = 0; k < playersQuantity; k++)
                    checkForPlayersDeaths(board, i, k);

                // Check if players died during fakeNews movement
                if (board.allPlayersDead()) {
                    flushScreen();
                    gameOver();
                    break;
                }

                sleep(3);
            }
            
            increaseTurnAndDrawBoard(i, board);
            System.out.println("--> " + Cores.ANSI_RED + "All Fake news " + Cores.ANSI_RESET + "moved");

            sleep(1);
        }
    }
}
