package com.acl.proceso.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acl.proceso.entity.Tabla;

@Repository
public interface TablaRepositorio extends CrudRepository<Tabla, Long> {
	
	public ArrayList<Tabla> findAll();
	
	
}
