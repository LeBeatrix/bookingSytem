//package com.startup.Repository.impl;
//
//import com.startup.entity.Bill;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author Michael Bezuidenhout
// */
//
//@D
//public class BillRepositoryImpl implements BillRepository {
//
//    private static BillRepository repository = null;
//    private Set<Bill> billDB;
//    private BillRepositoryImpl() {this.billDB = new HashSet<>(); }
//
//    public static BillRepository getRepository() {
//        if(repository == null) repository = new BillRepositoryImpl();
//            return repository;
//    }
//
//    @Override
//    public Bill create(Bill bill) {
//       this.billDB.add(bill);
//       return bill;
//    }
//
//    @Override
//    public Bill read(String billNo) {
//        for (Bill bill : this.billDB) {
//            if(bill.getBillNo().equalsIgnoreCase(billNo)) return bill;
//        }
//        return null;
//    }
//
//    @Override
//    public Bill update(Bill bill) {
//        boolean deleteBill = delete(bill.getBillNo());
//        if(deleteBill) {
//            this.billDB.add(bill);
//            return bill;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(String billNo) {
//        Bill bill = read(billNo);
//        if(bill != null) {
//            this.billDB.remove(bill);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Set<Bill> getAll() {
//        return this.billDB;
//    }
//}
