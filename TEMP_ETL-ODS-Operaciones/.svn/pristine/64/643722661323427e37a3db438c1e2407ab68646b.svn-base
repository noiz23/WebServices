package com.vmetrix.etl.ods.scheduler;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.vmetrix.etl.ods.util.OperacionesProperties;
import com.vmetrix.file.FileUtil;
import com.vmetrix.obtain.process.date.ProcessDate;

@Component
public class SchedulerClass {

	private static final String PROCESAR_TURING = "SI";
	private static final String FUSION_PROPERTIES = "fusionProperties";
	static Log logger = null;
	private static final String ERROR = "ERROR";
	private static final String CSV_FILE = ".csv";
	private static final String XML_FILE = ".xml";
	private static final String OPERACIONES_FINDUR = "vigente_findur";
	private static final String OPERACIONES_TURINGB = "vigente_turing-bac";
	private static final String MENSAJE_REPROCESO1="Ya se ha procesado el archivo ";
	private static final String MENSAJE_REPROCESO2=". Para reprocesarlo, renombre el archivo agregando la hora (_hhmm) despues de la fecha.";
	private static final String INSERT_PROCESOS = "INSERT INTO [dbo].[PROCESOS]  ([PROCESO] ,[FECHA_INICIO] ,[FECHA_TERMINO] ,[ESTADO] ,[ARCHIVO_PROCESADO] ,[ORIGEN] ,[COMENTARIO])   VALUES (?,?,?,?,?,?,?)";
	private static final String ORIGENF = "Findur";
	private static final String ORIGENT = "Turing";
	private static final String IGNORADO = "Ignorado";
	private static final String PROCESO = "Operaciones";
	private static final String COMENTARIO = "Fechas de nombre de archivo y de sistema no son iguales.";
	private static String validaProcesDate;
	private static Timestamp fechaInicio,fechaTermino;
	private static String typeFileF="opf";
	private static String typeFileT="opt";
	private Date date;
	private static int readedFileF, readedFileT;
	
	
	private static String FOLDER_FILES=null;
	private static String procesaTuring="";
	
	private static final String SELECT_TRANSACTIONT ="select cast(MAX(TRANSACTION_PROCESS_DATE) as varchar(10)) from TRANSACTIONT";

	private JobExecution execution;

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private Job job;
	
