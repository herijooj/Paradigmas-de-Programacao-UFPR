package Entities;

public class SupPlayer extends Player {
    public SupPlayer() {
        super(1, 7, 2, 2);
    }

    public void heal(Player player) {
        int life = player.getDefensePower() + 2;
        player.setDefensePower(life);
    }
}