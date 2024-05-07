package com.acl.proceso.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TablaRequest {	
		
		@NotNull
		@Min(value = 1, message = "El valor del Id, debe ser mayor que 0")
		private Long id;
		
		@NotNull
		@NotBlank(message="Debe ingresar una Descripción")
		private String descripcion;
		
		@NotNull(message="Fecha creación, No debe ser nulo")
		private Date fechaCreacion;		
		
		@NotNull(message="Vigente, No debe ser nulo")
		private Boolean vigente;
	
}
