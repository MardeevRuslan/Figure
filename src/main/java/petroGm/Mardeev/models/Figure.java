package petroGm.Mardeev.models;

import petroGm.Mardeev.intersections.Intersections;

public interface Figure {
    void draw();
    default void intersect(Figure figure) {
        Intersections.intersect(this, figure);
    }
}
