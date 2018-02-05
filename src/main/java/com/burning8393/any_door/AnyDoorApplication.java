package com.burning8393.any_door;

import com.burning8393.any_door.domain.Book;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.burning8393.any_door.mapper")
public class AnyDoorApplication {
    @Autowired
    private Book book;

    public static void main(String[] args) {
        SpringApplication.run(AnyDoorApplication.class, args);
    }

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String index() {
        return "Hello Spring Boot! The BookName is " + book.getName() + ";and Book Author is " + book.getAuthor() + ";and Book Price is " + book.getPrice();
    }
}
