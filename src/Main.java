import units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int GANG_SIZE = 10;
    public static List<Unit> leftGang;
    public static List<Unit> rightGang;

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            turnMove();
            scanner.nextLine();
            System.out.println(leftGang.size());
            System.out.println(rightGang.size());
        }

    }

    private static void turnMove() {
        List<Unit> sortedGang = new ArrayList<>();
        sortedGang.addAll(leftGang);
        sortedGang.addAll(rightGang);
        sortedGang.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());
        sortedGang.forEach(unit -> {
            if (!unit.getStatus().equals("Мертв")) {
                unit.step();
            }
        });
    }

    private static void init() {
        leftGang = new ArrayList<>();
        rightGang = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> leftGang.add(new Peasant(leftGang, rightGang, x, y++));
                case 1 -> leftGang.add(new Robber(leftGang, rightGang, x, y++));
                case 2 -> leftGang.add(new Sniper(leftGang, rightGang, x, y++));
                default -> leftGang.add(new Monk(leftGang, rightGang, x, y++));
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (new Random().nextInt(4)) {
                case 0 -> rightGang.add(new Peasant(rightGang, leftGang, x, y++));
                case 1 -> rightGang.add(new Spearman(rightGang, leftGang, x, y++));
                case 2 -> rightGang.add(new Xbowman(rightGang, leftGang, x, y++));
                default -> rightGang.add(new Wizard(rightGang, leftGang, x, y++));
            }
        }
    }
}