package units;

import java.util.List;

public class Peasant extends Unit {


    public Peasant(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(1, 1, 0, new int[]{1,1}, 1, 3, true, false, "Крестьянин");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDC68";
    }

    @Override
    public void step() {
        if (this.status.equals("Занят")) {
            this.status = "Стоит";
        }
    }
}
