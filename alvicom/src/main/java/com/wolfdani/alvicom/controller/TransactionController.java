package com.wolfdani.alvicom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolfdani.alvicom.entity.TranzAkcio;
import com.wolfdani.alvicom.repository.TranzAkcioRepository;

@RestController
public class TransactionController {
	
	@Autowired
	private TranzAkcioRepository tranzAkcioRepository;
	
	@PostMapping(path = "/tranz", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> executeTranzAkcio (@Valid @RequestBody TranzAkcio tranzAkcio) {
		return tranzAkcioRepository.executeAndSave(tranzAkcio);
	}
}
