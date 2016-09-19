package com.vmetrix.obtain.process.date;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*clase que permite obtener la fecha de procesamiento
a patir del nombre de archivo proporcionado como parametro
de entrada fileName.

El parametro typeFile puede contener solo los 
siguientes valores :
	- opf -> Archivo de operaciones FINDUR
	- opt -> Archivo de operaciones TURING
	- rc -> Archivo de Riesgo Credito
	- cv -> Archivo de Curvas
	- cp -> Archivo de Contrapartes*/

public class ProcessDate {
	
	public static String getProcessDate(String fileName, String typeFile){
		
		String tempDate="";
		String guion ="-";
		String anio="";
		String mes="";
		String dia="";
		StringBuffer processDate = new StringBuffer(1);
		
		 switch(typeFile)
	      {
	         case "opf" :
	        	 tempDate= fileName.substring(23,31);
	    		 anio=tempDate.substring(0, 4);
	    		 mes= tempDate.substring(4, 6);
	    		 dia=tempDate.substring(6);
	    		 processDate.append(anio);
	    		 processDate.append(guion);
	    		 processDate.append(mes);
	    		 processDate.append(guion);
	    		 processDate.append(dia);	
	            break;
	         	case "opt" :
	        	 tempDate= fileName.substring(27,35);
	    		 anio=tempDate.substring(0, 4);
	    		 mes= tempDate.substring(4, 6);
	    		 dia=tempDate.substring(6);
	    		 processDate.append(anio);
	    		 processDate.append(guion);
	    		 processDate.append(mes);
	    		 processDate.append(guion);
	    		 processDate.append(dia);	
	            break;
	         case "rc" :
	        	 tempDate= fileName.substring(16, 24);
	    		 anio=tempDate.substring(0, 4);
	    		 mes= tempDate.substring(4, 6);
	    		 dia=tempDate.substring(6);
	    		 processDate.append(anio);
	    		 processDate.append(guion);
	    		 processDate.append(mes);
	    		 processDate.append(guion);
	    		 processDate.append(dia);	        	 
	        	 break;
	         case "cv" :
//	        	 tempDate= fileName.substring(7,15);
	        	 tempDate= fileName.substring(24,32);
	    		 anio=tempDate.substring(0, 4);
	    		 mes= tempDate.substring(4, 6);
	    		 dia=tempDate.substring(6);
	    		 processDate.append(anio);
	    		 processDate.append(guion);
	    		 processDate.append(mes);
	    		 processDate.append(guion);
	    		 processDate.append(dia);
	            break;
	         case "cp" :
	        	 tempDate= fileName.substring(16, 24);
	    		 anio=tempDate.substring(0, 4);
	    		 mes= tempDate.substring(4, 6);
	    		 dia=tempDate.substring(6);
	    		 processDate.append(anio);
	    		 processDate.append(guion);
	    		 processDate.append(mes);
	    		 processDate.append(guion);
	    		 processDate.append(dia);
	            break;
	         default :
	        	 processDate.append("1900-01-01");
	      }

		return processDate.toString();
	}
	
	/*
	 * Valida que la fecha contenida en el nombre del archivo sea igual a la fecha de sistema.
	 * return true si ambas fechas son iguales, false de otro modo.
	 * 
	 */
	public static boolean validaPD(String path, String typeFile) throws ParseException {
		boolean rpta;
		File tem = new File(path);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date hoy = new Date();
		String sFechaSistema = format.format(hoy);
		Date dFechaSistema = format.parse(sFechaSistema);
				
		String sFechaArchivo = getProcessDate(tem.getName(),typeFile);
		Date dFechaArchivo = format.parse(sFechaArchivo);
		
				
		if(dFechaSistema.before(dFechaArchivo))
//			logger.debug("Fecha sistema menor que fecha archivo");
			rpta = false;
		else if(dFechaArchivo.before(dFechaSistema))
//			logger.debug("Fecha archivo menor que fecha sistema");
			rpta = false;
		else{
//			logger.debug("Las fechas de sistema y de archivo son iguales. Se procede a la carga.");
			return true;
		}
		
		return rpta;
	}

}
