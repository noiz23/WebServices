/**
 * POJO to represent the .cvs data.
 */
package com.vmetrix.etl.ods.model;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author REcheverri
 * 
 */
@XmlRootElement(name = "Operacion")
public class OperacionesDTO {
	
	private long  transaction_deal_num;
	private String transaction_trade_date;
	private String transaction_start_date;
	private String transaction_end_date;
	private String transaction_ET;
	private String transaction_modalidad_pago;
	private String transaction_nemo;
	private String transaction_serie;
	private double transaction_TIR_compra;
	private double transaction_TIR_mercado;
	private double transaction_strike;
	private int side_type;
	private String side_fix_flt;
	private String side_frec_p;
	private String side_reset_p;
	private double side_notional;
	private int side_notional_ccy_id;
	private int side_payment_ccy_id;
	private double side_rate;
	private double side_rate_spread;
	private String rate_type_name;
	private String yield_basis_name;
	private int interest_id;
	private String interest_start_date;
	private String interest_end_date;
	private String interest_payment_date;
	private String interest_fixing_date;
	private String interest_accounting_date;
	private double interest_rate;
	private double interest_payment;
	private double interest_npv;
	private int cashflow_id;
	private String cashflow_start_date;
	private String cashflow_end_date;
	private String cashflow_accounting_date;
	private String cashflow_fixing_date;
	private double cashflow_amount;
	private double cashflow_npv;
	private int facility_number;
	private double transaction_info_tc_costo;
	private double transaction_info_tc_cliente;
	private double transaction_info_paridad_costo;
	private double transaction_info_paridad_cliente;
	private double transaction_info_spread_tc;
	private double transaction_info_spread_paridad;
	private double equivalente_credito_corporativo;
	private double equivalente_credito_normativo;
	private double equivalente_credito_factor;
	private double equivalente_credito_factor_inter;
	private String medio_transaccional_name;
	private String canal_transaccional_name;
	private String profit_value;
	private int profit_ccy_id;
	private String portfolio_name;
	private String instrument_name;
	private String product_name;
	private String party_name;
	private String party_razon_social;
	private String party_rut;
	private String pricing_mtm;
	private int pricing_mtm_ccy_id;
	private String pricing_base_mtm;
	private double pricing_delta;
	private double pricing_gamma;
	private double pricing_vega;
	private double pricing_rho_local; //Antes de modificacion era pricing_rho
	private double pricing_rho_foranea;
	private double pricing_theta;
	private double pricing_volga;
	private String party_type_name;
	private String grupo_economico_name;
	private String party_contact_name;
	private String party_contact_email;
	private int instrument_id;
	private int product_id;
	private int portfolio_id;
	private int party_type_id;
	private int party_id;
	private int facility_id;
	private int canal_transaccional_id;
	private int medio_transaccional_id;
	private int transaction_party_secuencia;
	private int rate_type_id;
	private int yield_basis_id;
	private double pricing_beta;
	private String paymentconv_name;
	private int transaction_paymentconv_id;
	private int cashflowtype_id;
	private int side_id;
	private int origen_id =2;//default, origen xml
	private String side_projection_index;
	private double profit_mesa_clientes_clp;
	private double profit_mesa_trading_clp;
	private double pricing_pnl;
	private int transaction_status_id;
	private int transaction_id_group;
	private double interest_fixing_rate;
	private double interest_df;
	private double cashflow_fixing_rate;
	private double cashflow_df;
	private double transaction_info_fx_spot_cliente;
	private double transaction_info_fx_fwd_costo;
	private double transaction_info_fx_fwd_cliente;
	private double transaction_info_puntos_fwd;
	private double transaction_info_fx_uf_spot;
	private double transaction_info_fx_uf_tasa_costo;
	private double transaction_info_fx_uf_tasa_margen;
	private double transaction_info_fx_uf_tasa_cliente;
	private double transaction_info_fx_spot_margen;
	private double transaction_info_fx_fwd_margen;
	private double transaction_info_fx_uf_tasa_sucia_costo;
	private double transaction_info_fx_uf_tasa_sucia_cliente;
	private double equivalente_credito_factor_normativo;
	private double pricing_pnl_fx_unrealized;
	
	//Campos nuevos 2016-02-10
	private double profit_mesa_clientes_USD=0;
	private double profit_mesa_trading_USD=0;
	private double profit_total_USD=0;
	private double profit_total_CLP=0;
	private double pricing_base_mtm_USD=0;
	private double pricing_unrealized_pnl=0;
	private double pricing_current_cash=0;
	
	private String processDate;
	
	private double pricing_base_unrealized_pnl=0;
	
	
	private int call_put_id;
	
	//-- v 2.1 
	private String transaction_offset_tran_type;
	private String transaction_info_reference;
	private String transaction_trader_name;
	private String transaction_info_nombre_cliente;
	private String transaction_info_id_cliente;
	private String transaction_info_indicador_fx;
	private String transaction_info_observaciones;
	
	// -- v 2.2
	private String transaction_trader_id; 

	// -- v 2.3
	private String transaction_ET_NP="";
	
	
	
	
	
	@XmlAttribute(name = "call_put_id")
	public int getCall_put_id() {
		return call_put_id;
	}
	public void setCall_put_id(int call_put_id) {
		this.call_put_id = call_put_id;
	}

	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	@XmlAttribute(name = "profit_mesa_clientes_clp")
	public double getProfit_mesa_clientes_clp() {
		return profit_mesa_clientes_clp;
	}
	@XmlAttribute(name = "pricing_rho_local")
	public double getPricing_rho_local() {
		return pricing_rho_local;
	}
	
