package petroGm.test.Mardeev;


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
            figure.draw();
        }
    }
}
