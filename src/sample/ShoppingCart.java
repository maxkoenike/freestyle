package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCart extends JFrame{

    public  ShoppingCart(ArrayList<String> cart) {

        JFrame cartFrame = new JFrame();
        cartFrame.setTitle("Einkaufswagen");
        cartFrame.setLayout(new BorderLayout());
        cartFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


        // take number of items and list them

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel cartMessage = new JLabel("Hier findest du die Artikel, die sich im Warenkorb befinden:");
        topPanel.add(cartMessage);


        JPanel listPane = new JPanel((new FlowLayout(FlowLayout.CENTER)));

       /* String dc[] = {"Komponente                                Anzahl                                Einzelpreis                            Gesamtpreis"};
        JList list = new JList(dc);




        listPane.add(list); */


        //add price of the items together

        // TRY TABLE

        String[] columns = new String[] {"Komponente", "Anzahl", "Einzelpreis", "Gesamtpreis"};

        Object[][] data = new Object[][]{};

        for (int counter = 0; counter < cart.size(); counter++) {
           // data
            appendValue(data,cart.get(counter));

            System.out.println(cart.get(counter));
        }


        //create table with data
        JTable table = new JTable(data,columns);
        table.setPreferredSize(new Dimension(500,500));

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

    public void TableExample()
    {
        //headers for the table
        String[] columns = new String[] {
                "Id", "Name", "Hourly Rate", "Part Time"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
        };
        //create table with data
        JTable table = new JTable(data, columns);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Table Example");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private Object[] appendValue(Object[] obj, Object newObj) {

        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
        temp.add(newObj);
        return temp.toArray();

    }

}
