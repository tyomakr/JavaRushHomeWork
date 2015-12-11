package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
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

        modelData.setDisplayDeletedUserList(false);
        //Достань всех пользователей между 1 и 100 уровнями
        //Положи всех пользователей в modelData
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }

    public void loadDeletedUsers() {

        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

}
