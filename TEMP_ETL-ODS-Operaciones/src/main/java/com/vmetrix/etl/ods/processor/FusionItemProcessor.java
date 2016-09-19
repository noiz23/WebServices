package com.vmetrix.etl.ods.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vmetrix.etl.ods.model.OperacionesDTO;

public class FusionItemProcessor implements ItemProcessor<OperacionesDTO, OperacionesDTO> {
	
	private static final String GET_PRODUCT_ID = "select PRODUCT_ID from PRODUCT where PRODUCT_NAME = ?";
	private static final String GET_MAX_PRODUCT_ID = "select MAX(PRODUCT_ID) FROM PRODUCT";
	private static final String ADD_PRODUCT_ID = "insert into PRODUCT (PRODUCT_ID,PRODUCT_NAME) values (?,?)";
	
	
	private static final String GET_INSTRUMENT_ID = "select INSTRUMENT_ID from INSTRUMENT where INSTRUMENT_NAME = ?";
	private static final String GET_MAX_INSTRUMENT_ID = "select MAX(INSTRUMENT_ID) FROM INSTRUMENT";
	private static final String ADD_INSTRUMENT_ID = "insert into INSTRUMENT (INSTRUMENT_ID,PRODUCT_ID,INSTRUMENT_NAME) values (?,?,?)";
	
	private static final String GET_PORTFOLIO_ID = "select PORTFOLIO_ID from PORTFOLIO where PORTFOLIO_NAME = ?";
	private static final String GET_MAX_PORTFOLIO_ID = "select MAX(PORTFOLIO_ID) FROM PORTFOLIO";
	private static final String ADD_PORTFOLIO_ID = "insert into PORTFOLIO (PORTFOLIO_ID,PORTFOLIO_NAME) values (?,?)";
	
	private static final String GET_PARTY_ID = "select PARTY_ID from PARTY_TYPE where PARTY_TYPE_NAME = ?";
	private static final String GET_MAX_PARTY_ID = "select MAX(PARTY_TYPE_ID) FROM PARTY_TYPE";
	private static final String ADD_PARTY_ID = "insert into PARTY_TYPE (PARTY_TYPE_ID,PARTY_TYPE_NAME) values (?,?)";

	//----
	private static final String GET_FACILITY_ID = "select FACILITY_ID from FACILITY where FACILITY_NUMBER = ?";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public OperacionesDTO process(OperacionesDTO line) throws Exception {
	
		int facility_id = 0;
		
		//------------------------------------ start PRODUCT_ID:
		System.out.println("line.getProduct_name().toUpperCase() "+line.getProduct_name().toUpperCase());
		try {
			facility_id = jdbcTemplate.queryForObject(GET_FACILITY_ID, new Object[] { line.getFacility_number()}, Integer.class);
			
			//System.out.println("-----facility_id= ["+facility_id+"]");
			
			line.setFacility_id(facility_id);
			
			
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No existe registro en tabla FACILITY");
			line.setFacility_id(facility_id);
			
		} catch (Exception e) {
			System.out.println("facility_id="+facility_id);
			line.setFacility_id(facility_id);
			//e.printStackTrace();
			
		}
		
		return line;
	}

}
