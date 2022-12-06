package units;

import java.util.List;
import java.util.Random;

public class Monk extends Unit {

    public Monk(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(12, 7, 0, new int[]{-4,-4}, 30, 5, false, true, "Монах");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83E\uDDD8";
        quantity = new Random().nextInt(2,5);
    }

    @Override
    public void step() {
        double minHealth = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health > 0 && gang.get(i).health < gang.get(i).maxHealth) {
                if (gang.get(i).health < minHealth) {
                    minHealth = gang.get(i).health;
                    minIndex = i;
                }
            }
        }
        if (minIndex >= 0) {
            gang.get(minIndex).health -= this.damage[0];
            if (gang.get(minIndex).health > gang.get(minIndex).maxHealth) {
                gang.get(minIndex).health = gang.get(minIndex).maxHealth;
            }
        }

    }
}
