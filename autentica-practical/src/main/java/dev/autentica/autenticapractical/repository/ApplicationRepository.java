package dev.autentica.autenticapractical.repository;

import dev.autentica.autenticapractical.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
