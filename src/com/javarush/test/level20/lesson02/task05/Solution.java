package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {

            PrintStream console = System.out;
            PrintStream printStream = new PrintStream(outputStream);
            System.setOut(printStream);
            if (!string1.equals(null)) string1.print();
            if (!string2.equals(null)) string2.print();
            System.setOut(console);
            printStream.close();

        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int k = countStrings;
            int st1 = Integer.parseInt(reader.readLine().replace("string #",""))-1;
            countStrings =st1;
            string1 = new String();
            int st2 = Integer.parseInt(reader.readLine().replace("string #",""))-1;
            countStrings = st2;
            string2 = new String();
            reader.close();
            countStrings = k;

        }
    }

    public static int countStrings;


    public static class String {
        private final int number;

        public String() {

            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
