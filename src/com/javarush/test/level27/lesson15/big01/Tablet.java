package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import java.util.Observable;
import java.util.logging.Logger;

public class Tablet extends Observable {

    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());



    public Tablet(int number) {
        this.number = number;
    }


    public void createOrder() {
        Order order = null;
        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if(!order.isEmpty())
            {

                setChanged();
                notifyObservers(order);

                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";

    }

    public int getNumber() {
        return number;
    }

}


