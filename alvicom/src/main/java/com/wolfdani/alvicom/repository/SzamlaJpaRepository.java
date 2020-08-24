package com.wolfdani.alvicom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolfdani.alvicom.entity.Szamla;

public interface SzamlaJpaRepository extends JpaRepository<Szamla, Long> {

	Optional<Szamla> findBySzamlaSzam(String szamlaSzam);
}
