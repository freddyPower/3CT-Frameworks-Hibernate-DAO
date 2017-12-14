package com.tresct.dao;

import java.util.List;

import com.tresct.domain.Imagen;
import com.tresct.domain.Inmueble;

public interface InmuebleDao {
	
	public void guardar(Inmueble inmueble);
	public List<Imagen> buscarImagenes(Inmueble inmueble);
	public Inmueble buscarInmueble(int id);

}
