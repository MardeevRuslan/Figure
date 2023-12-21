package petroGm.test.Mardeev.models;

public class Line implements Figure{

    private final String name = "line";
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



    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw() {
        System.out.println(this.name + " at (" + this.x1 + ", " + this.y1 + "), (" + this.x2 + ", " + this.y2 + ")");
    }

    @Override
    public void intersect(Figure figure1) {

    }

}
