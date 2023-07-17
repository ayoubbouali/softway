package fr.softway.medical;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.util.TimeZone;

/**
 * Main class for the Softway application.
 *
 * This class serves as the entry point for the Spring Boot application. It contains the main method that starts the application,
 * and it also implements CommandLineRunner to define custom logic that runs after the application context has been initialized.
 */
@SpringBootApplication
public class SoftwayApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(SoftwayApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        // Custom logic to run after the application context has been initialized
        // Set the default time zone to UTC for the entire application
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}