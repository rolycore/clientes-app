package com.sstproyects.springboot.backend.apirest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1")
public class HomeController {
  @GetMapping("/home")
  public String getHomePage() {
    return "¡Bienvenido a la página de inicio!";
  }
}
