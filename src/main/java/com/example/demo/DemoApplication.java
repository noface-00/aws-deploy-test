package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RestController
    public static class HelloController {
        @GetMapping("/")
        public String home() {
            return "¡Bienvenido a mi aplicación en AWS! - Exámen Fin de Ciclo";
        }

        @GetMapping("/api/info")
        public InfoResponse getInfo() {
            return new InfoResponse(
                    "Mi Aplicación Spring Boot",
                    "Versión 1.0",
                    "Desplegada en AWS EC2",
                    System.getProperty("os.name")
            );
        }
    }

    public record InfoResponse(String nombre, String version, String ubicacion,
                               String sistemaOperativo) {
    }
}