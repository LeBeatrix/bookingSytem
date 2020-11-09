package com.startup.controller;

import com.startup.entity.Receptionist;
import com.startup.factory.ReceptionistFactory;
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

import static org.junit.Assert.*;
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReceptionistControllerTest {

    private static Receptionist receptionist = ReceptionistFactory.createReceptionist("Office Administration" );
    private static String SECURITY_USERNAME = "user";
    private static String SECURITY_PASSWORD = "1v482jj";


    @Autowired
    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String baseURL = "https://localhost:8080/receptionist/";
    
    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url + "\n" + "receptionist" + receptionist);
        System.out.println("recep" + receptionist);
        ResponseEntity<Receptionist> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, receptionist, Receptionist.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        receptionist = postResponse.getBody();
        System.out.println("recep saved" + receptionist);
        assertEquals(receptionist.getAdminId(),postResponse.getBody().getAdminId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + receptionist.getQualification();
        System.out.println("URL: " + url);
        ResponseEntity<Receptionist> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, Receptionist.class);
        assertEquals(receptionist.getAdminId(), response.getBody().getAdminId());
    }

    @Test
    public void c_update() {
        Receptionist updated = new Receptionist.Builder().copy(receptionist).setQualification("Computer").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Post date: " + updated);
        ResponseEntity<Receptionist> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, updated, Receptionist.class);
        assertEquals(receptionist.getAdminId(), response.getBody().getAdminId());
    }
    @Test
    @Ignore
    public void e_delete() {
        String url = baseURL + "delete/" + receptionist.getAdminId();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(url);
    }

    }