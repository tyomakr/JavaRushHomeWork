package com.javarush.test.level34.lesson15.big01.view;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;
import com.javarush.test.level34.lesson15.big01.model.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {

    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler(this);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        for (GameObject object : view.getGameObjects().getAll()) {
            object.draw(g);
        }

    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }


    public static class KeyHandler extends KeyAdapter {

        private Field field;

        public KeyHandler(Field field) {
            this.field = field;
        }

        @Override
        public void keyPressed(KeyEvent e) {

            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):
                    field.eventListener.move(Direction.LEFT);
                case (KeyEvent.VK_RIGHT):
                    field.eventListener.move(Direction.RIGHT);
                case (KeyEvent.VK_UP):
                    field.eventListener.move(Direction.UP);
                case (KeyEvent.VK_DOWN):
                    field.eventListener.move(Direction.DOWN);
                case (KeyEvent.VK_R):
                    field.eventListener.restart();
            }
        }
    }

}
