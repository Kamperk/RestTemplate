package client;

import client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    RestTemplate restTemplate;

    private final String url = "http://91.241.64.178:7081/api/users";
    private final String url2 = "http://91.241.64.178:7081/api/users/3";

    public ResponseEntity<List<User>> getAllUser(){
        return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
    }
    public ResponseEntity<String> createUser(HttpEntity<User> user){
        return restTemplate.exchange(url, HttpMethod.POST, user, String.class);
    }
    public ResponseEntity<String> UpdateUser(HttpEntity<User> user){
        return restTemplate.exchange(url, HttpMethod.PUT, user, String.class);
    }
    public ResponseEntity<String> DeleteUser(HttpEntity<User> user){
        return restTemplate.exchange(url2, HttpMethod.DELETE, user, String.class);
    }
}
