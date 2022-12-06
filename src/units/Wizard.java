package units;

import java.util.*;

public class Wizard extends Unit {

    static int tmpInd = -1;
    public Wizard(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(17, 12, 0, new int[]{-5,-5}, 30, 9, false, true, "Волшебник");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83E\uDDD9";
        quantity = new Random().nextInt(1,4);
    }

    @Override
    public void step() {
        Map<Integer, Double> healths = new HashMap<>();
        for (int i = 0; i < gang.size(); i++) {
            healths.put(i, gang.get(i).health / gang.get(i).maxHealth);
        }
        List<Double> a = new ArrayList<>(healths.values().stream().toList());
        Collections.sort(a);
        healths.forEach((index, value) -> {
            if (value.equals(a.get(0))) {
                tmpInd = index;
            }
        });
        if (a.get(0) > 0.5) {
            double dist = 1;
            int index = -1;
            for (int i = 0; i < enemyGang.size(); i++) {
                if (enemyGang.get(i).status.equals("Мертв")) {
                    continue;
                }
                if (enemyGang.get(i).health / enemyGang.get(i).maxHealth < dist) {
                    dist = enemyGang.get(i).health / enemyGang.get(i).maxHealth;
                    index = i;
                }
            }
            if (index < 0) {
                index = 0;
            }
            enemyGang.get(index).getHit(damage[0] * -1);
            status = "Выстрелил в " + index;
            return;
        }
        if (a.get(0).equals(0.0)) {
            tmpInd = -1;
            healths.forEach((index, value) -> {
                if (value.equals(0.0)) {
                    if (gang.get(index).getName().equals("Арбалетчик") || gang.get(index).getName().equals("Волшебник")) {
                        tmpInd = index;
                    }
                }
            });
            if (tmpInd >= 0) {
                gang.get(tmpInd).health = 1;
                gang.get(tmpInd).status = "Стоит";
                gang.get(tmpInd).quantity = 1;
                status = "Возродил " + tmpInd;
            }
            return;
        }
        if (a.get(0) <= 0.5) {
            gang.get(tmpInd).health -= this.damage[0];
            if (gang.get(tmpInd).health > gang.get(tmpInd).maxHealth) {
                gang.get(tmpInd).health = gang.get(tmpInd).maxHealth;
            }
            status = "Вылечил " + tmpInd;
        }

    }
}
