package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;


public class Aggregator {

    public static void main(String[] args) {

        HtmlView view = new HtmlView();
        Provider provider = new Provider(new HHStrategy());
        Model model = new Model(view, new Provider[] {provider});

        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();


    }

}
