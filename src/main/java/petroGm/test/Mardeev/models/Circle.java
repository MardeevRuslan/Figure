package petroGm.test.Mardeev.models;

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

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    @Override
    public void draw() {
        System.out.println(this.name + " at (" + this.x + ", " + this.y + "), rаdius = " + this.r);
    }

    @Override
    public void intersect(Figure figure1) {

    }

}
