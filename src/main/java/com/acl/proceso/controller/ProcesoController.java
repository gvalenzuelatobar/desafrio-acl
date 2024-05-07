package com.acl.proceso.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acl.proceso.entity.Tabla;
import com.acl.proceso.exception.ExceptionDTO;
import com.acl.proceso.request.TablaRequest;
import com.acl.proceso.response.TablaResponse;
import com.acl.proceso.service.TablaService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/tabla")
public class ProcesoController {
	
	private final Logger log = LoggerFactory.getLogger(ProcesoController.class);
	
	@Autowired
	private TablaService tablaService;
	
	@GetMapping("/todos")
    public ArrayList<Tabla> todos() {
		log.info("Responde todos los registros ");
		
		return  tablaService.findAll() ;
		
	}
	
	@Operation(summary = "Graba un registro en la BD", description = "un usuario y una lista de telefonos")	
	@PostMapping("/ingreso")
    public ResponseEntity<TablaResponse> ingreso( @RequestBody TablaRequest tabla) throws ExceptionDTO {
		log.info("Ingreso el registro en la BD");
		TablaResponse tablaResponse = new TablaResponse();
		
		tablaResponse =tablaService.ingreso(tabla);		
        if (tablaResponse == null) {
             new ResponseEntity<>(tablaResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
        	new ResponseEntity<>(tablaResponse, HttpStatus.OK); 
        }
		return new ResponseEntity<>(tablaResponse, HttpStatus.OK); 	
       
	}
	

}
