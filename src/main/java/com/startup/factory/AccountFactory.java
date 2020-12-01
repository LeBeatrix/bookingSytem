package com.startup.factory;

import com.startup.entity.Account;

/*
 * Class follows Single Responsibility Principle
 * Class is used to create objects of the Account Entity
 * Client calls createAccount method and passes through name, surname, password, cellNo as parameters
 * Builder pattern used to create object of Account
 */
public class AccountFactory {

    public static Account createAccount(String name, String surname, String username, String password, String cellNo) {
        Account account = new Account.Builder()
                .setName(name)
                .setSurname(surname)
                .setUsername(username)
                .setCellNo(cellNo)
                .setPassword(password)
                .build();

        return account;
    }
}
