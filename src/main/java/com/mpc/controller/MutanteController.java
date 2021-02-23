package com.mpc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mpc.entity.ADN;
import com.mpc.exception.MutantFunctionalException;
import com.mpc.model.Estadistica;
import com.mpc.model.Persona;
import com.mpc.model.Secuencia;
import com.mpc.service.MutanteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Api(tags = "Mutantes", value = "Gestiona y Verifica si una secuencia de ADN es de un Mutante")
@RestController
public class MutanteController {

	@Autowired
	MutanteService mutantServ;

	@ApiOperation(value = "Verifica si una secuencia es de un Mutante", produces = "application/json")
	@PostMapping("/mutant")
	public void verificarMutante(@RequestBody @ApiParam(value = "secuenciaADN") Secuencia secuenciaADN) throws MutantFunctionalException {

		log.info("DataEntrada: {}", secuenciaADN);

		Persona per = mutantServ.verificarMutante(secuenciaADN);

		log.info("Es Mutante : {}", per.isMutant());
		if (!per.isMutant()) {

			throw new MutantFunctionalException("No es Mutante");
		} 
	}

	@ApiOperation(value = "Calcula las estadisticas, entre humanos y mutantes", produces = "application/json")
	@GetMapping("/stats")
	public Estadistica conseguirEstadistica() {

		return mutantServ.conseguirEstadistica();



	}
	
	@ApiOperation(value = "Lista los ADN de humanos mutantes", produces = "application/json")
	@GetMapping("/adn")
	public List<ADN> conseguirADN() {

		return mutantServ.conseguirADN();


	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(MutantFunctionalException.class)
	public void handleValidationExceptions(MutantFunctionalException ex) {

		log.error("No es mutante", ex);

	}

}
