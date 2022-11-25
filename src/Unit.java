import java.util.ArrayList;
import java.util.List;

public abstract class Unit implements UnitInterface {
    protected int attack;
    protected int protect;
    protected int[] damage;
    protected float health;
    protected final float maxHealth;
    protected int speed;
    protected String state;

    protected List<Unit> gang;

    public Unit(int attack, int protect, int[] damage, float health, int speed, String state)  {
        this.attack = attack;
        this.protect = protect;
        this.damage = damage;
        this.health = health / 2;
        this.maxHealth = health;
        this.speed = speed;
        this.state = state;
    }

    @Override
    public String getInfo() {
        return "А:" + attack + ", З:" + protect + ", У:" + (damage[0] + damage[1]) / 2 + ", Зд:" + health + ", С:" + speed;
    }

    @Override
    public void step() {

    }
}
