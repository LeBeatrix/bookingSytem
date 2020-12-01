package com.startup.service.impl;
/**
 * @author Michael Bezuidenhout
 */

import com.startup.entity.Appointment;
import com.startup.entity.Bill;
import com.startup.service.IService;

import java.util.List;
import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();

    List<Appointment> appointmentList();

    Appointment findById(Long id);

    Appointment createAppointment(Appointment appointment);

    String deleteById(Long id);
}
