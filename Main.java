
import java.util.Scanner;

// import custom classes
import Board.*;

import Cores.*;

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
        // exit program
        System.exit(1);
    }

    // placeholder for game win
    public static void gameWin() {
        String[] pattern = {
                "  __          __  _                            _ ",
                "  \\ \\        / / | |                          | |",
                "   \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |",
                "    \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | |",
                "     \\  /\\  /  __/ | (_| (_) | | | | | |  __/ |_|",
                "      \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___| (_)"
        };
        for (int i = 0; i < pattern.length; i++) {
            System.out.println(pattern[i]);
        }
        // exit program
        System.exit(0);

    }

    public static void sleep(int seconds) {
        // Stops time for 1 secondd
        try {
            // in milliseconds
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

    // function to clear screen
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // this function receives a key and returns the corresponding direction
    public static int keyToDirection(String key) {
        // touppercase
        key = key.toUpperCase();

        // 1 = down, 2 = up, 3 = right, 4 = left
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
                return 0;
        }
    }

    /**
     * this function turns the turn
     * it clears the screen, prints the turn number and draws the board
     * it should be called at the start of each turn
     */
    public static void nextTurn(int turn, Board board) {
        flushScreen();
        System.out.println("Turn " + (turn + 1) + " of 25");
        board.drawBoard();
    }

    // choose a direction to move
    public static int chooseDirection(Scanner scanner) {
        String input;

        System.out.println("Choose a direction to move [WASD]");

        input = scanner.nextLine();

        // while the input is invalid
        while (input.length() != 1 || keyToDirection(input) == 0) {
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
            nextTurn(i, board);
            System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "died! :(\n", j + 1);
            sleep(1);
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
        Board board = new Board(9, playerCount);

        // 25 turns
        for (int i = 0; i < 25; i++) {
            // if it is the last turn, game over
            if (i == 24 || board.allPlayersDead()) {
                flushScreen();
                gameOver();// PASSIVO DE FAZER FACTORY METHOD, FICARA flushScreen("gameOver")
                break;
            }

            // player turn ==================================

            // for loop between players
            int playersQuantity = board.getPlayers().size();
            for (j = 0; j < playersQuantity; j++) {

                // If player died last round or before, skip
                if (board.checkPlayerState(j) == "outOfGame" || board.checkPlayerState(j) == "dead")
                    continue;

                // if every fakeNews is null, game over
                for (int k = 0; k < board.getFakeNews().size(); k++) {
                    if (board.getFakeNews().get(k) != null) {
                        break;
                    }
                    if (k == board.getFakeNews().size() - 1) {
                        flushScreen();
                        gameWin();// PASSIVO DE FAZER FACTORY METHOD, FICARA flushScreen("gameWin")
                        break;
                    }
                }

                previousJ = j;
                // Getting action
                if (!itemUsed) {
                    flushScreen();
                    System.out.println("Turn " + (i + 1) + " of 25");
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
                        nextTurn(i, board);
                        inventorySize = board.drawPlayerInventory(j + 1);

                        // input validation
                        placeholder = scanner.nextLine();
                        while (!placeholder.matches("[1-5]")) {
                            System.out.print("\033[2A");
                            System.out.println("invalid entry, Try again. [1 -> move / 2 -> use itens]");
                            placeholder = scanner.nextLine();
                        }
                        input = Integer.parseInt(placeholder);

                        // ISSO AQUI TA ESTRANHO, VC JÁ SABE QUE O INPUT É 2
                        // Acho que esse if faz o mesmo que o while logo acima
                        // Mas verifica se foi [1-4], porque o 5 eh pra sair do inventario
                        if (input > 0 && input < 5) {
                            // USE ITEM --------------------
                            nextTurn(i, board);
                            System.out.println("Item used!");
                            // board.useItem(j + 1, input - 1); // PODE RETURNAR UM BOOLEANO
                            itemUsed = true;
                        } else
                            itemUsed = false;
                        
                        j--;
                    }

                    // moving
                    else if (input == 1) {
                        nextTurn(i, board);
                        input = chooseDirection(scanner);

                        board.movePlayer(j, input);
                        nextTurn(i, board);
                        System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                        checkForPlayersDeaths(board, i, j);
                    }
                }
                // If item was used, only thing player can do now is move
                else {
                    nextTurn(i, board);

                    input = chooseDirection(scanner);

                    board.movePlayer(j, input);
                    nextTurn(i, board);
                    System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                    itemUsed = false;
                    checkForPlayersDeaths(board, i, j);
                }
                sleep(1);
            }

            // Check if players died during movement
            if (board.allPlayersDead()) {
                flushScreen();
                gameOver();
                break;
            }

            // Enemy turn ===================================
            nextTurn(i, board);
            System.out.println("--> " + Cores.ANSI_RED + "Fake news " + Cores.ANSI_RESET + "turn");

            sleep(1);

            // Enemy movement
            for (int x = 0; x < board.getFakeNews().size(); x++) {
                // Ignore outOfGame fakeNews
                if (board.checkFakeNewsState(x) == "outOfGame")
                    continue;

                board.moveIndividualFakeNews(x);
                nextTurn(i, board);
                System.out.println("--> " + Cores.ANSI_RED + " Fake news " + (x + 1) + Cores.ANSI_RESET + " moved");

                // Check for fakeNews deaths
                if (board.checkFakeNewsState(x) == "dead") {
                    // nextTurn(i, board);
                    System.out.printf("Fake news " + Cores.ANSI_RED + "%d " + Cores.ANSI_RESET + "died! :)\n", x + 1);
                }

                // Check for player deaths
                for (int k = 0; k < playersQuantity; k++)
                    checkForPlayersDeaths(board, i, k);

                sleep(1);
            }
            nextTurn(i, board);
            System.out.println("--> " + Cores.ANSI_RED + "All Fake news " + Cores.ANSI_RESET + "moved");

            sleep(1);

            // System.out.println("Press any key to continue the game...");
            // scanner.nextLine();
        }
    }
}