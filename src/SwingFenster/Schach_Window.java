package SwingFenster;

import Kern_Logik_Klassen.SchachSpiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.chrono.JapaneseChronology;

public class Schach_Window extends JFrame {



    private JPanel  southPanel;

    private JButton weissZugButton;
    private JButton schwarzZugButton;
    private JButton resettBoardButoon;

    private JButton autoPlayButton;
    private JButton loadGame;
    private JButton saveGame;

    private final Schachbrett_Panel panel = new Schachbrett_Panel();

    // separat SwingUtilities for Thread
    public static void main(String[] args) {
       new Schach_Window();
    }


    public Schach_Window(){


        setTitle("Schach Prototyp");
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panel,BorderLayout.CENTER);
        add(funktionsPanel(),BorderLayout.SOUTH);
        setResizable(true);
        setVisible(true);
        pack();

    }
    //TODO Listener müssen noch implementiert werden
    // moegliche MouseAdapter klasse erstellen


    private JPanel funktionsPanel(){

        southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());

        southPanel.add(innerPanel1(),BorderLayout.NORTH);
        southPanel.add(innerPanel2(),BorderLayout.SOUTH);



        return southPanel;
    }

    private JPanel innerPanel1(){

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        weissZugButton = new JButton("Weiß, Spielzug");

        schwarzZugButton = new JButton("Schwarz, Spielzug");

        autoPlayButton = new JButton("Auto. Spiel");


        jPanel.add(weissZugButton);
        jPanel.add(schwarzZugButton);
        jPanel.add(autoPlayButton);

        return jPanel;
    }


    private JPanel innerPanel2() {

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());

        saveGame = new JButton("Save");

        loadGame = new JButton("Load");


        //TODO
        //Bord neu aufstellen
        resettBoardButoon = new JButton("Bord neu aufstellen");
        resettBoardButoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.drawNew();
            }
        });


        jPanel.add(saveGame);
        jPanel.add(loadGame);
        jPanel.add(resettBoardButoon);

        return jPanel;
    }






}
