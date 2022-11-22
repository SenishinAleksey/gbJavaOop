public class Monk extends Unit {

    private boolean magic;

    public Monk() {
        super(12, 7, new int[]{-4, -4}, 30, 5, "Stand");
        magic = true;
    }

    @Override
    public String toString() {
        return "Монах " + super.toString() + ", магия, " + state;
    }
}
