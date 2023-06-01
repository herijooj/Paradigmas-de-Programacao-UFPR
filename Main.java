
import java.util.Scanner;

// import custom classes
import Board.*;

import Entities.Beings.*;
import Entities.Itens.*;
import Entities.*;

public class Main {

    //function to generate random number
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

    //placeholder for game win
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

        // title screen ------------------------------------

        flushScreen();
        titleScreen();
        System.out.println("Welcome to the game!");
        System.out.println("Press any key to continue...");
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

            // player turn ==================================
            System.out.println("Player action");
            System.out.println("Press any key to continue...");
            scanner.nextLine();
            flushScreen();
            board.drawBoard();

            // Enemy turn ===================================
            System.out.println("Enemy action");
            
            // Enemy movement
            
            // the enemies will move randomly
            

            board.drawBoard();

            System.out.println("Turn " + (i + 1) + " of 25");
            scanner.nextLine();
            board.drawBoard();
        }
    }
}