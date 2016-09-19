package com.vmetrix.etl.ods.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class EndFailedTask implements Tasklet {
	static Log logger = LogFactory.getLog(EndFailedTask.class);
   	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		logger.debug("Error en la Tarea. => EndFailedTask ");
		throw new Exception("Error en validacion de datos.");
	}
	
	


}
