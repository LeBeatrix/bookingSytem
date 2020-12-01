package com.startup.factory;

import com.startup.entity.Bill;
import com.startup.util.GenericHelper;

/*
 * Class follows Single Responsibility Principle
 * Class is used to create objects of the Bill Entity
 */
public class BillFactory {

    public static Bill generateBill(String appointId, String patientId, String amount) {

        String billNo = GenericHelper.generateId();
        Bill bill = new Bill.Builder()
                .setBillNo(billNo)
                .setAmount(amount)
                .setAppointId(appointId)
                .setPatientId(patientId)
                .build();

        return bill;
    }
}
