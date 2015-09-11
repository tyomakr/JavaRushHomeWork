package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

public class AdvertisementManager {

    private final AdvertisementStorage storage;
    private int timeSeconds;


    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
        storage = AdvertisementStorage.getInstance();
    }
    public void processVideos()
    {
        ConsoleHelper.writeMessage("processVideos method calling");
    }


}
