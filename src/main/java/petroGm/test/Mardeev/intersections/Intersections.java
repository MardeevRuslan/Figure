package petroGm.test.Mardeev.intersections;

import petroGm.test.Mardeev.models.*;

import java.util.ArrayList;
import java.util.List;

public class Intersections {

    public static void intersect(Figure figure, Figure figure1) {
        if (figure.getClass() == figure1.getClass()) {
            if (figure.equals(figure1)) {
                System.out.println("The " + figure.getClass().getSimpleName() + " and the " + figure1.getClass().getSimpleName() + " match");
                return;
            }
            intersectEqualsFigure(figure, figure1);
        } else {
            if (figure.getClass() == Point.class || figure1.getClass() == Point.class) {
                if (figure.getClass() == Circle.class || figure1.getClass() == Circle.class) {
                    intersectPointAndCircle(figure, figure1);
                } else if (figure.getClass() == Rect.class || figure1.getClass() == Rect.class) {
                    intersectPointAndRect(figure, figure1);
                } else if (figure.getClass() == Line.class || figure1.getClass() == Line.class) {
                    intersectPointAndLine(figure, figure1);
                }
            } else if (figure.getClass() == Line.class || figure1.getClass() == Line.class) {
                if (figure.getClass() == Circle.class || figure1.getClass() == Circle.class) {
                    intersectLineAndCircle(figure, figure1);
                } else if (figure.getClass() == Rect.class || figure1.getClass() == Rect.class) {
                    intersectLineAndCRect(figure, figure1);
                }
            } else if (figure.getClass() == Circle.class || figure1.getClass() == Circle.class) {
                if (figure.getClass() == Rect.class || figure1.getClass() == Rect.class) {
                    intersectCircleAndCRect(figure, figure1);
                }
            }
        }
    }

    public static void intersectEqualsFigure(Figure figure, Figure figure1) {
        if (figure.getClass() == Point.class) {
            intersectPoint((Point) figure, (Point) figure1);
        } else if (figure.getClass() == Circle.class) {
            intersectCircle((Circle) figure, (Circle) figure1);
        } else if (figure.getClass() == Rect.class) {
            intersectRect((Rect) figure, (Rect) figure1);
        } else if (figure.getClass() == Line.class) {
            intersectLine((Line) figure, (Line) figure1);
        } else {
            throw new RuntimeException();
        }
    }

    public static void intersectPoint(Point point, Point point1) {
        printNotIntersection(point.getName(), point1.getName());
    }

    private static void intersectCircle(Circle circle, Circle circle1) {

        int x1 = circle.getX();
        int y1 = circle.getY();
        int r1 = circle.getR();

        int x2 = circle1.getX();
        int y2 = circle1.getY();
        int r2 = circle1.getR();

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        List<Double> coordinate = new ArrayList<>();

        if (distance == r1 + r2) {
            double pointX = x1 + (r1 * (x2 - x1)) / distance;
            double pointY = y1 + (r1 * (y2 - y1)) / distance;
            coordinate.add(pointX);
            coordinate.add(pointY);
            printIntersection(circle.getName(), circle1.getName(), coordinate);
        } else if (distance <= r1 + r2 || distance < Math.abs(r1 - r2)) {
            double d = (Math.pow(r1, 2) - Math.pow(r2, 2) + Math.pow(distance, 2)) / (2 * distance);
            double h = Math.sqrt(Math.pow(r1, 2) - Math.pow(d, 2));
            double pointX1 = x1 + (d * (x2 - x1)) / distance + (h * (y2 - y1)) / distance;
            double pointY1 = y1 + (d * (y2 - y1)) / distance - (h * (x2 - x1)) / distance;
            double pointX2 = x1 + (d * (x2 - x1)) / distance - (h * (y2 - y1)) / distance;
            double pointY2 = y1 + (d * (y2 - y1)) / distance + (h * (x2 - x1)) / distance;
            coordinate.add(pointX1);
            coordinate.add(pointY1);
            coordinate.add(pointX2);
            coordinate.add(pointY2);
            printIntersection(circle.getName(), circle1.getName(), coordinate);
        } else {
            printNotIntersection(circle.getName(), circle1.getName());
        }
    }


