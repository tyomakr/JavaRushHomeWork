package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer{

    private final String name;


    public Cook(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof Order)
        {
            Order order = (Order) o;
            ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min");

            StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),name,order.getTotalCookingTime()*60,order.getDishes()));

            setChanged();
            notifyObservers(order);
        }
    }

}


