package fr.softway.medical;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.util.TimeZone;

@SpringBootApplication
public class SoftwayApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SoftwayApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}