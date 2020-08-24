package com.wolfdani.alvicom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolfdani.alvicom.entity.TranzAkcio;

public interface TranzAkcioJpaRepository extends JpaRepository<TranzAkcio, Long> {

	List<TranzAkcio> findBySzamlaSzam(String szamlaSzam);
}
