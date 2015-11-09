package com.javarush.test.level29.lesson15.big01.user;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    private boolean isManAnya = false;
    private boolean isManRoma = true;

    public void printUsers() {
        System.out.println("Имя: " + userAnya.getName());
        System.out.println("Фамилия: " + userAnya.getSurname());
        printAdditionalInfo(userAnya);

        System.out.println("Имя: " + userRoma.getName());
        System.out.println("Фамилия: " + userRoma.getSurname());
        printAdditionalInfo(userRoma);
    }

    public void printAdditionalInfo(User user) {
        if (ageLessThan16(user))
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    private boolean ageLessThan16(User user) {
        if (user.getAge() < 16) {
            return true;
        }
        return false;
    }

    public int calculateAvarageAge() {
        int age = 28;
        User userUra = new User("Юра", "Карп", age);

        age = (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;

        return age;
    }

    public void calculateRate(double base, int age, boolean hasWork, boolean hasHouse) {
        base += age / 100;
        base *= hasWork ? 1.1 : 0.9;
        base *= hasHouse ? 1.1 : 0.9;
    }

    public String getBoosName(User user) {
        Work work = user.getWork();
        return work.getBoss();
    }
}
