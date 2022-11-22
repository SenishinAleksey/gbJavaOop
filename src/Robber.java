public class Robber extends Unit {

    public Robber() {
        super(8, 3, new int[]{2, 4}, 10, 6, "Stand");
    }

    @Override
    public String toString() {
        return "Разбойник " + super.toString() + ", " + state;
    }
}
