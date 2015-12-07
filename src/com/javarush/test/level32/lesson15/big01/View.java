package com.javarush.test.level32.lesson15.big01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener  {

    private Controller controller;

    //это будет панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    //это будет компонент для визуального редактирования html
    private JTextPane htmlTextPane = new JTextPane();
    //это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();


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

