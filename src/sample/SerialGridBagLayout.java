package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SerialGridBagLayout extends JPanel {

    public SerialGridBagLayout() {

        super(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // INIT ALL ITEMS
        JLabel text = new JLabel("Bitte wähle deine gewünschten Komponenten aus und füge sie dem Warenkorb hinzu.");
        JLabel text2 = new JLabel("Komponenten der Klasse 2 eignen sich für leistungsgesteigerte Fahrzeuge.");
        //SPINNER VAR
        int min = 1;
        int step = 1;
        int initValue = 1;

        //PISTON
        int maxp = Piston.getP1();
        SpinnerModel model = new SpinnerNumberModel(initValue, min, maxp, step);

        JLabel piston = new JLabel("Kolben K3");
        JLabel apiston = new JLabel(Piston.getP1() + " verfügbar");
        JLabel ppiston = new JLabel("Stückpreis: " + Piston.getPp1() + "€");

        JSpinner pspinner = new JSpinner(model);

        JButton padd = new JButton("In den Einkaufswagen");


        //CONROD
        int maxc = Conrod.c1;
        SpinnerModel modelc = new SpinnerNumberModel(initValue, min, maxc, step);


        JLabel conrod = new JLabel("Pleuel K3");
        JLabel aconrod = new JLabel(Conrod.c1 + " verfügbar");
        JLabel pconrod = new JLabel("Stückpreis: " + Conrod.getCp1() + "€");

        JSpinner cspinner = new JSpinner(modelc);
        JButton cadd = new JButton("In den Einkaufswagen");

        //RING
        int maxr = Ring.r1;
        SpinnerModel modelr = new SpinnerNumberModel(initValue, min, maxr, step);

        JLabel ring = new JLabel("Kolbenringset K3");
        JLabel aring = new JLabel(Ring.r1 + " verfügbar");
        JLabel pring = new JLabel("Stückpreis: " + Ring.getRp1() + "€");

        JSpinner rspinner = new JSpinner(modelr);
        JButton radd = new JButton("In den Einkaufswagen");


        //SETTING UP GRIDS ROWS AND COLUMNS AND ADDING COMPONENTS TO GRID
        //PISTON
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 15;
        gbc.ipady = 15;
        gbc.insets = new Insets(40, 40, 0, 0);
        add(piston, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(apiston, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(ppiston, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        add(pspinner, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.ipadx = 15;
        gbc.ipady = 15;
        add(padd, gbc);

        //CONROD
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(conrod, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(aconrod, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(pconrod, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        add(cspinner, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.ipadx = 15;
        gbc.ipady = 15;
        add(cadd, gbc);

        //RING
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(ring, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(aring, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add(pring, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.ipadx = 20;
        gbc.ipady = 20;
        add(rspinner, gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.ipadx = 15;
        gbc.ipady = 15;
        add(radd, gbc);

    }




}
