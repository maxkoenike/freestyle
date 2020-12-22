package sample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCart extends JFrame {

    public ShoppingCart(ArrayList<String> cart) {

        JFrame cartFrame = new JFrame();
        cartFrame.setTitle("Einkaufswagen");
        cartFrame.setLayout(new BorderLayout());
        cartFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        // take number of items and list them
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel cartMessage = new JLabel("Hier findest du die Artikel, die sich im Warenkorb befinden:");
        topPanel.add(cartMessage);


        JPanel listPane = new JPanel((new FlowLayout(FlowLayout.CENTER)));

        String[] columns = new String[]{"Komponente", "Anzahl", "Einzelpreis"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);


        for (int i = 0; i < cart.size(); i++) {
            defaultModel.addRow(new Object[]{cart.get(i), "Test", "Test"});
        }

        //create table with data
        JTable table = new JTable(defaultModel);
        table.setPreferredSize(new Dimension(500, 500));

        listPane.add(table);

        //send order and erase cart
        JPanel sendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton calcIt = new JButton("Gesamtsumme berechnen");
        JButton sendIt = new JButton("Bestellen");

        sendPanel.add(calcIt);
        sendPanel.add(sendIt);


        //write order into history & erase number of items out of stock

        cartFrame.add(topPanel, BorderLayout.NORTH);
        cartFrame.add(listPane, BorderLayout.CENTER);
        cartFrame.add(sendPanel, BorderLayout.SOUTH);


        cartFrame.setSize(1000, 800);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setVisible(true);
    }
}
