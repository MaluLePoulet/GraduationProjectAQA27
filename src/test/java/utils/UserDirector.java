package utils;

import configuration.ReadProperties;
import models.User;

public class UserDirector {

    public static User getAdmin() {
        return new User.Builder()
                .setEmail(ReadProperties.username())
                .setPassword(ReadProperties.password())
                .build();
    }

    public static User getUserWithIncorrectEmail() {
        return new User.Builder()
                .setEmail("tester@maip.com")
                .setPassword(ReadProperties.password())
                .build();
    }

    public static User getUserWithIncorrectPassword() {
        return new User.Builder()
                .setEmail(ReadProperties.username())
                .setPassword("qwert")
                .build();
    }
}