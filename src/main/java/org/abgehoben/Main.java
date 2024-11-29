package org.abgehoben;

import org.abgehoben.rest.cards;
import org.abgehoben.service.SpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {


    public static void main(String[] args) {

        SpringApplication.run(SpringBoot.class, args);
    }


}