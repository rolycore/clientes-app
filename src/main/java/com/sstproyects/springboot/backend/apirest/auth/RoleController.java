package com.sstproyects.springboot.backend.apirest.auth;

import com.sstproyects.springboot.backend.apirest.user.Role;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {

  @GetMapping("/all")
  public List<Role> getAllRoles() {
    return Arrays.asList(Role.values());
  }
}
