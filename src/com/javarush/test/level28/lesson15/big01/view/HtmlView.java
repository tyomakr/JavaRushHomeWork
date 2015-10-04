package com.javarush.test.level28.lesson15.big01.view;


import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class HtmlView implements View {

    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}
