package com.huaylupo.spmia.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import lombok.Data;

@SpringBootApplication
@RestController
@RequestMapping(value = "hello")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping(value = "/{firstName}")
    public String helloGET(
            @PathVariable("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }

    @PostMapping
    public String helloPOST(@RequestBody HelloRequest request) {
        return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
    }
}

@Data
class HelloRequest {
    private String firstName;
    private String lastName;
}

