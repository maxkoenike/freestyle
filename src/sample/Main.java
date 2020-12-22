package sample;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    static int total;

    private static ArrayList<String> cart = new ArrayList<String>();


    public static void main(String[] args) {



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

        JMenu cartMenu = new JMenu("Einkaufswagen");
        JMenuItem insideCart = new JMenuItem("Einkaufswagen anzeigen");

        JMenu history = new JMenu("Bestellhistorie");
        JMenuItem showHistory = new JMenuItem("Bestellhistorie anzeigen");

        menu.add(storage);
        menu.add(history);
        menu.add(cartMenu);

        storage.add(bestand);
        cartMenu.add(insideCart);
        history.add(showHistory);

        frame.setJMenuBar(menu);

        // SETTING ACTION FOR SHOPPING CART BUTTON
        insideCart.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShoppingCart shoppingCart = new ShoppingCart(cart);
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
                SerialEngine serialEngine = new SerialEngine(cart);


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




    //L+ENGINE METHOD
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
