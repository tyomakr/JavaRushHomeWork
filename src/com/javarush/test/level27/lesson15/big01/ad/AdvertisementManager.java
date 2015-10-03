package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {

        //сортируем ролики в хранилище в порядке уменьшения стоимости показа одного рекламного ролика
        //и увеличению стоимости показа в тысячных частях копейки
        Collections.sort(storage.list(), new Comparator<Advertisement>() {

            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int result = Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
                if (result != 0)
                    return -result;

                long oneSecondCost1 = o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration();
                long oneSecondCost2 = o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration();

                return Long.compare(oneSecondCost1, oneSecondCost2);
            }
        });

        int timeLeft = timeSeconds;
        //перебираем ролики в хранилище,
        for (Advertisement advertisement : storage.list()) {

            //если оставшееся время показа меньше, чем текущий ролик в цикле - переходим к следующему
            if (timeLeft < advertisement.getDuration()) {
                continue;
            }
            //показ ролика
            ConsoleHelper.writeMessage(advertisement.getName() + " is displaying... "
                    + advertisement.getAmountPerOneDisplaying() + ", "
                    + advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration());

            timeLeft -= advertisement.getDuration();
            advertisement.revalidate();
        }

        // если не осталось времени для показа
        if (timeLeft == timeSeconds) {
            throw new NoVideoAvailableException();
        }
    }
}