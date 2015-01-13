package com.javarush.test.level13.lesson11.home04;
 
/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileWriter writer = new FileWriter(fileName);
        ArrayList<String> enteredStr = new ArrayList<String>();

        while(true) {
            String s = reader.readLine();
            enteredStr.add(s);
            if (s.equals("exit")) {
                for (String x: enteredStr) {
                    writer.write(x);
                }
                break;
            }
            enteredStr.add("\n");
        }
        writer.close();
    }
}