package com.joshuasantacruz.RepuestosSA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepuestosSaJsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RepuestosSaJsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API funcional ");
    }
}
