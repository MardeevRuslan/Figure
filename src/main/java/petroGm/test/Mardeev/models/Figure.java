package petroGm.test.Mardeev.models;

import petroGm.test.Mardeev.intersections.Intersections;

public interface Figure {
    void draw();
    default void intersect(Figure figure) {
        Intersections.intersect(this, figure);
    }
}
