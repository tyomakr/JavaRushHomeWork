package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        String fileName;

        while(!(fileName = reader.readLine()).equals("exit")){
            files.add(fileName);
        }

        for(String s : files){
            new ReadThread(s).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        Map<Integer, Integer> countingMap = new HashMap<>();

        @Override
        public void run() {

            try {

                FileInputStream iStream = new FileInputStream(fileName);
                int max = Integer.MIN_VALUE;
                int result = Integer.MIN_VALUE;

                while (iStream.available() > 0) {
                    int data = iStream.read();
                    if (countingMap.containsKey(data)) {
                        countingMap.put(data, countingMap.get(data) + 1);
                    }
                    else {
                        countingMap.put(data, 1);
                    }
                }
                iStream.close();

                for (Map.Entry<Integer, Integer> entry : countingMap.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        result = entry.getKey();
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(this.fileName, result);
                }



            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
