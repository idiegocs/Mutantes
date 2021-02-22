package com.mpc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpc.controller.MutanteController;
import com.mpc.entity.ADN;
import com.mpc.model.Estadistica;
import com.mpc.model.Persona;
import com.mpc.model.Secuencia;
import com.mpc.repository.MutantRepository;
import com.mpc.service.MutanteService;
import com.mpc.util.ADNUtil;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class MutanteServiceImpl implements MutanteService {

	@Autowired
	 private MutantRepository  mutantRepo;
	
	
	@Override
	public Persona verificarMutante(Secuencia secuencia) {
		
		
		ADNUtil adnUtil=new ADNUtil();
		
		boolean isM=adnUtil.isMutant(secuencia.getDna().toArray(new String[secuencia.getDna().size()]));
		
		ADN adn;
		
		long numAdn=mutantRepo.findBySecuencia(secuencia.toString());
		
		if(numAdn==0)
		{
			adn=new ADN();
			adn.setSecuencia(secuencia.toString());
			adn.setMutant(isM);
			mutantRepo.save(adn);
		}
		else
		{

			log.info("Adn ya encontrado {} ",numAdn);
		}
		
		
		
		
		return new Persona(secuencia.toString(),isM);
	}
	
	
	public Estadistica conseguirEstadistica()
	{
		Estadistica estadistica= new Estadistica();
		
		
		long contMutantes=mutantRepo.findByCondicion(true);
		long contHumanos=mutantRepo.findByCondicion(false);
		double ratio=0;
		
		if(contHumanos!=0 && contMutantes!=0)	
		{
			ratio=(double)contMutantes/contHumanos;
		}
		
		estadistica.setContadorHumanos(contHumanos);
		estadistica.setContadorMutantes(contMutantes);
		estadistica.setRatio(ratio);
		
		return  estadistica;
	}

}
