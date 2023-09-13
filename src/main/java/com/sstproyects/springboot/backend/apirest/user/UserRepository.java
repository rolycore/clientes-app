package com.sstproyects.springboot.backend.apirest.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
  Optional<User> findByNombreUsuarioOrEmail(String nombreUsuario, String email);

  Optional<User> findByNombreUsuarioOrEmail(String mailTo);

  Optional<User> getByTokenPassword(String tokenPassword);
}
