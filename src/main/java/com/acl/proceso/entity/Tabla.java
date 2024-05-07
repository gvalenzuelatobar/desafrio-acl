package com.acl.proceso.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TABLA")
public class Tabla {
	
		
		@Id	
		@Column(name = "ID")
		private Long id;
		
		
		@Column(name = "DESCRIPCION")
	    private String descripcion; 
		
		@Column(name = "FECHA_CREACION")
	    private Date fechaCreacion; 
		
		@Column(name = "VIGENCIA")
	    private Boolean vigencia;	

}
