package com.burning8393.any_door;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AnyDoorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnyDoorApplication.class, args);
	}

	@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String index() {
        return "hello any_door";
    }
}
