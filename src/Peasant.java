public class Peasant extends Unit {

    private boolean delivery;

    public Peasant() {
        super(1, 1, new int[]{0, 1}, 1, 3, "Stand");
        delivery = true;
    }

    @Override
    public String getInfo() {
        return "Крестьянин " + super.getInfo() + ", доставка, " + state;
    }
}
