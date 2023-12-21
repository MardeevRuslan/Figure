package petroGm.test.Mardeev.parser;

import petroGm.test.Mardeev.exception.InvalidDataException;
import petroGm.test.Mardeev.factory.FigureFactory;
import petroGm.test.Mardeev.models.Figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserFile {

    private FigureFactory figureFactory;

    public ParserFile() {
        this.figureFactory = new FigureFactory();
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
                String[] parts = line.split(" ");
                String figureType = parts[0];
                List<Integer> parameters = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    parameters.add(Integer.parseInt(parts[i]));
                }
                try {
                    figureFactory.addFigure(figureType, parameters);
                } catch (InvalidDataException e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
