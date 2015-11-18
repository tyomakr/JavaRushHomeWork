package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> advertisements = new ArrayList<>();
        for (Advertisement ad : storage.list())
        {
            if (ad.getHits() > 0)
            {
                advertisements.add(ad);
            }
        }
        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        Collections.sort(advertisements, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying())
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                if (o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration() != o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration())
                    return Long.compare(o1.getAmountPerOneDisplaying() * 1000 / o1.getDuration(), o2.getAmountPerOneDisplaying() * 1000 / o2.getDuration());
                return 0;
            }
        });

        advertisements = maxMany(advertisements);

        if (advertisements.isEmpty())
            throw new NoVideoAvailableException();

        int sumAmount = 0;
        int sumDuration = 0;
        for (Advertisement el : advertisements)
        {
            sumAmount += el.getAmountPerOneDisplaying();
            sumDuration += el.getDuration();
        }

        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(advertisements, sumAmount, sumDuration));

        for (Advertisement advertisement : advertisements)
        {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                    advertisement.getName(),
                    advertisement.getAmountPerOneDisplaying(),
                    advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
            advertisement.revalidate();
        }
    }

    private List<Advertisement> maxMany(List<Advertisement> advertisements)
    {

        int timeD = 0;
        for (Advertisement advertisement : advertisements)
        {
            timeD += advertisement.getDuration();
        }

        if (timeD > timeSeconds)
        {
            List<Advertisement> adv = new ArrayList<>();
            timeD = 0;
            for (Advertisement el : advertisements)
            {
                timeD += el.getDuration();
                if (timeD <= timeSeconds)
                {
                    adv.add(el);
                }
            }

            for (int i = 0; i < advertisements.size(); i++)
            {
                List<Advertisement> list = new ArrayList<>(advertisements);
                list.remove(i);
                int timeD2 = 0;
                for (Advertisement advertisement2 : list)
                {
                    timeD2 += advertisement2.getDuration();
                }
                if (timeD2 > timeSeconds)
                {
                    list = maxMany(list);
                }
                if (adv.size() > 0)
                {
                    compareAd(adv, list);
                } else
                {
                    adv.addAll(list);
                }
            }
            return adv;
        } else
        {
            return advertisements;
        }
    }

    private void compareAd(List<Advertisement> advertisements, List<Advertisement> list)
    {
        long sum = 0;
        long sum2 = 0;
        int sumt = 0;
        int sumt2 = 0;
        int k = 0;
        int k2 = 0;
        for (Advertisement el : advertisements)
        {
            sum += el.getAmountPerOneDisplaying();
            sumt += el.getDuration();
            k++;
        }
        for (Advertisement el : list)
        {
            sum2 += el.getAmountPerOneDisplaying();
            sumt2 += el.getDuration();
            k2++;
        }
        if (sum < sum2)
        {
            advertisements.clear();
            advertisements.addAll(list);
        } else if (sum == sum2)
        {
            if (sumt < sumt2)
            {
                advertisements.clear();
                advertisements.addAll(list);
            } else if (sumt == sumt2)
            {
                if (k > k2)
                {
                    advertisements.clear();
                    advertisements.addAll(list);
                }
            }
        }
    }
}
