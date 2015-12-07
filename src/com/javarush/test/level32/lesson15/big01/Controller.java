package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {

    private View view;
    private HTMLDocument document;

    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }
}
/*

1.5.	Добавь в класс View поле Controller controller.
1.6.	Добавь в класс View сеттер и геттер для поля controller.
1.7.	Добавь пустую реализацию метода, который объявлен в интерфейсе ActionListener.
 */