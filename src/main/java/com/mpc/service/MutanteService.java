package com.mpc.service;

import com.mpc.model.Estadistica;
import com.mpc.model.Persona;
import com.mpc.model.Secuencia;

public interface MutanteService {
	
	
	public  Persona verificarMutante(Secuencia secuenciaADN);
	
	public Estadistica conseguirEstadistica();

}
