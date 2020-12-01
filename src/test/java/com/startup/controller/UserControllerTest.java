package com.startup.controller;

import com.startup.entity.User;
import com.startup.factory.UserFactory;
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

import java.util.Random;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {

    private static User user = UserFactory.createUser("BoogyMan", "JW1243", "John", "Wick", "087123457", "test@gmail.com");
    private static String SECURITY_USERNAME = "Admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/bookingSystem/user/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL" + url);
        System.out.println("POST data: " + user);
        ResponseEntity<User> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        user = postResponse.getBody();
        System.out.println("Saved data: " + user);
        assertEquals(user.getUserId(), postResponse.getBody().getUserId());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
    }

    @Test
    public void c_update() {
        User updatedUser = new User.Builder().copy(user).setName("Neo").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Updated details: " + updatedUser);
        ResponseEntity<User> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updatedUser, User.class);
        assertEquals(user.getUserId(), response.getBody().getUserId());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + user.getUserId();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }
}