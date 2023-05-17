package jogo;

public class Principal {
    public static void main(String[] args) {
        System.out.println(Cores.ANSI_RED + "Red text" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_BLUE + "Blue text" + Cores.ANSI_RESET);
        System.out.println(Cores.ANSI_YELLOW_BACKGROUND + "Yellow background"
                + Cores.ANSI_RESET);
    }
}