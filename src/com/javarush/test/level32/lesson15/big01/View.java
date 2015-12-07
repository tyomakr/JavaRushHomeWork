package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener  {


    private Controller controller;

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    //setter and getter

    public com.javarush.test.level32.lesson15.big01.Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
