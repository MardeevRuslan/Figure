package petroGm.test.Mardeev.parser;

import petroGm.test.Mardeev.factory.FigureFactory;
import petroGm.test.Mardeev.models.Figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserFile {
    private List<Figure> figureList;

    public ParserFile() {
        this.figureList = new ArrayList<>();
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    public void complete() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceUrl = classLoader.getResource("CreateFigure.txt");
        if (resourceUrl == null) {
            System.out.println("Ресурс не найден");
            return;
        }
        File file = new File(resourceUrl.getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
                FigureFactory factory = new FigureFactory();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
