
import java.util.Scanner;

// import custom classes
import Board.*;

import Entities.Beings.*;
import Entities.Itens.*;
import Entities.*;

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
        String chosenAction;
        int playerCount;

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
        // create player

        board.drawBoard();

        // 25 turns
        for (int i = 0; i < 25; i++) {
            // if it is the last turn, game over
            if (i == 24) {
                flushScreen();
                gameOver();
                break;
            }

            System.out.println("Turn " + (i + 1) + " of 25");

            // player turn ==================================

            // for loop between players
            System.out.println("--> Player x turn");

            sleep(2);

            System.out.println("Press action desired [1 -> move / 2 -> use itens]");
            chosenAction = scanner.nextLine();
            flushScreen();
            
            board.drawBoard();

            System.out.println("Chosen action = " + chosenAction);
        
            sleep(2);

            // EXECUTE ACTION /////////////

            // After the action was exexuted
            flushScreen();
            board.drawBoard();
            System.out.println("Action executed");

            sleep(2);

            // Enemy turn ===================================
            flushScreen();
            board.drawBoard();
            System.out.println("--> Fake news turn");

            sleep(2);

            // Enemy movement
            board.moveFakeNews();
            flushScreen();
            board.drawBoard();
            System.out.println("--> Fake news moved");

            sleep(2);

            System.out.println("Press any key to continue the game...");
            scanner.nextLine();
            flushScreen();
            board.drawBoard();
        }
    }
}
