package sample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderHistory extends JFrame {

    public OrderHistory(ArrayList<String> history) {

        JFrame historyFrame = new JFrame();
        historyFrame.setTitle("Bestellhistorie");
        historyFrame.setLayout(new BorderLayout());
        historyFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel historyMessage = new JLabel("Hier findest du deine Bestellungen");
        topPanel.add(historyMessage);


        JPanel listPane = new JPanel((new FlowLayout(FlowLayout.CENTER)));

        String[] columns = new String[]{"Bestellung Nr.", "Anzahl Artikel", "Gesamtsumme"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);


        for (int i = 0; i < history.size(); i++) {
            defaultModel.addRow(new Object[]{history.get(i), "Test", "Test"});
        }

        //create table with data
        JTable table = new JTable(defaultModel);
        table.setPreferredSize(new Dimension(500, 500));

        listPane.add(table);


        historyFrame.add(topPanel, BorderLayout.NORTH);
        historyFrame.add(listPane, BorderLayout.CENTER);

        historyFrame.setSize(1000, 800);
        historyFrame.setLocationRelativeTo(null);
        historyFrame.setVisible(true);



    }
}
