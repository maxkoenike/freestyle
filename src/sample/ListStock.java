package sample;

import javax.swing.*;
import java.awt.*;

public class ListStock {

    public ListStock() {

        JFrame storage = new JFrame();
        storage.setTitle("Bestellhistorie");
        storage.setLayout(new BorderLayout());
        storage.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel pane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centerpane = new JPanel(new GridLayout(9, 1));


        Font font = new Font(Font.DIALOG, Font.PLAIN, 24);
        JLabel inStock = new JLabel("Aktueller Lagerbestand");
        inStock.setFont(font);


        JLabel p1 = new JLabel("Es sind " + Piston.getP1() + " Kolben der Klasse 3 auf Lager.");
        JLabel p2 = new JLabel("Es sind " + Piston.getP2() + " Kolben der Klasse 2 auf Lager.");
        JLabel p3 = new JLabel("Es sind " + Piston.getP3() + " Kolben der Klasse 1 auf Lager.");


        JLabel c1 = new JLabel("Es sind " + Conrod.c1 + " Pleuelstangen der Klasse 3 auf Lager.");
        JLabel c2 = new JLabel("Es sind " + Conrod.c2 + " Pleuelstangen der Klasse 2 auf Lager.");
        JLabel c3 = new JLabel("Es sind " + Conrod.c3 + " Pleuelstangen der Klasse 1 auf Lager.");


        JLabel r1 = new JLabel("Es sind " + Ring.r1 + " Kolbenringsets der Klasse 3 auf Lager.");
        JLabel r2 = new JLabel("Es sind " + Ring.r2 + " Kolbenringsets der Klasse 2 auf Lager.");
        JLabel r3 = new JLabel("Es sind " + Ring.r3 + " Kolbenringsets der Klasse 1 auf Lager.");

        p1.setHorizontalAlignment(JLabel.CENTER);
        p2.setHorizontalAlignment(JLabel.CENTER);
        p3.setHorizontalAlignment(JLabel.CENTER);

        c1.setHorizontalAlignment(JLabel.CENTER);
        c2.setHorizontalAlignment(JLabel.CENTER);
        c3.setHorizontalAlignment(JLabel.CENTER);

        r1.setHorizontalAlignment(JLabel.CENTER);
        r2.setHorizontalAlignment(JLabel.CENTER);
        r3.setHorizontalAlignment(JLabel.CENTER);

        centerpane.add(p1);
        centerpane.add(p2);
        centerpane.add(p3);

        centerpane.add(c1);
        centerpane.add(c2);
        centerpane.add(c3);

        centerpane.add(r1);
        centerpane.add(r2);
        centerpane.add(r3);

        pane.add(inStock);

        storage.add(centerpane, BorderLayout.CENTER);
        storage.add(pane, BorderLayout.NORTH);


        storage.setSize(1000, 800);
        storage.setLocationRelativeTo(null);
        storage.setVisible(true);


    }



}
