package shopsystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SerialEngine {

    public SerialEngine(ArrayList<CartDataModel> cart) {

        JFrame frame2 = new JFrame();
        frame2.setTitle("Komponenten für Serienmotoren");

        //TEXTABOVE
        JPanel text = new JPanel(new FlowLayout(FlowLayout.CENTER));
        text.add(new JLabel("Bitte wähle deine gewünschten Komponenten aus und füge sie dem Warenkorb hinzu."));
        text.add(new JLabel("Komponenten der Klasse 3 eignen sich für Fahrzeuge mit Serienmotor."));

        //PISTON
        JLabel piston = new JLabel("Kolben K3");
        JLabel apiston = new JLabel(Piston.getP1() + " verfügbar");
        JLabel ppiston = new JLabel("Stückpreis: " + Piston.getPp1() + "€");

        int min = 1;
        int maxp = Piston.getP1();
        int step = 1;
        int initValue = 1;

        SpinnerModel model = new SpinnerNumberModel(initValue, min, maxp, step);
        JSpinner pspinner = new JSpinner(model);

        JButton padd = new JButton("In den Einkaufswagen");


        //CONROD

        JLabel conrod = new JLabel("Pleuel K3");
        JLabel aconrod = new JLabel(Conrod.c1 + " verfügbar");
        JLabel pconrod = new JLabel("Stückpreis: " + Conrod.getCp1() + "€");

        int maxc = Conrod.c1;
        SpinnerModel modelc = new SpinnerNumberModel(initValue, min, maxc, step);

        JSpinner cspinner = new JSpinner(modelc);
        JButton cadd = new JButton("In den Einkaufswagen");


        //RING

        JLabel ring = new JLabel("Kolbenringsatz K3");
        JLabel aring = new JLabel(Ring.r1 + " verfügbar");
        JLabel pring = new JLabel("Stückpreis: " + Ring.getRp1() + "€");

        int maxr = Ring.r1;
        SpinnerModel modelr = new SpinnerNumberModel(initValue, min, maxr, step);

        JSpinner rspinner = new JSpinner(modelr);
        JButton radd = new JButton("In den Einkaufswagen");


        frame2.add(text, BorderLayout.NORTH);
        frame2.add(new SerialGridBagLayout(cart));

        frame2.setSize(1000, 400);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.setVisible(true);


    }




}




