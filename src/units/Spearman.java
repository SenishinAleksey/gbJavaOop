package units;

import java.util.List;

public class Spearman extends Unit {
    public Spearman(List<Unit> gang, List<Unit> enemyGang, int x, int y) {
        super(4, 5, 0, new int[]{1,3}, 10, 4, false, false, "Копейщик");
        super.gang = gang;
        super.enemyGang = enemyGang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDD8C";
    }
}
