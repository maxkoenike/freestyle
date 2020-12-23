package shopsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingCart extends JFrame {

    public ShoppingCart(ArrayList<CartDataModel> cart) {

        JFrame cartFrame = new JFrame();
        cartFrame.setTitle("Einkaufswagen");
        cartFrame.setLayout(new BorderLayout());
        cartFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        // take number of items and list them
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel cartMessage = new JLabel("Hier findest du die Artikel, die sich im Warenkorb befinden:");
        topPanel.add(cartMessage);


        JPanel listPane = new JPanel((new FlowLayout(FlowLayout.CENTER)));

        String[] columns = new String[]{"Komponente", "Anzahl", "Einzelpreis", "Gesamtpreis"};

        DefaultTableModel defaultModel = new DefaultTableModel(columns, 0);

        int totalprice = 0;

        defaultModel.addRow(columns);

        for (int i = 0; i < cart.size(); i++) {
            defaultModel.addRow(new Object[]{cart.get(i).name, cart.get(i).quantity, cart.get(i).price, cart.get(i).pricesum});
            totalprice = totalprice + (cart.get(i).quantity * cart.get(i).price);
        }



        //create table with data
        JTable table = new JTable(defaultModel);


        table.setPreferredSize(new Dimension(500, 500));

        listPane.add(table);

        JPanel sendPanel = new JPanel();
        sendPanel.add(new JLabel("Gesamtsumme : " + totalprice + " € (zum Aktualisieren Fenster schließen und erneut öffnen.)"));

        cartFrame.add(topPanel, BorderLayout.NORTH);
        cartFrame.add(listPane, BorderLayout.CENTER);
        cartFrame.add(sendPanel, BorderLayout.SOUTH);



//        cartFrame.add(new CartGridBagLayout());

        cartFrame.setSize(1000, 800);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setVisible(true);
    }
}
