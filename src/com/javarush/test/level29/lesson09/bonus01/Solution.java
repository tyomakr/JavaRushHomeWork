package com.javarush.test.level29.lesson09.bonus01;

/* Кеширование
В CacheComputeManager реализуйте логику пустого метода.
Догадайтесь, что он должен делать по названию метода и по логике класса.
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //////////////first example///////////////////
        Square square = new Square();
        CacheComputeManager<Integer, Integer> manager = new CacheComputeManager(square);

        for (int i = 0; i < 8; i++) {
            int j = i % 4;
            Integer result = manager.compute(j);
            System.out.format("%d * %d = %d\n", j, j, result);
        }

        /* output
            0 will be cached  0 * 0 = 0
            1 will be cached  1 * 1 = 1
            2 will be cached  2 * 2 = 4
            3 will be cached  3 * 3 = 9
            0 taken from cache  0 * 0 = 0
            1 taken from cache  1 * 1 = 1
            2 taken from cache  2 * 2 = 4
            3 taken from cache  3 * 3 = 9
         */

        //////////////second example///////////////////
        Copyright copyright = new Copyright();
        CacheComputeManager manager2 = new CacheComputeManager(copyright);
        System.out.println(manager2.compute(new Copyright.Period(2012, 2014)));
        System.out.println(manager2.compute(new Copyright.Period(2012, 2013)));
        System.out.println(manager2.compute(new Copyright.Period(2012, 2014)));

        /* output
        Period{firstYear=2012, secondYear=2014} will be cached  All rights reserved (c) 2012-2014
        Period{firstYear=2012, secondYear=2013} will be cached  All rights reserved (c) 2012-2013
        Period{firstYear=2012, secondYear=2014} taken from cache  All rights reserved (c) 2012-2014
         */
    }
}
