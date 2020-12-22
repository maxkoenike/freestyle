package sample;

import javax.swing.*;
import java.awt.*;

public class ListStock {

    public ListStock() {

        JFrame storageFrame = new JFrame();
        storageFrame.setTitle("Bestellhistorie");
        storageFrame.setLayout(new BorderLayout());
        storageFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerpane = new JPanel(new FlowLayout());

        Font font = new Font(Font.DIALOG, Font.PLAIN, 24);
        JLabel inStock = new JLabel("Aktueller Lagerbestand");
        inStock.setFont(font);

        JList stockList = new JList();

        stockList.add(new JLabel("Es sind " + Piston.getP1() + " Kolben der Klasse 3 auf Lager."));
        stockList.add(new JLabel("Es sind " + Piston.getP2() + " Kolben der Klasse 2 auf Lager."));
        stockList.add(new JLabel("Es sind " + Piston.getP3() + " Kolben der Klasse 1 auf Lager."));

        stockList.add(new JLabel("Es sind " + Conrod.c1 + " Pleuelstangen der Klasse 3 auf Lager."));
        stockList.add(new JLabel("Es sind " + Conrod.c2 + " Pleuelstangen der Klasse 2 auf Lager."));
        stockList.add(new JLabel("Es sind " + Conrod.c3 + " Pleuelstangen der Klasse 1 auf Lager."));

        stockList.add(new JLabel("Es sind " + Ring.r1 + " Kolbenringsets der Klasse 3 auf Lager."));
        stockList.add(new JLabel("Es sind " + Ring.r2 + " Kolbenringsets der Klasse 2 auf Lager."));
        stockList.add(new JLabel("Es sind " + Ring.r3 + " Kolbenringsets der Klasse 1 auf Lager."));



        centerpane.add(stockList);
        pane.add(inStock);

        storageFrame.add(centerpane, BorderLayout.CENTER);
        storageFrame.add(pane, BorderLayout.NORTH);


        storageFrame.setSize(1000, 800);
        storageFrame.setLocationRelativeTo(null);
        storageFrame.setVisible(true);


    }



}
