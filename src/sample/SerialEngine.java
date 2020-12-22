package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class SerialEngine {

    public SerialEngine(ArrayList<String> cart) {

        JFrame frame2 = new JFrame();
        frame2.setTitle("Komponenten für Serienmotoren");

        //TEXTABOVE

        JPanel text = new JPanel(new FlowLayout(FlowLayout.CENTER));
        text.add(new JLabel("Bitte wähle deine gewünschten Komponenten aus und füge sie dem Warenkorb hinzu."));

        //GRIDLAYOUT ERSTELLEN
        JPanel grid = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //grid.setMaximumSize(new Dimension(400, 400));


        //GRID COMPONENTS

        //PISTON
        JLabel piston = new JLabel("Kolben K3");
        JLabel apiston = new JLabel(Piston.getP1() + " verfügbar");
        JLabel ppiston = new JLabel("Stückpreis: " + Piston.getPp1() + "�");


        int min = 1;
        int maxp = Piston.getP1();
        int step = 1;
        int initValue = 1;

        SpinnerModel model = new SpinnerNumberModel(initValue, min, maxp, step);
        JSpinner pspinner = new JSpinner(model);

        JButton padd = new JButton("In den Einkaufswagen");


        //CONROD

        JLabel conrod = new JLabel("Pleuel K3");
        JLabel aconrod = new JLabel(Conrod.c1 + " verf�gbar");
        JLabel pconrod = new JLabel("Stückpreis: " + Conrod.getCp1() + "�");

        int maxc = Conrod.c1;
        SpinnerModel modelc = new SpinnerNumberModel(initValue, min, maxc, step);

        JSpinner cspinner = new JSpinner(modelc);
        JButton cadd = new JButton("In den Einkaufswagen");


        //RING

        JLabel ring = new JLabel("Kolbenringset K3");
        JLabel aring = new JLabel(Ring.r1 + " verfügbar");
        JLabel pring = new JLabel("Stückpreis: " + Ring.getRp1() + "�");

        int maxr = Ring.r1;
        SpinnerModel modelr = new SpinnerNumberModel(initValue, min, maxr, step);

        JSpinner rspinner = new JSpinner(modelr);
        JButton radd = new JButton("In den Einkaufswagen");


        //FORMAT OF ITEMS
        piston.setPreferredSize(new Dimension(100, 100));
        piston.setHorizontalAlignment(JLabel.CENTER);


        conrod.setPreferredSize(new Dimension(100, 100));
        conrod.setHorizontalAlignment(JLabel.CENTER);


        ring.setPreferredSize(new Dimension(100, 100));
        ring.setHorizontalAlignment(JLabel.CENTER);


        //CREATING A LIST

        JList serialList = new JList();

        serialList.add(new JLabel("Kolben K3"));


        grid.add(serialList);






        //ADDING COMP. TO GRID
       /* grid.add(piston);
        grid.add(apiston);
        grid.add(ppiston);
        grid.add(pspinner);
        grid.add(padd);

        grid.add(conrod);
        grid.add(aconrod);
        grid.add(pconrod);
        grid.add(cspinner);
        grid.add(cadd);

        grid.add(ring);
        grid.add(aring);
        grid.add(pring);
        grid.add(rspinner);
        grid.add(radd); */


        //LIST
        //String Komponente[] = {"Kolben K3", "Pleuelstange K3", "Kolbenringset K3"};
        //JList component = new JList(Komponente);
        //grid.add(component);

        /*
         * Overview of serialengine components
         *
         * GridLayout(3,4)
         * Piston "p1" ; available (int p1) ; price p.u. ; add/remove ; into cart
         *   conrod "c1" ; available (int c1) ; price p.u. ; add/remove ; into cart
         * 		ringset "r1" ; available (int r1) ; price p.u. ; add/remove ; into cart
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         */
        frame2.add(text, BorderLayout.NORTH);
        frame2.add(grid, BorderLayout.CENTER);


//        public void addToCart (String name,int quantity, int price){
//
//            grid2.add(new JLabel(name));
//            grid2.add(new JLabel(quantity));
//            grid2.add(new JLabel(price));
//        }


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

     /*   frame2.add(new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 600);
            }

        });

        frame2.pack();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame2.getWidth();
        int y = 0;


        frame2.setLocation(x, y); */
        frame2.setSize(1000, 800);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.setVisible(true);


    }


}