	static String[] springConfig  = 
		{	"applicationContext.xml",
			"jobs/file-import-job.xml" 
		};
	static ApplicationContext context =new ClassPathXmlApplicationContext(springConfig);

	
	public void run() throws Exception{
		logger = LogFactory.getLog(SchedulerClass.class);
		
		readedFileT=0;
		readedFileF=0;
		
		logger.debug("------------ Calling Run Operaciones");
		//context = new ClassPathXmlApplicationContext(springConfig);
		OperacionesProperties properties;
		File f;
		List<String> csvOperaciones;
		List<String> xml;
		File[] ficheros;
		JobParametersBuilder jpBuilder;
		String nombreArch = "";

		try {
			properties = (OperacionesProperties) context.getBean(FUSION_PROPERTIES);
			FOLDER_FILES=properties.getFile_repository();
			procesaTuring=properties.getProcesaTuring();
			validaProcesDate = properties.getValidaPdate();
			
			logger.debug("Se procesaran archivos XML (Turing)? = "+ procesaTuring);
			
			f = new File(FOLDER_FILES);
			csvOperaciones = new ArrayList<String>();
			xml = new ArrayList<String>();
			if (f.exists()){
				
				ficheros = f.listFiles();
				for (int x = 0; x < ficheros.length; x++) {
					if(ficheros[x].getName().toLowerCase().contains(OPERACIONES_FINDUR) && ficheros[x].getName().toLowerCase().contains(CSV_FILE)&& !((ficheros[x].getName().contains(ERROR)) || (ficheros[x].getName().contains(IGNORADO.toUpperCase())))){
						csvOperaciones.add(ficheros[x].getCanonicalPath());
					} else if (ficheros[x].getName().toLowerCase().contains(OPERACIONES_TURINGB)&& ficheros[x].getName().toLowerCase().contains(XML_FILE) && !((ficheros[x].getName().contains(ERROR)) || (ficheros[x].getName().contains(IGNORADO.toUpperCase())))) {
						xml.add(ficheros[x].getCanonicalPath());
					}
				}
			}else {
				logger.error("------------ No esxite el directorio"+FOLDER_FILES);
				
			}
			
			if(csvOperaciones.size()>0){
				
				for(String name : csvOperaciones){
					jobLauncher = (JobLauncher) context.getBean("jobLauncher");
					job = (Job) context.getBean("operacionesJob");//simpleFileImportJobPartyTable
					jpBuilder = new   JobParametersBuilder().addString("input.file.name", name);
					nombreArch = name;
					logger.debug("Se debe validar el process date? = "+ (Integer.valueOf(validaProcesDate)==1?"Si":"No"));
					if(Integer.valueOf(validaProcesDate)==1){
						if(ProcessDate.validaPD(name,typeFileF)){
							execution = jobLauncher.run(job, jpBuilder.toJobParameters());
							++readedFileF;
					}else{
							//Las fechas de sistema y archivo  no son iguales. Se registra en tabla PROCESOS
							
							if (jdbcTemplate==null)
								jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
							
							date=new Date();
							fechaInicio = new Timestamp(date.getTime());
							fechaTermino = fechaInicio;
							File tem = new File(name);
							logger.debug("Fechas de nombre de archivo y de sistema no son iguales. ");
							logger.debug("Se ignora procesamiento de archivo "+tem.getName());
							FileUtil.renameFile(tem, IGNORADO.toUpperCase());
							
							jdbcTemplate.update(INSERT_PROCESOS,PROCESO,fechaInicio,fechaTermino,IGNORADO,tem.getName(),ORIGENF,COMENTARIO);
						}
						
					}else{
						execution = jobLauncher.run(job, jpBuilder.toJobParameters());
						++readedFileF;
					}
					
				}
			}
			
			if(procesaTuring.equalsIgnoreCase(PROCESAR_TURING)){

				if(xml.size()>0){
					
					for(String name : xml){
						jobLauncher = (JobLauncher) context.getBean("jobLauncher");
						jpBuilder = new   JobParametersBuilder().addString("input.file.name", name);
						nombreArch = name;
						job = (Job) context.getBean("simpleFileImportJob2");
						logger.debug("Se debe validar el process date? = "+ (Integer.valueOf(validaProcesDate)==1?"Si":"No"));
						if(Integer.valueOf(validaProcesDate)==1){
							if(ProcessDate.validaPD(name,typeFileT)){
								execution = jobLauncher.run(job, jpBuilder.toJobParameters());
								++readedFileT;
							}
							else{
								//Las fechas de sistema y archivo  no son iguales. Se registra en tabla PROCESOS
								
								if (jdbcTemplate==null)
									jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
								
								date=new Date();
								fechaInicio = new Timestamp(date.getTime());
								fechaTermino = fechaInicio;
								File tem = new File(name);
								logger.debug("Fechas de nombre de archivo y de sistema no son iguales. ");
								logger.debug("Se ignora procesamiento de archivo "+tem.getName());
								FileUtil.renameFile(tem, IGNORADO.toUpperCase());
								
								jdbcTemplate.update(INSERT_PROCESOS,PROCESO,fechaInicio,fechaTermino,IGNORADO,tem.getName(),ORIGENT,COMENTARIO);
							}
							
						}else{
							execution = jobLauncher.run(job, jpBuilder.toJobParameters());
							++readedFileT;
						}
							
					}
				}
			}
			
			if(readedFileT>0 || readedFileF>0){
				//Execute Procedures
				jobLauncher = (JobLauncher) context.getBean("jobLauncher");
				job = (Job) context.getBean("deleteCallProcedureFile");
				execution = jobLauncher.run(job, new JobParameters());
				
			}
			

		
		} catch (JobExecutionAlreadyRunningException e) {
			logger.debug("-----> Running....");
//			e.printStackTrace();
		} catch (JobRestartException e) {	
			logger.warn("-----> JobRestartException ",e);
//			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.warn(e.getMessage());
//			logger.warn(MENSAJE_REPROCESO1 + nombreArch + MENSAJE_REPROCESO2);
			throw new Exception(MENSAJE_REPROCESO1 + nombreArch + MENSAJE_REPROCESO2);
		} catch (JobParametersInvalidException e) {	
			logger.warn("-----> JobParametersInvalidException ",e);
//			e.printStackTrace();
		} catch (IOException e) {
			logger.error("-----> IOException ",e);
			throw e;
		} catch (DuplicateKeyException e) {
			logger.debug("-----> Running.......");
		}catch (Exception e) {
			logger.error("-----> Exception ",e);
			throw e;
		}finally {
			if(execution!=null)
			execution.stop();
			job=null;
			properties=null;
			f=null;
			csvOperaciones=null;
			xml=null;
			ficheros=null;
			jobLauncher=null;
			jpBuilder=null;
			logger=null;
			
		}
	}
	

}