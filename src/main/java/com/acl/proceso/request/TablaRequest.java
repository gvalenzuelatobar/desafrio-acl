package com.acl.proceso.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TablaRequest {	
		
		private Long id;
		private String descripcion;
		private Date fechaCreacion;		
		private Boolean vigente;
	
}
