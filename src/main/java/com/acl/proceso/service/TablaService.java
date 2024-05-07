package com.acl.proceso.service;

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

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


@Service

public interface TablaService{
	
	
	public ArrayList<Tabla> findAll();
	
	public TablaResponse ingreso(TablaRequest tablaRequest) throws ExceptionDTO ;
	
	public Tabla grabarTabla(TablaRequest tablaRequest);
	
	public Tabla actualizarTabla(Optional<Tabla> tabla, TablaRequest tablaRequest);
}


