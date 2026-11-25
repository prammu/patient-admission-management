package com.dscribe.patient.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Patient Admission Management API is running",
            "api", "/api/patients"
        );
    }
}

