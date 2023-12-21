package petroGm.test.Mardeev.figureList;

import petroGm.test.Mardeev.models.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureListSingleton {
    private static FigureListSingleton instance;
    private List<Figure> figureList;

    private FigureListSingleton() {
        figureList = new ArrayList<>();
    }

    public static FigureListSingleton getInstance() {
        if (instance == null) {
            instance = new FigureListSingleton();
        }
        return instance;
    }

    public List<Figure> getFigureList() {
        return figureList;
    }
}