package com.sstproyects.springboot.backend.apirest.config.accescontrol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessControlConfigRepository extends JpaRepository<AccessControlConfig, Long> {
}
