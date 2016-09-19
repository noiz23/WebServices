package com.vmetrix.etl.ods.reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.core.io.Resource;
import org.springframework.validation.BindException;

import com.vmetrix.etl.ods.model.OperacionesDTO;
import com.vmetrix.obtain.process.date.ProcessDate;

public class OperacionesFieldSetMapper implements FieldSetMapper<OperacionesDTO> {
	private static final String TRANSACTION_TRADER_ID = "transaction_trader_id";
	static Log logger = LogFactory.getLog(OperacionesFieldSetMapper.class);
	private static final String TRANSACTION_INFO_REFERENCE = "transaction_info_reference";
	private static final String TRANSACTION_INFO_NOMBRE_CLIENTE = "transaction_info_nombre_cliente";
	private static final String TRANSACTION_INFO_ID_CLIENTE = "transaction_info_id_cliente";
	private static final String TRANSACTION_INFO_INDICADOR_FX = "transaction_info_indicador_fx";
	private static final String TRANSACTION_INFO_OBSERVACIONES = "transaction_info_observaciones";
	private static final String TRANSACTION_TRADER_NAME = "transaction_trader_name";
	private static final String TRANSACTION_OFFSET_TRAN_TYPE = "transaction_offset_tran_type";
	private static final String PRICING_BASE_UNREALIZED_PNL = "pricing_base_unrealized_pnl";
	private static final String PRICING_CURRENT_CASH = "pricing_current_cash";
	private static final String PRICING_UNREALIZED_PNL = "pricing_unrealized_pnl";
	private static final String PRICING_BASE_MTM_USD = "pricing_base_mtm_USD";
	private static final String PROFIT_TOTAL_CLP = "profit_total_CLP";
	private static final String PROFIT_TOTAL_USD = "profit_total_USD";
	private static final String PROFIT_MESA_TRADING_USD = "profit_mesa_trading_USD";
	private static final String PROFIT_MESA_CLIENTES_USD = "profit_mesa_clientes_USD";
	
