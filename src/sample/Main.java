package sample;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    private static ArrayList<CartDataModel> cart = new ArrayList<CartDataModel>();



    public static void main(String[] args) {


        //MAIN Frame
        JFrame frame = new JFrame();
        frame.setTitle("Zylinderkomponentensystem");

        frame.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ADDING MENU BAR
        JMenuBar menu = new JMenuBar();

        JMenu storage = new JMenu("Lager");
        JMenuItem stock = new JMenuItem("Bestand auflisten");

        JMenu cartMenu = new JMenu("Einkaufswagen");
        JMenuItem insideCart = new JMenuItem("Einkaufswagen anzeigen");

        menu.add(storage);
        menu.add(cartMenu);

        storage.add(stock);
        cartMenu.add(insideCart);

        frame.setJMenuBar(menu);

        //SETTING ACTION FOR LIST STOCK BUTTON

        stock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                ListStock listStock = new ListStock();

            }

        });


        // SETTING ACTION FOR SHOPPING CART BUTTON
        insideCart.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShoppingCart shoppingCart = new ShoppingCart(cart);
            }

        }));


        //NORTH Panel
        JPanel northPanel = new JPanel(new GridLayout(2, 1));

        //WELCOME Panel
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
        JLabel welcome = new JLabel("Willkommen im Zylinderkomponentenshopsystem. Hier findest Du alles, was dein Motorinneres begehrt - Egal ob Alltagsboot oder Motorsportkarre!");
        welcome.setFont(font);

        welcomePanel.add(welcome);
        northPanel.add(welcomePanel);

        //TEXT ABOVE middlePanel
        JLabel WA = new JLabel("Für welchen Anwendungsbereich suchst du Komponenten?");
        Font fontr = new Font(Font.DIALOG, Font.PLAIN, 14);
        WA.setFont(fontr);
        WA.setHorizontalAlignment(JLabel.CENTER);
        northPanel.add(WA);

        //SETTING GL 4 middlePanel

        JPanel middlePanel = new JPanel(new FlowLayout());
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //ADDING BUTTONS INTO middlePanel
        JButton button3 = new JButton("Für Serienmotoren");
        JButton button4 = new JButton("Für leistungsgesteigerte Motoren");
        JButton button5 = new JButton("Für Rennsport-Motoren");

        button3.setFont(fontr);
        button4.setFont(fontr);
        button5.setFont(fontr);

        middlePanel.add(button3);
        middlePanel.add(button4);
        middlePanel.add(button5);

        //ADDING PANELS into FRAME
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);

        frame.setSize(1100, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //SETTING ACTION 4 "SERIENMOTOREN" BUTTON

        button3.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SerialEngine serialEngine = new SerialEngine(cart);
            }

        }));

        //SETTING ACTION 4 "L+ MOTOREN" BUTTON
        button4.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TunedEngine tunedEngine = new TunedEngine((cart));
            }

        }));

        //SETTING ACTION 4 "R+ MOTOREN" BUTTON
        button5.addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RacingEngine racingEngine = new RacingEngine((cart));
            }

        }));
    }

}


