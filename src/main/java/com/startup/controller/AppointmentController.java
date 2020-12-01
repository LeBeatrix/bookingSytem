package com.startup.controller;

/**
@authur Anati Jack
 */

import com.startup.entity.Appointment;
import com.startup.entity.Bill;
import com.startup.factory.AppointmentFactory;
import com.startup.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl appointmentService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public String appointmentList(Model model){
        model.addAttribute("appointments", appointmentService.appointmentList());
        return "appointment/list";
    }

    @RequestMapping("/list/{id}")
    public Appointment findById(@PathVariable Long id){
        return appointmentService.findById(id);
    }

    @RequestMapping("/create")
    public Appointment createBill(@RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return appointmentService.deleteById(id);
    }








    @PostMapping("/create")
    public Appointment a_create (@RequestBody Appointment appointment){
        Appointment newAppointment = AppointmentFactory.createAppointment(appointment.getAppointID(), appointment.getPatientNo(), appointment.getDocID(), appointment.getLocalDate(), appointment.getLocalTime());
        return appointmentService.create(newAppointment);
    }

    @GetMapping("/all")
    public Set<Appointment> d_getAll(){
        return  appointmentService.getAll();
    }

    @GetMapping("/read/{id}")
    public Appointment b_read(@PathVariable String id){
        return appointmentService.read(id);
    }

    @PostMapping ("/update")
    public Appointment c_update(@RequestBody Appointment address){
        return appointmentService.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public boolean e_delete(@PathVariable String id){
        return appointmentService.delete(id);
    }
}
