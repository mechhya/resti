package rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.beans.Bean_login;
import rest.beans.Greeting;
import rest.logics.Logic_Login;
import rest.services.dao.DAO_LOGIN;
import rest.services.dto.UserDto;

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
