package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TunedEngine {

    public TunedEngine(ArrayList<String> cart) {

        JFrame frame3 = new JFrame();
        frame3.setTitle("Komponenten für leistungsgesteigerte Motoren");

        //TEXTABOVE
        JPanel text = new JPanel(new FlowLayout(FlowLayout.CENTER));
        text.add(new JLabel("Bitte wähle deine gewünschten Komponenten aus und füge sie dem Warenkorb hinzu."));
        text.add(new JLabel("Komponenten der Klasse 2 eignen sich für leistungsgesteigerte Fahrzeuge."));

        //PISTON
        JLabel piston = new JLabel("Kolben K2");
        JLabel apiston = new JLabel(Piston.getP2() + " verfügbar");
        JLabel ppiston = new JLabel("Stückpreis: " + Piston.getPp2() + "€");


        int min = 1;
        int maxp = Piston.getP2();
        int step = 1;
        int initValue = 1;

        SpinnerModel model = new SpinnerNumberModel(initValue, min, maxp, step);
        JSpinner pspinner = new JSpinner(model);

        JButton padd = new JButton("In den Einkaufswagen");


        //CONROD

        JLabel conrod = new JLabel("Pleuel K2");
        JLabel aconrod = new JLabel(Conrod.c2 + " verfügbar");
        JLabel pconrod = new JLabel("Stückpreis: " + Conrod.getCp2() + "€");

        int maxc = Conrod.c2;
        SpinnerModel modelc = new SpinnerNumberModel(initValue, min, maxc, step);

        JSpinner cspinner = new JSpinner(modelc);
        JButton cadd = new JButton("In den Einkaufswagen");


        //RING

        JLabel ring = new JLabel("Kolbenringsatz K2");
        JLabel aring = new JLabel(Ring.r2 + " verfügbar");
        JLabel pring = new JLabel("Stückpreis: " + Ring.getRp2() + "€");

        int maxr = Ring.r2;
        SpinnerModel modelr = new SpinnerNumberModel(initValue, min, maxr, step);

        JSpinner rspinner = new JSpinner(modelr);
        JButton radd = new JButton("In den Einkaufswagen");


        frame3.add(text, BorderLayout.NORTH);



//        public void addToCart (String name,int quantity, int price){
//
//           grid2.add(new JLabel(name));
        //          grid2.add(new JLabel(quantity));
        //         grid2.add(new JLabel(price));
        //      }


        // GET VALUE OF SPINNERS

        padd.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String pvalue = pspinner.getValue().toString();
                System.out.println(pvalue);

                int p1cart = Integer.parseInt(pvalue);

                System.out.println("und als int: " + p1cart);


                if (p1cart > 0) {
                    cart.add("Kolben der Klasse 3" + p1cart + "                                        " + Piston.getPp1() + "�" + "                                                  " + p1cart * Piston.getPp1() + "�");
                }


            }


        }));

        cadd.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String cvalue = cspinner.getValue().toString();
                System.out.println(cvalue);

                int c1cart = Integer.parseInt(cvalue);

                if (c1cart > 0) {
                    cart.add("Pleuelstange der Klasse 3                 " + c1cart + "                                        " + Conrod.getCp1() + "�" + "                                                  " + c1cart * Conrod.getCp1() + "�");
                }


            }


        }));

        radd.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String rvalue = rspinner.getValue().toString();
                int r1cart = Integer.parseInt(rvalue);

                if (r1cart > 0) {
                    cart.add("Kolbenringsatz der Klasse 3              " + r1cart + "                                        " + Ring.getRp1() + "�" + "                                                  " + r1cart * Ring.getRp1() + "�");

                }

            }


        }));






























        frame3.add(new TunedGridBagLayout());
        frame3.setSize(1000, 400);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        frame3.setVisible(true);


    }

}
