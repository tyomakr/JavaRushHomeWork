package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Класс StrikeThroughAction, который отвечает за стиль текста "Зачеркнутый"
 */
public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {

    public StrikeThroughAction() {
        super(StyleConstants.StrikeThrough.toString());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
