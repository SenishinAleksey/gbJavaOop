import chars.Vector2;

import java.util.Collections;

public class ConsoleView {

    private static int step = 1;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("--b")))+formatDiv("--c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("--e")))+formatDiv("--f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("--h")))+formatDiv("--i");

    public static void view(){
        if (step == 1) {
            System.out.println(AnsiColors.RED+"First step."+AnsiColors.RESET);
        } else {
            System.out.println(AnsiColors.RED+"Step №" + step +"."+AnsiColors.RESET);
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE-1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|    ");
            System.out.println(getInfo(i));
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, 10)));
        }
        System.out.print("|    ");
        System.out.println(getInfo(10));
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
                .replace('-', '\u2500')
                .replace("S", "...")
                .replace("O", "---");
    }
    private static String getChar(Vector2 position){
        String str = "|  ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEquals(position)) {
                str = "|" + AnsiColors.BLUE_BACKGROUND + Main.darkSide.get(i).getIcon() + AnsiColors.RESET;
            }
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
                str = "|" + AnsiColors.GREEN_BACKGROUND + Main.whiteSide.get(i).getIcon() + AnsiColors.RESET;
            }
        }
        return str;
    }

    private static String getInfo(int row){
        StringBuilder info = new StringBuilder();
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.whiteSide.get(i).getPosition().getY() == row) {
                info.append(AnsiColors.GREEN).append(Main.whiteSide.get(i).getInfo()).append(AnsiColors.RESET);
                int length = info.length();
                for (int j = 0; j <= 80 - length; j++) {
                    info.append(' ');
                }
            }
            if (Main.darkSide.get(i).getPosition().getY() == row) {
                info.append(AnsiColors.BLUE).append(Main.darkSide.get(i).getInfo()).append(AnsiColors.RESET);
            }
        }
        return info.toString();
    }

}
