package units;

import java.util.List;

public class Robber extends Unit {
    public Robber(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, false, false, "Разбойник");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDD2A";
    }
}
