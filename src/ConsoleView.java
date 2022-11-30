import units.Vector2;

import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("--b"))) + formatDiv("--c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("--e"))) + formatDiv("--f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(Main.GANG_SIZE - 1, formatDiv("--h"))) + formatDiv("--i");

    public static void view() {
        if (step == 1) {
            System.out.println(AnsiColors.RED + "First step." + AnsiColors.RESET);
        } else {
            System.out.println(AnsiColors.RED + "Step №" + step + "." + AnsiColors.RESET);
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|    ");
            System.out.println(getInfo(i));
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, Main.GANG_SIZE)));
        }
        System.out.print("|    ");
        System.out.println(getInfo(Main.GANG_SIZE));
        System.out.println(ConsoleView.bottom10);
        System.out.println("Press Enter.");
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(Vector2 position) {
        String str = "|  ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            String color = AnsiColors.RED_BG;
            if (Main.rightGang.get(i).getPosition().isEquals(position)) {
                if (!Main.rightGang.get(i).getStatus().equals("Мертв")) {
                    color = AnsiColors.CYAN_BG;
                }
                str = "|" + AnsiColors.getColorString(color, Main.rightGang.get(i).getIcon());
            }
            if (Main.leftGang.get(i).getPosition().isEquals(position)) {
                if (!Main.leftGang.get(i).getStatus().equals("Мертв")) {
                    color = AnsiColors.YELLOW_BG;
                }
                str = "|" + AnsiColors.getColorString(color, Main.leftGang.get(i).getIcon());
            }
        }
        return str;
    }

    private static String getInfo(int row) {
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.leftGang.get(i).getPosition().getY() == row) {
                info.append(AnsiColors.getColorString(AnsiColors.YELLOW, Main.leftGang.get(i).getInfo()));
                int length = info.length();
                info.append(" ".repeat(Math.max(0, 81 - length)));
            }
            if (Main.rightGang.get(i).getPosition().getY() == row) {
                info.append(AnsiColors.getColorString(AnsiColors.CYAN, Main.rightGang.get(i).getInfo()));
            }
        }
        return info.toString();
    }

}
