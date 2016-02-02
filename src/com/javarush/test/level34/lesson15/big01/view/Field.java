package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.model.*;
import com.javarush.test.level34.lesson15.big01.model.Box;


import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private View view;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);

        Player player = new Player(30, 30);
        player.draw(g);
        com.javarush.test.level34.lesson15.big01.model.Box box = new Box(100, 100);
        box.draw(g);
    }

}