	public void setPricing_rho_local(double pricing_rho_local) {
		this.pricing_rho_local = pricing_rho_local;
	}
	@XmlAttribute(name = "pricing_rho_foranea")
	public double getPricing_rho_foranea() {
		return pricing_rho_foranea;
	}
	public void setPricing_rho_foranea(double pricing_rho_foranea) {
		this.pricing_rho_foranea = pricing_rho_foranea;
	}
	@XmlAttribute(name = "pricing_pnl")
	public double getPricing_pnl() {
		return pricing_pnl;
	}
	public void setPricing_pnl(double pricing_pnl) {
		this.pricing_pnl = pricing_pnl;
	}
	public void setProfit_mesa_clientes_clp(double profit_mesa_clientes_clp) {
		this.profit_mesa_clientes_clp = profit_mesa_clientes_clp;
	}
	@XmlAttribute(name = "profit_mesa_trading_clp")
	public double getProfit_mesa_trading_clp() {
		return profit_mesa_trading_clp;
	}
	public void setProfit_mesa_trading_clp(double profit_mesa_trading_clp) {
		this.profit_mesa_trading_clp = profit_mesa_trading_clp;
	}
	@XmlAttribute(name = "transaction_deal_num")
	public long  getTransaction_deal_num() {
		return transaction_deal_num;
	}
	public void setTransaction_deal_num(long  transaction_deal_num) {
		this.transaction_deal_num = transaction_deal_num;
	}
//	@XmlAttribute(name = "transaction_deal_number")
//	public int getTransaction_deal_number() {
//		return transaction_deal_number;
//	}
//	public void setTransaction_deal_number(int transaction_deal_number) {
//		this.transaction_deal_number = transaction_deal_number;
//	}
	@XmlAttribute(name = "transaction_trade_date")
	public String getTransaction_trade_date() {
		return transaction_trade_date;
	}
	public void setTransaction_trade_date(String transaction_trade_date) {
		this.transaction_trade_date = transaction_trade_date;
	}
	@XmlAttribute(name = "transaction_start_date")
	public String getTransaction_start_date() {
		return transaction_start_date;
	}
	public void setTransaction_start_date(String transaction_start_date) {
		this.transaction_start_date = transaction_start_date;
	}
	@XmlAttribute(name = "transaction_end_date")
	public String getTransaction_end_date() {
		return transaction_end_date;
	}
	public void setTransaction_end_date(String transaction_end_date) {
		this.transaction_end_date = transaction_end_date;
	}
	@XmlAttribute(name = "transaction_ET")
	public String getTransaction_ET() {
		return transaction_ET;
	}
	public void setTransaction_ET(String transaction_ET) {
		this.transaction_ET = transaction_ET;
	}
	@XmlAttribute(name = "transaction_modalidad_pago")
	public String getTransaction_modalidad_pago() {
		return transaction_modalidad_pago;
	}
	public void setTransaction_modalidad_pago(String transaction_modalidad_pago) {
		this.transaction_modalidad_pago = transaction_modalidad_pago;
	}
	@XmlAttribute(name = "transaction_nemo")
	public String getTransaction_nemo() {
		return transaction_nemo;
	}
	public void setTransaction_nemo(String transaction_nemo) {
		this.transaction_nemo = transaction_nemo;
	}
	@XmlAttribute(name = "transaction_serie")
	public String getTransaction_serie() {
		return transaction_serie;
	}
	public void setTransaction_serie(String transaction_serie) {
		this.transaction_serie = transaction_serie;
	}
	@XmlAttribute(name = "transaction_TIR_compra")
	public double getTransaction_TIR_compra() {
		return transaction_TIR_compra;
	}
	public void setTransaction_TIR_compra(double transaction_TIR_compra) {
		this.transaction_TIR_compra = transaction_TIR_compra;
	}
	@XmlAttribute(name = "transaction_TIR_mercado")
	public double getTransaction_TIR_mercado() {
		return transaction_TIR_mercado;
	}
	public void setTransaction_TIR_mercado(double transaction_TIR_mercado) {
		this.transaction_TIR_mercado = transaction_TIR_mercado;
	}
	@XmlAttribute(name = "transaction_strike")
	public double getTransaction_strike() {
		return transaction_strike;
	}
	public void setTransaction_strike(double transaction_strike) {
		this.transaction_strike = transaction_strike;
	}
	@XmlAttribute(name = "side_type")
	public int getSide_type() {
		return side_type;
	}
	public void setSide_type(int side_type) {
		this.side_type = side_type;
	}
	@XmlAttribute(name = "side_fix_flt")
	public String getSide_fix_flt() {
		return side_fix_flt;
	}
	public void setSide_fix_flt(String side_fix_flt) {
		this.side_fix_flt = side_fix_flt;
	}

