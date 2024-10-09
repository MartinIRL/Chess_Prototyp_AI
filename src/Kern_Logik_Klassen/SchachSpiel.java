package Kern_Logik_Klassen;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SchachSpiel {

    //\\resources
    private final List<SchachFigur> figurenListe = new ArrayList<>();


    public SchachSpiel(){
        addSchachFiguren();
    }


    public void addSchachFiguren(){

        for(FigurFarbe figurFarbe : FigurFarbe.values()) {
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM, figurFarbe)
                    .setKoordinateX(0).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER, figurFarbe)
                    .setKoordinateX(1).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER, figurFarbe)
                    .setKoordinateX(2).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIGIN, figurFarbe)
                    .setKoordinateX(3).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIG, figurFarbe)
                    .setKoordinateX(4).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER, figurFarbe)
                    .setKoordinateX(5).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER, figurFarbe)
                    .setKoordinateX(6).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());
            figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM, figurFarbe)
                    .setKoordinateX(7).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 7 : 0).build());

            for (int i = 0; i < 8; i++) {
                figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER, figurFarbe)
                        .setKoordinateX(i).setKoordinateY(figurFarbe == FigurFarbe.WEISS ? 6:1).build());
            }
        }

        /*
        //Weisse Figuren aufstellen
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM,FigurFarbe.WEISS).setKoordinateX(0).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER,FigurFarbe.WEISS).setKoordinateX(1).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER,FigurFarbe.WEISS).setKoordinateX(2).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIGIN,FigurFarbe.WEISS).setKoordinateX(3).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIG,FigurFarbe.WEISS).setKoordinateX(4).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER,FigurFarbe.WEISS).setKoordinateX(5).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER,FigurFarbe.WEISS).setKoordinateX(6).setKoordinateY(7).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM,FigurFarbe.WEISS).setKoordinateX(7).setKoordinateY(7).build());

        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(0).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(1).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(2).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(3).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(4).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(5).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(6).setKoordinateY(6).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.WEISS).setKoordinateX(7).setKoordinateY(6).build());


        // Schwarze Figuren aufstellen
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM,FigurFarbe.SCHWARZ).setKoordinateX(0).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER,FigurFarbe.SCHWARZ).setKoordinateX(1).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER,FigurFarbe.SCHWARZ).setKoordinateX(2).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIGIN,FigurFarbe.SCHWARZ).setKoordinateX(3).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.KOENIG,FigurFarbe.SCHWARZ).setKoordinateX(4).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.LAUEFER,FigurFarbe.SCHWARZ).setKoordinateX(5).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.SPRINGER,FigurFarbe.SCHWARZ).setKoordinateX(6).setKoordinateY(0).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.TURM,FigurFarbe.SCHWARZ).setKoordinateX(7).setKoordinateY(0).build());


        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(0).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(1).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(2).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(3).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(4).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(5).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(6).setKoordinateY(1).build());
        figurenListe.add(new Fact_Pattern_Schachfigur(FigurTyp.BAUER,FigurFarbe.SCHWARZ).setKoordinateX(7).setKoordinateY(1).build());
        */
    }

    public void schachfigurBewegung(int schachFigurIndex, int zielX,int zielY){
        figurenListe.get(schachFigurIndex).setKoordinaten(zielX,zielY);
    }


    public List<SchachFigur> getFigurenListe() {
        return figurenListe;
    }

    public boolean isBewegungLegal(int schachFigurIndex, int zielX,int zielY){
    //return true wenn figur sich legal auf den angegeben koordinaten bewgen darf bzw der move richtig ist
    // ansonsten return false
    SchachFigur figur = figurenListe.get(schachFigurIndex);

    //ist die Position, in welche sich die figur bewegt (sollte)
    int positionX = zielX - figur.getKoordinateX();
    int positionY = zielY - figur.getKoordinateY();

        return figur.getFigurTyp().getIstBewegungMoeglich().isMoveLegal(figur.getFigurFarbe(),positionX,positionY);
    }

}
