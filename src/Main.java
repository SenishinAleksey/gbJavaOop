import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int GANG_SIZE = 5;
    public static void main(String[] args) {
        List<Unit> whiteSide = new ArrayList<>();
        List<Unit> blackSide = new ArrayList<>();
        while (whiteSide.size() < GANG_SIZE) {
            whiteSide.add(getUnit(0, whiteSide));
            blackSide.add(getUnit(3, blackSide));
        }
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        blackSide.forEach(unit -> System.out.println(unit.getInfo()));
        System.out.println();
        whiteSide.forEach(Unit::step);
        blackSide.forEach(Unit::step);
        whiteSide.forEach(unit -> System.out.println(unit.getInfo()));
        blackSide.forEach(unit -> System.out.println(unit.getInfo()));
    }

    private static Unit getUnit(int origin, List<Unit> side) {
        int num = new Random().nextInt(origin, origin + 4);
        return switch (num) {
            case 0 -> new Monk(side);
            case 1 -> new Robber();
            case 2 -> new Sniper();
            case 3 -> new Peasant();
            case 4 -> new Spearman();
            case 5 -> new Wizard(side);
            default -> new Xbowman();
        };
    }

    private static void getType(List<Unit> units, String type) {
        for (Unit unit : units) {
            if (unit.toString().split(" ")[0].equals(type)) {
                System.out.println(unit);
            }
        }
    }
}