	@XmlAttribute(name = "side_notional")
	public double getSide_notional() {
		return side_notional;
	}
	public void setSide_notional(double side_notional) {
		this.side_notional = side_notional;
	}
	@XmlAttribute(name = "side_notional_ccy_id")
	public int getSide_notional_ccy_id() {
		return side_notional_ccy_id;
	}
	public void setSide_notional_ccy_id(int side_notional_ccy_id) {
		this.side_notional_ccy_id = side_notional_ccy_id;
	}
	@XmlAttribute(name = "side_payment_ccy_id")
	public int getSide_payment_ccy_id() {
		return side_payment_ccy_id;
	}
	public void setSide_payment_ccy_id(int side_payment_ccy_id) {
		this.side_payment_ccy_id = side_payment_ccy_id;
	}
	@XmlAttribute(name = "side_rate")
	public double getSide_rate() {
		return side_rate;
	}
	public void setSide_rate(double side_rate) {
		this.side_rate = side_rate;
	}
	@XmlAttribute(name = "side_rate_spread")
	public double getSide_rate_spread() {
		return side_rate_spread;
	}
	public void setSide_rate_spread(double side_rate_spread) {
		this.side_rate_spread = side_rate_spread;
	}
	//@XmlAttribute(name = "rate_type_name")
	public String getRate_type_name() {
		return rate_type_name;
	}
	public void setRate_type_name(String rate_type_name) {
		this.rate_type_name = rate_type_name;
	}
	public String getYield_basis_name() {
		return yield_basis_name;
	}
	public void setYield_basis_name(String yield_basis_name) {
		this.yield_basis_name = yield_basis_name;
	}
	@XmlAttribute(name = "interest_id")
	public int getInterest_id() {
		return interest_id;
	}
	public void setInterest_id(int interest_id) {
		this.interest_id = interest_id;
	}
	@XmlAttribute(name = "interest_start_date")
	public String getInterest_start_date() {
		return interest_start_date;
	}
	public void setInterest_start_date(String interest_start_date) {
		this.interest_start_date = interest_start_date;
	}
	@XmlAttribute(name = "interest_end_date")
	public String getInterest_end_date() {
		return interest_end_date;
	}
	public void setInterest_end_date(String interest_end_date) {
		this.interest_end_date = interest_end_date;
	}
	@XmlAttribute(name = "interest_payment_date")
	public String getInterest_payment_date() {
		return interest_payment_date;
	}
	public void setInterest_payment_date(String interest_payment_date) {
		this.interest_payment_date = interest_payment_date;
	}
	@XmlAttribute(name = "interest_fixing_date")
	public String getInterest_fixing_date() {
		return interest_fixing_date;
	}
	public void setInterest_fixing_date(String interest_fixing_date) {
		this.interest_fixing_date = interest_fixing_date;
	}
	@XmlAttribute(name = "interest_accounting_date")
	public String getInterest_accounting_date() {
		return interest_accounting_date;
	}
	public void setInterest_accounting_date(String interest_accounting_date) {
		this.interest_accounting_date = interest_accounting_date;
	}
	@XmlAttribute(name = "interest_rate")
	public double getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	@XmlAttribute(name = "interest_payment")
	public double getInterest_payment() {
		return interest_payment;
	}
	public void setInterest_payment(double interest_payment) {
		this.interest_payment = interest_payment;
	}
	@XmlAttribute(name = "interest_npv")
	public double getInterest_npv() {
		return interest_npv;
	}
	public void setInterest_npv(double interest_npv) {
		this.interest_npv = interest_npv;
	}
	@XmlAttribute(name = "cashflow_id")
	public int getCashflow_id() {
		return cashflow_id;
	}
	public void setCashflow_id(int cashflow_id) {
		this.cashflow_id = cashflow_id;
	}
	@XmlAttribute(name = "cashflow_start_date")
	public String getCashflow_start_date() {
		return cashflow_start_date;
	}
	public void setCashflow_start_date(String cashflow_start_date) {
		this.cashflow_start_date = cashflow_start_date;
	}
	@XmlAttribute(name = "cashflow_end_date")
	public String getCashflow_end_date() {
		return cashflow_end_date;
	}
	public void setCashflow_end_date(String cashflow_end_date) {
		this.cashflow_end_date = cashflow_end_date;
	}
	@XmlAttribute(name = "cashflow_accounting_date")
	public String getCashflow_accounting_date() {
		return cashflow_accounting_date;
	}
	public void setCashflow_accounting_date(String cashflow_accounting_date) {
		this.cashflow_accounting_date = cashflow_accounting_date;
	}
	@XmlAttribute(name = "cashflow_fixing_date")
	public String getCashflow_fixing_date() {
		return cashflow_fixing_date;
	}
	public void setCashflow_fixing_date(String cashflow_fixing_date) {
		this.cashflow_fixing_date = cashflow_fixing_date;
	}
	@XmlAttribute(name = "cashflow_amount")
	public double getCashflow_amount() {
		return cashflow_amount;
	}
	public void setCashflow_amount(double cashflow_amount) {
		this.cashflow_amount = cashflow_amount;
	}
	@XmlAttribute(name = "cashflow_npv")
	public double getCashflow_npv() {
		return cashflow_npv;
	}
	public void setCashflow_npv(double cashflow_npv) {
		this.cashflow_npv = cashflow_npv;
	}
	
	public int getFacility_number() {
		return facility_number;
	}
	public void setFacility_number(int facility_number) {
		this.facility_number = facility_number;
	}
	@XmlAttribute(name = "transaction_info_tc_costo")
	public double getTransaction_info_tc_costo() {
		return transaction_info_tc_costo;
	}
	public void setTransaction_info_tc_costo(double transaction_info_tc_costo) {
		this.transaction_info_tc_costo = transaction_info_tc_costo;
	}
	@XmlAttribute(name = "transaction_info_tc_cliente")
	public double getTransaction_info_tc_cliente() {
		return transaction_info_tc_cliente;
	}
	public void setTransaction_info_tc_cliente(double transaction_info_tc_cliente) {
		this.transaction_info_tc_cliente = transaction_info_tc_cliente;
	}
	@XmlAttribute(name = "transaction_info_paridad_costo")
	public double getTransaction_info_paridad_costo() {
		return transaction_info_paridad_costo;
	}
	public void setTransaction_info_paridad_costo(double transaction_info_paridad_costo) {
		this.transaction_info_paridad_costo = transaction_info_paridad_costo;
	}
	@XmlAttribute(name = "transaction_info_paridad_cliente")
	public double getTransaction_info_paridad_cliente() {
		return transaction_info_paridad_cliente;
	}
	public void setTransaction_info_paridad_cliente(double transaction_info_paridad_cliente) {
		this.transaction_info_paridad_cliente = transaction_info_paridad_cliente;
	}
	@XmlAttribute(name = "transaction_info_spread_tc")
	public double getTransaction_info_spread_tc() {
		return transaction_info_spread_tc;
	}
	public void setTransaction_info_spread_tc(double transaction_info_spread_tc) {
		this.transaction_info_spread_tc = transaction_info_spread_tc;
	}
	@XmlAttribute(name = "transaction_info_spread_paridad")
	public double getTransaction_info_spread_paridad() {
		return transaction_info_spread_paridad;
	}
	public void setTransaction_info_spread_paridad(double transaction_info_spread_paridad) {
		this.transaction_info_spread_paridad = transaction_info_spread_paridad;
	}
	@XmlAttribute(name = "equivalente_credito_corporativo")
	public double getEquivalente_credito_corporativo() {
		return equivalente_credito_corporativo;
	}
	public void setEquivalente_credito_corporativo(double equivalente_credito_corporativo) {
		this.equivalente_credito_corporativo = equivalente_credito_corporativo;
	}
	@XmlAttribute(name = "equivalente_credito_normativo")
	public double getEquivalente_credito_normativo() {
		return equivalente_credito_normativo;
	}
	public void setEquivalente_credito_normativo(double equivalente_credito_normativo) {
		this.equivalente_credito_normativo = equivalente_credito_normativo;
	}
	@XmlAttribute(name = "equivalente_credito_factor")
	public double getEquivalente_credito_factor() {
		return equivalente_credito_factor;
	}
	public void setEquivalente_credito_factor(double equivalente_credito_factor) {
		this.equivalente_credito_factor = equivalente_credito_factor;
	}
	@XmlAttribute(name = "equivalente_credito_factor_inter")
	public double getEquivalente_credito_factor_inter() {
		return equivalente_credito_factor_inter;
	}
	public void setEquivalente_credito_factor_inter(double equivalente_credito_factor_inter) {
		this.equivalente_credito_factor_inter = equivalente_credito_factor_inter;
	}
	public String getMedio_transaccional_name() {
		return medio_transaccional_name;
	}
	public void setMedio_transaccional_name(String medio_transaccional_name) {
		this.medio_transaccional_name = medio_transaccional_name;
	}
	public String getCanal_transaccional_name() {
		return canal_transaccional_name;
	}
	public void setCanal_transaccional_name(String canal_transaccional_name) {
		this.canal_transaccional_name = canal_transaccional_name;
	}
	@XmlAttribute(name = "profit_value")
	public String getProfit_value() {
		return profit_value;
	}
	public void setProfit_value(String profit_value) {
		this.profit_value = profit_value;
	}

