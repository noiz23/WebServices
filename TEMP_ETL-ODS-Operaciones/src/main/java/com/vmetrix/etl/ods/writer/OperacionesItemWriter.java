package com.vmetrix.etl.ods.writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.vmetrix.xml.operation.model.CashFlowType;
import cl.vmetrix.xml.operation.model.EquivalenteCreditoType;
import cl.vmetrix.xml.operation.model.InterestType;
import cl.vmetrix.xml.operation.model.OperationType;
import cl.vmetrix.xml.operation.model.PricingType;
import cl.vmetrix.xml.operation.model.ProfitType;
import cl.vmetrix.xml.operation.model.SideType;
import cl.vmetrix.xml.operation.model.TransactionInfoType;
import cl.vmetrix.xml.operation.model.TransactionType;

import com.vmetrix.etl.ods.model.OperacionesDTO;



public class OperacionesItemWriter implements ItemWriter<OperacionesDTO>{
//	final static Logger logger = Logger.getLogger(OperacionesItemWriter.class);
	static Log logger = LogFactory.getLog(OperacionesItemWriter.class);
	

			
	   private static final String INSERT_TRANSACTION = "INSERT INTO TRANSACTIONT (TRANSACTION_DEAL_NUM,TRANSACTION_PROCESS_DATE,INSTRUMENT_ID,PORTFOLIO_ID,PARTY_ID,FACILITY_ID,TRANSACTION_TRADE_DATE,TRANSACTION_START_DATE,TRANSACTION_END_DATE,TRANSACTION_ORIGEN,TRANSACTION_ET,TRANSACTION_MODALIDAD_PAGO,TRANSACTION_NEMO,TRANSACTION_SERIE,TRANSACTION_TIR_COMPRA,TRANSACTION_TIR_MERCADO,TRANSACTION_STRIKE,TRANSACTION_PARTY_SECUENCIA,TRANSACTION_PAYMENTCONV_ID,TRANSACTION_STATUS_ID,TRANSACTION_ID_GROUP,TRANSACTION_CALL_PUT_ID,TRANSACTION_OFFSET_TRAN_TYPE,TRANSACTION_TRADER_NAME,TRANSACTION_TRADER_ID,TRANSACTION_ET_NP) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_SIDE = "INSERT INTO SIDE VALUES  (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?)";
	   private static final String INSERT_INTEREST ="INSERT INTO INTEREST VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_CASHFLOW = "INSERT INTO CASHFLOW VALUES (? ,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_PROFIT = "INSERT INTO PROFIT VALUES (? ,? ,? ,?,?,?,?,?,?,?,?,?)";
	   private static final String INSERT_EQUIVALENTE_CREDITO ="INSERT INTO EQUIVALENTE_CREDITO VALUES (?,? ,? ,? ,? ,? ,?,?)";
	   private static final String INSERT_TRANSACTION_INFO = "INSERT INTO TRANSACTION_INFO (CANAL_TRANSACCIONAL_ID,TRANSACTION_DEAL_NUM,TRANSACTION_PROCESS_DATE,MEDIO_TRANSACCIONAL_ID,TRANSACTION_INFO_TC_COSTO,TRANSACTION_INFO_TC_CLIENTE,TRANSACTION_INFO_PARIDAD_COSTO,TRANSACTION_INFO_PARIDAD_CLIENTE,TRANSACTION_INFO_SPREAD_TC,TRANSACTION_INFO_SPREAD_PARIDAD,TRANSACTION_INFO_FX_SPOT_CLIENTE,TRANSACTION_INFO_FX_FWD_COSTO,TRANSACTION_INFO_FX_FWD_CLIENTE,TRANSACTION_INFO_PUNTOS_FWD,TRANSACTION_INFO_FX_UF_SPOT,TRANSACTION_INFO_FX_UF_TASA_COSTO,TRANSACTION_INFO_FX_UF_TASA_MARGEN,TRANSACTION_INFO_FX_UF_TASA_CLIENTE,TRANSACTION_INFO_FX_SPOT_MARGEN,TRANSACTION_INFO_FX_FWD_MARGEN,TRANSACTION_INFO_FX_UF_TASA_SUCIA_COSTO,TRANSACTION_INFO_FX_UF_TASA_SUCIA_CLIENTE,TRANSACTION_ORIGEN,TRANSACTION_INFO_REFERENCE,TRANSACTION_INFO_NOMBRE_CLIENTE,TRANSACTION_INFO_ID_CLIENTE,TRANSACTION_INFO_INDICADOR_FX,TRANSACTION_INFO_OBSERVACIONES) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,?,? ,? ,? ,? ,? ,?,? ,? ,? ,? ,? ,?,?,?,?,?,?,?)";
	   private static final String INSERT_PRICING = "INSERT INTO PRICING VALUES (?,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?,?,?,?,?)";
//	   private static final String INSERT_PAYMENTCONVENTION = "INSERT INTO PAYMENTCONVENTION VALUES  (?,?,?,?)";
	   
		private static final String DELETE_CASHFLOW = "DELETE FROM CASHFLOW WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_EQUIVALENTE_CREDITO = "DELETE FROM EQUIVALENTE_CREDITO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_INTEREST = "DELETE FROM INTEREST WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
//		private static final String DELETE_PAYMENTCONVENTION = "DELETE FROM PAYMENTCONVENTION WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ?";
		private static final String DELETE_PRICING = "DELETE FROM PRICING WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_PROFIT = "DELETE FROM PROFIT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_SIDE = "DELETE FROM SIDE WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_TRANSACTION_INFO = "DELETE FROM TRANSACTION_INFO WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		private static final String DELETE_TRANSACTIONT = "DELETE FROM TRANSACTIONT WHERE CAST(TRANSACTION_PROCESS_DATE AS DATE) = ? AND TRANSACTION_ORIGEN=1";
		
	   private static  List<Long> cacheTransaction = new ArrayList<Long>();
	   private static List<String> cahceSide = new ArrayList<String>();

	   static boolean clean = true;
	   
	   private static String typeFile="opf";
		
		
		private  Resource resource;

		public Resource getResource() {
			return resource;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}
	   
		private String processDate;
	    @Autowired
	    private JdbcTemplate jdbcTemplate;
	public void write(List<? extends OperacionesDTO> data) throws Exception {
		
		
		
		TransactionType transaction;
		TransactionInfoType transactionInfo;
		EquivalenteCreditoType eqCred;
		ProfitType profit;
		
		SideType sideData;
		PricingType pricing;
		
		InterestType interest;
		
		CashFlowType cashflow;
		
		OperationType opt = new OperationType();
		
		
		
		
		
		for(OperacionesDTO line : data){
				
			if(!(cacheTransaction.contains(line.getTransaction_deal_num()))){
				transaction = new TransactionType();
				transactionInfo = new TransactionInfoType();
				eqCred = new EquivalenteCreditoType();
				profit = new ProfitType();
				//Data TRANSACTION table
				transaction.setCallPutId(line.getCall_put_id());
				transaction.setEndDate(line.getTransaction_end_date());
				transaction.setEt(line.getTransaction_ET());
				transaction.setEtNp(line.getTransaction_ET_NP());
				transaction.setFacilityId(line.getFacility_id());
				transaction.setGroupId(line.getTransaction_id_group());
				transaction.setInstrumentId(line.getInstrument_id());
				transaction.setModalidadPago(line.getTransaction_modalidad_pago());
				transaction.setNemo(line.getTransaction_nemo());
				transaction.setOffsetTranType(line.getTransaction_offset_tran_type());
				transaction.setPartyId(line.getParty_id());
				transaction.setPartySecuencia(line.getTransaction_party_secuencia());
				transaction.setPaymentConvId(line.getTransaction_paymentconv_id());
				transaction.setPortFolio(line.getPortfolio_id());
				transaction.setSerie(line.getTransaction_serie());
				transaction.setStartDate(line.getTransaction_start_date());
				transaction.setStatusId(line.getTransaction_status_id());
				transaction.setStrike(line.getTransaction_strike());
				transaction.setTirCompra(line.getTransaction_TIR_compra());
				transaction.setTirMercado(line.getTransaction_TIR_mercado());
				transaction.setTradeDate(line.getTransaction_trade_date());
				transaction.setTraderId(line.getTransaction_trader_id());
				transaction.setTraderName(line.getTransaction_trader_name());
//				transaction.setDealNum(line.getTransaction_deal_num());
//				transaction.setOrigin(line.getOrigen_id());
//				transaction.setProcessDate(line.getProcessDate());
				
				opt.setTransaction(transaction);
				
				
				//Data TRANSACTION_INFO table
				transactionInfo.setCanalTransaccionalId(line.getCanal_transaccional_id());
				transactionInfo.setFxForwardCliente(line.getTransaction_info_fx_fwd_cliente());
				transactionInfo.setFxForwardCosto(line.getTransaction_info_fx_fwd_costo());
				transactionInfo.setFxFwdMargen(line.getTransaction_info_fx_fwd_margen());
				transactionInfo.setFxSpotCliente(line.getTransaction_info_fx_spot_cliente());
				transactionInfo.setFxSpotMargen(line.getTransaction_info_fx_spot_margen());
				transactionInfo.setFxUfSpot(line.getTransaction_info_fx_uf_spot());
				transactionInfo.setFxUfTasaCliente(line.getTransaction_info_fx_uf_tasa_cliente());
				transactionInfo.setFxUfTasaCosto(line.getTransaction_info_fx_uf_tasa_costo());
				transactionInfo.setFxUfTasaMargen(line.getTransaction_info_fx_uf_tasa_margen());
				transactionInfo.setFxUfTasaSuciaCliente(line.getTransaction_info_fx_uf_tasa_sucia_cliente());
				transactionInfo.setFxUfTasaSuciaCosto(line.getTransaction_info_fx_uf_tasa_sucia_costo());
				transactionInfo.setIdCliente(line.getTransaction_info_id_cliente());
				transactionInfo.setIndicadorFx(line.getTransaction_info_indicador_fx());
				transactionInfo.setNombreCliente(line.getTransaction_info_nombre_cliente());
				transactionInfo.setObservaciones(line.getTransaction_info_observaciones());
				transactionInfo.setParidadCliente(line.getTransaction_info_paridad_cliente());
				transactionInfo.setParidadCosto(line.getTransaction_info_paridad_costo());
				transactionInfo.setPuntosFwd(line.getTransaction_info_puntos_fwd());
				transactionInfo.setReference(line.getTransaction_info_reference());
				transactionInfo.setSpreadParidad(line.getTransaction_info_spread_paridad());
				transactionInfo.setSpreadTc(line.getTransaction_info_spread_tc());
				transactionInfo.setTcCosto(line.getTransaction_info_tc_costo());
				transactionInfo.setTcCliente(line.getTransaction_info_tc_cliente());
				transactionInfo.setMedioTransactionalID(line.getMedio_transaccional_id());
				
//				transactionInfo.setDealNum(line.getTransaction_deal_num());
//				transactionInfo.setOrigin(line.getOrigen_id());
//				transactionInfo.setProcessDate(line.getProcessDate());
				
				opt.setTransactionInfo(transactionInfo);
				
				//Data EQUIVALENTE_CREDITO table
				eqCred.setCreditoCorporativo(line.getEquivalente_credito_corporativo());
				eqCred.setCreditoFactor(line.getEquivalente_credito_factor());
				eqCred.setCreditoFactorInterno(line.getEquivalente_credito_factor_inter());
				eqCred.setCreditoFactorNormativo(line.getEquivalente_credito_factor_normativo());
				eqCred.setCreditoNormativo(line.getEquivalente_credito_normativo());
//				eqCred.setDealNum(line.getTransaction_deal_num());
//				eqCred.setOrigin(line.getOrigen_id());
//				eqCred.setProcessDate(line.getProcessDate());				
				
				opt.setEquivalenteCredito(eqCred);
				
				//Data PROFIT table
				profit.setCcy(line.getSide_notional_ccy_id());
				profit.setCurrencyId(line.getProfit_ccy_id());
				profit.setMesaClientesCLP(line.getProfit_mesa_clientes_clp());
				profit.setMesaClientesUsd(line.getProfit_mesa_clientes_USD());
				profit.setMesaTradingClp(line.getProfit_mesa_trading_clp());
				profit.setMesaTradingUsd(line.getProfit_mesa_trading_USD());
				profit.setTotalClp(line.getProfit_total_CLP());
				profit.setTotalUsd(line.getProfit_total_USD());
				profit.setValue(Double.valueOf(line.getProfit_value()));
//				profit.setDealNum(line.getTransaction_deal_num());
//				profit.setOrigin(line.getOrigen_id());
//				profit.setProcessDate(line.getProcessDate());				
				
				opt.setProfit(profit);
				
				cacheTransaction.add(line.getTransaction_deal_num());
			}
			
			StringBuffer side = new StringBuffer();
			
			if(!(cahceSide.contains(side.toString()))){
				sideData = new SideType();
				pricing = new PricingType();
				//Data SIDE table
				
				sideData.setCurCurrencyId(line.getSide_payment_ccy_id());
				sideData.setCurrencyId(line.getSide_notional_ccy_id());
				sideData.setFixFlt(line.getSide_fix_flt());
				sideData.setFrecPago(Double.valueOf(line.getSide_frec_p()));
				sideData.setNotional(line.getSide_notional());
				sideData.setProjectionIndex(line.getSide_projection_index());
				sideData.setRate(line.getSide_rate());
				sideData.setRateSpread(line.getSide_rate_spread());
				sideData.setRateTypeId(line.getRate_type_id());
				sideData.setResetP(Double.valueOf(line.getSide_reset_p()));
				sideData.setSideId(line.getSide_id());
				sideData.setType(String.valueOf(line.getSide_type()));
				sideData.setYieldBasisId(line.getYield_basis_id());
				
//				sideData.setDealNum(line.getTransaction_deal_num());
//				sideData.setOrigin(line.getOrigen_id());
//				sideData.setProcessDate(line.getProcessDate());	
				
				//Data PRICING table
				pricing.setBaseMtm(Double.valueOf(line.getPricing_base_mtm()));
				pricing.setBaseMtmUsd(line.getPricing_base_mtm_USD());
				pricing.setBaseUnrealizedPnl(line.getPricing_unrealized_pnl());
				pricing.setBeta(line.getPricing_beta());
				pricing.setCurrentCash(line.getPricing_current_cash());
				pricing.setDelta(line.getPricing_delta());
				pricing.setGamma(line.getPricing_gamma());
				pricing.setMtm(Double.valueOf(line.getPricing_mtm()));
				pricing.setMtmCcy(line.getPricing_mtm_ccy_id());
				pricing.setPnl(line.getPricing_pnl());
				pricing.setPnlFxUnrealized(line.getPricing_pnl_fx_unrealized());
				pricing.setRhoForanea(line.getPricing_rho_foranea());
				pricing.setRhoLocal(line.getPricing_rho_local());
				pricing.setSideId(line.getSide_id());
				pricing.setTheta(line.getPricing_theta());
				pricing.setUnrealizedPnl(line.getPricing_base_unrealized_pnl());
				pricing.setVega(line.getPricing_vega());
				pricing.setVolga(line.getPricing_volga());
//				pricing.setDealNum(line.getTransaction_deal_num());
//				pricing.setOrigin(line.getOrigen_id());
//				pricing.setProcessDate(line.getProcessDate());	
//				
				cahceSide.add(side.toString());
				
				opt.getSide().add(sideData);
				opt.getPricing().add(pricing);
				
			}
			
			if(line.getInterest_id()!=0){
				//Data INTEREST table
				interest = new InterestType();
				
				interest.setAccountingDate(line.getInterest_accounting_date());
				interest.setDf(line.getInterest_df());
				interest.setEndDate(line.getInterest_end_date());
				interest.setFixingDate(line.getInterest_fixing_date());
				interest.setFixingRate(line.getInterest_fixing_rate());
				interest.setInterestId(line.getInterest_id());
				interest.setNpv(line.getInterest_npv());
				interest.setPayment(line.getInterest_payment());
				interest.setPaymentDate(line.getInterest_payment_date());
				interest.setRate(line.getInterest_rate());
				interest.setSideId(line.getSide_id());
				interest.setStartDate(line.getInterest_start_date());
//				interest.setDealNum(line.getTransaction_deal_num());
//				interest.setOrigin(line.getOrigen_id());
//				interest.setProcessDate(line.getProcessDate());
				
				opt.getInterest().add(interest);
				
			}
			
			if(line.getCashflow_id()!=0){
				
				//Data CASHFLOW table
				cashflow = new CashFlowType();
				
				cashflow.setAccountingDate(line.getCashflow_accounting_date());
				cashflow.setAmount(line.getCashflow_amount());
				cashflow.setCashFlowId(line.getCashflow_id());
				cashflow.setCashFlowTypeId(line.getCashflowtype_id());
				cashflow.setDf(line.getCashflow_df());
				cashflow.setEndDate(line.getCashflow_end_date());
				cashflow.setFixingDate(line.getCashflow_fixing_date());
				cashflow.setFixingRate(line.getCashflow_fixing_rate());
				cashflow.setNpv(line.getCashflow_npv());
				cashflow.setSideId(line.getSide_id());
				cashflow.setStartDate(line.getCashflow_start_date());
//				cashflow.setDealNum(line.getTransaction_deal_num());
//				cashflow.setOrigin(line.getOrigen_id());
//				cashflow.setProcessDate(line.getProcessDate());
				
				
				
				opt.getCashFlow().add(cashflow);
				
						
				
			}
			
			
			if(opt.getProcessDate()==null){
				opt.setDealNum(line.getTransaction_deal_num());
				opt.setOrigin(line.getOrigen_id());
				opt.setProcessDate(line.getProcessDate());
			}
			
			/*
			try{
								
			
			StringBuffer side = new StringBuffer();

		
			if(!(cacheTransaction.contains(line.getTransaction_deal_num()))){
//--------Start insert TRANSACTIONT table
				jdbcTemplate.update( INSERT_TRANSACTION, line.getTransaction_deal_num(),line.getProcessDate(), line.getInstrument_id(),line.getPortfolio_id(),line.getParty_id(),line.getFacility_id(),line.getTransaction_trade_date(),line.getTransaction_start_date(),line.getTransaction_end_date(), line.getOrigen_id(),line.getTransaction_ET(),line.getTransaction_modalidad_pago(),line.getTransaction_nemo(),line.getTransaction_serie(),line.getTransaction_TIR_compra(),line.getTransaction_TIR_mercado(),line.getTransaction_strike(),line.getTransaction_party_secuencia(),line.getTransaction_paymentconv_id(),line.getTransaction_status_id(),line.getTransaction_id_group(),line.getCall_put_id(),line.getTransaction_offset_tran_type(),line.getTransaction_trader_name(),line.getTransaction_trader_id(),line.getTransaction_ET_NP());
//--------End insert TRANSACTIONT table					
//----------Star insert TRANSACTION_INFO table
				jdbcTemplate.update( INSERT_TRANSACTION_INFO,line.getCanal_transaccional_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getMedio_transaccional_id(),line.getTransaction_info_tc_costo(),line.getTransaction_info_tc_cliente(),line.getTransaction_info_paridad_costo(),line.getTransaction_info_paridad_cliente(),line.getTransaction_info_spread_tc(),line.getTransaction_info_spread_paridad(),line.getTransaction_info_fx_spot_cliente(),line.getTransaction_info_fx_fwd_costo(),line.getTransaction_info_fx_fwd_cliente(),line.getTransaction_info_puntos_fwd(),line.getTransaction_info_fx_uf_spot(),line.getTransaction_info_fx_uf_tasa_costo(),line.getTransaction_info_fx_uf_tasa_margen(),line.getTransaction_info_fx_uf_tasa_cliente(),line.getTransaction_info_fx_spot_margen(),line.getTransaction_info_fx_fwd_margen(),line.getTransaction_info_fx_uf_tasa_sucia_costo(),line.getTransaction_info_fx_uf_tasa_sucia_cliente(),line.getOrigen_id(),line.getTransaction_info_reference(),line.getTransaction_info_nombre_cliente(),line.getTransaction_info_id_cliente(),line.getTransaction_info_indicador_fx(),line.getTransaction_info_observaciones());
//----------End insert TRANSACTION_INFO table	
				
//----------Star insert PAYMENTCONVENTION table
				//jdbcTemplate.update( INSERT_PAYMENTCONVENTION,line.getPaymentconv_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getPaymentconv_name());
//----------End insert PAYMENTCONVENTION table	
				
//----------Start insert EQUIVALENTE_CREDITO table
				jdbcTemplate.update( INSERT_EQUIVALENTE_CREDITO,line.getTransaction_deal_num(),line.getProcessDate(),line.getEquivalente_credito_corporativo(),line.getEquivalente_credito_normativo(),line.getEquivalente_credito_factor(),line.getEquivalente_credito_factor_inter(),line.getEquivalente_credito_factor_normativo(),line.getOrigen_id());
//----------End insert EQUIVALENTE_CREDITO table
				
//----------Start insert PROFIT table
				jdbcTemplate.update( INSERT_PROFIT,line.getSide_notional_ccy_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getProfit_value(),line.getProfit_ccy_id(),line.getProfit_mesa_clientes_clp(),line.getProfit_mesa_trading_clp(),line.getProfit_mesa_clientes_USD(),line.getProfit_mesa_trading_USD(),line.getProfit_total_USD(),line.getProfit_total_CLP(),line.getOrigen_id());
//----------End insert PROFIT table					
				cacheTransaction.add(line.getTransaction_deal_num());
			}
		
				//------------Start insert SIDE table
				side.append(line.getSide_id());
				side.append(line.getTransaction_deal_num());
			if(!(cahceSide.contains(side.toString()))){
				jdbcTemplate.update( INSERT_SIDE, line.getSide_id(),line.getSide_notional_ccy_id(),line.getRate_type_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getYield_basis_id(),line.getSide_payment_ccy_id(),line.getSide_type(),line.getSide_notional(),line.getSide_rate(),line.getSide_rate_spread(),line.getSide_frec_p(),line.getSide_reset_p(),line.getSide_fix_flt(),line.getSide_projection_index(),line.getOrigen_id());
				//----------Star insert PRICING table
				jdbcTemplate.update( INSERT_PRICING,line.getTransaction_deal_num(),line.getProcessDate(),line.getSide_id(),line.getPricing_mtm(),line.getPricing_mtm_ccy_id(),line.getPricing_base_mtm(),line.getPricing_base_mtm_USD(),line.getPricing_delta(),line.getPricing_gamma(),line.getPricing_vega(),line.getPricing_beta(),line.getPricing_rho_local(),line.getPricing_rho_foranea(),line.getPricing_theta(),line.getPricing_volga(),line.getPricing_pnl(),line.getPricing_unrealized_pnl(),line.getPricing_pnl_fx_unrealized(),line.getPricing_current_cash(),line.getOrigen_id(),line.getPricing_base_unrealized_pnl());
				//----------End insert PRICING table				
				cahceSide.add(side.toString());
			}
			//------------End insert SIDE table	
		


				if(line.getInterest_id()!=0){
						//-----------Start insert INTEREST table
						jdbcTemplate.update( INSERT_INTEREST, line.getInterest_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getSide_id(),line.getInterest_start_date(),line.getInterest_end_date(),line.getInterest_payment_date(),line.getInterest_fixing_date(),line.getInterest_accounting_date(),line.getInterest_rate(),line.getInterest_payment(),line.getInterest_npv(),line.getInterest_fixing_rate(),line.getInterest_df(),line.getOrigen_id());
						//-----------End insert INTEREST table						
				}
			
						
//-----------Start insert CASHFLOW table:
				if(line.getCashflow_id()!=0){
						jdbcTemplate.update( INSERT_CASHFLOW, line.getCashflow_id(),line.getCashflowtype_id(),line.getTransaction_deal_num(),line.getProcessDate(),line.getSide_id(),line.getCashflow_start_date(),line.getCashflow_end_date(),line.getCashflow_accounting_date(),line.getCashflow_fixing_date(),line.getCashflow_amount(),line.getCashflow_npv(),line.getCashflow_fixing_rate(),line.getCashflow_df(),line.getOrigen_id());
				}
//-----------End insert CASHFLOW table

				
			}catch(Exception e){
				logger.debug("Inicio Rollback de registros FINDUR para la fecha "+processDate);
				rollBack(processDate);
				logger.debug("Fin de ejecucion  Rollback de registros FINDUR para la fecha "+processDate);
				logger.error("Error writing data = " + line.toString());
				logger.error(e);
				throw e;
			}
	
			*/
		}
		
		
		
		try{
			File file = new File("C:\\newOp\\fileOperation.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(OperationType.class);
			Marshaller jaxbMarshaller = (Marshaller) jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(opt, file);
			jaxbMarshaller.marshal(opt,  System.out);

			
		}catch (JAXBException e) {
			e.printStackTrace();
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
