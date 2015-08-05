package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
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

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

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

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);

        public void save(OutputStream outputStream) throws Exception {

            PrintWriter writer = new PrintWriter(outputStream);

            for (int i = 0; i < users.size(); i++) {
                writer.println("#");

                String firstName = users.get(i).getFirstName();
                if (firstName == null) {
                    firstName = "unknown";
                }
                writer.println(firstName);

                String lastName = users.get(i).getLastName();
                if (lastName == null) {
                    lastName = "unknown";
                }
                writer.println(lastName);

                writer.println(dateFormat.format(users.get(i).getBirthDate()));
                writer.println(String.valueOf(users.get(i).isMale()));
                writer.println(users.get(i).getCountry());
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {

                String newUser = reader.readLine();

                if (newUser.equals("#")) {

                    User user = new User();

                    String firstName = reader.readLine();
                    if (firstName.equals("unknown")) {
                        firstName = null;
                    }
                    user.setFirstName(firstName);

                    String lastName = reader.readLine();
                    if (lastName.equals("unknown")) {
                        lastName = null;
                    }
                    user.setLastName(lastName);

                    user.setBirthDate(dateFormat.parse(reader.readLine()));

                    if (reader.readLine().equals(true)) {
                        user.setMale(true);
                    } else {
                        user.setMale(false);
                    }

                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);
                }

            }

        }
    }
}
