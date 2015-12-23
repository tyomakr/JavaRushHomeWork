package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Map;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        Map<Date, Double> advertisementProfit = StatisticManager.getInstance().getAdvertisementProfit();
        BigDecimal totalProfit = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        for (Map.Entry<Date, Double> entry : advertisementProfit.entrySet()) {
            BigDecimal profit = new BigDecimal(entry.getValue()).setScale(2, RoundingMode.HALF_UP);
            ConsoleHelper.writeMessage(String.format(
                    "%1$td-%1$tb-%1$tY - %2$.2f",
                    entry.getKey(),
                    profit.doubleValue()
            ));
            totalProfit = totalProfit.add(profit);
        }
        ConsoleHelper.writeMessage(String.format("Total - %.2f", totalProfit.doubleValue()));
        ConsoleHelper.writeMessage("");
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookWorkloading = StatisticManager.getInstance().getCookWorkloading();
        boolean firstrow = true;
        for (Map.Entry<Date, Map<String, Integer>> entry : cookWorkloading.entrySet()) {
            if (!firstrow) ConsoleHelper.writeMessage("");
            firstrow = false;
            ConsoleHelper.writeMessage(String.format(
                    "%1$td-%1$tb-%1$tY",
                    entry.getKey()
            ));
            Map<String, Integer> nameLoadMap = entry.getValue();
            for (Map.Entry<String, Integer> nameLoadEntry : nameLoadMap.entrySet()) {
                ConsoleHelper.writeMessage(String.format(
                        "%s - %d min",
                        nameLoadEntry.getKey(),
                        nameLoadEntry.getValue()
                ));
            }

        }
    }
    public void printActiveVideoSet() {
    }
    public void printArchivedVideoSet() {
    }

}
