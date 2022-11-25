public class Spearman extends Unit {

    public Spearman() {
        super(4, 5, new int[]{1, 3}, 10, 4, "Stand");
    }

    @Override
    public String getInfo() {
        return "Копейщик " + super.getInfo() + ", " + state;
    }
}
