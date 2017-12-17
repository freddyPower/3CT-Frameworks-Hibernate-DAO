package test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;


import com.tresct.domain.Imagen;
import com.tresct.domain.Inmueble;
import com.tresct.service.InmuebleService;

import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		//Probamos el servicio con lista nula
		InmuebleService inmuebleService = new InmuebleService(sesion);
		inmuebleService.guardar(new Inmueble("Departamentos", "CDMX-Norte" ), null);
		
		List<Imagen> listaImagenes = new ArrayList();
		listaImagenes.add(new Imagen("www.",new Timestamp(new Date().getTime())));
		listaImagenes.add(new Imagen("http.",new Timestamp(new Date().getTime())));
		listaImagenes.add(new Imagen("https.",new Timestamp(new Date().getTime())));
		
		//Probamos el servicio con lista 
		inmuebleService.guardar(new Inmueble("Departamentos", "CDMX-Sur" ), listaImagenes);
		inmuebleService.cerrarSesion();
	}	
}
