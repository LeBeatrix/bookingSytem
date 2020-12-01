package com.startup.controller;

import com.startup.entity.Appointment;
import com.startup.factory.AppointmentFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.parser.Entity;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentControllerTest {

    private static Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", LocalDate.of(2020,8,25), LocalTime.of(15,0) );
    private String SECURITY_USERNAME = "Michael_ADMIN";
    private String SECURITY_PASSWORD = "321";

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseURL = "http://localhost:8080/bookingSystem/appointment/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + appointment);
        ResponseEntity<Appointment> postResponse = restTemplate.
                withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        appointment = postResponse.getBody();
        System.out.println("save: " + appointment);
        assertEquals(appointment.getAppointID(), postResponse.getBody().getAppointID());

    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();

    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.Builder().copy(appointment)
                .setAppointID("07263015222").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Appointment> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, updated, Appointment.class);
        assertEquals(appointment.getAppointID(), response.getBody().getAppointID());
    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseURL + "delete/" + appointment.getAppointID();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }

}