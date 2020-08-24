package com.wolfdani.alvicom.component;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wolfdani.alvicom.entity.Szamla;
import com.wolfdani.alvicom.repository.SzamlaRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	@Autowired
	SzamlaRepository szamlaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Szamla szamla = new Szamla("11111111-22222222","HUF",new BigDecimal("150000"));
		szamlaRepository.save(szamla);
		
		Szamla szamla2 = new Szamla("22222222-33333333","USD",new BigDecimal("1230"));
		szamlaRepository.save(szamla2);
		
		Szamla szamla3 = new Szamla("11111111-33333333","EUR",new BigDecimal("300"));
		szamlaRepository.save(szamla3);
	}
}
