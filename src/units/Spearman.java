package units;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Spearman extends Unit {
    public Spearman(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false, "Копейщик");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDD8C";
        quantity = new Random().nextInt(10,15);
    }

    @Override
    public void step() {
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
            if (dist < 2) {
                enemyGang.get(index).getHit(getDamage(enemyGang.get(index)));
            } else {
                Vector2 enemyPos = enemyGang.get(index).getPosition();
                Vector2 newPos = new Vector2(0,0);
                if (enemyPos.y == position.y) {
                    newPos.y = position.y;
                    if (position.x - enemyPos.x < 0) {
                        newPos.x = position.x + 1;
                    } else {
                        newPos.x = position.x - 1;
                    }
                } else {
                    newPos.x = position.x;
                    if (enemyPos.y - position.y > 0) {
                        newPos.y = position.y + 1;
                    } else {
                        newPos.y = position.y - 1;
                    }
                }
                AtomicBoolean empty = new AtomicBoolean(true);
                gang.forEach(unit -> {
                    if (unit.getPosition().isEquals(newPos)) {
                        empty.set(false);
                    }
                });
                if (empty.get()) {
                    position = newPos;
                }

            }

        }
    }
}
