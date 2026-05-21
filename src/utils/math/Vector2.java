package utils.math;

public class Vector2 {
    private int x,y;
    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void x(int x) {
        this.x = x;
    }
    public int x() {
        return x;
    }
    void y(int y) {
        this.y = y;
    }
    public int y() {
        return y;
    }
    public static Vector2 add(Vector2 a, Vector2 b) {
        return new Vector2(a.x + b.x, a.y + b.y);
    }
    public static Vector2 scale(Vector2 a, int scale) {
        return new Vector2(a.x * scale, a.y * scale);
    }
}
