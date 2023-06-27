package service;

import entity.Manager;
import entity.School;
import entity.User;

import java.util.ArrayList;

public class Operation {
    private static ArrayList<User> users = new ArrayList<>();

    public Operation() {
        init();
    }


    private void init(){
        users.add(new User(1, "John", "staff", "123"));
        users.add(new Manager(2, "ROOT", "BOSS", "root"));

    }

    public User findUser(int id, String password) {
        for (User user : users){
            if (user.getUserID() == id && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

}
