package petroGm.test.Mardeev.factory;

import petroGm.test.Mardeev.exception.InvalidDataException;
import petroGm.test.Mardeev.figureList.FigureListSingleton;
import petroGm.test.Mardeev.models.*;

import java.util.List;

public class FigureFactory {
    private List<Figure> figureList;

    public FigureFactory() {
        this.figureList = FigureListSingleton.getInstance().getFigureList();
    }

    public void addFigure(String figureType, List<Integer> parameters) throws InvalidDataException {
        Figure figure = getFigure(figureType, parameters);
        figureList.add(figure);
    }
    private Figure getFigure(String figureType, List<Integer> parameters) throws InvalidDataException {
        switch (figureType) {
            case "point":
                return createPoint(parameters);
            case "circle":
                return createCircle(parameters);
            case "rect":
                return createRect(parameters);
            case "line" :
                return createLine(parameters);
            default:
                throw new InvalidDataException("Boss, there is no such figure on the list: " + figureType);
        }
    }

    private Point createPoint(List<Integer> parameters) throws InvalidDataException {
        if (parameters.size() != 2) {
            throw new InvalidDataException("Boss, this point is wrong, " + parameters.size() + " parameters are set, but 2 are needed");
        }
        return new Point(parameters.get(0), parameters.get(1) );
    }

    private Rect createRect(List<Integer> parameters) throws InvalidDataException {
        if (parameters.size() != 4) {
            throw new InvalidDataException("Boss, this rect is wrong, " + parameters.size() + " parameters are set, but 4 are needed");
        }
        return new Rect(parameters.get(0),  parameters.get(1), parameters.get(2), parameters.get(3));
    }

    private Circle createCircle(List<Integer> parameters) throws InvalidDataException {
        if (parameters.size() != 3) {
            throw new InvalidDataException("Boss, this circle is wrong, " + parameters.size() + " parameters are set, but 3 are needed");
        }
        return new Circle(parameters.get(0),  parameters.get(1), parameters.get(2));
    }

    private Line createLine(List<Integer> parameters) throws InvalidDataException {
        if (parameters.size() != 4) {
            throw new InvalidDataException("Boss, this line is wrong, " + parameters.size() + " parameters are set, but 4 are needed");
        }
        return new Line(parameters.get(0),  parameters.get(1), parameters.get(2), parameters.get(3));
    }
}
