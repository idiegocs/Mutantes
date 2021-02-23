package com.mpc.service;

import java.util.List;

import com.mpc.entity.ADN;
import com.mpc.model.Estadistica;
import com.mpc.model.Persona;
import com.mpc.model.Secuencia;

public interface MutanteService {
	
	
	public  Persona verificarMutante(Secuencia secuenciaADN);
	
	public Estadistica conseguirEstadistica();
	
	public List<ADN> conseguirADN();

}
