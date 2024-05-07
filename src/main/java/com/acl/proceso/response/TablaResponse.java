package com.acl.proceso.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablaResponse {
	
	private Long id;
	private String descripcion;
	private Date fechaCreacion;		
	private Boolean vigente;
}
