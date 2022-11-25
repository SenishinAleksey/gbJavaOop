public class Sniper extends Unit {

    private int shoots;

    public Sniper() {
        super(12, 10, new int[]{8, 10}, 15, 9, "Stand");
        shoots = 32;
    }

    @Override
    public String getInfo() {
        return "Снайпер " + super.getInfo() + ", выстрелы: " + shoots + ", " + state;
    }
}
