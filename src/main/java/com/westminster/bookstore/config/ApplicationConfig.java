package com.westminster.bookstore.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        // Register resource and exception mapper packages
        packages("com.westminster.bookstore.resources", "com.westminster.bookstore.exceptions");

        // Register JacksonFeature for JSON serialization/deserialization
        register(JacksonFeature.class);

        // Register JavaTimeModule to handle Java 8 date/time types
        register(new JavaTimeModule());
    }
}