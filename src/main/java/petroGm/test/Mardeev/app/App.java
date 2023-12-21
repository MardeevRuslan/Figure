package petroGm.test.Mardeev.app;


import petroGm.test.Mardeev.figureList.FigureListSingleton;
import petroGm.test.Mardeev.models.Figure;
import petroGm.test.Mardeev.parser.ParserFile;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ParserFile parserFile = new ParserFile();
        parserFile.complete();
        List<Figure> figureList = FigureListSingleton.getInstance().getFigureList();
        for (Figure figure : figureList) {
            for (Figure figure1 : figureList) {
                figure.draw();
                figure1.draw();
                figure1.intersect(figure);
                System.out.println();
            }
        }
    }
}
