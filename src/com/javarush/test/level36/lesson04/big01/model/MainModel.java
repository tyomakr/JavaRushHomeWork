package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.model.service.UserService;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    //Модель обращается к сервисам, создай поле UserService userService, инициализируй объектом
    private UserService userService = new UserServiceImpl();



    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        //Достань всех пользователей между 1 и 100 уровнями
        //Положи всех пользователей в modelData
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));

    }

}
