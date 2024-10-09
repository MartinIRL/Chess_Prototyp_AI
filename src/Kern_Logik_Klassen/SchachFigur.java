package Kern_Logik_Klassen;

public class SchachFigur {



    private final String bild;
    private final FigurFarbe figurFarbe;
    private final FigurTyp figurTyp;


    private int koordinateY;
    private int koordinateX;



    public SchachFigur(FigurTyp figurTyp, FigurFarbe figurFarbe, int koordinateX, int koordinateY,String bild){
        this.figurTyp = figurTyp;
        this.figurFarbe = figurFarbe;
        this.koordinateX= koordinateX;
        this.koordinateY= koordinateY;
        this.bild = bild;
    }


  public void setKoordinaten(int x, int y){
        this.koordinateX = x;
        this.koordinateY = y;
  }

    public String getBild() {
        return bild;
    }



    public FigurFarbe getFigurFarbe() {
        return figurFarbe;
    }



    public FigurTyp getFigurTyp() {
        return figurTyp;
    }


    public int getKoordinateY() {
        return koordinateY;
    }



    public int getKoordinateX() {
        return koordinateX;
    }








}
