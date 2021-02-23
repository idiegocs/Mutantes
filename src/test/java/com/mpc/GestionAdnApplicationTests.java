package com.mpc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mpc.model.Direccion;
import com.mpc.model.Persona;
import com.mpc.model.Secuencia;
import com.mpc.service.MutanteService;
import com.mpc.util.ADNUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
class GestionAdnApplicationTests {

	ADNUtil secuenciaADN;
	
	@Autowired
	MutanteService mutanteSer;

	@Test
	void findMutant() {

		int[] coordenada = new int[] { -1, -1, -1 };
		secuenciaADN = new ADNUtil(6, 6);
		List<String> sec = new ArrayList<>();
		sec.add("ATGCGA");
		sec.add("CAGTGC");
		sec.add("TTATGT");
		sec.add("AGAAGG");
		sec.add("CCCCTA");
		sec.add("TCACTG");

		List<String> caracteristicas = new ArrayList<>();
		caracteristicas.add("CCCC");
		caracteristicas.add("AAAA");
		caracteristicas.add("GGGG");
		caracteristicas.add("TTTT");

		secuenciaADN.cargar(sec);

		coordenada = secuenciaADN.buscar(caracteristicas.get(0));

		log.info("La palabra {} esta en F({}) / C({}) / {}", caracteristicas.get(0), coordenada[0], coordenada[1],
				Direccion.findById(coordenada[2]));

		coordenada = secuenciaADN.buscar(caracteristicas.get(1));

		log.info("La palabra {} esta en F({}) / C({}) / {}", caracteristicas.get(1), coordenada[0], coordenada[1],
				Direccion.findById(coordenada[2]));

		coordenada = secuenciaADN.buscar(caracteristicas.get(2));

		log.info("La palabra {} esta en F({}) / C({}) / {}", caracteristicas.get(2), coordenada[0], coordenada[1],
				Direccion.findById(coordenada[2]));

		coordenada = secuenciaADN.buscar(caracteristicas.get(3));

		log.info("La palabra {} esta en F({}) / C({}) / {}", caracteristicas.get(3), coordenada[0], coordenada[1],
				Direccion.findById(coordenada[2]));

		assertEquals(-1, coordenada[2], "No se encontro");

	}

	@Test
	void isMutante() {

		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		secuenciaADN = new ADNUtil();

		boolean isM = secuenciaADN.isMutant(dna);

		log.info("Es mutante {}", isM);

		assertEquals(true, isM, "NO Es Mutante");

	}

	@Test
	public void getAdn() throws IOException {

		// Given
		HttpUriRequest request = new HttpGet("http://localhost:8080/adn");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

	}

	@Test
	public void getEstadisticas() throws IOException {

		// Given
		HttpUriRequest request = new HttpGet("http://localhost:8080/stats");

		// When
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// Then
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

	}
	
	@Test
	public void validateMutant() throws IOException {

	
		
	    CloseableHttpClient client = HttpClients.createDefault();
	    Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");

		// Given
	    HttpPost  httpPost= new HttpPost("http://localhost:8080/mutant");
	    httpPost.setHeader(header);
	    
	    String json = "{ \"dna\": [ \"ACCGA\", \"CAGTGC\", \"TTATGT\", \"AGAATG\", \"CCCCTA\", \"TCACTG\" ]}";
	    StringEntity entity = new StringEntity(json);
	    
	    httpPost.setEntity(entity);


		CloseableHttpResponse response = client.execute(httpPost);
		assertEquals(200,response.getStatusLine().getStatusCode());
	    client.close();

	}
	
	@Test
	public void validateHumano() throws IOException {
		
		Secuencia secuenciaADN =new Secuencia();
		List<String> dna = new ArrayList<>();
		dna.add("ATGCGA");
		dna.add("CAGTCC");
		dna.add("TTATGT");
		dna.add("AGAAGG");
		dna.add("CCACTA");
		dna.add("TCACTG");
		secuenciaADN.setDna(dna);
		
		Persona per=mutanteSer.verificarMutante(secuenciaADN);
		
		assertEquals(false,per.isMutant());
		
	}
	

}
