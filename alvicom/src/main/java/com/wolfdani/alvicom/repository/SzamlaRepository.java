package com.wolfdani.alvicom.repository;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import com.wolfdani.alvicom.entity.Szamla;

@Repository
@Transactional()
@Validated
public class SzamlaRepository {

	@Autowired
	private SzamlaJpaRepository repository;
	
	public void save(@Valid Szamla szamla) {
		repository.saveAndFlush(szamla);
	} 
}
