package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Класс отмены действия UndoAction.
 * Он должен наследоваться от AbstractAction и содержать конструктор UndoAction(View view).
 */
public class UndoAction extends AbstractAction {

    private View view;

    public UndoAction(View view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
