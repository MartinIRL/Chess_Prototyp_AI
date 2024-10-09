package Kern_Logik_Klassen;

import java.util.function.Predicate;

public enum FigurTyp {


    BAUER((figurFarbe, x, y) ->{
        //kann 1 oder 2 nach oben, wenn diagonal eine figur steht, schlagbar...
        return (y == (figurFarbe == FigurFarbe.WEISS ? -1 : 1)) ||
                (y == (figurFarbe == FigurFarbe.WEISS ? -2 : 2)) ||
                (y == (figurFarbe == FigurFarbe.WEISS ? -1 : 1) && Math.abs(x) == 1);
    }),
    TURM((figurFarbe, x, y) -> {
        boolean istZugLegalHorizontal = x != 0 && y == 0;
        boolean istZugLegalVertikal = x == 0 && y != 0;
        return istZugLegalVertikal || istZugLegalHorizontal;
    }),
    SPRINGER((figurFarbe, x, y) ->{
        return (Math.abs(x) == 2 && Math.abs(y) == 1) || (Math.abs(x) == 1 && Math.abs(y) == 2) &&  !(x == 0 && y == 0);
    } ),
    KOENIGIN((figurFarbe, x, y) -> {
        boolean istZugLegalDiagonal = (Math.abs(x) == Math.abs(y));
        boolean istZugLegalHorizontal = x != 0 && y == 0;
        boolean istZugLegalVertikal = x == 0 && y != 0;

        return istZugLegalDiagonal &&  !(x == 0) || istZugLegalHorizontal || istZugLegalVertikal;
    }),
    KOENIG((figurFarbe, x, y) -> {
        return Math.abs(x) <= 1 && Math.abs(y) <=1 && !(x == 0 && y == 0);
    }),
    LAUEFER((figurFarbe, x, y) ->{
        return Math.abs(x) == Math.abs(y) &&  !(x == 0 && y == 0);
    } );


    private final PredicateBewegung<FigurFarbe, Integer,Integer> istBewegungMoeglich;

    FigurTyp(PredicateBewegung<FigurFarbe,Integer,Integer> istBewegungMoeglich){
        this.istBewegungMoeglich = istBewegungMoeglich;
    }


    public PredicateBewegung<FigurFarbe, Integer, Integer> getIstBewegungMoeglich() {
        return istBewegungMoeglich;
    }
}
