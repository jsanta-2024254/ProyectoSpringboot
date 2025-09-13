package com.joshuasantacruz.sportfinal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SportFinalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SportFinalApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Api funcional");
    }
}
