package com.xfl.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by XFL
 * time on 2017/9/27 23:06
 * description:
 */
public class TestList {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        List<User> userLis2 = new ArrayList<>();
        List<User> userLis3 = new ArrayList<>();
        User user = new User("xfl", "13");
        User user1 = new User("xfl", "12");
        User user2 = new User("xfl2", "15");
        User user3 = new User("xfl", "12");
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userLis2.add(user3);
        Iterator<User> iterator = userList.iterator();
        Iterator<User> iterator2 = userLis2.iterator();
        while (iterator.hasNext()) {
            User user4 = iterator.next();
            while (iterator2.hasNext()) {
                User user5 = iterator2.next();
                if (user4.getName().equals(user5.getName())) {
                    if (user4.getAge().equals(user5.getAge())) {
                        iterator2.remove();
                    } else {
                        iterator.remove();
                    }
                }
            }
        }
        userLis3.addAll(userList);
        userLis3.addAll(userLis2);
        System.out.println(userLis3.size());
    }

    static class User {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }
}
