package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {

        double total = 0;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getTotalMoneyPerDay().entrySet()) {

            double e = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(entry.getKey()), e));
            total += e;
        }
        if (total > 0) ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }
    public void printCookWorkloading() {

        for (Map.Entry<Date, TreeMap<String, Integer>> pair : StatisticManager.getInstance().getCookInfo().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {
                if (pair2.getValue() > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", pair2.getKey(), pair2.getValue()));
                }
            }
        }
    }

    public void printActiveVideoSet() {}
    public void printArchivedVideoSet() {}
}