    public static void intersectRect(Rect rect, Rect rect1) {
        List<Line> lineList = createLineForRect(rect);
        List<Line> lineList1 = createLineForRect(rect1);
        List<Double> coordinate = new ArrayList<>();
        for (Line line : lineList) {
            for (Line line1 : lineList1) {
                try {
                    List<Double> coordinateOneLine = intersectOneLine(line, line1);
                    if (!coordinateOneLine.isEmpty()) {
                        coordinate.addAll(coordinateOneLine);
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        if (coordinate.isEmpty()) {
            printNotIntersection(rect.getName(), rect1.getName());
        } else {
            deleteEqualCoordinate(coordinate);
            printIntersection(rect.getName(), rect1.getName(), coordinate);
        }
    }

    private static List<Line> createLineForRect(Rect rect) {
        List<Line> lineLine = new ArrayList<>();
        lineLine.add(new Line(rect.getX1(), rect.getY1(), rect.getX2(), rect.getY1()));
        lineLine.add(new Line(rect.getX1(), rect.getY1(), rect.getX1(), rect.getY2()));
        lineLine.add(new Line(rect.getX2(), rect.getY2(), rect.getX2(), rect.getY1()));
        lineLine.add(new Line(rect.getX2(), rect.getY2(), rect.getX1(), rect.getY2()));
        return lineLine;
    }

    public static void intersectLine(Line line, Line line1) {
        try {
            List<Double> coordinate = intersectOneLine(line, line1);
            if (coordinate.isEmpty()) {
                printNotIntersection(line.getName(), line1.getName());
            } else {
                printIntersection(line.getName(), line1.getName(), coordinate);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void intersectPointAndCircle(Figure figure, Figure figure1) {
        Point point = (Point) (figure instanceof Point ? figure : figure1);
        Circle circle = (Circle) (figure instanceof Circle ? figure : figure1);
        double distance = Math.sqrt(Math.pow(point.getX() - circle.getX(), 2) + Math.pow(point.getY() - circle.getY(), 2));
        if (distance == circle.getR()) {
            List<Double> coordinate = new ArrayList<>();
            coordinate.add((double) point.getX());
            coordinate.add((double) point.getY());
            printIntersection(point.getName(), circle.getName(), coordinate);
        }
    }

    public static void intersectPointAndLine(Figure figure, Figure figure1) {
        Point point = (Point) (figure instanceof Point ? figure : figure1);
        Line line = (Line) (figure instanceof Line ? figure : figure1);
        List<Double> coordinate = intersectPointAndOneLine(point, line);
        if (coordinate.isEmpty()) {
            printNotIntersection(line.getName(), point.getName());
        } else {
            printIntersection(line.getName(), point.getName(), coordinate);
        }
    }

    public static void intersectPointAndRect(Figure figure, Figure figure1) {
        Point point = (Point) (figure instanceof Point ? figure : figure1);
        Rect rect = (Rect) (figure instanceof Rect ? figure : figure1);
        List<Line> lineList = createLineForRect(rect);
        List<Double> coordinate = new ArrayList<>();
        for (Line line : lineList) {
            List<Double> coordinateOneLine = intersectPointAndOneLine(point, line);
            if (!coordinateOneLine.isEmpty()) {
                coordinate.addAll(coordinateOneLine);
                break;
            }
        }
        if (coordinate.isEmpty()) {
            printNotIntersection(rect.getName(), point.getName());
        } else {
            deleteEqualCoordinate(coordinate);
            printIntersection(rect.getName(), point.getName(), coordinate);
        }
    }

    public static void intersectLineAndCircle(Figure figure, Figure figure1) {
        Line line = (Line) (figure instanceof Line ? figure : figure1);
        Circle circle = (Circle) (figure instanceof Circle ? figure : figure1);
        List<Double> coordinate = intersectCircleAndOneLine(circle, line);
        if (coordinate.isEmpty()) {
            printNotIntersection(circle.getName(), line.getName());
        } else {
            printIntersection(circle.getName(), line.getName(), coordinate);
        }
    }

    public static void intersectLineAndCRect(Figure figure, Figure figure1) {
        Line line = (Line) (figure instanceof Line ? figure : figure1);
        Rect rect = (Rect) (figure instanceof Rect ? figure : figure1);
        List<Line> lineList = createLineForRect(rect);
        List<Double> coordinate = new ArrayList<>();
        try {
            for (Line lineRect : lineList) {
                List<Double> coordinateOne = intersectOneLine(line, lineRect);
                if (!coordinateOne.isEmpty()) {
                    coordinate.addAll(coordinateOne);
                }
            }
            if (coordinate.isEmpty()) {
                printNotIntersection(line.getName(), rect.getName());
            } else {
                printIntersection(line.getName(), rect.getName(), coordinate);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void intersectCircleAndCRect(Figure figure, Figure figure1) {
        Circle circle = (Circle) (figure instanceof Circle ? figure : figure1);
        Rect rect = (Rect) (figure instanceof Rect ? figure : figure1);
        List<Line> lineList = createLineForRect(rect);
        List<Double> coordinate = new ArrayList<>();
        for (Line line : lineList) {
            List<Double> coordinateOne = intersectCircleAndOneLine(circle, line);
            if (!coordinateOne.isEmpty()) {
                coordinate.addAll(coordinateOne);
            }
        }
        if (coordinate.isEmpty()) {
            printNotIntersection(circle.getName(), rect.getName());
        } else {
            deleteEqualCoordinate(coordinate);
            printIntersection(circle.getName(), rect.getName(), coordinate);
        }
    }


    private static List<Double> intersectPointAndOneLine(Point point, Line line) {
        List<Double> coordinate = new ArrayList<>();
        if (point.getX() >= Math.min(line.getX1(), line.getX2()) && point.getX() <= Math.max(line.getX1(), line.getX2()) &&
                point.getY() >= Math.min(line.getY1(), line.getY2()) && point.getY() <= Math.max(line.getY1(), line.getY2())) {
            coordinate.add((double) point.getX());
            coordinate.add((double) point.getY());
        }
        return coordinate;
    }

    private static List<Double> intersectCircleAndOneLine(Circle circle, Line line) {
        List<Double> coordinate = new ArrayList<>();
        double a = 1;
        double b = -2 * circle.getX();
        double c = -2 * circle.getY();
        double d = circle.getX() * circle.getX() + circle.getY() * circle.getY() - circle.getR() * circle.getR();


        double m = (line.getY2() - line.getY1()) / (line.getX2() - line.getX1());
        double bLine = line.getY1() - m * line.getX1();


        double A = 1 + m * m;
        double B = 2 * m * bLine - 2 * circle.getX() - 2 * circle.getY() * m;
        double C = circle.getX() * circle.getX() + circle.getY() * circle.getY() + bLine * bLine - 2 * bLine * circle.getY() - circle.getR() * circle.getR();

        double discriminant = B * B - 4 * A * C;

        if (discriminant < 0) {
            return coordinate;
        }

        if (discriminant == 0) {
            double x = -B / (2 * A);
            double y = m * x + bLine;
            if (isCoordinate(x, y, line)) {
                coordinate.add(x);
                coordinate.add(y);
            }
            return coordinate;
        }

        double x1 = (-B + Math.sqrt(discriminant)) / (2 * A);
        double y1 = m * x1 + bLine;
        double x2 = (-B - Math.sqrt(discriminant)) / (2 * A);
        double y2 = m * x2 + bLine;

        if (isCoordinate(x1, y1, line)) {
            coordinate.add(x1);
            coordinate.add(y1);
        }
        if (isCoordinate(x2, y2, line)) {
            coordinate.add(x2);
            coordinate.add(y2);
        }
        return coordinate;
    }

    private static boolean isCoordinate(double x, double y, Line line) {
        return ((x >= Math.min(line.getX1(), line.getX2()) &&
                x <= Math.max(line.getX1(), line.getX2()))) &&
                ((y >= Math.min(line.getY1(), line.getY2()) &&
                        x <= Math.max(line.getY1(), line.getY2())));
    }

    private static List<Double> intersectOneLine(Line line, Line line1) throws RuntimeException {

        double x1 = line.getX1();
        double y1 = line.getY1();
        double x2 = line.getX2();
        double y2 = line.getY2();

        double x3 = line1.getX1();
        double y3 = line1.getY1();
        double x4 = line1.getX2();
        double y4 = line1.getY2();

        if ((x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2) &&
                y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2) &&
                x4 >= Math.min(x1, x2) && x4 <= Math.max(x1, x2) &&
                y4 >= Math.min(y1, y2) && y4 <= Math.max(y1, y2)) ||
                (x1 >= Math.min(x3, x4) && x1 <= Math.max(x3, x4) &&
                        y1 >= Math.min(y3, y4) && y1 <= Math.max(y3, y4) &&
                        x2 >= Math.min(x3, x4) && x2 <= Math.max(x3, x4) &&
                        y2 >= Math.min(y3, y4) && y2 <= Math.max(y3, y4))) {
            throw new RuntimeException("An infinite number of intersection points");
        }

        double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        List<Double> coordinate = new ArrayList<>();

        if (denominator != 0) {
            double x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;
            double y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;
            if (x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                    y >= Math.min(y1, y2) && y <= Math.max(y1, y2) &&
                    x >= Math.min(x3, x4) && x <= Math.max(x3, x4) &&
                    y >= Math.min(y3, y4) && y <= Math.max(y3, y4)) {
                coordinate.add(x);
                coordinate.add(y);
            }
        }
        return coordinate;
    }

    private static void deleteEqualCoordinate(List<Double> coordinate) {
        if (coordinate.size() >= 4) {
            for (int i = 0; i < coordinate.size() - 3; i += 2) {
                double x1 = coordinate.get(i);
                double y1 = coordinate.get(i + 1);
                if (i + 3 < coordinate.size() && (x1 == coordinate.get(i + 2)) && (y1 == coordinate.get(i + 3))) {
                    coordinate.remove(i + 3);
                    coordinate.remove(i + 2);
                }
            }
        }
    }


    private static void printIntersection(String name, String name1, List<Double> coordinate) {
        System.out.print("Thе " + name + " and the " + name1 + " intersect at  " + coordinate.size() / 2 + " point(s) ");
        for (int i = 0; i < coordinate.size(); i += 2) {
            System.out.print(" (" + coordinate.get(i) + " , " + coordinate.get(i + 1) + " ) ");
        }
        System.out.println();
    }

    private static void printNotIntersection(String name, String name1) {
        System.out.println("Thе " + name + " cannot intersect the " + name1);
    }
}
