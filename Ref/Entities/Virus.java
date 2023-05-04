package Entities;

import java.util.Random;

public class Virus extends Entity {

    public Virus() {
        super(1, 1);
    }

    public Virus(Random generator) {
        int rand = generator.nextInt(3)+1;
        this.setAttackPower(rand);
        this.setDefensePower(rand);
    }   

}
