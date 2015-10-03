package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleHelper {


    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }


    public static String readString() throws IOException {

        String message;
        message = reader.readLine();

        return message;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> listDish = new ArrayList<>();

        String str = "";
        writeMessage("Выберите блюдо:\n" + Dish.allDishesToString());


        while (true) {

            str = readString();
            if (str.equalsIgnoreCase("exit")) {
                break;
            }

            else {
                try {
                    listDish.add(Dish.valueOf(str));
                }

                catch (IllegalArgumentException e) {
                    writeMessage(str + " is not detected");
                }
            }
        }

        return listDish;
    }

}
