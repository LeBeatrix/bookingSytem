package com.startup.service.impl;

import com.startup.entity.Bill;
import com.startup.service.IService;

import java.util.List;
import java.util.Set;

/*
 * @author Anati Jack
 */

public interface BillService extends IService<Bill, String> {

    Set<Bill> getAll();

    List<Bill> billList();

    Bill findById(Long id);

    Bill createBill(Bill bill);

    String deleteById(Long id);
}
