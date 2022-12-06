package units;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Unit implements UnitInterface {
    private int attack;
    private int defence;
    protected int shoot;
    protected int[] damage;
    protected double health;
	protected double maxHealth;
    protected int speed;
    private boolean delivery;
    private boolean magic;
    private final String name;
	protected String status;
    private static int idCounter;
    private final int playerID;
    protected List<Unit> gang;
    protected List<Unit> enemyGang;
    protected Vector2 position;
    protected String icon;

    protected int quantity;

    public Unit(int attack, int defence, int shoot, int[] damage, double health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.maxHealth = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.status = "Стоит";
        playerID = idCounter++;
    }

    public Vector2 getPosition(){return position;}

    public int getPlayerID() {
        return playerID;
    }
	
    public double getHealth() {return health;}

    public String getName() {return name;}

    public String getIcon() {return icon;}

    public int getSpeed() {return speed;}

    public String getStatus() {return status;}

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append(icon).append(name);
        info.append(" ".repeat(Math.max(0, 14 - info.length())));
        info.append('<').append(status).append('>');
        info.append(" [\uD83D\uDC96").append(health)
                .append(" \uD83D\uDDE1").append(attack)
                .append(" \uD83D\uDEE1").append(defence)
                .append(" \uD83D\uDD25").append((damage[0] + damage[1]) / 2)
                .append(" \uD83D\uDC5F").append(speed).append(' ').append(quantity);
        if (shoot > 0) { info.append(" \uD83D\uDCA5").append(shoot); }
        info.append(']');
        return info.toString();
    }

    @Override
    public void step() {

    }

    public double getDamage(Unit enemy) {
        int d = enemy.defence - attack;
        if (d == 0) {
            return ((this.damage[0] + this.damage[1]) / 2.0) * quantity;
        } else if (d < 0) {
            return this.damage[0] * quantity;
        } else {
            return this.damage[1] * quantity;
        }
    }

    public void getHit(double damage) {
        double tmpHealth = (quantity - 1) * maxHealth + health;
        tmpHealth -= damage;
        if (tmpHealth <= 0) {
            this.health = 0;
            this.status = "Мертв";
            quantity = 0;
        } else {
            quantity = (int) (tmpHealth / maxHealth);
            health = maxHealth;
            if (tmpHealth % maxHealth > 0) {
                quantity++;
                health = tmpHealth % maxHealth;
            }
        }
    }
}