package com.vmetrix.etl.ods.writer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.vmetrix.etl.ods.model.OperacionesDTO;
import com.vmetrix.obtain.process.date.ProcessDate;



public class OperacionesXMLItemWriter implements ItemWriter<OperacionesDTO>{
//	final static Logger logger = Logger.getLogger(OperacionesItemWriter.class);
	static Log logger = LogFactory.getLog(OperacionesXMLItemWriter.class);
			
	   private static final String INSERT_TRANSACTION = "INSERT INTO TRANSACTIONT (TRANSACTION_DEAL_NUM,TRANSACTION_PROCESS_DATE,INSTRUMENT_ID,PORTFOLIO_ID,PARTY_ID,FACILITY_ID,TRANSACTION_TRADE_DATE,TRANSACTION_START_DATE,TRANSACTION_END_DATE,TRANSACTION_ORIGEN,TRANSACTION_ET,TRANSACTION_MODALIDAD_PAGO,TRANSACTION_NEMO,TRANSACTION_SERIE,TRANSACTION_TIR_COMPRA,TRANSACTION_TIR_MERCADO,TRANSACTION_STRIKE,TRANSACTION_PARTY_SECUENCIA,TRANSACTION_PAYMENTCONV_ID,TRANSACTION_STATUS_ID,TRANSACTION_ID_GROUP,TRANSACTION_CALL_PUT_ID,TRANSACTION_OFFSET_TRAN_TYPE,TRANSACTION_TRADER_NAME,TRANSACTION_TRADER_ID,TRANSACTION_ET_NP) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_SIDE = "INSERT INTO SIDE VALUES  (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?)";
	   private static final String INSERT_INTEREST ="INSERT INTO INTEREST VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_CASHFLOW = "INSERT INTO CASHFLOW VALUES (? ,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_PROFIT = "INSERT INTO PROFIT VALUES (? ,? ,? ,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_EQUIVALENTE_CREDITO ="INSERT INTO EQUIVALENTE_CREDITO VALUES (?,? ,? ,? ,? ,? ,?,?)";
	   private static final String INSERT_TRANSACTION_INFO = "INSERT INTO TRANSACTION_INFO (CANAL_TRANSACCIONAL_ID,TRANSACTION_DEAL_NUM,TRANSACTION_PROCESS_DATE,MEDIO_TRANSACCIONAL_ID,TRANSACTION_INFO_TC_COSTO,TRANSACTION_INFO_TC_CLIENTE,TRANSACTION_INFO_PARIDAD_COSTO,TRANSACTION_INFO_PARIDAD_CLIENTE,TRANSACTION_INFO_SPREAD_TC,TRANSACTION_INFO_SPREAD_PARIDAD,TRANSACTION_INFO_FX_SPOT_CLIENTE,TRANSACTION_INFO_FX_FWD_COSTO,TRANSACTION_INFO_FX_FWD_CLIENTE,TRANSACTION_INFO_PUNTOS_FWD,TRANSACTION_INFO_FX_UF_SPOT,TRANSACTION_INFO_FX_UF_TASA_COSTO,TRANSACTION_INFO_FX_UF_TASA_MARGEN,TRANSACTION_INFO_FX_UF_TASA_CLIENTE,TRANSACTION_INFO_FX_SPOT_MARGEN,TRANSACTION_INFO_FX_FWD_MARGEN,TRANSACTION_INFO_FX_UF_TASA_SUCIA_COSTO,TRANSACTION_INFO_FX_UF_TASA_SUCIA_CLIENTE,TRANSACTION_ORIGEN,TRANSACTION_INFO_REFERENCE,TRANSACTION_INFO_NOMBRE_CLIENTE,TRANSACTION_INFO_ID_CLIENTE,TRANSACTION_INFO_INDICADOR_FX,TRANSACTION_INFO_OBSERVACIONES) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,?,? ,? ,? ,? ,? ,?,? ,? ,? ,? ,? ,?,?,?,?,?,?,?)";
	   private static final String INSERT_PRICING = "INSERT INTO PRICING VALUES (?,?,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?,?,?,?)";
//	   private static final String INSERT_PAYMENTCONVENTION = "INSERT INTO PAYMENTCONVENTION VALUES  (?,?,?,?)";
	   private static final String DELETE_CASHFLOW = "DELETE FROM CASHFLOW WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_EQUIVALENTE_CREDITO = "DELETE FROM EQUIVALENTE_CREDITO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_INTEREST = "DELETE FROM INTEREST WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
//		private static final String DELETE_PAYMENTCONVENTION = "DELETE FROM PAYMENTCONVENTION WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ?";
		private static final String DELETE_PRICING = "DELETE FROM PRICING WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_PROFIT = "DELETE FROM PROFIT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_SIDE = "DELETE FROM SIDE WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_TRANSACTION_INFO = "DELETE FROM TRANSACTION_INFO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		private static final String DELETE_TRANSACTIONT = "DELETE FROM TRANSACTIONT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=2";
		
	   private static  List<Long> cacheTransaction = new ArrayList<Long>();
	   private static List<String> cahceSide = new ArrayList<String>();
//	   private Date procesDate = null;
	   boolean clean = true;
	   
	    @Autowired
	    private JdbcTemplate jdbcTemplate;
	    
	    private static String typeFile="opt";
		
		
		private  Resource resource;

		public Resource getResource() {
			return resource;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}
		
		private String procesDate;
	public void write(List<? extends OperacionesDTO> data) throws Exception {

		procesDate = ProcessDate.getProcessDate(resource.getFilename(), typeFile);
		
		
//		logger.debug("----- > Call writer clean procesDate="+ procesDate);
		
		for(OperacionesDTO line : data){
			try{
				if(clean){
					logger.debug("Inicia clean para el dia de hoy "+procesDate+". TURING");
					logger.debug("----- > Call writer clean procesDate="+ procesDate);
					SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("cleanDB");
					Map<String, Object> inParamMap = new HashMap<String, Object>();
					inParamMap.put("origen", line.getOrigen_id());
					inParamMap.put("fecha", procesDate);
					SqlParameterSource in = new MapSqlParameterSource(inParamMap);
					Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
					logger.debug("Clean finalizado. ");
					logger.debug("Running.... ");
					
					clean=false;
				}
				
			
			StringBuffer side = new StringBuffer(1);
			StringBuffer findurTranNnum = new StringBuffer(1);
			
			findurTranNnum.append(line.getInstrument_id());
			findurTranNnum.append(line.getTransaction_deal_num());
			
			line.setTransaction_deal_num(Long.valueOf(findurTranNnum.toString()));

			
		
			if(!(cacheTransaction.contains(line.getTransaction_deal_num()))){
//--------Start insert TRANSACTIONT table
				jdbcTemplate.update( INSERT_TRANSACTION, line.getTransaction_deal_num(),procesDate, line.getInstrument_id(),line.getPortfolio_id(),line.getParty_id(),line.getFacility_id(),line.getTransaction_trade_date(),line.getTransaction_start_date(),line.getTransaction_end_date(), line.getOrigen_id(),line.getTransaction_ET(),line.getTransaction_modalidad_pago(),line.getTransaction_nemo(),line.getTransaction_serie(),line.getTransaction_TIR_compra(),line.getTransaction_TIR_mercado(),line.getTransaction_strike(),line.getTransaction_party_secuencia(),line.getTransaction_paymentconv_id(),line.getTransaction_status_id(),line.getTransaction_id_group(),line.getCall_put_id(),line.getTransaction_offset_tran_type(),line.getTransaction_trader_name(),line.getTransaction_trader_id(),line.getTransaction_ET_NP());
//--------End insert TRANSACTIONT table					
//----------Star insert TRANSACTION_INFO table
				jdbcTemplate.update( INSERT_TRANSACTION_INFO,line.getCanal_transaccional_id(),line.getTransaction_deal_num(),procesDate,line.getMedio_transaccional_id(),line.getTransaction_info_tc_costo(),line.getTransaction_info_tc_cliente(),line.getTransaction_info_paridad_costo(),line.getTransaction_info_paridad_cliente(),line.getTransaction_info_spread_tc(),line.getTransaction_info_spread_paridad(),line.getTransaction_info_fx_spot_cliente(),line.getTransaction_info_fx_fwd_costo(),line.getTransaction_info_fx_fwd_cliente(),line.getTransaction_info_puntos_fwd(),line.getTransaction_info_fx_uf_spot(),line.getTransaction_info_fx_uf_tasa_costo(),line.getTransaction_info_fx_uf_tasa_margen(),line.getTransaction_info_fx_uf_tasa_cliente(),line.getTransaction_info_fx_spot_margen(),line.getTransaction_info_fx_fwd_margen(),line.getTransaction_info_fx_uf_tasa_sucia_costo(),line.getTransaction_info_fx_uf_tasa_sucia_cliente(),line.getOrigen_id(),line.getTransaction_info_reference(),line.getTransaction_info_nombre_cliente(),line.getTransaction_info_id_cliente(),line.getTransaction_info_indicador_fx(),line.getTransaction_info_observaciones());
//----------End insert TRANSACTION_INFO table	
				
//----------Star insert PAYMENTCONVENTION table
				//jdbcTemplate.update( INSERT_PAYMENTCONVENTION,line.getPaymentconv_id(),line.getTransaction_deal_num(),procesDate,line.getPaymentconv_name());
//----------End insert PAYMENTCONVENTION table	
				
//----------Start insert EQUIVALENTE_CREDITO table
				jdbcTemplate.update( INSERT_EQUIVALENTE_CREDITO,line.getTransaction_deal_num(),procesDate,line.getEquivalente_credito_corporativo(),line.getEquivalente_credito_normativo(),line.getEquivalente_credito_factor(),line.getEquivalente_credito_factor_inter(),line.getEquivalente_credito_factor_normativo(),line.getOrigen_id());
//----------End insert EQUIVALENTE_CREDITO table
				
//----------Start insert PROFIT table
				jdbcTemplate.update( INSERT_PROFIT,line.getSide_notional_ccy_id(),line.getTransaction_deal_num(),procesDate,line.getProfit_value(),line.getProfit_ccy_id(),line.getProfit_mesa_clientes_clp(),line.getProfit_mesa_trading_clp(),line.getProfit_mesa_clientes_USD(),line.getProfit_mesa_trading_USD(),line.getProfit_total_USD(),line.getProfit_total_CLP(),line.getOrigen_id());
//----------End insert PROFIT table					
				cacheTransaction.add(line.getTransaction_deal_num());
			}

			//------------Start insert SIDE table
				side.append(line.getSide_id());
				side.append(line.getTransaction_deal_num());
			if(!(cahceSide.contains(side.toString()))){
				jdbcTemplate.update( INSERT_SIDE, line.getSide_id(),line.getSide_notional_ccy_id(),line.getRate_type_id(),line.getTransaction_deal_num(),procesDate,line.getYield_basis_id(),line.getSide_payment_ccy_id(),line.getSide_type(),line.getSide_notional(),line.getSide_rate(),line.getSide_rate_spread(),line.getSide_frec_p(),line.getSide_reset_p(),line.getSide_fix_flt(),line.getSide_projection_index(),line.getOrigen_id());
				//----------Star insert PRICING table
				jdbcTemplate.update( INSERT_PRICING,line.getTransaction_deal_num(),procesDate,line.getSide_id(),line.getPricing_mtm(),line.getPricing_mtm_ccy_id(),line.getPricing_base_mtm(),line.getPricing_base_mtm_USD(),line.getPricing_delta(),line.getPricing_gamma(),line.getPricing_vega(),line.getPricing_beta(),line.getPricing_rho_local(),line.getPricing_rho_foranea(),line.getPricing_theta(),line.getPricing_volga(),line.getPricing_pnl(),line.getPricing_unrealized_pnl(),line.getPricing_pnl_fx_unrealized(),line.getPricing_current_cash(),line.getOrigen_id(),line.getPricing_base_unrealized_pnl());
				//----------End insert PRICING table				
				
				cahceSide.add(side.toString());
			}
			//------------End insert SIDE table	
			
	
//---------INTEREST
			if(line.getInstrument_id()==1000001 || line.getInstrument_id()==1000002 || line.getInstrument_id()==1000003 || line.getInstrument_id()==1000004 || line.getInstrument_id()==1000005){
				line.setInterest_id(1);
				line.setInterest_start_date(line.getTransaction_start_date());
				line.setInterest_end_date(line.getTransaction_end_date());
				line.setInterest_accounting_date(line.getTransaction_end_date());
				line.setInterest_payment(line.getSide_notional());
				
			}
			
			if(line.getInterest_id()!=0){
					jdbcTemplate.update( INSERT_INTEREST, line.getInterest_id(),line.getTransaction_deal_num(),procesDate,line.getSide_id(),line.getInterest_start_date(),line.getInterest_end_date(),line.getInterest_payment_date(),line.getInterest_fixing_date(),line.getInterest_accounting_date(),line.getInterest_rate(),line.getInterest_payment(),line.getInterest_npv(),line.getInterest_fixing_rate(),line.getInterest_df(),line.getOrigen_id());
					}
//-----------INTEREST			
						
//-----------Start insert CASHFLOW table:
			if(line.getInstrument_id()==1000001 || line.getInstrument_id()==1000002 || line.getInstrument_id()==1000003 || line.getInstrument_id()==1000004 || line.getInstrument_id()==1000005){
				line.setCashflow_id(1);
				line.setCashflow_start_date(line.getTransaction_start_date());
				line.setCashflow_end_date(line.getTransaction_end_date());
				line.setCashflow_accounting_date(line.getTransaction_end_date());
				line.setCashflow_amount(line.getSide_notional());
			}
			
				if(line.getCashflow_id()!=0){
					jdbcTemplate.update( INSERT_CASHFLOW, line.getCashflow_id(),line.getCashflowtype_id(),line.getTransaction_deal_num(),procesDate,line.getSide_id(),line.getCashflow_start_date(),line.getCashflow_end_date(),line.getCashflow_accounting_date(),line.getCashflow_fixing_date(),line.getCashflow_amount(),line.getCashflow_npv(),line.getCashflow_fixing_rate(),line.getCashflow_df(),line.getOrigen_id());
					
				}
//-----------End insert CASHFLOW table

				
			}catch(Exception e){
				logger.debug("Inicio de ejecucion  Rollback de registros TURING para la fecha "+procesDate);
				rollBack(procesDate);
				logger.debug("Fin de ejecucion  Rollback de registros TURING para la fecha "+procesDate);
				logger.error("Error writing data = " + line.toString());
				logger.error(e);
				throw e;
			}
	
		}
		
		
		
	}
	
	
	public void rollBack(String processDate){
		jdbcTemplate.update(DELETE_CASHFLOW, processDate);
		jdbcTemplate.update(DELETE_EQUIVALENTE_CREDITO,processDate);
		jdbcTemplate.update(DELETE_INTEREST,processDate);
		jdbcTemplate.update(DELETE_PRICING,processDate);
		jdbcTemplate.update(DELETE_PROFIT,processDate);
		jdbcTemplate.update(DELETE_SIDE,processDate);
		jdbcTemplate.update(DELETE_TRANSACTION_INFO,processDate);
		jdbcTemplate.update(DELETE_TRANSACTIONT,processDate);
		
	}

}
