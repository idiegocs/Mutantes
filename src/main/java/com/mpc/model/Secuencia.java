package com.mpc.model;

import java.util.List;


import io.swagger.annotations.ApiModelProperty;

public class Secuencia {
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(dna);
		builder.append("]");
		return builder.toString();
	}

    @ApiModelProperty(example = "[\"ACCGA\",\"CAGTGC\",\"TTATGT\",\"AGAATG\",\"CCCCTA\",\"TCACTG\"]")
	public List<String> dna;

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}
	
	
	

}
