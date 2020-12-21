package sample;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    protected static boolean mwst;

    static private int p1cart;

    public static int getP1cart() {
        return p1cart;
    }

    public static void setP1cart(int p1cart) {
        Main.p1cart = p1cart;
    }

    static private int c1cart;

    public static int getC1cart() {
        return c1cart;
    }

    public static void setC1cart(int c1cart) {
        Main.c1cart = c1cart;
    }

    static private int r1cart;

    public static int getR1cart() {
        return r1cart;
    }

    public static void setR1cart(int r1cart) {
        Main.r1cart = r1cart;
    }

    static int total;

    private static DefaultListModel listModel;
    private static DefaultListModel listModelTot;
    private JList list;
    private JList totalList;

    public static void main(String[] args) {

        listModel = new DefaultListModel();

        listModelTot = new DefaultListModel();

        //MAIN Frame
        JFrame frame = new JFrame();
        frame.setTitle("Zylinderkomponentensystem");

        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ADDING MENU BAR
        JMenuBar menu = new JMenuBar();

        JMenu storage = new JMenu("Lager");
        JMenuItem bestand = new JMenuItem("Bestand auflisten");

        bestand.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                showStorage();

                System.out.println("Es sind " + Piston.getP1() + " Kolben der Klasse 3 auf Lager.");
                System.out.println("Es sind " + Piston.getP2() + " Kolben der Klasse 2 auf Lager.");
                System.out.println("Es sind " + Piston.getP3() + " Kolben der Klasse 1 auf Lager.");

                System.out.println("----------------------------------------------------------------");

                System.out.println("Es sind " + Conrod.c1 + " Pleuelstangen der Klasse 3 auf Lager.");
                System.out.println("Es sind " + Conrod.c2 + " Pleuelstangen der Klasse 2 auf Lager.");
                System.out.println("Es sind " + Conrod.c3 + " Pleuelstangen der Klasse 1 auf Lager.");

                System.out.println("----------------------------------------------------------------");

                System.out.println("Es sind " + Ring.r1 + " Kolbenringsets der Klasse 3 auf Lager.");
                System.out.println("Es sind " + Ring.r2 + " Kolbenringsets der Klasse 2 auf Lager.");
                System.out.println("Es sind " + Ring.r3 + " Kolbenringsets der Klasse 1 auf Lager.");

            }

        });

        JMenu cart = new JMenu("Einkaufswagen");
        JMenuItem insideCart = new JMenuItem("Einkaufswagen anzeigen");

        JMenu history = new JMenu("Bestellhistorie");
        JMenuItem showHistory = new JMenuItem("Bestellhistorie anzeigen");

        menu.add(storage);
        menu.add(history);
        menu.add(cart);

        storage.add(bestand);
        cart.add(insideCart);
        history.add(showHistory);

        frame.setJMenuBar(menu);

        // SETTING ACTION FOR SHOPPING CART BUTTON
        insideCart.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoppingCart();
            }


        }));

        //SETTING ACTION FOR HISTORY BUTTON
        showHistory.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showHistory();
            }
        }));


        //NORTH Panel
        JPanel northPanel = new JPanel(new GridLayout(2, 1));

        //WELOCOME Panel
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Font font = new Font(Font.DIALOG, Font.PLAIN, 18);
        JLabel welcome = new JLabel("Willkommen im Zylinderkomponentenshopsystem. Hier findest Du alles, was dein Motorinneres begehrt - Egal ob Alltagsboot oder Motorsportkarre!");
        welcome.setFont(font);

        welcomePanel.add(welcome);
        northPanel.add(welcomePanel);


        //SETTING GL 4 GridButtons
        JPanel middlePanel = new JPanel(new GridLayout(4, 1));

        //TEXT ABOVE GridButtons
        JLabel WA = new JLabel("Für welchen Anwendungsbereich suchst du Komponenten?");
        Font fontr = new Font(Font.DIALOG, Font.PLAIN, 16);
        WA.setFont(fontr);
        WA.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(WA);

        //ADDING BUTTONS INTO GRID
        JButton button3 = new JButton("Für Serienmotoren");
        JButton button4 = new JButton("Für leistungsgesteigerte Motoren");
        JButton button5 = new JButton("Für Rennsport-Motoren");

        button3.setSize(new Dimension(100, 100));
        button4.setSize(new Dimension(100, 100));
        button5.setSize(new Dimension(100, 100));

        button3.setFont(fontr);
        button4.setFont(fontr);
        button5.setFont(fontr);


        middlePanel.add(button3);
        middlePanel.add(button4);
        middlePanel.add(button5);

        //ADDING SOUTH TEXT AREA
        JTextArea textArea = new JTextArea(15, 50);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));

        JPanel UIPanel = new JPanel();
        UIPanel.setLayout(new FlowLayout());

        JTextField input = new JTextField(20);

        JButton buttonEXE = new JButton("Best�tigen");

        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        //ADDING INPUT AND BUTTON INTO SOUTH PANEL
        UIPanel.add(input);
        UIPanel.add(buttonEXE);


        //ADDING PANELS into FRAME
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(UIPanel, BorderLayout.SOUTH);
        frame.add(middlePanel, BorderLayout.CENTER);

        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //SETTING ACTION 4 SERIENMOTOREN BUTTON

        button3.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                serialengine();

            }


        }));

        //SETTING ACTION 4 L+ MOTOREN BUTTON
        button4.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tunedengine();
            }


        }));

        //SETTING ACTION 4 R+ MOTOREN BUTTON
        button5.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                racingengine();
            }


        }));
    }

    //SERIALENGINE METHOD
    static void serialengine() {

        JFrame frame2 = new JFrame();
        frame2.setTitle("Komponenten für Serienmotoren");

        //TEXTABOVE

        JPanel text = new JPanel(new FlowLayout(FlowLayout.CENTER));
        text.add(new JLabel("Bitte wähle deine gewünschten Komponenten aus und füge sie dem Warenkorb hinzu."));

        //GRIDLAYOUT ERSTELLEN
        JPanel grid = new JPanel(new GridLayout(3, 5));
        grid.setMaximumSize(new Dimension(400, 400));


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


        //ADDING COMP. TO GRID
        grid.add(piston);
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
        grid.add(radd);


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
                    listModel.addElement("Kolben der Klasse 3                             " + p1cart + "                                        " + Piston.getPp1() + "�" + "                                                  " + p1cart * Piston.getPp1() + "�");
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
                    listModel.addElement("Pleuelstange der Klasse 3                 " + c1cart + "                                        " + Conrod.getCp1() + "�" + "                                                  " + c1cart * Conrod.getCp1() + "�");
                }


            }


        }));

        radd.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String rvalue = rspinner.getValue().toString();
                int r1cart = Integer.parseInt(rvalue);

                if (r1cart > 0) {
                    listModel.addElement("Kolbenringsatz der Klasse 3              " + r1cart + "                                        " + Ring.getRp1() + "�" + "                                                  " + r1cart * Ring.getRp1() + "�");

                }

            }


        }));


        frame2.setSize(1000, 800);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame2.setVisible(true);


    }

    //L+ENGINGE METHOD
    static void tunedengine() {

        JFrame frame3 = new JFrame();
        frame3.setTitle("Komponenten f�r leistungsgesteigerte Motoren");
        frame3.setSize(1200, 1000);
        frame3.setLocationRelativeTo(null);
        frame3.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        frame3.setVisible(true);


    }

    //R+ ENGINE
    static void racingengine() {

        JFrame frame4 = new JFrame();
        frame4.setTitle("Komponenten f�r Rennsport Motoren");
        frame4.setSize(1200, 1000);
        frame4.setLocationRelativeTo(null);
        frame4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame4.setVisible(true);
    }

    //SHOPPING CART
    static void shoppingCart() {

        JFrame cart = new JFrame();
        cart.setTitle("Einkaufswagen");
        cart.setLayout(new BorderLayout());
        cart.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        // take number of items and list them

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel cartMessage = new JLabel("Hier findest du die Artikel, die sich im Warenkorb befinden:");
        topPanel.add(cartMessage);


        String dc[] = {"Komponente                                             Anzahl                                  Einzelpreis                            Gesamtpreis"};
        JList list = new JList(dc);


        JList shoppingList = new JList(listModel);
        JList totalList = new JList(listModelTot);


        JPanel grid2 = new JPanel();
        grid2.setLayout(new GridLayout(1, 4));

        JLabel KompName = new JLabel("Komponente");
        JLabel Anzahl = new JLabel("Anzahl");
        JLabel Einzelpreis = new JLabel("Einzelpreis");
        JLabel Gesamtpreis = new JLabel("Gesamtpreis");

        grid2.add(KompName);
        grid2.add(Anzahl);
        grid2.add(Einzelpreis);
        grid2.add(Gesamtpreis);


        //add price of the items together


        //send order and erase cart
        JPanel sendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton calcIt = new JButton("Gesamtsumme berechnen");
        JButton sendIt = new JButton("Bestellen");
        sendPanel.add(totalList);
        sendPanel.add(calcIt);
        sendPanel.add(sendIt);

        calcIt.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                total = p1cart * Piston.getPp1() + c1cart * Conrod.getCp1() + r1cart * Ring.getRp1();
                System.out.println(p1cart);
                System.out.println(Piston.getPp1());
                listModelTot.addElement("Gesamtsumme             " + total);
            }


        }));


        //write order into history & erase number of items out of stock

        cart.add(topPanel, BorderLayout.NORTH);
        cart.add(grid2, FlowLayout.CENTER);
        cart.add(sendPanel, BorderLayout.SOUTH);


        cart.setSize(1000, 800);
        cart.setLocationRelativeTo(null);
        cart.setVisible(true);


    }


    //HISTORY
    static void showHistory() {

        JFrame history = new JFrame();
        history.setTitle("Bestellhistorie");
        history.setLayout(new BorderLayout());
        history.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        history.setSize(1000, 800);
        history.setLocationRelativeTo(null);
        history.setVisible(true);

    }

    static void showStorage() {

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
