package chars;

import java.util.List;

public class Robber extends Base{
    public Robber(List<Base> gang, int x, int y) {
        super(8, 3, 0, new int[]{2,4}, 10, 6, false, false, "Разбойник");
        super.gang = gang;
        super.position = new Vector2(x, y);
        super.icon = "\uD83D\uDD2A";
    }
}
