package com.mpc.model;

public class Persona {
	
	public Persona()
	{
		
	}
	
	public Persona(String adn, boolean mutante)
	{
		this.adn=adn;
		this.isMutant=mutante;
	}
	private String adn;
	
	private boolean isMutant;
	

	public boolean isMutant() {
		return isMutant;
	}

	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}
	

}
