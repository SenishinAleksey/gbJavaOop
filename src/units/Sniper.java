package units;

import java.util.List;

public class Sniper extends Unit {
    public Sniper(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(12, 10, 32, new int[]{8,10}, 15, 9, false, false, "Снайпер");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDD2B";
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
