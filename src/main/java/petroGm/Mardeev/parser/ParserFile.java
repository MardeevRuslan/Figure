package petroGm.Mardeev.parser;

import petroGm.Mardeev.exception.InvalidDataException;
import petroGm.Mardeev.factory.FigureFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
        InputStream inputStream = getClass().getResourceAsStream("/CreateFigure.txt");
        if (inputStream == null) {
            System.out.println("Ресурс не найден");
            return;
        }
        try (Scanner scanner = new Scanner(inputStream)) {
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
        }
    }
}
