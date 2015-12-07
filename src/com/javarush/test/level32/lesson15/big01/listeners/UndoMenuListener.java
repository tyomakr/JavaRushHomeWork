package com.javarush.test.level32.lesson15.big01.listeners;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *  он должен реализовывать интерфейс MenuListener и иметь
 конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem
 redoMenuItem).
 */
public class UndoMenuListener implements MenuListener {


    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
    }

    @Override
    public void menuSelected(MenuEvent e) {

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
