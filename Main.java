
import java.util.Scanner;

// import custom classes
import Board.*;

import Entities.Beings.*;
import Entities.Itens.*;
import Entities.*;
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
    }

    public static void sleep(int seconds) 
    {
         // Stops time for 1 secondd
         try 
         {
             // in milliseconds
             Thread.sleep(seconds * 1000);
         }
         catch (InterruptedException e) 
         {
             // Handle the exception if needed
             e.printStackTrace();
         }
    }

    // function to clear screen
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // main function ====================================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int playerCount, input, inventorySize;
        boolean itemUsed = false;

        // title screen ------------------------------------

        flushScreen();
        titleScreen();
        System.out.println("Welcome to the game!");
        System.out.println("Choose a number of players [1-4]");

        playerCount = scanner.nextInt();
        scanner.nextLine();  // clears the \n from the buffer

        while (playerCount < 1 || playerCount > 4)
        {
            flushScreen();
            titleScreen();
            System.out.println("Invalid player Count, choose between 1 and 4.");

            playerCount = scanner.nextInt();       
            scanner.nextLine();  // clears the \n from the buffer     
        }

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
            if (i == 24) {
                flushScreen();
                gameOver();
                break;
            }

            // player turn ==================================

            // for loop between players
            for (int j = 0; j < playerCount; j++)
            {
                // Getting action
                if (!itemUsed)
                { 
                    flushScreen();
                    System.out.println("Turn " + (i + 1) + " of 25");
                    board.drawBoard();
                    System.out.printf("--> " + Cores.ANSI_GREEN + "Player %d " + Cores.ANSI_RESET + "turn\n", j + 1);
                    System.out.println("Press action desired [1 -> move / 2 -> use itens]");

                    input = scanner.nextInt();
                    scanner.nextLine();
                    while (input < 1 || input > 2)
                    {
                        flushScreen();
                        System.out.println("Turn " + (i + 1) + " of 25");
                        board.drawBoard();
                        System.out.println("Invalid action! Press 1 to move, or 2 to use itens");
                        input = scanner.nextInt();
                        scanner.nextLine();
                    }

                    if (input == 2)
                    {
                        flushScreen();
                        System.out.println("Turn " + (i + 1) + " of 25");
                        board.drawBoard();
                        inventorySize = board.drawPlayerInventory(j + 1);

                        input = scanner.nextInt();
                        scanner.nextLine();

                        while (input < 0 || input > inventorySize && input != 5)
                        {
                            flushScreen();
                            System.out.println("Turn " + (i + 1) + " of 25");
                            board.drawBoard();
                            System.out.println("Invalid item number, type again.");
                            inventorySize = board.drawPlayerInventory(j + 1);

                            input = scanner.nextInt();
                            scanner.nextLine();
                        }

                        if (input > 0 && input < 5)
                        {
                            // USE ITEM --------------------
                            flushScreen();
                            System.out.println("Turn " + (i + 1) + " of 25");
                            board.drawBoard();
                            System.out.println("Item used!");
                            itemUsed = true;
                        }
                        else 
                            itemUsed = false;
                        j--;
                    }

                     // Realizing action
                    else if (input == 1)
                    {
                        flushScreen();
                        System.out.println("Turn " + (i + 1) + " of 25");
                        board.drawBoard();
                        System.out.println("Choose a direction to move: [1 - DOWN], [2 - UP], [3 - RIGHT], [4 - LEFT]");
                        input = scanner.nextInt();
                        scanner.nextLine();
                        while (input < 1 || input > 4)
                        {
                            flushScreen();
                            System.out.println("Turn " + (i + 1) + " of 25");
                            board.drawBoard();
                            System.out.println("Invalid direction, type again:");
                            System.out.println("[1 - DOWN], [2 - UP], [3 - RIGHT], [4 - LEFT]");
                            input = scanner.nextInt();
                            scanner.nextLine();
                        }

                        board.movePlayer(j, input);
                        flushScreen();
                        System.out.println("Turn " + (i + 1) + " of 25");
                        board.drawBoard();
                        System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                    }
                }

                // If item was used, only thing player can do now is move
                else
                {
                    flushScreen();
                    System.out.println("Turn " + (i + 1) + " of 25");
                    board.drawBoard();

                    System.out.println("Choose a direction to move: [1 - DOWN], [2 - UP], [3 - RIGHT], [4 - LEFT]");
                    input = scanner.nextInt();
                    scanner.nextLine();
                    while (input < 1 || input > 4)
                    {
                        flushScreen();
                        System.out.println("Turn " + (i + 1) + " of 25");
                        board.drawBoard();
                        System.out.println("Invalid direction, type again:");
                        System.out.println("[1 - DOWN], [2 - UP], [3 - RIGHT], [4 - LEFT]");
                        input = scanner.nextInt();
                        scanner.nextLine();
                    }

                    board.movePlayer(j, input);
                    flushScreen();
                    System.out.println("Turn " + (i + 1) + " of 25");
                    board.drawBoard();
                    System.out.printf("Player " + Cores.ANSI_GREEN + "J%d " + Cores.ANSI_RESET + "moved!\n", j + 1);
                    itemUsed = false;
                }
                sleep(2);
            }

            // Enemy turn ===================================
            flushScreen();
            System.out.println("Turn " + (i + 1) + " of 25");
            board.drawBoard();
            System.out.println("--> " + Cores.ANSI_RED + "Fake news " + Cores.ANSI_RESET + "turn");

            sleep(2);

            // Enemy movement
            board.moveFakeNews();
            flushScreen();
            System.out.println("Turn " + (i + 1) + " of 25");
            board.drawBoard();
            System.out.println("--> " + Cores.ANSI_RED + "Fake news " + Cores.ANSI_RESET + "moved");

            sleep(2);

            System.out.println("Press any key to continue the game...");
            scanner.nextLine();
        }
    }
}
