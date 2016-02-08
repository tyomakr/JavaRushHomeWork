package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;

import java.nio.file.Path;
import java.util.Date;
import java.util.Set;

public class LogParser implements IPQuery {

    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}


/*
Класс, который будет отвечать за парсинг логов называется LogParser.
1.1.	Добавь в класс LogParser конструктор с парметром Path logDir, где logDir -
директория с логами (логов может быть несколько, все они должны иметь расширение log).
1.2.	Реализуй интерфейс IPQuery у класса LogParser:
1.2.1.	Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать
количество уникальных IP адресов за выбранный период. Здесь и далее,
если в методе есть параметры Date after и Date before, то нужно возвратить
данные касающиеся только данного периода (включая даты after и before).
Если параметр after равен null, то нужно обработать все записи, у которых
дата меньше или равна before.
Если параметр before равен null, то нужно обработать все записи, у которых
дата больше или равна after.
Если и after, и before равны null, то нужно обработать абсолютно все записи
(без фильтрации по дате).
1.2.2.	Метод getUniqueIPs() должен возвращать множество, содержащее все
неповторяющиеся IP. Тип в котором будем хранить IP будет String.
1.2.3.	Метод getIPsForUser() должен возвращать IP, с которых работал
переданный пользователь.
1.2.4.	Метод getIPsForEvent() должен возвращать IP, с которых было произведено
переданное событие.
1.2.5.	Метод getIPsForStatus() должен возвращать IP, события с которых
закончилось переданным статусом.

Реализацию метода main() можешь менять по своему усмотрению.
 */