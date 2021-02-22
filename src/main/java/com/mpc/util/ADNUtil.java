package com.mpc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mpc.model.Direccion;

import lombok.extern.log4j.Log4j2;
import static com.mpc.model.Direccion.*;



@Log4j2
public class ADNUtil {

	private char[][] secuencia;
	private Direccion[] direcciones = Direccion.values();

	public ADNUtil(int ancho, int alto) {
		this.secuencia = new char[alto][ancho];
	
	}
	
	public ADNUtil() {
		
	}

	public void cargar(List<String> secADN) {

		String fila = null;
		char colum;
		for (int i = 0; i < secuencia.length; i++) {
			for (int j = 0; j < secuencia[i].length; j++) {

				fila = secADN.get(i).toUpperCase();
				colum = fila.charAt(j);

				secuencia[i][j] = colum;

			}
			log.info(fila);
		}

		
	}
	


	public int[] buscar(String palabra) {

		int[] coordenada = new int[] { -1, -1, -1 };

		log.info("Buscar {} ", palabra);

		boolean encontrada = false;

		for (int fila = 0; fila < secuencia.length; fila++) {

			for (int columna = 0; columna < secuencia[fila].length; columna++) {

				coordenada = buscarDirecciones(palabra, fila, columna);

				if (evaluarCoordenada(coordenada)) {
					encontrada = true;
					break;
				}

			} // cierra for columnas

			if (encontrada) {
				break;
			}

		} // cierra for filas

		return coordenada;
	}

	public boolean evaluarCoordenada(int[] coordenada) {
		return (-1 != coordenada[0]);

	}

	public int[] buscarDirecciones(String palabra, int fila, int columna) {

		int[] coordenada = new int[] { -1, -1, -1 };

		for (Direccion direccion : direcciones) {

			switch (direccion) {

			case ARRIBA:
				coordenada = buscarArriba(palabra, fila, columna);

				break;
			case ABAJO:
				coordenada = buscarAbajo(palabra, fila, columna);

				break;
			case DERECHA:
				coordenada = buscarDerecha(palabra, fila, columna);

				break;
			case IZQUIERDA:

				coordenada = buscarIzquierda(palabra, fila, columna);

				break;
			case ARRIBA_DER:

				coordenada = buscarArribaDerecha(palabra, fila, columna);

				break;
			case ARRIBA_IZQ:

				coordenada = buscarArribaIzquierda(palabra, fila, columna);

				break;
			case ABAJO_DER:

				coordenada = buscarAbajoDerecha(palabra, fila, columna);

				break;
			case ABAJO_IZQ:

				coordenada = buscarAbajoIzquierda(palabra, fila, columna);

				break;

			default:

				break;

			}// cierra switch

			if (evaluarCoordenada(coordenada)) {
				break;
			}

		} // cierra for

		return coordenada;
	}

	public int[] buscarDerecha(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if (columna + (palabra.length() - 1) < secuencia[fila].length) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {

				if (palabra.charAt(letras) != secuencia[fila][columna + letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				asignarCordenada(coordenada,fila,columna,DERECHA.getId());


			}
		}

		return coordenada;

	}

	public int[] buscarIzquierda(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if (columna - (palabra.length() - 1) >= 0) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila][columna - letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				
				asignarCordenada(coordenada,fila,columna,IZQUIERDA.getId());


			}
		}

		return coordenada;

	}

	public int[] buscarAbajo(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if (fila + (palabra.length() - 1) < secuencia.length) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila + letras][columna]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				asignarCordenada(coordenada,fila,columna,ABAJO.getId());
	

			}
		}

		return coordenada;

	}

	public int[] buscarArriba(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };
		if (fila - (palabra.length() - 1) >= 0) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila - letras][columna]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				asignarCordenada(coordenada,fila,columna,ARRIBA.getId());


			}
		}

		return coordenada;

	}

	public int[] buscarArribaDerecha(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if ((fila - (palabra.length() - 1) >= 0) && (columna + (palabra.length() - 1) < secuencia[fila].length)) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila - letras][columna + letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				
				asignarCordenada(coordenada,fila,columna,ARRIBA_DER.getId());


			}
		}

		return coordenada;

	}

	public int[] buscarArribaIzquierda(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if ((fila - (palabra.length() - 1) >= 0) && (columna - (palabra.length() - 1) >= 0)) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila - letras][columna - letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				asignarCordenada(coordenada,fila,columna,ABAJO_IZQ.getId());


			}
		}

		return coordenada;

	}

	public int[] buscarAbajoDerecha(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if ((fila + (palabra.length() - 1) < secuencia.length)
				&& (columna + (palabra.length() - 1) <= secuencia[fila].length)) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila + letras][columna + letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				
				asignarCordenada(coordenada,fila,columna,ABAJO_DER.getId());

			}
		}

		return coordenada;

	}

	public int[] buscarAbajoIzquierda(String palabra, int fila, int columna) {

		boolean encontrada = false;
		int[] coordenada = new int[] { -1, -1, -1 };

		if ((fila + (palabra.length() - 1) < secuencia.length) && (columna - (palabra.length() - 1) >= 0)) {
			encontrada = true;

			for (int letras = 0; letras < palabra.length(); letras++) {
				if (palabra.charAt(letras) != secuencia[fila + letras][columna - letras]) {
					encontrada = false;
					break;
				}
			}
			if (encontrada) {
				asignarCordenada(coordenada,fila,columna,ABAJO_IZQ.getId());
			}
		}

		return coordenada;

	}
	
	public void asignarCordenada(int[] coordenada,  int fila, int columna, int direccion )
	{
		coordenada[0] = fila;
		coordenada[1] = columna;
		coordenada[2] = direccion;
	}
	
	
	public boolean isMutant(String[] dna)
	{
		int[] coordenada;
		boolean isMutant=false;
		int numSecuencias=0;
		final String MENSAJE ="La palabra {} esta en F({}) / C({}) / {}";
		
		secuencia = new char[dna.length][dna[0].length()];
		this.cargar(Arrays.asList(dna));
		
		List<String> caracteristicas=new ArrayList<>();
		caracteristicas.add("CCCC");
		caracteristicas.add("AAAA");
		caracteristicas.add("GGGG");
		caracteristicas.add("TTTT");
		
		
		coordenada=this.buscar(caracteristicas.get(0));
		if(this.evaluarCoordenada(coordenada))
		{
			numSecuencias++;
		}
		
		log.info(MENSAJE,caracteristicas.get(0),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		coordenada=this.buscar(caracteristicas.get(1));
		if(this.evaluarCoordenada(coordenada))
		{
			numSecuencias++;
		}
		
		log.info(MENSAJE,caracteristicas.get(1),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
	   coordenada=this.buscar(caracteristicas.get(2));
	    if(this.evaluarCoordenada(coordenada))
		{
			numSecuencias++;
		}
		
		log.info(MENSAJE,caracteristicas.get(2),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		coordenada=this.buscar(caracteristicas.get(3));
		
		log.info(MENSAJE,caracteristicas.get(3),coordenada[0],coordenada[1],Direccion.findById(coordenada[2]));
		
		if(this.evaluarCoordenada(coordenada))
		{
			numSecuencias++;
		}
			
		
		log.info("Nuemero de secuencias encontradas {} ",numSecuencias);

		
		if(numSecuencias>1)
		{
			isMutant=true;
		}
		
		
		return isMutant;
		
	}



}
