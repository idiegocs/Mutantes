package com.mpc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estadistica {
	
	@JsonProperty("count_mutant_dna")
	private long contadorMutantes;
	
	@JsonProperty("count_human_dna")
	private long contadorHumanos;
	
	@JsonProperty("ratio")
	private double ratio;

	public long getContadorMutantes() {
		return contadorMutantes;
	}

	public void setContadorMutantes(long contadorMutantes) {
		this.contadorMutantes = contadorMutantes;
	}

	public long getContadorHumanos() {
		return contadorHumanos;
	}

	public void setContadorHumanos(long contadorHumanos) {
		this.contadorHumanos = contadorHumanos;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estadistica [contadorMutantes=");
		builder.append(contadorMutantes);
		builder.append(", contadorHumanos=");
		builder.append(contadorHumanos);
		builder.append(", ratio=");
		builder.append(ratio);
		builder.append("]");
		return builder.toString();
	}
	
	

}
