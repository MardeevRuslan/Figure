package petroGm.Mardeev.models;

import java.util.Objects;

public class Point implements Figure{

    private final String name = "point";
    private final int x;
    public final int y;

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y && Objects.equals(name, point.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y);
    }

    @Override
    public void draw() {
        System.out.println(this.name + " at (" + this.x + ", " + this.y + ")");
    }

}
