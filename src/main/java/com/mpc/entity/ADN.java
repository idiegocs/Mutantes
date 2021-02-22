package com.mpc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADN")
public class ADN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "SECUENCE")
	private String secuencia;
	
	
	@Column(name = "CONDITION")
	private boolean isMutant;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getSecuencia() {
		return secuencia;
	}


	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}


	public boolean isMutant() {
		return isMutant;
	}


	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}
	
	
	
	
	
}
