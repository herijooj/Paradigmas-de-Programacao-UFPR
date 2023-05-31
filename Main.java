
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
    public static void asciiArt() {
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

    // function to clear screen
    public static void flushScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // main function ====================================
    public static void main(String[] args) {

        // title screen ------------------------------------

        flushScreen();
        asciiArt();
        System.out.println("Welcome to the game!");
        System.out.println("Press any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        flushScreen();

        // game loop ---------------------------------------

        Board board = new Board(9);
        board.drawBoard();

        // 25 turns
        for (int i = 0; i < 25; i++) {
            if (i == 24) {
                flushScreen();
                asciiArt(); // substitute for game over screen
                break;
            }
            System.out.println("Turn " + (i + 1) + " of 25");
            scanner.nextLine();
            //flushScreen();
            board.drawBoard();
        }
    }
}