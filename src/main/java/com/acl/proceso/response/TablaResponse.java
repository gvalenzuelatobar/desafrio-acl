package com.acl.proceso.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TablaResponse {
	
	private Long id;
	private String descripcion;
	private String fechaCreacion;		
	private Boolean vigente;
}
