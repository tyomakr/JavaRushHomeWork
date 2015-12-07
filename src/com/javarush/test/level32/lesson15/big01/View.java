package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener  {

    private Controller controller;


    //methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void init() {

    }


    //Добавь в представление метод exit(), он должен вызывать exit() у контроллера
    public void exit() {
        controller.exit();
    }


    //setter and getter
    public com.javarush.test.level32.lesson15.big01.Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
