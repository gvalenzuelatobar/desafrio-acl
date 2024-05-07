package com.acl.proceso.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.acl.proceso.entity.Tabla;

public interface TablaRepositorio extends CrudRepository<Tabla, Long> {
	
	public ArrayList<Tabla> findAll();
	
	
}
