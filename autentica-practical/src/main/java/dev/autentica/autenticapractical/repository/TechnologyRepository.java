package dev.autentica.autenticapractical.repository;

import dev.autentica.autenticapractical.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {}
