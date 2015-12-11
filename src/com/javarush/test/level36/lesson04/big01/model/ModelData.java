package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.List;

/**
 * ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте
 */
public class ModelData {

    private List<User> users;


    //getters and setters
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
