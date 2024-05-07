package com.acl.proceso.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.acl.proceso.entity.Tabla;
import com.acl.proceso.request.TablaRequest;
import com.acl.proceso.response.TablaResponse;


@Service

public interface TablaService{
	
	
	public ArrayList<Tabla> findAll();
	
	public TablaResponse ingreso(TablaRequest tablaRequest) ;
	
	public Tabla grabarTabla(TablaRequest tablaRequest);
	
	public Tabla actualizarTabla(Optional<Tabla> tabla, TablaRequest tablaRequest);
}


