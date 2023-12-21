package petroGm.Mardeev.app;


import petroGm.Mardeev.figureList.FigureListSingleton;
import petroGm.Mardeev.parser.ParserFile;
import petroGm.Mardeev.models.Figure;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        ParserFile parserFile = new ParserFile();
        parserFile.complete();
        List<Figure> figureList = FigureListSingleton.getInstance().getFigureList();
        for (int i = 0; i <= figureList.size() - 1; i+=2) {
            Figure figure = figureList.get(i);
            figure.draw();
            if(i + 1 < figureList.size()) {
                Figure figure1 = figureList.get(i + 1);
                figure1.draw();
                figure.intersect(figure1);
            }
            System.out.println();
        }
    }
}
