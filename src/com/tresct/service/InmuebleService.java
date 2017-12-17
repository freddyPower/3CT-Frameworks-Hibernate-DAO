package com.tresct.service;

import java.util.List;

import org.hibernate.Session;

import com.tresc.dao.impl.InmuebleDaoImpl;
import com.tresct.domain.Imagen;
import com.tresct.domain.Inmueble;

public class InmuebleService {
	
	private InmuebleDaoImpl inmuebleDao;

	public InmuebleService(Session sesion) {
		inmuebleDao =  new InmuebleDaoImpl(sesion);
	}
	
	public Inmueble buscarPorId(int id) {
		return inmuebleDao.buscarInmueble(id);
	}
	
	//Este metodo aplica el concepto de metodo envoltorio para el service.
	public void guardar(Inmueble inmueble, List<Imagen>  lista) {
		if(lista != null) {
			for(Imagen img : lista) {
				inmueble.getImagenes().add(img);
			}
		}
		inmuebleDao.guardar(inmueble);
	}
	
	public void cerrarSesion() {
		inmuebleDao.cerrarSesion();
	}
}
