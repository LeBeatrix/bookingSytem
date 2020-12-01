package com.startup.factory;

import com.startup.entity.User;
import com.startup.util.GenericHelper;

import javax.print.DocFlavor;

/**
 * @author Yamkela Mbali
 * desc : factory classs for User
 */

public class UserFactory {

    public static User createUser(String username, String password, String name, String surname, String cellNo, String emailAddress ){

        String userId = String.valueOf(GenericHelper.generateId());
        User user = new User.Builder().setUserId(userId)
                .setUsername(username)
                .setPassword(password)
                .setName(name)
                .setSurName(surname)
                .setCellNo(cellNo)
                .setEmailAddress(emailAddress)
                .build();
        return user;
    }
}
