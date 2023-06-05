
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

    // function to clear screen
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // main function ====================================
    public static void main(String[] args) {

        String chosenAction;

        // title screen ------------------------------------

        flushScreen();
        titleScreen();
        System.out.println("Welcome to the game!");
        System.out.println("Press any key to start...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        flushScreen();

        // game loop ---------------------------------------

        // create board
        Board board = new Board(9);
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
            System.out.println("--> Player x turn");

            // Stops time for 1 secondd
            try {
            // Pause the execution for 1 seconds (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
                e.printStackTrace();
            }

            System.out.println("Press action desired [1 -> move / 2 -> use itens]");
            chosenAction = scanner.nextLine();
            flushScreen();

            System.out.println("Chosen action = " + chosenAction);
            // Stops time for 2 seconds
            try {
                // Pause the execution for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
                e.printStackTrace();
            }

            board.drawBoard();

            try {
                // Pause the execution for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
                e.printStackTrace();
            }

            // Enemy turn ===================================
            System.out.println("--> Fake news turn");

            try {
                // Pause the execution for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
                e.printStackTrace();
            }

            // Enemy movement
            board.moveFakeNews();
            board.drawBoard();
            try {
                // Pause the execution for 2 seconds (2000 milliseconds)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // Handle the exception if needed
                e.printStackTrace();
            }

            System.out.println("Press any key to continue the game...");
            scanner.nextLine();
            //board.drawBoard();
        }
    }
}
