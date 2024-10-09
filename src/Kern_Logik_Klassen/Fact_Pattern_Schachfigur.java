package Kern_Logik_Klassen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Fact_Pattern_Schachfigur {


    private FigurFarbe figurFarbe;
    private FigurTyp figurTyp;

    private int koordinateY;
    private int koordinateX;



    public Fact_Pattern_Schachfigur(FigurTyp figurTyp, FigurFarbe figurFarbe){
        this.figurTyp = figurTyp;
        this.figurFarbe = figurFarbe;
    }


    public Fact_Pattern_Schachfigur setKoordinateY(int y){
        this.koordinateY = y;
        return this;
    }

    public Fact_Pattern_Schachfigur setKoordinateX(int x){
        this.koordinateX = x;
        return this;
    }


    public SchachFigur build(){
        return new SchachFigur(this.figurTyp,this.figurFarbe,this.koordinateX,this.koordinateY,"Schach_"+
                this.figurTyp.toString().toLowerCase()+"_" + (this.figurFarbe == FigurFarbe.WEISS ? "W" : "S")+".png");
    }

}
