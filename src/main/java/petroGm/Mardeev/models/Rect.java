package petroGm.Mardeev.models;

import java.util.Objects;

public class Rect implements Figure {
    private final String name = "rect";
    private final int x1;
    public final int y1;

    private final int x2;

    public final int y2;

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getName() {
        return name;
    }

    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return x1 == rect.x1 && y1 == rect.y1 && x2 == rect.x2 && y2 == rect.y2 && Objects.equals(name, rect.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x1, y1, x2, y2);
    }

    @Override
    public void draw() {
        System.out.println(this.name + " at (" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ")");
    }

}
