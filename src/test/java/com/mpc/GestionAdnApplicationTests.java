package com.mpc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mpc.model.Direccion;
import com.mpc.util.ADNUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class GestionAdnApplicationTests {

	ADNUtil secuenciaADN;
	
	@Test
	void findMutant() {
	
		int[] coordenada = new int[]{-1, -1, -1};
		secuenciaADN=new ADNUtil(6, 6);
		List<String> sec=new ArrayList<>();
		sec.add("ATGCGA");
		sec.add("CAGTGC");
		sec.add("TTATGT");
		sec.add("AGAAGG");
		sec.add("CCCCTA");
		sec.add("TCACTG");
		
		List<String> caracteristicas=new ArrayList<>();
		caracteristicas.add("CCCC");
		caracteristicas.add("AAAA");
		caracteristicas.add("GGGG");
		caracteristicas.add("TTTT");
		
		secuenciaADN.cargar(sec);
		
		coordenada=secuenciaADN.buscar(caracteristicas.get(0));
		
		log.info("La palabra {} esta en F({}) / C({}) / {}",caracteristicas.get(0),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		coordenada=secuenciaADN.buscar(caracteristicas.get(1));
		
		log.info("La palabra {} esta en F({}) / C({}) / {}",caracteristicas.get(1),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
	   coordenada=secuenciaADN.buscar(caracteristicas.get(2));
		
		log.info("La palabra {} esta en F({}) / C({}) / {}",caracteristicas.get(2),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		coordenada=secuenciaADN.buscar(caracteristicas.get(3));
			
		log.info("La palabra {} esta en F({}) / C({}) / {}",caracteristicas.get(3),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		assertEquals(-1, coordenada[2], "No se encontro");
		
	}
	
	
	@Test
	void isMutante() {
		
		
		String[] dna= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		secuenciaADN=new ADNUtil();
		
		boolean isM=secuenciaADN.isMutant(dna);
		
		log.info("Es mutante {}",isM);
		
		assertEquals(true,isM, "NO Es Mutante");
	
	}

}
