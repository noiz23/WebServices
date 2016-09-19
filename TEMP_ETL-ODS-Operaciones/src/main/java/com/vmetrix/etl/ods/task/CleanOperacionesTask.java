package com.vmetrix.etl.ods.task;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.vmetrix.obtain.process.date.ProcessDate;

public class CleanOperacionesTask implements Tasklet {
	static Log logger = LogFactory.getLog(CleanOperacionesTask.class);
	private static final String SELECT_TRANSACTIONT ="SELECT COUNT(*) FROM TRANSACTIONT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_CASHFLOW = "DELETE FROM CASHFLOW WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_EQUIVALENTE_CREDITO = "DELETE FROM EQUIVALENTE_CREDITO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_INTEREST = "DELETE FROM INTEREST WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_PRICING = "DELETE FROM PRICING WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_PROFIT = "DELETE FROM PROFIT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_SIDE = "DELETE FROM SIDE WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_TRANSACTION_INFO = "DELETE FROM TRANSACTION_INFO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static final String DELETE_TRANSACTIONT = "DELETE FROM TRANSACTIONT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN = ?";
	private static String typeFileF="opf";
	private static String typeFileT="opt";
	private static int origen =0;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
		private  Resource resource;

		
	
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		
		logger.debug("-------------------> Start Rollback -->");
		try{
			String processDate;
			if(resource.getFilename().contains("_FINDUR")){
				processDate=ProcessDate.getProcessDate(resource.getFilename(), typeFileF);
				origen=1;
			}else{
				processDate=ProcessDate.getProcessDate(resource.getFilename(), typeFileT);
				origen=2;
			}
			
			
			
			int count = jdbcTemplate.queryForObject(SELECT_TRANSACTIONT, new Object[] {processDate,origen},Integer.class);
			
			logger.debug("---->Numero de registros para antes de rollbac para la fecha = ["+ processDate+"] = "+count);
		if(count>0){
				jdbcTemplate.update(DELETE_CASHFLOW, processDate,origen);
				jdbcTemplate.update(DELETE_EQUIVALENTE_CREDITO,processDate,origen);
				jdbcTemplate.update(DELETE_INTEREST,processDate,origen);
				jdbcTemplate.update(DELETE_PRICING,processDate,origen);
				jdbcTemplate.update(DELETE_PROFIT,processDate,origen);
				jdbcTemplate.update(DELETE_SIDE,processDate,origen);
				jdbcTemplate.update(DELETE_TRANSACTION_INFO,processDate,origen);
				jdbcTemplate.update(DELETE_TRANSACTIONT,processDate,origen);
				
			}else{
				logger.debug("Rollback --> No Existia data");
			}

		}catch(Exception e){
//			logger.error("Error writing data = " + ctte.toString());
			logger.error(e);
			throw e;
		}
		
		return RepeatStatus.FINISHED;
	}
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
