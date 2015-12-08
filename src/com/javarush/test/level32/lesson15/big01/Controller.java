package com.javarush.test.level32.lesson15.big01;

import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;

public class Controller {

    private View view;
    private HTMLDocument document;

    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }


    public void init() {}

    /*
    Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он
должен:
15.1.	Удалять у текущего документа document слушателя правок которые можно
отменить/вернуть (найди подходящий для этого метод, унаследованный от
AbstractDocument). Слушателя нужно запросить у представления (метод getUndoListener()).
Не забудь проверить, что текущий документ существует (не null).
15.2.	Создавать новый документ по умолчанию и присваивать его полю document.
Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.
15.3.	Добавлять новому документу слушателя правок.
15.4.	Вызывать у представления метод update().
     */

    public void resetDocument() {
        if (document != null) {
            //Удалять у текущего документа document слушателя правок которые можно отменить/вернуть
            document.removeUndoableEditListener(view.getUndoListener());
        }
        //Создавать новый документ по умолчанию и присваивать его полю document
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        //Добавлять новому документу слушателя правок
        document.addUndoableEditListener(view.getUndoListener());
        //Вызывать у представления метод update()
        view.update();

    }



    public void exit() {
        System.exit(0);
    }


    //psvm
    public static void main(String[] args) {

        //Создавать объект представления
        View view = new View();
        //Создавать контроллер, используя представление
        Controller controller = new Controller(view);
        //Устанавливать у представления контроллер
        view.setController(controller);
        //Инициализировать представление
        view.init();
        //Инициализировать контроллер. Контроллер должен инициализироваться после представления
        controller.init();

    }


    //setters and getters
    public HTMLDocument getDocument() {
        return document;
    }
}
