package petroGm.test.Mardeev.models;

public class Point implements Figure{

    private final String name = "point";
    private final int x;
    public final int y;

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
    public void draw() {
        System.out.println(this.name + " at (" + this.x + ", " + this.y + ")");
    }

    @Override
    public void intersect(Figure figure1) {

    }


}
