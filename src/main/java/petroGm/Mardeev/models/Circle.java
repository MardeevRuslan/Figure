package petroGm.Mardeev.models;

import java.util.Objects;

public class Circle implements Figure{

    private final String name = "circle";
    private final int x;
    public final int y;
    private final int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return x == circle.x && y == circle.y && r == circle.r && Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y, r);
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public String getName() {
        return name;
    }

    @Override
    public void draw() {
        System.out.println(this.name + " at (" + this.x + ", " + this.y + "), rаdius = " + this.r);
    }

}
