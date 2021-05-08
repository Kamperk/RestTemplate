package client;

import client.config.Config;
import client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

@ComponentScan("client")
public class app {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        Communication communication = annotationConfigApplicationContext.getBean("communication", Communication.class);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://91.241.64.178:7081/api/users";
        HttpHeaders headers = new HttpHeaders();
        headers.put("Cookie", Objects.requireNonNull(communication.getAllUser().getHeaders().get("Set-Cookie")));
        User user = new User((long)3,"James", "Brown", (byte) 21);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        System.out.println(communication.createUser(entity));
        user.setName("Thomas");
        user.setLastName("Shelby");
        System.out.println(communication.UpdateUser(entity));
        System.out.println(communication.DeleteUser(entity));

    }

}
