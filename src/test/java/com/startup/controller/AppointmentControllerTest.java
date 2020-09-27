package com.startup.controller;

import com.startup.entity.Appointment;
import com.startup.factory.AppointmentFactory;
import org.junit.FixMethodOrder;
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

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppointmentControllerTest {

    private static Appointment appointment = AppointmentFactory.createAppointment("0706CP071401", "CP071401", "Harding0411", LocalDate.of(2020,8,25), LocalTime.of(15,0) );

    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseURL = "";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL:" + url);
        System.out.println("Post data: " + appointment);
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(url, appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        appointment = postResponse.getBody();
        System.out.println("save: " + appointment);
        assertEquals(appointment.getPatientNo(), postResponse.getBody().getPatientNo());

    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + appointment.getPatientNo();
        System.out.println("URL: " + url);
        ResponseEntity<Appointment> response = restTemplate.getForEntity(url, Appointment.class);
        assertEquals(appointment.getPatientNo(),response.getBody().getPatientNo());
    }

    @Test
    public void c_update() {
        Appointment updated = new Appointment.Builder().copy(appointment).setPatientNo("12456665").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Appointment> response = restTemplate.postForEntity(url, updated, Appointment.class);
        assertEquals(appointment.getPatientNo(), response.getBody().getPatientNo());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + appointment.getPatientNo();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

}