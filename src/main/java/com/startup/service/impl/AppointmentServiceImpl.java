package com.startup.service.impl;

import com.startup.Repository.impl.AppointmentRepository;

import com.startup.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michael Bezuidenhout
 */

@Service
public class AppointmentServiceImpl implements AppointmentService {

   @Autowired
    private AppointmentRepository repository;


    @Override
    public List<Appointment> appointmentList() {
        return this.repository.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public String deleteById(Long id) {
        this.repository.deleteById(id);
        return "{'message':'Appointment deleted successfully'}";
    }










    @Override
    public Set<Appointment> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


    @Override
    public Appointment create(Appointment appointment) {
        return this.repository.save(appointment);
    }

    @Override
    public Appointment read(String s) {
//        return this.repository.findById(s).orElse(null);
        return  null;
    }

    @Override
    public Appointment update(Appointment appointment) {
//        if (this.repository.existsById(appointment.getAppointID())){
//            return this.repository.save(appointment);
//        }
        return  null;
    }


    @Override
    public boolean delete(String s) {
//        this.repository.deleteById(s);
//        if (this.repository.existsById(s)) return false;
        return  true;
    }
}