	private static final String TRANSACTION_PAYMENTCONV_ID = "transaction_paymentconv_id";
	private static final String TRANSACTION_INFO_FX_UF_TASA_SUCIA_CLIENTE = "transaction_info_fx_uf_tasa_sucia_cliente";
	private static final String TRANSACTION_INFO_FX_UF_TASA_SUCIA_COSTO = "transaction_info_fx_uf_tasa_sucia_costo";
	private static final String TRANSACTION_INFO_FX_FWD_MARGEN = "transaction_info_fx_fwd_margen";
	private static final String TRANSACTION_INFO_FX_SPOT_MARGEN = "transaction_info_fx_spot_margen";
	private static final String TRANSACTION_INFO_FX_UF_TASA_CLIENTE = "transaction_info_fx_uf_tasa_cliente";
	private static final String TRANSACTION_INFO_FX_UF_TASA_MARGEN = "transaction_info_fx_uf_tasa_margen";
	private static final String TRANSACTION_INFO_FX_UF_TASA_COSTO = "transaction_info_fx_uf_tasa_costo";
	private static final String TRANSACTION_INFO_FX_UF_SPOT = "transaction_info_fx_uf_spot";
	private static final String TRANSACTION_INFO_PUNTOS_FWD = "transaction_info_puntos_fwd";
	private static final String TRANSACTION_INFO_FX_FWD_CLIENTE = "transaction_info_fx_fwd_cliente";
	private static final String TRANSACTION_INFO_FX_FWD_COSTO = "transaction_info_fx_fwd_costo";
	private static final String TRANSACTION_INFO_FX_SPOT_CLIENTE = "transaction_info_fx_spot_cliente";
	private static final String EQUIVALENTE_CREDITO_FACTOR_NORMATIVO = "equivalente_credito_factor_normativo";
	private static final String PRICING_PNL_FX_UNREALIZED = "pricing_pnl_fx_unrealized";
	private static final String CASHFLOW_DF = "cashflow_df";
	private static final String CASHFLOW_FIXING_RATE = "cashflow_fixing_rate";
	private static final String INTEREST_DF = "interest_df";
	private static final String INTEREST_FIXING_RATE = "interest_fixing_rate";
	private static final String TRANSACTION_ID_GROUP = "transaction_id_group";
	private static final String TRANSACTION_STATUS_ID = "transaction_status_id";
	private static final String TRANSACTION_PARTY_SECUENCIA = "party_secuencia";
	private static final String PRICING_RHO_FORANEA = "pricing_rho_foranea";
	private static final String PRICING_RHO_LOCAL = "pricing_rho_local";
	private static final String PRICING_PNL = "pricing_pnl";
	private static final String PROFIT_MESA_TRADING_CLP = "profit_mesa_trading_CLP";
	private static final String PROFIT_MESA_CLIENTES_CLP = "profit_mesa_clientes_CLP";
	private static final String SIDE_PAYMENT_CCY = "side_payment_ccy_id";
	private static final String SIDE_NOTIONAL_CCY = "side_notional_ccy_id";
	private static final String TRANSACTION_TRADE_DATE = "transaction_trade_date";
	private static final String PRICING_MTM_CCY = "pricing_mtm_ccy_id";
	private static final String PROFIT_CCY = "profit_ccy_id";
	private static final String SIDE_FIX_FLT = "side_fix_flt";
	private static final String TRANSACTION_STRIKE = "transaction_strike";
	private static final String TRANSACTION_TIR_MERCADO = "transaction_TIR_mercado";
	private static final String TRANSACTION_TIR_COMPRA = "transaction_TIR_compra";
	private static final String TRANSACTION_SERIE = "transaction_serie";
	private static final String TRANSACTION_NEMO = "transaction_nemo";
	private static final String TRANSACTION_MODALIDAD_PAGO = "transaction_modalidad_pago";
	private static final String TRANSACTION_ET = "transaction_ET";
	private static final String TRANSACTION_ET_NP = "transaction_ET_NP";
	private static final String SIDE_PROJECTION_INDEX = "side_projection_index";
	private static final String TRANSACTION_INFO_SPREAD_PARIDAD = "transaction_info_spread_paridad";
	private static final String TRANSACTION_INFO_SPREAD_TC = "transaction_info_spread_tc";
	private static final String TRANSACTION_INFO_PARIDAD_CLIENTE = "transaction_info_paridad_cliente";
	private static final String TRANSACTION_INFO_PARIDAD_COSTO = "transaction_info_paridad_costo";
	private static final String TRANSACTION_INFO_TC_CLIENTE = "transaction_info_tc_cliente";
	private static final String TRANSACTION_INFO_TC_COSTO = "transaction_info_tc_costo";
	private static final String MEDIO_TRANSACCIONAL_ID = "medio_transaccional_id";
	private static final String CANAL_TRANSACCIONAL_ID = "canal_transaccional_id";
	private static final String EQUIVALENTE_CREDITO_FACTOR_INTER = "equivalente_credito_factor_inter";
	private static final String EQUIVALENTE_CREDITO_FACTOR = "equivalente_credito_factor";
	private static final String EQUIVALENTE_CREDITO_NORMATIVO = "equivalente_credito_normativo";
	private static final String EQUIVALENTE_CREDITO_CORPORATIVO = "equivalente_credito_corporativo";
	private static final String PRICING_VOLGA = "pricing_volga";
	private static final String PRICING_THETA = "pricing_theta";
	private static final String PRICING_BETA = "pricing_beta";
	private static final String PRICING_VEGA = "pricing_vega";
	private static final String PRICING_GAMMA = "pricing_gamma";
	private static final String PRICING_DELTA = "pricing_delta";
	private static final String PRICING_BASE_MTM = "pricing_base_mtm";
	private static final String PRICING_MTM = "pricing_mtm";
	private static final String PROFIT_VALUE = "profit_value";
	private static final String CASHFLOW_NPV = "cashflow_npv";
	private static final String CASHFLOW_AMOUNT = "cashflow_amount";
	private static final String CASHFLOW_FIXING_DATE = "cashflow_fixing_date";
	private static final String CASHFLOW_ACCOUNTING_DATE = "cashflow_accounting_date";
	private static final String CASHFLOW_END_DATE = "cashflow_end_date";
	private static final String CASHFLOW_START_DATE = "cashflow_start_date";
	private static final String CASHFLOWTYPE_ID = "cashflowtype_id";
	private static final String INTEREST_NPV = "interest_npv";
	private static final String INTEREST_PAYMENT = "interest_payment";
	private static final String INTEREST_RATE = "interest_rate";
	private static final String INTEREST_ACCOUNTING_DATE = "interest_accounting_date";
	private static final String INTEREST_FIXING_DATE = "interest_fixing_date";
	private static final String INTEREST_PAYMENT_DATE = "interest_payment_date";
	private static final String INTEREST_END_DATE = "interest_end_date";
	private static final String INTEREST_START_DATE = "interest_start_date";
	private static final String SIDE_RESET_P = "side_reset_p";
	private static final String SIDE_FREC_P = "side_frec_p";
	private static final String SIDE_RATE_SPREAD = "side_rate_spread";
	private static final String SIDE_RATE = "side_rate";
	private static final String SIDE_NOTIONAL = "side_notional";
	private static final String SIDE_TYPE = "side_type";
	private static final String YIELD_BASIS_ID = "side_yield_basis_id";
	private static final String CASHFLOW_ID = "cashflow_id";
	private static final String RATE_TYPE_ID = "side_rate_type_id";
	private static final String INTEREST_ID = "interest_id";
	private static final String SIDE_ID = "side_id";
	private static final String TRANSACTION_END_DATE = "transaction_end_date";
	private static final String TRANSACTION_START_DATE = "transaction_start_date";
	private static final String FACILITY_ID = "facility_id";
	private static final String PARTY_ID = "party_id";
	private static final String PORTFOLIO_ID = "portfolio_id";
	private static final String INSTRUMENT_ID = "instrument_id";
	private static final String TRANSACTION_DEAL_NUM = "transaction_deal_num";
	private static String typeFile="opf";
	
	
	private  Resource resource;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}	
		
	
	public OperacionesDTO mapFieldSet(FieldSet fieldSet) throws BindException {
		OperacionesDTO fusionData = new OperacionesDTO();
		try {
		fusionData.setProcessDate(ProcessDate.getProcessDate(resource.getFilename(), typeFile));
			
		fusionData.setOrigen_id(1);// Lectura de CSV Itau
// Mapping data for TRANSACTIONT table:
		// TRANSACTION_DEAL_NUM )+"]");
		fusionData.setTransaction_deal_num(fieldSet.readInt(TRANSACTION_DEAL_NUM));
		// TRANSACTION_PROCESS_DATE is generated in writer
		fusionData.setTransaction_trade_date(fieldSet.readRawString(TRANSACTION_TRADE_DATE));
		fusionData.setInstrument_id(fieldSet.readInt(INSTRUMENT_ID));
		fusionData.setPortfolio_id(fieldSet.readInt(PORTFOLIO_ID));
		fusionData.setParty_id(fieldSet.readInt(PARTY_ID));

		fusionData.setFacility_id(fieldSet.readInt(FACILITY_ID));
		fusionData.setTransaction_start_date(fieldSet.readRawString(TRANSACTION_START_DATE));
		fusionData.setTransaction_end_date(fieldSet.readRawString(TRANSACTION_END_DATE));
		fusionData.setTransaction_ET(fieldSet.readRawString(TRANSACTION_ET));
		fusionData.setTransaction_ET_NP(fieldSet.readRawString(TRANSACTION_ET_NP));
		fusionData.setTransaction_modalidad_pago(fieldSet.readRawString(TRANSACTION_MODALIDAD_PAGO));
		fusionData.setTransaction_nemo(fieldSet.readString(TRANSACTION_NEMO));
		fusionData.setTransaction_serie(fieldSet.readString(TRANSACTION_SERIE));
		fusionData.setTransaction_TIR_compra(fieldSet.readDouble(TRANSACTION_TIR_COMPRA));
		fusionData.setTransaction_TIR_mercado(fieldSet.readDouble(TRANSACTION_TIR_MERCADO));
		fusionData.setTransaction_strike(fieldSet.readDouble(TRANSACTION_STRIKE));
		fusionData.setTransaction_party_secuencia(fieldSet.readInt(TRANSACTION_PARTY_SECUENCIA));
		fusionData.setTransaction_status_id(fieldSet.readInt(TRANSACTION_STATUS_ID));
		fusionData.setTransaction_id_group(fieldSet.readInt(TRANSACTION_ID_GROUP));
		fusionData.setTransaction_paymentconv_id(fieldSet.readInt(TRANSACTION_PAYMENTCONV_ID));
		
		fusionData.setTransaction_offset_tran_type(fieldSet.readRawString(TRANSACTION_OFFSET_TRAN_TYPE));
		fusionData.setTransaction_trader_name(fieldSet.readRawString(TRANSACTION_TRADER_NAME));
		fusionData.setTransaction_trader_id(fieldSet.readRawString(TRANSACTION_TRADER_ID));
		
		// TRANSACTION_TIMESTAMP is generated for DB

// Mapping data for SIDE table:
		fusionData.setSide_id(fieldSet.readInt(SIDE_ID));
		fusionData.setInterest_id(fieldSet.readInt(INTEREST_ID));
		fusionData.setSide_notional_ccy_id(fieldSet.readInt(SIDE_NOTIONAL_CCY));
		fusionData.setRate_type_id(fieldSet.readInt(RATE_TYPE_ID));
		// TRANSACTION_DEAL_NUM mapeado
		// TRANSACTION_PROCESS_DATE generado en writer
		fusionData.setCashflow_id(fieldSet.readInt(CASHFLOW_ID));
		fusionData.setYield_basis_id(fieldSet.readInt(YIELD_BASIS_ID));
		fusionData.setSide_payment_ccy_id(fieldSet.readInt(SIDE_PAYMENT_CCY));
		fusionData.setSide_type(fieldSet.readInt(SIDE_TYPE));
		fusionData.setSide_notional(fieldSet.readDouble(SIDE_NOTIONAL));
//		fusionData.setSide_payment_date(fieldSet.readRawString(SIDE_PAYMENT_DATE));
		fusionData.setSide_rate(fieldSet.readDouble(SIDE_RATE));
		fusionData.setSide_rate_spread(fieldSet.readDouble(SIDE_RATE_SPREAD));
		fusionData.setSide_frec_p(fieldSet.readString(SIDE_FREC_P));
		fusionData.setSide_reset_p(fieldSet.readString(SIDE_RESET_P));
		fusionData.setSide_projection_index(fieldSet.readString(SIDE_PROJECTION_INDEX));
		fusionData.setSide_fix_flt(fieldSet.readString(SIDE_FIX_FLT));


	// Mapping data for INTEREST table:
		if(fusionData.getInterest_id()!=0){
			// INTEREST_ID mapeado
			// TRANSACTION_DEAL_NUM mapeado
			// TRANSACTION_PROCESS_DATE generado en writer
				fusionData.setInterest_start_date(fieldSet.readRawString(INTEREST_START_DATE));
				fusionData.setInterest_end_date(fieldSet.readRawString(INTEREST_END_DATE));
				fusionData.setInterest_payment_date(fieldSet.readRawString(INTEREST_PAYMENT_DATE));
				fusionData.setInterest_fixing_date(fieldSet.readRawString(INTEREST_FIXING_DATE));
				fusionData.setInterest_accounting_date(fieldSet.readRawString(INTEREST_ACCOUNTING_DATE));
				fusionData.setInterest_rate(fieldSet.readDouble(INTEREST_RATE));
				fusionData.setInterest_payment(fieldSet.readDouble(INTEREST_PAYMENT));
				fusionData.setInterest_npv(fieldSet.readDouble(INTEREST_NPV));
				fusionData.setInterest_fixing_rate(fieldSet.readDouble(INTEREST_FIXING_RATE));
				fusionData.setInterest_df(fieldSet.readDouble(INTEREST_DF));
				
			
		}


// //Mapping data for CASHFLOW table
		fusionData.setCashflow_id(fieldSet.readInt(CASHFLOW_ID));
		if (fusionData.getCashflow_id() != 0) {
			fusionData.setCashflowtype_id(fieldSet.readInt(CASHFLOWTYPE_ID));
			// TRANSACTION_DEAL_NUM mapeado
			// TRANSACTION_PROCESS_DATE generado en writer
			// SIDE_ID seteado en SIDE
			fusionData.setCashflow_start_date(fieldSet.readRawString(CASHFLOW_START_DATE));
			fusionData.setCashflow_end_date(fieldSet.readRawString(CASHFLOW_END_DATE));
			fusionData.setCashflow_accounting_date(fieldSet.readRawString(CASHFLOW_ACCOUNTING_DATE));
			fusionData.setCashflow_fixing_date(fieldSet.readRawString(CASHFLOW_FIXING_DATE));
			fusionData.setCashflow_amount(fieldSet.readDouble(CASHFLOW_AMOUNT));
			fusionData.setCashflow_npv(fieldSet.readDouble(CASHFLOW_NPV));
			fusionData.setCashflow_fixing_rate(fieldSet.readDouble(CASHFLOW_FIXING_RATE));
			fusionData.setCashflow_df(fieldSet.readDouble(CASHFLOW_DF));
			
		}
//Mapping data for PROFIT table
		// CURRENCY_ID ya esta mapeado en SIDE
		// TRANSACTION_DEAL_NUM mapeado
		// TRANSACTION_PROCESS_DATE generado en writer
		fusionData.setProfit_value(fieldSet.readRawString(PROFIT_VALUE));
		fusionData.setProfit_ccy_id(fieldSet.readInt(PROFIT_CCY));
		fusionData.setProfit_mesa_clientes_clp(fieldSet.readDouble(PROFIT_MESA_CLIENTES_CLP));
		fusionData.setProfit_mesa_trading_clp(fieldSet.readDouble(PROFIT_MESA_TRADING_CLP));
		fusionData.setProfit_mesa_clientes_USD(fieldSet.readDouble(PROFIT_MESA_CLIENTES_USD));
		fusionData.setProfit_mesa_trading_USD(fieldSet.readDouble(PROFIT_MESA_TRADING_USD));
		fusionData.setProfit_total_USD(fieldSet.readDouble(PROFIT_TOTAL_USD));
		fusionData.setProfit_total_CLP(fieldSet.readDouble(PROFIT_TOTAL_CLP));
		//
//Mapping data for PRICING table
		// TRANSACTION_DEAL_NUM mapeado
		// TRANSACTION_PROCESS_DATE generado en writer
		fusionData.setPricing_mtm(fieldSet.readRawString(PRICING_MTM));
		fusionData.setPricing_base_mtm(fieldSet.readRawString(PRICING_BASE_MTM));
		fusionData.setPricing_delta(fieldSet.readDouble(PRICING_DELTA));
		fusionData.setPricing_gamma(fieldSet.readDouble(PRICING_GAMMA));
		fusionData.setPricing_vega(fieldSet.readDouble(PRICING_VEGA));
		fusionData.setPricing_beta(fieldSet.readDouble(PRICING_BETA));
		fusionData.setPricing_rho_local(fieldSet.readDouble(PRICING_RHO_LOCAL));
		fusionData.setPricing_rho_foranea(fieldSet.readDouble(PRICING_RHO_FORANEA));
		fusionData.setPricing_theta(fieldSet.readDouble(PRICING_THETA));
		fusionData.setPricing_volga(fieldSet.readDouble(PRICING_VOLGA));
		fusionData.setPricing_mtm_ccy_id(fieldSet.readInt(PRICING_MTM_CCY));
		fusionData.setPricing_pnl(fieldSet.readDouble(PRICING_PNL));
		fusionData.setPricing_pnl_fx_unrealized(fieldSet.readDouble(PRICING_PNL_FX_UNREALIZED));
		fusionData.setPricing_base_mtm_USD(fieldSet.readDouble(PRICING_BASE_MTM_USD));
		fusionData.setPricing_unrealized_pnl(fieldSet.readDouble(PRICING_UNREALIZED_PNL));
		fusionData.setPricing_current_cash(fieldSet.readDouble(PRICING_CURRENT_CASH));
		fusionData.setPricing_base_unrealized_pnl(fieldSet.readDouble(PRICING_BASE_UNREALIZED_PNL));
// Mapping data for EQUIVALENTE_CREDITO table
		// TRANSACTION_DEAL_NUM mapeado
		// TRANSACTION_PROCESS_DATE generado en writer
		fusionData.setEquivalente_credito_corporativo(fieldSet.readDouble(EQUIVALENTE_CREDITO_CORPORATIVO));
		fusionData.setEquivalente_credito_normativo(fieldSet.readDouble(EQUIVALENTE_CREDITO_NORMATIVO));
		fusionData.setEquivalente_credito_factor(fieldSet.readDouble(EQUIVALENTE_CREDITO_FACTOR));
		fusionData.setEquivalente_credito_factor_inter(fieldSet.readDouble(EQUIVALENTE_CREDITO_FACTOR_INTER));
		fusionData.setEquivalente_credito_factor_normativo(fieldSet.readDouble(EQUIVALENTE_CREDITO_FACTOR_NORMATIVO));
		
// Mapping data for TRANSACTION_INFO table
		fusionData.setCanal_transaccional_id(fieldSet.readInt(CANAL_TRANSACCIONAL_ID));
		
		// TRANSACTION_DEAL_NUM mapeado
		// TRANSACTION_PROCESS_DATE generado en writer
		fusionData.setMedio_transaccional_id(fieldSet.readInt(MEDIO_TRANSACCIONAL_ID));
		fusionData.setTransaction_info_tc_costo(fieldSet.readDouble(TRANSACTION_INFO_TC_COSTO));
		fusionData.setTransaction_info_tc_cliente(fieldSet.readDouble(TRANSACTION_INFO_TC_CLIENTE));
		fusionData.setTransaction_info_paridad_costo(fieldSet.readDouble(TRANSACTION_INFO_PARIDAD_COSTO));
		fusionData.setTransaction_info_paridad_cliente(fieldSet.readDouble(TRANSACTION_INFO_PARIDAD_CLIENTE));
		fusionData.setTransaction_info_spread_tc(fieldSet.readDouble(TRANSACTION_INFO_SPREAD_TC));
		fusionData.setTransaction_info_spread_paridad(fieldSet.readDouble(TRANSACTION_INFO_SPREAD_PARIDAD));
		fusionData.setTransaction_info_fx_spot_cliente(fieldSet.readDouble(TRANSACTION_INFO_FX_SPOT_CLIENTE));
		fusionData.setTransaction_info_fx_fwd_costo(fieldSet.readDouble(TRANSACTION_INFO_FX_FWD_COSTO));
		fusionData.setTransaction_info_fx_fwd_cliente(fieldSet.readDouble(TRANSACTION_INFO_FX_FWD_CLIENTE));
		fusionData.setTransaction_info_puntos_fwd(fieldSet.readDouble(TRANSACTION_INFO_PUNTOS_FWD));
		fusionData.setTransaction_info_fx_uf_spot(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_SPOT));
		fusionData.setTransaction_info_fx_uf_tasa_costo(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_TASA_COSTO));
		fusionData.setTransaction_info_fx_uf_tasa_margen(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_TASA_MARGEN));
		fusionData.setTransaction_info_fx_uf_tasa_cliente(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_TASA_CLIENTE));
		fusionData.setTransaction_info_fx_spot_margen(fieldSet.readDouble(TRANSACTION_INFO_FX_SPOT_MARGEN));
		fusionData.setTransaction_info_fx_fwd_margen(fieldSet.readDouble(TRANSACTION_INFO_FX_FWD_MARGEN));
		fusionData.setTransaction_info_fx_uf_tasa_sucia_costo(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_TASA_SUCIA_COSTO));
		fusionData.setTransaction_info_fx_uf_tasa_sucia_cliente(fieldSet.readDouble(TRANSACTION_INFO_FX_UF_TASA_SUCIA_CLIENTE));
		
		fusionData.setTransaction_info_reference(fieldSet.readRawString(TRANSACTION_INFO_REFERENCE));
		fusionData.setTransaction_info_nombre_cliente(fieldSet.readRawString(TRANSACTION_INFO_NOMBRE_CLIENTE));
		fusionData.setTransaction_info_id_cliente(fieldSet.readRawString(TRANSACTION_INFO_ID_CLIENTE));
		fusionData.setTransaction_info_indicador_fx(fieldSet.readRawString(TRANSACTION_INFO_INDICADOR_FX));
		fusionData.setTransaction_info_observaciones(fieldSet.readRawString(TRANSACTION_INFO_OBSERVACIONES));
		

		
	} catch (Exception e) {
		logger.error("Exception in OperacionesDTO mapping fusionData=  "+ fusionData.toString());
		logger.error(e);
		throw new BindException(e,"Error en lectura de archivo");
	}
		return fusionData;
	}

}
