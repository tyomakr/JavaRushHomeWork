package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

public class Model  {

    //размер ячейки игрового поля
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("..\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        this.gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel = currentLevel + 1;
        restartLevel(currentLevel);
    }

    public void move(Direction direction){}


    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        return gameObject.isCollision(gameObject, direction);
    }

    
}

/*
15.2.	boolean checkBoxCollision(Direction direction). Этот метод проверяет
столкновение с ящиками. Метод должен:
15.2.1.	Вернуть true, если игрок не может быть сдвинут в направлении direction (там
находится: или ящик, за которым стена; или ящик за которым еще один ящик).
15.2.2.	Вернуть false, если игрок может быть сдвинут в направлении direction (там
находится: или свободная ячейка; или дом; или ящик, за которым свободная
ячейка или дом). При это, если на пути есть ящик, который может быть сдвинут, то
необходимо переместить этот ящик на новые координаты. Обрати внимание, что
все объекты перемещаются на фиксированное значение FIELD_SELL_SIZE, не
зависящее от размеров объекта, которые используются для его отрисовки.
Подсказка: для определения столкновений используй методы isCollision() игровых
объектов и метод checkWallCollision() модели.
15.3.	void checkCompletion(). Этот метод должен проверить пройден ли уровень (на
всех ли домах стоят ящики, их координаты должны совпадать). Если условие
выполнено, то проинформировать слушателя событий, что текущий уровень завершен.
15.4.	void move(Direction direction). Метод должен:
15.4.1.	Проверить столкновение со стеной (метод checkWallCollision()), если есть
столкновение – выйти из метода.
15.4.2.	Проверить столкновение с ящиками (метод checkBoxCollision()), если есть
столкновение – выйти из метода.
15.4.3.	Передвинуть игрока в направлении direction.
15.4.4.	Проверить завершен ли уровень.

Запусти программу и проверь, что игрока можно перемещать, он может перемещать
ящики, стены преграждают движение, а при перемещении всех ящиков в дома выводится
сообщение о прохождении уровня.
 */
