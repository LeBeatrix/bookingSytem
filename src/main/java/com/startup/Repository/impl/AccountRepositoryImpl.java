//package com.startup.Repository.impl;
///**
// * @author Michael Bezuidenhout
// */
//
//
//import com.startup.entity.Account;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class AccountRepositoryImpl implements AccountRepository {
//
//    private static AccountRepository repository = null;
//    private Set<Account> accountDB;
//    private AccountRepositoryImpl() { this.accountDB = new HashSet<>();}
//
//    public static AccountRepository getRepository() {
//        if(repository == null) repository = new AccountRepositoryImpl();
//        return repository;
//    }
//
//    @Override
//    public Account create(Account account) {
//        this.accountDB.add(account);
//        return account;
//    }
//
//    @Override
//    public Account read(final String username) {
//        for (Account account : this.accountDB) {
//            if(account.getUsername().equalsIgnoreCase(username)) return account;
//        }
//        return null;
//    }
//
//    @Override
//    public Account update(Account account) {
//        boolean deleteAccount = delete(account.getUsername());
//        if(deleteAccount) {
//            this.accountDB.add(account);
//            return account;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String username) {
//        Account account = read(username);
//        if(account != null) {
//            this.accountDB.remove(account);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Account> getAll() {
//        return this.accountDB;
//    }
//}
