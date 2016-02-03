package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {

        Date begin = new Date();
        for(String s : strings)
            ids.add(shortener.getId(s));
        Date end = new Date();

        return end.getTime() - begin.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {

        Date begin = new Date();
        for(Long id : ids)
            strings.add(shortener.getString(id));
        Date end = new Date();

        return end.getTime() - begin.getTime();
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++)
            origStrings.add(Helper.generateRandomString());

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);

        long time3 = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        long time4 = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());
        Assert.assertEquals(time3, time4, 5);
    }
}
