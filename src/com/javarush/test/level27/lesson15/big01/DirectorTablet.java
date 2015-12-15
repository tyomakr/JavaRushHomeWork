package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DirectorTablet {

    DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");

    public void printAdvertisementProfit(){

        double sum = 0;
        for (Map.Entry<Date, Double> el : StatisticManager.getInstance().getVideoProfit().entrySet()) {
            ConsoleHelper.writeMessage(String.format("%s - %.2f", dateFormat.format(el.getKey()), el.getValue() * 1.0 / 100));
            sum += el.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f%n", sum * 1.0 / 100));
    }

    public void printCookWorkloading(){

        for (Map.Entry<Date, Map<String, Integer>> el : StatisticManager.getInstance().getCookWorkloading().entrySet())
        {
            ConsoleHelper.writeMessage(String.format("%s", dateFormat.format(el.getKey())));
            for (Map.Entry<String, Integer> el2 : el.getValue().entrySet())
            {
                ConsoleHelper.writeMessage("" + el2.getKey() + " - " + el2.getValue() + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {}

    public void printArchivedVideoSet() {}

}
