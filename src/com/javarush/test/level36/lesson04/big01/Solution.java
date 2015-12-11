package com.javarush.test.level36.lesson04.big01;

import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.MainModel;
import com.javarush.test.level36.lesson04.big01.model.Model;
import com.javarush.test.level36.lesson04.big01.view.UsersView;

public class Solution {
    //Класс Solution будет эмулятором пользователя
    public static void main(String[] args)
    {
        Model model = new MainModel();
        UsersView usersView = new UsersView();

        Controller controller = new Controller();

        usersView.setController(controller);


        controller.setModel(model);
        controller.setUsersView(usersView);
        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
    }
}
