package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        String cryptType = args[0];
        String fileInput = args[1];
        String fileOutput = args[2];

        try {

            cryptFile(fileInput, fileOutput, cryptType);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void cryptFile (String fileInput, String fileOutput, String cryptType) throws Exception {
        FileInputStream iStream = new FileInputStream(fileInput);
        FileOutputStream oStream = new FileOutputStream(fileOutput);


        if (cryptType.equals("-e")) {  //encrypt

            while (iStream.available() > 0) {
                int data = iStream.read();
                data = data * 3;
                oStream.write(data);
            }
            iStream.close();

        }
        else if (cryptType.equals("-d")) { //decrypt

            while (iStream.available() > 0) {
                int data = iStream.read();
                data = data / 3;
                oStream.write(data);
            }
            oStream.close();

        }

    }

}
