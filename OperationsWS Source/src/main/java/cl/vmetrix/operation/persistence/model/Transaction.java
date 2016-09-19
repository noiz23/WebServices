/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * This class maps the TRANSACTIONT table. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "TRANSACTIONT")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	@Column(name = "INSTRUMENT_ID", nullable = true)
	protected int instrumentId;
	
	
	@Column(name = "PORTFOLIO_ID", nullable = true)
    protected int portFolio;
    
    
	@Column(name = "PARTY_ID", nullable = true)
    protected int partyId;
    
    
	@Column(name = "FACILITY_ID", nullable = true)
    protected int facilityId;


	@Column(name = "TRANSACTION_TRADE_DATE", nullable = true)
    protected String tradeDate;


	@Column(name = "TRANSACTION_START_DATE", nullable = true)
    protected String startDate;


	@Column(name = "TRANSACTION_END_DATE", nullable = true)
    protected String endDate;


	@Column(name = "TRANSACTION_ET", nullable = true)
    protected String et;


	@Column(name = "TRANSACTION_MODALIDAD_PAGO", nullable = true)
    protected String modalidadPago;


	@Column(name = "TRANSACTION_NEMO", nullable = true)
    protected String nemo;


	@Column(name = "TRANSACTION_SERIE", nullable = true)
    protected String serie;
    
    
	@Column(name = "TRANSACTION_TIR_COMPRA", nullable = true)
    protected double tirCompra;
    
    
	@Column(name = "TRANSACTION_TIR_MERCADO", nullable = true)
    protected double tirMercado;
    
    
	@Column(name = "TRANSACTION_STRIKE", nullable = true)
    protected double strike;
    
    
	@Column(name = "TRANSACTION_PARTY_SECUENCIA", nullable = true)
    protected int partySecuencia;
    
    
	@Column(name = "TRANSACTION_PAYMENTCONV_ID", nullable = true)
    protected int paymentConvId;
    
    
	@Column(name = "TRANSACTION_STATUS_ID", nullable = true)
    protected int statusId;
    
    
	@Column(name = "TRANSACTION_ID_GROUP", nullable = true)
    protected int groupId;
    
    
	@Column(name = "TRANSACTION_CALL_PUT_ID", nullable = true)
    protected int callPutId;


	@Column(name = "TRANSACTION_OFFSET_TRAN_TYPE", nullable = true)
    protected String offsetTranType;


	@Column(name = "TRANSACTION_TRADER_NAME", nullable = true)
    protected String traderName;


	@Column(name = "TRANSACTION_TRADER_ID", nullable = true)
    protected String traderId;


	@Column(name = "TRANSACTION_ET_NP", nullable = true)
    protected String etNp;


	@Column(name = "TRANSACTION_ORIGEN", nullable = true)
    protected Integer origin;


	@Column(name = "TRANSACTION_DEAL_NUM", nullable = true)
    protected Long dealNum;


	@Column(name = "TRANSACTION_PROCESS_DATE", nullable = true)
    protected String processDate;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getInstrumentId() {
		return instrumentId;
	}


	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}


	public int getPortFolio() {
		return portFolio;
	}


	public void setPortFolio(int portFolio) {
		this.portFolio = portFolio;
	}


	public int getPartyId() {
		return partyId;
	}


	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}


	public int getFacilityId() {
		return facilityId;
	}


	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}


	public String getTradeDate() {
		return tradeDate;
	}


	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getEt() {
		return et;
	}


	public void setEt(String et) {
		this.et = et;
	}


	public String getModalidadPago() {
		return modalidadPago;
	}


	public void setModalidadPago(String modalidadPago) {
		this.modalidadPago = modalidadPago;
	}


	public String getNemo() {
		return nemo;
	}


	public void setNemo(String nemo) {
		this.nemo = nemo;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public double getTirCompra() {
		return tirCompra;
	}


	public void setTirCompra(double tirCompra) {
		this.tirCompra = tirCompra;
	}


	public double getTirMercado() {
		return tirMercado;
	}


	public void setTirMercado(double tirMercado) {
		this.tirMercado = tirMercado;
	}


	public double getStrike() {
		return strike;
	}


	public void setStrike(double strike) {
		this.strike = strike;
	}


	public int getPartySecuencia() {
		return partySecuencia;
	}


	public void setPartySecuencia(int partySecuencia) {
		this.partySecuencia = partySecuencia;
	}


	public int getPaymentConvId() {
		return paymentConvId;
	}


	public void setPaymentConvId(int paymentConvId) {
		this.paymentConvId = paymentConvId;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public int getCallPutId() {
		return callPutId;
	}


	public void setCallPutId(int callPutId) {
		this.callPutId = callPutId;
	}


	public String getOffsetTranType() {
		return offsetTranType;
	}


	public void setOffsetTranType(String offsetTranType) {
		this.offsetTranType = offsetTranType;
	}


	public String getTraderName() {
		return traderName;
	}


	public void setTraderName(String traderName) {
		this.traderName = traderName;
	}


	public String getTraderId() {
		return traderId;
	}


	public void setTraderId(String traderId) {
		this.traderId = traderId;
	}


	public String getEtNp() {
		return etNp;
	}


	public void setEtNp(String etNp) {
		this.etNp = etNp;
	}


	public Integer getOrigin() {
		return origin;
	}


	public void setOrigin(Integer origin) {
		this.origin = origin;
	}


	public Long getDealNum() {
		return dealNum;
	}


	public void setDealNum(Long dealNum) {
		this.dealNum = dealNum;
	}


	public String getProcessDate() {
		return processDate;
	}


	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	
	
	
	

}
