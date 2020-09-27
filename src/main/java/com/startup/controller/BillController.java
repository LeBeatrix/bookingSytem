package com.startup.controller;

import com.startup.entity.Bill;
import com.startup.factory.BillFactory;
import com.startup.service.impl.BillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("Bill")
public class BillController {

    @Autowired
    public BillServiceImpl billService;

    @RequestMapping(value = "/generate")
    public Bill create(Bill bill){
        Bill newBill = BillFactory.generateBill(bill.getAmount(),
                bill.getPatientId(),
                bill.getAppointId());
        return billService.create(newBill);

        }

    @GetMapping("/read")
    public Bill read(@PathVariable String bill){
        return  billService.read(bill);
    }

    @PostMapping("/update")
    public Bill update(@RequestBody Bill bill) {
        return billService.update(bill);
    }

    @GetMapping("/all")
    public Set<Bill> getall(){
        return billService.getAll();
    }

    @DeleteMapping("/delete/{bill}")
    public boolean delete(@PathVariable String bill) {
        return billService.delete(bill);
    }

}

