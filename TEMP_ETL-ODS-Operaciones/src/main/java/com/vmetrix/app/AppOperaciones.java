package com.vmetrix.app;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.vmetrix.etl.ods.scheduler.SchedulerClass;

public class AppOperaciones {

	static Log logger = LogFactory.getLog(AppOperaciones.class.getName());  
	public static void main(String[] args) {
		SchedulerClass sch = new SchedulerClass();
		try {
			logger.debug("ETL Operaciones, compatible con Exportador FINDUR INTF_Itau_ODS V 2.4");
			sch.run();
			
		} catch (IOException e) {
			logger.error("IO Exception ExamResult failed" +e);
		}catch (Exception e) {
			logger.error("Error al iniciar el job: ", e);
		}
	}

}