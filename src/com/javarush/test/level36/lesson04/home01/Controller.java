package com.javarush.test.level36.lesson04.home01;


import java.util.List;

public class Controller {

    private Model model = new Model();

    public List<String> onDataListShow() {
        return model.getStringDataList();
    }


}
