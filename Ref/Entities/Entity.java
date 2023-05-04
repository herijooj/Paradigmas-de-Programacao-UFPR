package Entities;
public abstract class Entity {

    protected int attackPower;
    protected int defensePower;

    public Entity() {
        setAttackPower(1);
        setDefensePower(2);
    }

    public Entity(int attackPower, int defensePower) {
        setAttackPower(attackPower);
        setDefensePower(defensePower);
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getDefensePower() {
        return this.defensePower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefensePower(int defensePower) {
        if (defensePower < 0) {
            this.defensePower = 0;
        } else {
            this.defensePower = defensePower;
           if(this.defensePower >= 9) this.defensePower = 9;
        }
    }

    public boolean attack(Entity entity) {
        if (this.getDefensePower() > 0){
            int life = entity.getDefensePower() - this.getAttackPower();
            entity.setDefensePower(life);
            return true;
        }
        return false;
    }
}
