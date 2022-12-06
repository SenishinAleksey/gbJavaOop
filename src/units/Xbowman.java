package units;

import java.util.List;
import java.util.Random;

public class Xbowman extends Unit {
    public Xbowman(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(6, 3, 16, new int[]{2,3}, 10, 4, false, false, "Арбалетчик");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83C\uDFF9";
        quantity = new Random().nextInt(2, 8);
    }

    @Override
    public void step() {
        for (Unit unit: super.gang) {
            if (unit.getName().equals("Крестьянин")) {
                if (!unit.status.equals("Мертв") && !unit.status.equals("Занят")) {
                    shoot++;
                    unit.status = "Занят";
                    break;
                }
            }
        }
        if (shoot > 0) {
            double dist = Double.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < enemyGang.size(); i++) {
                if (enemyGang.get(i).status.equals("Мертв")) {
                    continue;
                }
                double tmp = enemyGang.get(i).getPosition().getDistance(this.getPosition());
                if (dist > tmp) {
                    dist = tmp;
                    index = i;
                }
            }
            if (index >= 0) {
                enemyGang.get(index).getHit(speed > dist ? getDamage(enemyGang.get(index)) : getDamage(enemyGang.get(index)) / 2);
                shoot--;
            }
        }
    }
}
