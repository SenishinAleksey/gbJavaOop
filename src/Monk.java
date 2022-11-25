import java.util.List;

public class Monk extends Unit {

    private boolean magic;

    public Monk(List<Unit> gang) {
        super(12, 7, new int[]{-4, -4}, 30, 5, "Stand");
        magic = true;
        super.gang = gang;
    }

    @Override
    public String getInfo() {
        return "Монах " + super.getInfo() + ", магия, " + state;
    }

    @Override
    public void step() {
        float minHealth = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health < gang.get(i).maxHealth) {
                if (gang.get(i).health < minHealth) {
                    minHealth = gang.get(i).health;
                    minIndex = i;
                }
            }
        }
        if (minIndex >= 0) {
            gang.get(minIndex).health -= this.damage[0];
            if (gang.get(minIndex).health > gang.get(minIndex).maxHealth) {
                gang.get(minIndex).health = gang.get(minIndex).maxHealth;
            }
        }

    }
}
