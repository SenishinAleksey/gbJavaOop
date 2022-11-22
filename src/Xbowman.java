public class Xbowman extends Unit {

    private int shoots;

    public Xbowman() {
        super(6, 3, new int[]{2, 3}, 10, 4, "Stand");
        shoots = 16;
    }

    public String toString() {
        return "Арбалетчик " + super.toString() + ", выстрелы: " + shoots + ", " + state;
    }
}
