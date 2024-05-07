package com.acl.proceso.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatFecha {
	
	private static final String DATEHOUR_FORMAT = "dd-MM-yyyy";
	
	public static String convertirfechaToString(Date fecha) {
				
		SimpleDateFormat simpleformat = new SimpleDateFormat(DATEHOUR_FORMAT);		
		return simpleformat.format(fecha);
	}
	
	
	public static Date convertirfechaToDate(String fecha) {
		
		SimpleDateFormat simpleformat = new SimpleDateFormat(DATEHOUR_FORMAT);		
		try {
			return simpleformat.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
