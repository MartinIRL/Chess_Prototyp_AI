package SwingFenster;

import Kern_Logik_Klassen.SchachFigur;
import Kern_Logik_Klassen.SchachSpiel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;

public class Schachbrett_Panel extends JPanel {

    private final int schachBrettGroesse = 8;
    private final int schachBrettQuadrat = 60;

    private SchachSpiel schachSpiel = new SchachSpiel();

    private int selectionX = -1;
    private int selectionY = -1;
    private int figurIndex = -1;


    //test für bewegen
    public Schachbrett_Panel() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {

                selectionX = e.getX() / schachBrettQuadrat;
                selectionY = e.getY() / schachBrettQuadrat;

                if(figurIndex == -1) {
                    for (int i = 0; i < schachSpiel.getFigurenListe().size(); i++) {
                        final SchachFigur schachFigur = schachSpiel.getFigurenListe().get(i);
                        if (schachFigur.getKoordinateX() == selectionX && schachFigur.getKoordinateY() == selectionY) {
                            figurIndex = i;
                            break;
                        }
                     }
                }else if(figurIndex != -1){
                        if(schachSpiel.isBewegungLegal(figurIndex,selectionX,selectionY)) {
                            schachSpiel.schachfigurBewegung(figurIndex, selectionX, selectionY);
                        }
                        selectionX = selectionY = -1;
                        figurIndex = -1;
                }
                repaint();
            }
        });


    }


    @Override
    public void paintComponent(Graphics graphics) {

        //zeilen / rows
        for (int i = 0; i < schachBrettGroesse; i++) {

            //spalen / columns
            for (int j = 0; j < schachBrettGroesse; j++) {

                if ((j + i) % 2 == 0) {
                    graphics.setColor(Color.WHITE);
                } else {
                    graphics.setColor(Color.GRAY);
                }
                //graphics.fillRect(j * quadratGroesse, i * quadratGroesse, quadratGroesse, quadratGroesse);
                graphics.fillRect(j * schachBrettQuadrat, i * schachBrettQuadrat, schachBrettQuadrat, schachBrettQuadrat);


                // draw blue square on field for testing  X and Y coordinates
                if (i == selectionY && j == selectionX) {
                    graphics.setColor(Color.BLUE);
                    graphics.fillRect(j * schachBrettQuadrat, i* schachBrettQuadrat, schachBrettQuadrat, schachBrettQuadrat);

                }


            }

            for (SchachFigur schachFigur : schachSpiel.getFigurenListe()) {
                //google hilft
                final InputStream inputStream = Schachbrett_Panel.class.getResourceAsStream("/" + schachFigur.getBild());
                try {
                    if (inputStream != null) {
                        Image image = ImageIO.read(inputStream);
                        // Anpassung der Schachfiguren-Images durch getScaledInstance -> x,y jeweils shachBrettQuadrat
                        Image scaledImage = image.getScaledInstance(schachBrettQuadrat, schachBrettQuadrat, Image.SCALE_DEFAULT);
                        graphics.drawImage(scaledImage, schachFigur.getKoordinateX() * schachBrettQuadrat, schachFigur.getKoordinateY() * schachBrettQuadrat, this);
                        //graphics.drawImage(image,schachFigur.getKoordinateX()*75,schachFigur.getKoordinateY()*60,this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(schachBrettGroesse*schachBrettQuadrat,schachBrettGroesse*schachBrettQuadrat);
    }


    public void drawNew (){
           schachSpiel = new SchachSpiel();
           this.repaint();

    }


}
