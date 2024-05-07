package com.acl.proceso.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acl.proceso.entity.Tabla;
import com.acl.proceso.exception.ExceptionDTO;
import com.acl.proceso.repository.TablaRepositorio;
import com.acl.proceso.request.TablaRequest;
import com.acl.proceso.response.TablaResponse;
import com.acl.proceso.service.TablaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


@Service
public class TablaServiceImpl implements TablaService{
	
	private  Logger log = LoggerFactory.getLogger(TablaServiceImpl.class);

	@Autowired
	TablaRepositorio tablaRepositorio;		
	
	
	public ArrayList<Tabla> findAll() {
		
		return tablaRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public TablaResponse ingreso(TablaRequest tablaRequest) throws ExceptionDTO {
		TablaResponse response =new TablaResponse();
		try {
			Tabla tablaResp = new Tabla();
			
			Optional<Tabla> tabla =tablaRepositorio.findById(tablaRequest.getId());
			if(tabla.isEmpty()) {
				log.info("Registo Vacia, se ingresa el registro");
				tablaResp = grabarTabla(tablaRequest);				
				
			}else {
				log.info("Registro encontrado, se actualiza información, segun el id encontrado");				
				tablaResp = actualizarTabla(tabla, tablaRequest);
			}
			
			response.setId(tablaResp.getId());
			response.setDescripcion(tablaResp.getDescripcion());
			response.setFechaCreacion(tablaResp.getFechaCreacion());
			response.setVigente(tablaResp.getVigencia());
				
			
			
			
        } catch (DataAccessException ex) {
        	log.error(ex.getCause().getMessage());
        }		
		return response;
		
	}
	
	@Override
	@Transactional
	public Tabla grabarTabla(TablaRequest tablaRequest) {
		
		Tabla tabla = Tabla.builder()
				.id(tablaRequest.getId())
				.descripcion(tablaRequest.getDescripcion())
				.fechaCreacion(tablaRequest.getFechaCreacion())
				.vigencia(tablaRequest.getVigente())
				.build();
		
		return tablaRepositorio.save(tabla);
	}
	
	@Override
	@Transactional
	public Tabla actualizarTabla(Optional<Tabla> tabla, TablaRequest tablaUpdate) {
		
		Tabla updateTabla = Tabla.builder()
				.id(tabla.get().getId())
				.descripcion(tablaUpdate.getDescripcion())
				.fechaCreacion(tablaUpdate.getFechaCreacion())
				.vigencia(tablaUpdate.getVigente())
				.build();
		
		return tablaRepositorio.save(updateTabla);
	}
	
}


