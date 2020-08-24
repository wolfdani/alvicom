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
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class  Szamla {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id; 

	@NotNull
	@Column(unique=true)
	@Pattern(regexp = "^[0-9]{8}-[0-9]{8}$")
    private String szamlaSzam;
	
	@NotNull
	@Pattern(regexp = "^[EUR|HUF|USD|JPN]{3}$")
	private String penzNem;

	@NotNull
	@Column(updatable=true)
	private BigDecimal aktualisEgyenleg;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable=false)
	@CreationTimestamp
	protected Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	protected Date updatedOn;
		
	public Szamla() {}
	
	public Szamla(String szamlaSzam, String penzNem, BigDecimal aktualisEgyenleg) {
		this.szamlaSzam = szamlaSzam;
		this.penzNem = penzNem;
		this.aktualisEgyenleg = aktualisEgyenleg;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public BigDecimal getAktualisEgyenleg() {
		return aktualisEgyenleg;
	}

	public void setAktualisEgyenleg(BigDecimal aktualisEgyenleg) {
		this.aktualisEgyenleg = aktualisEgyenleg;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "Szamla [Id=" + Id + ", szamlaSzam=" + szamlaSzam + ", penzNem=" + penzNem + ", aktualisEgyenleg="
				+ aktualisEgyenleg + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
}