	public String getPortfolio_name() {
		return portfolio_name;
	}
	public void setPortfolio_name(String portfolio_name) {
		this.portfolio_name = portfolio_name;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	@XmlAttribute(name = "party_name")
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	@XmlAttribute(name = "party_razon_social")
	public String getParty_razon_social() {
		return party_razon_social;
	}
	public void setParty_razon_social(String party_razon_social) {
		this.party_razon_social = party_razon_social;
	}
	@XmlAttribute(name = "party_rut")
	public String getParty_rut() {
		return party_rut;
	}
	public void setParty_rut(String party_rut) {
		this.party_rut = party_rut;
	}
	@XmlAttribute(name = "pricing_mtm")
	public String getPricing_mtm() {
		return pricing_mtm;
	}
	public void setPricing_mtm(String pricing_mtm) {
		this.pricing_mtm = pricing_mtm;
	}
	@XmlAttribute(name = "pricing_mtm_ccy_id")
	public int getPricing_mtm_ccy_id() {
		return pricing_mtm_ccy_id;
	}
	public void setPricing_mtm_ccy_id(int pricing_mtm_ccy_id) {
		this.pricing_mtm_ccy_id = pricing_mtm_ccy_id;
	}
	@XmlAttribute(name = "pricing_base_mtm")
	public String getPricing_base_mtm() {
		return pricing_base_mtm;
	}
	public void setPricing_base_mtm(String pricing_base_mtm) {
		this.pricing_base_mtm = pricing_base_mtm;
	}
	@XmlAttribute(name = "pricing_delta")
	public double getPricing_delta() {
		return pricing_delta;
	}
	public void setPricing_delta(double pricing_delta) {
		this.pricing_delta = pricing_delta;
	}
	@XmlAttribute(name = "pricing_gamma")
	public double getPricing_gamma() {
		return pricing_gamma;
	}
	public void setPricing_gamma(double pricing_gamma) {
		this.pricing_gamma = pricing_gamma;
	}
	@XmlAttribute(name = "pricing_vega")	
	public double getPricing_vega() {
		return pricing_vega;
	}
	public void setPricing_vega(double pricing_vega) {
		this.pricing_vega = pricing_vega;
	}

	@XmlAttribute(name = "pricing_theta")	
	public double getPricing_theta() {
		return pricing_theta;
	}
	public void setPricing_theta(double pricing_theta) {
		this.pricing_theta = pricing_theta;
	}
	@XmlAttribute(name = "pricing_volga")	
	public double getPricing_volga() {
		return pricing_volga;
	}
	public void setPricing_volga(double pricing_volga) {
		this.pricing_volga = pricing_volga;
	}
	@XmlAttribute(name = "party_type_name")
	public String getParty_type_name() {
		return party_type_name;
	}
	public void setParty_type_name(String party_type_name) {
		this.party_type_name = party_type_name;
	}
	@XmlAttribute(name = "grupo_economico_name")
	public String getGrupo_economico_name() {
		return grupo_economico_name;
	}
	public void setGrupo_economico_name(String grupo_economico_name) {
		this.grupo_economico_name = grupo_economico_name;
	}
	@XmlAttribute(name = "party_contact_name")
	public String getParty_contact_name() {
		return party_contact_name;
	}
	public void setParty_contact_name(String party_contact_name) {
		this.party_contact_name = party_contact_name;
	}
	@XmlAttribute(name = "party_contact_email")
	public String getParty_contact_email() {
		return party_contact_email;
	}
	public void setParty_contact_email(String party_contact_email) {
		this.party_contact_email = party_contact_email;
	}
	@XmlAttribute(name = "instrument_id")
	public int getInstrument_id() {
		return instrument_id;
	}
	public void setInstrument_id(int instrument_id) {
		this.instrument_id = instrument_id;
	}
	@XmlAttribute(name = "product_id")
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@XmlAttribute(name = "portfolio_id")
	public int getPortfolio_id() {
		return portfolio_id;
	}
	public void setPortfolio_id(int portfolio_id) {
		this.portfolio_id = portfolio_id;
	}
	public int getParty_type_id() {
		return party_type_id;
	}
	public void setParty_type_id(int party_type_id) {
		this.party_type_id = party_type_id;
	}
	@XmlAttribute(name = "party_id")
	public int getParty_id() {
		return party_id;
	}
	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}
	@XmlAttribute(name = "facility_id")
	public int getFacility_id() {
		return facility_id;
	}
	public void setFacility_id(int facility_id) {
		this.facility_id = facility_id;
	}
	@XmlAttribute(name = "canal_transaccional_id")
	public int getCanal_transaccional_id() {
		return canal_transaccional_id;
	}
	public void setCanal_transaccional_id(int canal_transaccional_id) {
		this.canal_transaccional_id = canal_transaccional_id;
	}
	@XmlAttribute(name = "medio_transaccional_id")
	public int getMedio_transaccional_id() {
		return medio_transaccional_id;
	}
	public void setMedio_transaccional_id(int medio_transaccional_id) {
		this.medio_transaccional_id = medio_transaccional_id;
	}
//	@XmlAttribute(name = "currency_id")
//	public int getCurrency_id() {
//		return currency_id;
//	}
//	public void setCurrency_id(int currency_id) {
//		this.currency_id = currency_id;
//	}
	@XmlAttribute(name = "rate_type_id")
	public int getRate_type_id() {
		return rate_type_id;
	}
	public void setRate_type_id(int rate_type_id) {
		this.rate_type_id = rate_type_id;
	}
	@XmlAttribute(name = "yield_basis_id")
	public int getYield_basis_id() {
		return yield_basis_id;
	}
	public void setYield_basis_id(int yield_basis_id) {
		this.yield_basis_id = yield_basis_id;
	}
//	@XmlAttribute(name = "cur_currency_id")
//	public int getCur_currency_id() {
//		return cur_currency_id;
//	}
//	public void setCur_currency_id(int cur_currency_id) {
//		this.cur_currency_id = cur_currency_id;
//	}
//	@XmlAttribute(name = "side_payment_date")
//	public String getSide_payment_date() {
//		return side_payment_date;
//	}
//	public void setSide_payment_date(String side_payment_date) {
//		this.side_payment_date = side_payment_date;
//	}
	@XmlAttribute(name = "pricing_beta")
	public double getPricing_beta() {
		return pricing_beta;
	}
	public void setPricing_beta(double pricing_beta) {
		this.pricing_beta = pricing_beta;
	}
	@XmlAttribute(name = "paymentconv_name")
	public String getPaymentconv_name() {
		return paymentconv_name;
	}
	public void setPaymentconv_name(String paymentconv_name) {
		this.paymentconv_name = paymentconv_name;
	}

