package com.mpc.model;

public enum Direccion {

	ARRIBA(0), ARRIBA_DER(1), DERECHA(2), ABAJO_DER(3), ABAJO(4), ABAJO_IZQ(5), IZQUIERDA(6), ARRIBA_IZQ(7);

	private Direccion(int id)
	{
		this.id=id;
	}
	
	private int id;

	public int getId() {
		return id;
	}

	
	public static Direccion findById(int id){
	    for(Direccion d : values()){
	        if(d.getId()==id){
	            return d;
	        }
	    }
	    return null;
	}

	

} // Cierre del enum
