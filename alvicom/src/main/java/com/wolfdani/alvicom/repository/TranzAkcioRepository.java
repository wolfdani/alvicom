package com.wolfdani.alvicom.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.wolfdani.alvicom.entity.Szamla;
import com.wolfdani.alvicom.entity.TranzAkcio;

@Repository
@Transactional()
public class TranzAkcioRepository {
	
	private final static String transActionExecuted = "transAction executed";
	
	private final static String invoiceNumber = "SzámlaSzám: ";
	
	private final static String invalidInvoiceWarning = "WARNING: Nem érvényes számlaszám: ";
	
	@Value("${alvicom.statistic.counter:10}") 
	private int configuredCounter;

	@Autowired
	private TranzAkcioJpaRepository tranzAkcioRepository;
	
	@Autowired
	private SzamlaJpaRepository szamlaRepository;
	
	private int statisticCounter;
	
	public ResponseEntity<String> executeAndSave(TranzAkcio tranzAkcio) {
		
		Optional<Szamla> szamla = findBySzamlaSzam(tranzAkcio.getSzamlaSzam());
		
		if (szamla.isPresent()) {
			executeTranzAktion(szamla.get(),tranzAkcio);
			tranzAkcioRepository.saveAndFlush(tranzAkcio);
			traceStatistic();
			return new ResponseEntity<>(TranzAkcioRepository.transActionExecuted,HttpStatus.OK);
		} else {
			System.out.println( TranzAkcioRepository.invalidInvoiceWarning + tranzAkcio.getSzamlaSzam());
			return new ResponseEntity<>(TranzAkcioRepository.invalidInvoiceWarning,HttpStatus.BAD_REQUEST);
		}
	} 
	
	private Optional<Szamla> findBySzamlaSzam(String szamlaSzam) {
		return szamlaRepository.findBySzamlaSzam(szamlaSzam);
	}
	
	private void executeTranzAktion(Szamla szamla, TranzAkcio tranzAkcio) {
		BigDecimal aktualisUtalas = 
				szamla.getPenzNem().equals(tranzAkcio.getPenzNem())?
						tranzAkcio.getOsszeg():tranzAkcio.getOsszeg().multiply(tranzAkcio.getValutaArfolyam());
						 
		
		BigDecimal aktualisEgyenleg = szamla.getAktualisEgyenleg().add(aktualisUtalas);
		szamla.setAktualisEgyenleg(aktualisEgyenleg);
		szamlaRepository.save(szamla);
	}
	
	private void traceStatistic() {
		statisticCounter++;
		if(statisticCounter==configuredCounter) {
			List<Szamla> szamlak = szamlaRepository.findAll();
			System.out.println(System.lineSeparator());
			szamlak.forEach(szamla -> {
				
				System.out.println(TranzAkcioRepository.invoiceNumber + szamla.getSzamlaSzam());
				List<TranzAkcio> tranzAkciok = tranzAkcioRepository.findBySzamlaSzam(szamla.getSzamlaSzam());
				tranzAkciok.forEach(tranzAkcio -> System.out.println(tranzAkcio));
			});
			System.out.println(System.lineSeparator());
			statisticCounter=0;
		}
	}
}
