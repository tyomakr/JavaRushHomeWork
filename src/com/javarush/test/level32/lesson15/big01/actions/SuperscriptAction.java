package com.javarush.test.level32.lesson15.big01.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

/**
 * Класс SuperscriptAction. Он будет отвечать за стиль "Надстрочный знак". Добавь ему
 правильный родительский класс.
 */
public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
