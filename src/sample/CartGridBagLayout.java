package sample;

import javax.swing.*;
import java.awt.*;

public class CartGridBagLayout extends JPanel {

    public CartGridBagLayout() {

        super(new GridBagLayout());

        GridBagConstraints gbs = new GridBagConstraints();

        JLabel name = new JLabel("Komponente");
        JLabel quantity = new JLabel("Anzahl");
        JLabel ppu = new JLabel("Einzelpreis");

        JLabel rn = new JLabel("Lfd. Nr.");
        JLabel rn2 = new JLabel("1");
        JLabel rn3 = new JLabel("2");


        //FORMAT
        gbs.insets = new Insets(20,100,20,0);
        gbs.ipadx = 100;
        gbs.ipady = 10;


        //RUNNING NUMBER
        gbs.gridx = 0;
        gbs.gridy = 0;
        add(rn, gbs);

        gbs.gridx = 0;
        gbs.gridy = 1;
        add(rn2,gbs);

        gbs.gridx = 0;
        gbs.gridy = 2;
        add(rn3, gbs);


        //DESCRIPTION
        gbs.gridx = 1;
        gbs.gridy = 0;
        add(name);

        gbs.gridx = 2;
        add(quantity);

        gbs.gridx = 3;
        add(ppu);

        //ADD COMPONENTS TO CART

        JLabel name1 = new JLabel("Kolben K3");
        JLabel qu1 = new JLabel("2");
        JLabel ppu1 = new JLabel(String.valueOf(Piston.getPp1()));

        gbs.gridx = 1;
        gbs.gridy = 1;
        add(name1, gbs);

        gbs.gridx = 2;
        gbs.gridy = 1;
        add(qu1, gbs);

        gbs.gridx = 3;
        gbs.gridy = 1;
        add(ppu1, gbs);

    }




}
