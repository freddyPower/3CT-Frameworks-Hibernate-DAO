package com.tresc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tresct.dao.InmuebleDao;
import com.tresct.domain.Imagen;
import com.tresct.domain.Imagen_;
import com.tresct.domain.Inmueble;
import com.tresct.domain.Inmueble_;

public class InmuebleDaoImpl implements InmuebleDao{

	private Session sesion;
		
	public InmuebleDaoImpl(Session sesion) {
		this.sesion = sesion;
	}

	@Override
	public void guardar(Inmueble inmueble) {
		Transaction tx = null;		
		try {
			tx = sesion.beginTransaction();
			sesion.save(inmueble);
			
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}		
	}

	@Override
	public List<Imagen> buscarImagenes(Inmueble inmueble) {
		Transaction tx = null;	
		List<Imagen> lista = new ArrayList();
		try {
			tx = sesion.beginTransaction();
			CriteriaBuilder builder = sesion.getCriteriaBuilder();
			CriteriaQuery<Imagen> criteria =  builder.createQuery(Imagen.class);
			Root<Imagen> root = criteria.from(Imagen.class);
			
			//Traemos todas las imagenes de un inmueble
			Join<Imagen, Inmueble> join = root.join(Imagen_.inmuebles); 
			criteria.where(
						builder.equal(join.get(Inmueble_.idInmueble), inmueble.getIdInmueble())
					);
			
			lista = sesion.createQuery(criteria).getResultList();
			
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}		
		return lista;
	}

	@Override
	public Inmueble buscarInmueble(int id) {
		Transaction tx = null;		
		try {
			tx = sesion.beginTransaction();
			
			
			tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}		
		return null;
	}

}
