package com.vmetrix.etl.ods.task;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class EndTask implements Tasklet {
	
//	@Autowired
   	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		return RepeatStatus.FINISHED;
	}
	
	


}
