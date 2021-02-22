package com.mpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mpc.entity.ADN;




public interface MutantRepository extends JpaRepository<ADN, Long>{
	
	
	 @Query("SELECT count(m) FROM ADN m WHERE m.secuencia=?1")
	 long findBySecuencia(String secuencia);
	 
	 @Query("SELECT count(m) FROM ADN m WHERE m.isMutant=?1")
	 long findByCondicion(boolean condicion);


}
