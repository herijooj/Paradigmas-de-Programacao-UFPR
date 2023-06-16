
import java.util.Scanner;

// import custom classes
import Board.*;

import Cores.*;
import Entities.Coordinate;

public class Main {

    /**
     * Generates a random integer between the specified minimum and maximum values (inclusive).
     *
     * @param min the minimum value of the random number (inclusive)
     * @param max the maximum value of the random number (inclusive)
     * @return a random integer between the minimum and maximum values (inclusive)
     */ 
    public static int randomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * Prints a title screen to the console.
     *
     * The title screen is a pattern of dots and characters that spells out the word "Fake News".
     * The pattern is printed to the console using the System.out.println method.
     */    
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

    /**
     * Prints a Game Over screen to the console.
     *
     * The Game Over is a pattern of lines and symbols that spells out the word "GameOver".
     * The pattern is printed to the console using the System.out.println method.
     */  
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

    /**
     * Prints a Game Win screen to the console.
     *
     * The Game Win is a pattern of lines and symbols that spells out the word "You Win".
     * The pattern is printed to the console using the System.out.println method.
     */  
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

    /**
     * Suspends the current thread for the specified number of seconds.
     *
     * @param seconds the number of seconds to sleep
     * @throws InterruptedException if the thread is interrupted while sleeping
     */    
    public static void sleep(int seconds) {
        try {
            // in milliseconds
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }


    /**
     * Clears the console screen by printing the ANSI escape codes for the "home" and "clear screen" commands.
     */
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Maps a keyboard key to a direction for the game.
     *
     * @param key the keyboard key to map to a direction
     * @return the direction mapped to the keyboard key (1 = down, 2 = up, 3 = right, 4 = left, 0 = don't move)
     */
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

    /**
     * Prompts the user to choose a direction to move in the game and returns the corresponding direction.
     *
     * @param scanner the scanner to read user input from
     * @return the direction chosen by the user (1 = down, 2 = up, 3 = right, 4 = left, 0 = don't move)
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
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

    /**
     * Checks if a player has died on the game board and prints a message if they have.
     *
     * @param board the game board to check for player deaths
     * @param i the current turn number
     * @param j the index of the player to check for death
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
    public static void checkForPlayersDeaths(Board board, int i, int j) {
        // Check for player deaths
        if (board.checkPlayerState(j) == "dead") {
            increaseTurnAndDrawBoard(i, board);
            System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "died! :(\n", j + 1);
            sleep(1);
        }
    }

    /**
     * Prints an update to the console about the position of a player or fake news entity on the game board.
     *
     * @param board the game board containing the entity
     * @param index the index of the entity in the list of players or fake news entities
     * @param entityType the type of entity ("player" or "fakeNews")
     */
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

                System.out.println("--> " + Cores.ANSI_RED + " Fake news " + board.getFakeNews().get(index).toString() + Cores.ANSI_RESET
                        + " moved to position: " + position.getI() + "-" + position.getJ());
            }
        }
    }

    // main function ====================================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount, input, j = 0;
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
        Board board = new Board(9, playerCount, 4, 6, 20);

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
                        board.drawPlayerInventory(j + 1);

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
                printPositionUpdate(board, x, "fakeNews");

                // Check for fakeNews deaths
                if (board.checkFakeNewsState(x) == "dead")
                    System.out.printf("Fake news " + Cores.ANSI_RED + "%s " + Cores.ANSI_RESET + "died! :)\n", board.getFakeNews().get(x).toString());
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