	@XmlAttribute(name = "cashflowtype_id")
	public int getCashflowtype_id() {
		return cashflowtype_id;
	}
	public void setCashflowtype_id(int cashflowtype_id) {
		this.cashflowtype_id = cashflowtype_id;
	}
	@XmlAttribute(name = "side_id")
	public int getSide_id() {
		return side_id;
	}
	public void setSide_id(int side_id) {
		this.side_id = side_id;
	}
	public int getOrigen_id() {
		return origen_id;
	}
	public void setOrigen_id(int origen_id) {
		this.origen_id = origen_id;
	}
	@XmlAttribute(name = "side_projection_index")
	public String getSide_projection_index() {
		return side_projection_index;
	}
	public void setSide_projection_index(String side_projection_index) {
		this.side_projection_index = side_projection_index;
	}
	
	@XmlAttribute(name = "party_secuencia")
	public int getTransaction_party_secuencia() {
		return transaction_party_secuencia;
	}
	public void setTransaction_party_secuencia(int transaction_party_secuencia) {
		this.transaction_party_secuencia = transaction_party_secuencia;
	}
	@XmlAttribute(name = "transaction_status_id")
	public int getTransaction_status_id() {
		return transaction_status_id;
	}
	public void setTransaction_status_id(int transaction_status_id) {
		this.transaction_status_id = transaction_status_id;
	}
	@XmlAttribute(name = "transaction_id_group")
	public int getTransaction_id_group() {
		return transaction_id_group;
	}
	public void setTransaction_id_group(int transaction_id_group) {
		this.transaction_id_group = transaction_id_group;
	}
	@XmlAttribute(name = "interest_fixing_rate")
	public double getInterest_fixing_rate() {
		return interest_fixing_rate;
	}
	public void setInterest_fixing_rate(double interest_fixing_rate) {
		this.interest_fixing_rate = interest_fixing_rate;
	}
	@XmlAttribute(name = "interest_df")
	public double getInterest_df() {
		return interest_df;
	}
	public void setInterest_df(double interest_df) {
		this.interest_df = interest_df;
	}
	@XmlAttribute(name = "cashflow_fixing_rate")
	public double getCashflow_fixing_rate() {
		return cashflow_fixing_rate;
	}
	public void setCashflow_fixing_rate(double cashflow_fixing_rate) {
		this.cashflow_fixing_rate = cashflow_fixing_rate;
	}
	@XmlAttribute(name = "cashflow_df")
	public double getCashflow_df() {
		return cashflow_df;
	}
	public void setCashflow_df(double cashflow_df) {
		this.cashflow_df = cashflow_df;
	}
	@XmlAttribute(name = "transaction_info_fx_spot_cliente")
	public double getTransaction_info_fx_spot_cliente() {
		return transaction_info_fx_spot_cliente;
	}
	public void setTransaction_info_fx_spot_cliente(double transaction_info_fx_spot_cliente) {
		this.transaction_info_fx_spot_cliente = transaction_info_fx_spot_cliente;
	}
	@XmlAttribute(name = "transaction_info_fx_fwd_costo")
	public double getTransaction_info_fx_fwd_costo() {
		return transaction_info_fx_fwd_costo;
	}
	public void setTransaction_info_fx_fwd_costo(double transaction_info_fx_fwd_costo) {
		this.transaction_info_fx_fwd_costo = transaction_info_fx_fwd_costo;
	}
	@XmlAttribute(name = "transaction_info_fx_fwd_cliente")
	public double getTransaction_info_fx_fwd_cliente() {
		return transaction_info_fx_fwd_cliente;
	}
	public void setTransaction_info_fx_fwd_cliente(double transaction_info_fx_fwd_cliente) {
		this.transaction_info_fx_fwd_cliente = transaction_info_fx_fwd_cliente;
	}
	@XmlAttribute(name = "transaction_info_puntos_fwd")
	public double getTransaction_info_puntos_fwd() {
		return transaction_info_puntos_fwd;
	}
	public void setTransaction_info_puntos_fwd(double transaction_info_puntos_fwd) {
		this.transaction_info_puntos_fwd = transaction_info_puntos_fwd;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_spot")
	public double getTransaction_info_fx_uf_spot() {
		return transaction_info_fx_uf_spot;
	}
	public void setTransaction_info_fx_uf_spot(double transaction_info_fx_uf_spot) {
		this.transaction_info_fx_uf_spot = transaction_info_fx_uf_spot;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_tasa_costo")
	public double getTransaction_info_fx_uf_tasa_costo() {
		return transaction_info_fx_uf_tasa_costo;
	}
	public void setTransaction_info_fx_uf_tasa_costo(double transaction_info_fx_uf_tasa_costo) {
		this.transaction_info_fx_uf_tasa_costo = transaction_info_fx_uf_tasa_costo;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_tasa_margen")
	public double getTransaction_info_fx_uf_tasa_margen() {
		return transaction_info_fx_uf_tasa_margen;
	}
	public void setTransaction_info_fx_uf_tasa_margen(double transaction_info_fx_uf_tasa_margen) {
		this.transaction_info_fx_uf_tasa_margen = transaction_info_fx_uf_tasa_margen;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_tasa_cliente")
	public double getTransaction_info_fx_uf_tasa_cliente() {
		return transaction_info_fx_uf_tasa_cliente;
	}
	public void setTransaction_info_fx_uf_tasa_cliente(double transaction_info_fx_uf_tasa_cliente) {
		this.transaction_info_fx_uf_tasa_cliente = transaction_info_fx_uf_tasa_cliente;
	}
	@XmlAttribute(name = "transaction_info_fx_spot_margen")
	public double getTransaction_info_fx_spot_margen() {
		return transaction_info_fx_spot_margen;
	}
	public void setTransaction_info_fx_spot_margen(double transaction_info_fx_spot_margen) {
		this.transaction_info_fx_spot_margen = transaction_info_fx_spot_margen;
	}
	@XmlAttribute(name = "transaction_info_fx_fwd_margen")
	public double getTransaction_info_fx_fwd_margen() {
		return transaction_info_fx_fwd_margen;
	}
	public void setTransaction_info_fx_fwd_margen(double transaction_info_fx_fwd_margen) {
		this.transaction_info_fx_fwd_margen = transaction_info_fx_fwd_margen;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_tasa_sucia_costo")
	public double getTransaction_info_fx_uf_tasa_sucia_costo() {
		return transaction_info_fx_uf_tasa_sucia_costo;
	}
	public void setTransaction_info_fx_uf_tasa_sucia_costo(double transaction_info_fx_uf_tasa_sucia_costo) {
		this.transaction_info_fx_uf_tasa_sucia_costo = transaction_info_fx_uf_tasa_sucia_costo;
	}
	@XmlAttribute(name = "transaction_info_fx_uf_tasa_sucia_cliente")
	public double getTransaction_info_fx_uf_tasa_sucia_cliente() {
		return transaction_info_fx_uf_tasa_sucia_cliente;
	}
	public void setTransaction_info_fx_uf_tasa_sucia_cliente(double transaction_info_fx_uf_tasa_sucia_cliente) {
		this.transaction_info_fx_uf_tasa_sucia_cliente = transaction_info_fx_uf_tasa_sucia_cliente;
	}
	@XmlAttribute(name = "equivalente_credito_factor_normativo")
	public double getEquivalente_credito_factor_normativo() {
		return equivalente_credito_factor_normativo;
	}
	public void setEquivalente_credito_factor_normativo(double equivalente_credito_factor_normativo) {
		this.equivalente_credito_factor_normativo = equivalente_credito_factor_normativo;
	}
	@XmlAttribute(name = "pricing_pnl_fx_unrealized")
	public double getPricing_pnl_fx_unrealized() {
		return pricing_pnl_fx_unrealized;
	}
	public void setPricing_pnl_fx_unrealized(double pricing_pnl_fx_unrealized) {
		this.pricing_pnl_fx_unrealized = pricing_pnl_fx_unrealized;
	}
	@XmlAttribute(name = "transaction_paymentconv_id")
	public int getTransaction_paymentconv_id() {
		return transaction_paymentconv_id;
	}
	public void setTransaction_paymentconv_id(int transaction_paymentconv_id) {
		this.transaction_paymentconv_id = transaction_paymentconv_id;
	}
	@XmlAttribute(name = "profit_ccy_id")
	public int getProfit_ccy_id() {
		return profit_ccy_id;
	}
	public void setProfit_ccy_id(int profit_ccy_id) {
		this.profit_ccy_id = profit_ccy_id;
	}
	@XmlAttribute(name = "side_frec_p")
	public String getSide_frec_p() {
		return side_frec_p;
	}
	public void setSide_frec_p(String side_frec_p) {
		this.side_frec_p = side_frec_p;
	}
	@XmlAttribute(name = "side_reset_p")
	public String getSide_reset_p() {
		return side_reset_p;
	}
	public void setSide_reset_p(String side_reset_p) {
		this.side_reset_p = side_reset_p;
	}
	public double getProfit_mesa_clientes_USD() {
		return profit_mesa_clientes_USD;
	}
	public void setProfit_mesa_clientes_USD(double profit_mesa_clientes_USD) {
		this.profit_mesa_clientes_USD = profit_mesa_clientes_USD;
	}
	public double getProfit_mesa_trading_USD() {
		return profit_mesa_trading_USD;
	}
	public void setProfit_mesa_trading_USD(double profit_mesa_trading_USD) {
		this.profit_mesa_trading_USD = profit_mesa_trading_USD;
	}
	public double getProfit_total_USD() {
		return profit_total_USD;
	}
	public void setProfit_total_USD(double profit_total_USD) {
		this.profit_total_USD = profit_total_USD;
	}
	public double getProfit_total_CLP() {
		return profit_total_CLP;
	}
	public void setProfit_total_CLP(double profit_total_CLP) {
		this.profit_total_CLP = profit_total_CLP;
	}
	public double getPricing_base_mtm_USD() {
		return pricing_base_mtm_USD;
	}
	public void setPricing_base_mtm_USD(double pricing_base_mtm_USD) {
		this.pricing_base_mtm_USD = pricing_base_mtm_USD;
	}
	public double getPricing_unrealized_pnl() {
		return pricing_unrealized_pnl;
	}
	public void setPricing_unrealized_pnl(double pricing_unrealized_pnl) {
		this.pricing_unrealized_pnl = pricing_unrealized_pnl;
	}
	public double getPricing_current_cash() {
		return pricing_current_cash;
	}
	public void setPricing_current_cash(double pricing_current_cash) {
		this.pricing_current_cash = pricing_current_cash;
	}
	
	@XmlAttribute(name = "pricing_base_unrealized_pnl")
	public double getPricing_base_unrealized_pnl() {
		return pricing_base_unrealized_pnl;
	}
	public void setPricing_base_unrealized_pnl(double pricing_base_unrealized_pnl) {
		this.pricing_base_unrealized_pnl = pricing_base_unrealized_pnl;
	}
	
	public String getTransaction_offset_tran_type() {
		return transaction_offset_tran_type;
	}
	public void setTransaction_offset_tran_type(String transaction_offset_tran_type) {
		this.transaction_offset_tran_type = transaction_offset_tran_type;
	}
	public String getTransaction_info_reference() {
		return transaction_info_reference;
	}
	public void setTransaction_info_reference(String transaction_info_reference) {
		this.transaction_info_reference = transaction_info_reference;
	}
	public String getTransaction_trader_name() {
		return transaction_trader_name;
	}
	public void setTransaction_trader_name(String transaction_trader_name) {
		this.transaction_trader_name = transaction_trader_name;
	}
	public String getTransaction_info_nombre_cliente() {
		return transaction_info_nombre_cliente;
	}
	public void setTransaction_info_nombre_cliente(String transaction_info_nombre_cliente) {
		this.transaction_info_nombre_cliente = transaction_info_nombre_cliente;
	}
	public String getTransaction_info_id_cliente() {
		return transaction_info_id_cliente;
	}
	public void setTransaction_info_id_cliente(String transaction_info_id_cliente) {
		this.transaction_info_id_cliente = transaction_info_id_cliente;
	}
	public String getTransaction_info_indicador_fx() {
		return transaction_info_indicador_fx;
	}
	public void setTransaction_info_indicador_fx(String transaction_info_indicador_fx) {
		this.transaction_info_indicador_fx = transaction_info_indicador_fx;
	}
	public String getTransaction_info_observaciones() {
		return transaction_info_observaciones;
	}
	public void setTransaction_info_observaciones(String transaction_info_observaciones) {
		this.transaction_info_observaciones = transaction_info_observaciones;
	}
	public String getTransaction_trader_id() {
		return transaction_trader_id;
	}
	public void setTransaction_trader_id(String transaction_trader_id) {
		this.transaction_trader_id = transaction_trader_id;
	}
	public String getTransaction_ET_NP() {
		return transaction_ET_NP;
	}
	public void setTransaction_ET_NP(String transaction_ET_NP) {
		this.transaction_ET_NP = transaction_ET_NP;
	}
	@Override
	public String toString() {
		return "OperacionesDTO [transaction_deal_num=" + transaction_deal_num + ", transaction_trade_date="
				+ transaction_trade_date + ", transaction_start_date=" + transaction_start_date
				+ ", transaction_end_date=" + transaction_end_date + ", transaction_ET=" + transaction_ET
				+ ", transaction_modalidad_pago=" + transaction_modalidad_pago + ", transaction_nemo="
				+ transaction_nemo + ", transaction_serie=" + transaction_serie + ", transaction_TIR_compra="
				+ transaction_TIR_compra + ", transaction_TIR_mercado=" + transaction_TIR_mercado
				+ ", transaction_strike=" + transaction_strike + ", side_type=" + side_type + ", side_fix_flt="
				+ side_fix_flt + ", side_frec_p=" + side_frec_p + ", side_reset_p=" + side_reset_p + ", side_notional="
				+ side_notional + ", side_notional_ccy_id=" + side_notional_ccy_id + ", side_payment_ccy_id="
				+ side_payment_ccy_id + ", side_rate=" + side_rate + ", side_rate_spread=" + side_rate_spread
				+ ", rate_type_name=" + rate_type_name + ", yield_basis_name=" + yield_basis_name + ", interest_id="
				+ interest_id + ", interest_start_date=" + interest_start_date + ", interest_end_date="
				+ interest_end_date + ", interest_payment_date=" + interest_payment_date + ", interest_fixing_date="
				+ interest_fixing_date + ", interest_accounting_date=" + interest_accounting_date + ", interest_rate="
				+ interest_rate + ", interest_payment=" + interest_payment + ", interest_npv=" + interest_npv
				+ ", cashflow_id=" + cashflow_id + ", cashflow_start_date=" + cashflow_start_date
				+ ", cashflow_end_date=" + cashflow_end_date + ", cashflow_accounting_date=" + cashflow_accounting_date
				+ ", cashflow_fixing_date=" + cashflow_fixing_date + ", cashflow_amount=" + cashflow_amount
				+ ", cashflow_npv=" + cashflow_npv + ", facility_number=" + facility_number
				+ ", transaction_info_tc_costo=" + transaction_info_tc_costo + ", transaction_info_tc_cliente="
				+ transaction_info_tc_cliente + ", transaction_info_paridad_costo=" + transaction_info_paridad_costo
				+ ", transaction_info_paridad_cliente=" + transaction_info_paridad_cliente
				+ ", transaction_info_spread_tc=" + transaction_info_spread_tc + ", transaction_info_spread_paridad="
				+ transaction_info_spread_paridad + ", equivalente_credito_corporativo="
				+ equivalente_credito_corporativo + ", equivalente_credito_normativo=" + equivalente_credito_normativo
				+ ", equivalente_credito_factor=" + equivalente_credito_factor + ", equivalente_credito_factor_inter="
				+ equivalente_credito_factor_inter + ", medio_transaccional_name=" + medio_transaccional_name
				+ ", canal_transaccional_name=" + canal_transaccional_name + ", profit_value=" + profit_value
				+ ", profit_ccy_id=" + profit_ccy_id + ", portfolio_name=" + portfolio_name + ", instrument_name="
				+ instrument_name + ", product_name=" + product_name + ", party_name=" + party_name
				+ ", party_razon_social=" + party_razon_social + ", party_rut=" + party_rut + ", pricing_mtm="
				+ pricing_mtm + ", pricing_mtm_ccy_id=" + pricing_mtm_ccy_id + ", pricing_base_mtm=" + pricing_base_mtm
				+ ", pricing_delta=" + pricing_delta + ", pricing_gamma=" + pricing_gamma + ", pricing_vega="
				+ pricing_vega + ", pricing_rho_local=" + pricing_rho_local + ", pricing_rho_foranea="
				+ pricing_rho_foranea + ", pricing_theta=" + pricing_theta + ", pricing_volga=" + pricing_volga
				+ ", party_type_name=" + party_type_name + ", grupo_economico_name=" + grupo_economico_name
				+ ", party_contact_name=" + party_contact_name + ", party_contact_email=" + party_contact_email
				+ ", instrument_id=" + instrument_id + ", product_id=" + product_id + ", portfolio_id=" + portfolio_id
				+ ", party_type_id=" + party_type_id + ", party_id=" + party_id + ", facility_id=" + facility_id
				+ ", canal_transaccional_id=" + canal_transaccional_id + ", medio_transaccional_id="
				+ medio_transaccional_id + ", transaction_party_secuencia=" + transaction_party_secuencia
				+ ", rate_type_id=" + rate_type_id + ", yield_basis_id=" + yield_basis_id + ", pricing_beta="
				+ pricing_beta + ", paymentconv_name=" + paymentconv_name + ", transaction_paymentconv_id="
				+ transaction_paymentconv_id + ", cashflowtype_id=" + cashflowtype_id + ", side_id=" + side_id
				+ ", origen_id=" + origen_id + ", side_projection_index=" + side_projection_index
				+ ", profit_mesa_clientes_clp=" + profit_mesa_clientes_clp + ", profit_mesa_trading_clp="
				+ profit_mesa_trading_clp + ", pricing_pnl=" + pricing_pnl + ", transaction_status_id="
				+ transaction_status_id + ", transaction_id_group=" + transaction_id_group + ", interest_fixing_rate="
				+ interest_fixing_rate + ", interest_df=" + interest_df + ", cashflow_fixing_rate="
				+ cashflow_fixing_rate + ", cashflow_df=" + cashflow_df + ", transaction_info_fx_spot_cliente="
				+ transaction_info_fx_spot_cliente + ", transaction_info_fx_fwd_costo=" + transaction_info_fx_fwd_costo
				+ ", transaction_info_fx_fwd_cliente=" + transaction_info_fx_fwd_cliente
				+ ", transaction_info_puntos_fwd=" + transaction_info_puntos_fwd + ", transaction_info_fx_uf_spot="
				+ transaction_info_fx_uf_spot + ", transaction_info_fx_uf_tasa_costo="
				+ transaction_info_fx_uf_tasa_costo + ", transaction_info_fx_uf_tasa_margen="
				+ transaction_info_fx_uf_tasa_margen + ", transaction_info_fx_uf_tasa_cliente="
				+ transaction_info_fx_uf_tasa_cliente + ", transaction_info_fx_spot_margen="
				+ transaction_info_fx_spot_margen + ", transaction_info_fx_fwd_margen=" + transaction_info_fx_fwd_margen
				+ ", transaction_info_fx_uf_tasa_sucia_costo=" + transaction_info_fx_uf_tasa_sucia_costo
				+ ", transaction_info_fx_uf_tasa_sucia_cliente=" + transaction_info_fx_uf_tasa_sucia_cliente
				+ ", equivalente_credito_factor_normativo=" + equivalente_credito_factor_normativo
				+ ", pricing_pnl_fx_unrealized=" + pricing_pnl_fx_unrealized + ", profit_mesa_clientes_USD="
				+ profit_mesa_clientes_USD + ", profit_mesa_trading_USD=" + profit_mesa_trading_USD
				+ ", profit_total_USD=" + profit_total_USD + ", profit_total_CLP=" + profit_total_CLP
				+ ", pricing_base_mtm_USD=" + pricing_base_mtm_USD + ", pricing_unrealized_pnl="
				+ pricing_unrealized_pnl + ", pricing_current_cash=" + pricing_current_cash + ", processDate="
				+ processDate + ", pricing_base_unrealized_pnl=" + pricing_base_unrealized_pnl + ", call_put_id="
				+ call_put_id + ", transaction_offset_tran_type=" + transaction_offset_tran_type
				+ ", transaction_info_reference=" + transaction_info_reference + ", transaction_trader_name="
				+ transaction_trader_name + ", transaction_info_nombre_cliente=" + transaction_info_nombre_cliente
				+ ", transaction_info_id_cliente=" + transaction_info_id_cliente + ", transaction_info_indicador_fx="
				+ transaction_info_indicador_fx + ", transaction_info_observaciones=" + transaction_info_observaciones
				+ ", transaction_trader_id=" + transaction_trader_id + ", transaction_et_np=" + transaction_ET_NP + "]";
	}
	
	
}
