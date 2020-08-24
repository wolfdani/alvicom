package com.wolfdani.alvicom.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class TranzAkcio {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    private String szamlaSzam;
    
	@NotNull
    private String penzNem;
   
	@NotNull
    private BigDecimal osszeg;
    
	@NotNull
    private BigDecimal valutaArfolyam;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	@CreationTimestamp
	protected Date createdOn;

	public TranzAkcio() {}
	
	public TranzAkcio(String szamlaSzam, String penzNem, BigDecimal osszeg, BigDecimal valutaArfolyam) {
		this.szamlaSzam = szamlaSzam;
		this.penzNem = penzNem;
		this.osszeg = osszeg;
		this.valutaArfolyam = valutaArfolyam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSzamlaSzam() {
		return szamlaSzam;
	}

	public void setSzamlaSzam(String szamlaSzam) {
		this.szamlaSzam = szamlaSzam;
	}

	public String getPenzNem() {
		return penzNem;
	}

	public void setPenzNem(String penzNem) {
		this.penzNem = penzNem;
	}

	public BigDecimal getOsszeg() {
		return osszeg;
	}

	public void setOsszeg(BigDecimal osszeg) {
		this.osszeg = osszeg;
	}

	public BigDecimal getValutaArfolyam() {
		return valutaArfolyam;
	}

	public void setValutaArfolyam(BigDecimal valutaArfolyam) {
		this.valutaArfolyam = valutaArfolyam;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "TranzAkcio [id=" + id + ", szamlaSzam=" + szamlaSzam + ", penzNem=" + penzNem + ", osszeg=" + osszeg
				+ ", valutaArfolyam=" + valutaArfolyam + ", createdOn=" + createdOn + "]";
	}
}