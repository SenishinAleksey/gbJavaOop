package units;

public class Vector2 {
    int x, y;

    public Vector2(int x, int y){this.x = x; this.y = y;}

    public boolean isEquals(Vector2 opposit){
        if (opposit.y == y && opposit.x == x) return true;
        return false;
    }

    public int getY() {
        return y;
    }

    public double getDistance(Vector2 opposite) {
        return Math.sqrt(Math.pow(opposite.x - this.x, 2) + Math.pow(opposite.y - this.y, 2));
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}