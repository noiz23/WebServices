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
 * This class maps the PROFIT table. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "PROFIT")
public class Profit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	
	@Column(name = "CURRENCY_ID", nullable = true)
	protected int currencyId;
	
	
	@Column(name = "PROFIT_VALUE", nullable = true)
    protected double value;
    
    
	@Column(name = "PROFIT_CCY", nullable = true)
    protected int ccy;
    
    
	@Column(name = "PROFIT_MESA_CLIENTES_CLP", nullable = true)
    protected double mesaClientesCLP;
    
    
	@Column(name = "PROFIT_MESA_TRADING_CLP", nullable = true)
    protected double mesaTradingClp;
    
    
	@Column(name = "PROFIT_MESA_CLIENTES_USD", nullable = true)
    protected double mesaClientesUsd;
    
    
	@Column(name = "PROFIT_MESA_TRADING_USD", nullable = true)
    protected double mesaTradingUsd;
    
    
    
	@Column(name = "PROFIT_TOTAL_USD", nullable = true)
    protected double totalUsd;
    
    
    
	@Column(name = "PROFIT_TOTAL_CLP", nullable = true)
    protected double totalClp;

    
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


	public int getCurrencyId() {
		return currencyId;
	}


	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public int getCcy() {
		return ccy;
	}


	public void setCcy(int ccy) {
		this.ccy = ccy;
	}


	public double getMesaClientesCLP() {
		return mesaClientesCLP;
	}


	public void setMesaClientesCLP(double mesaClientesCLP) {
		this.mesaClientesCLP = mesaClientesCLP;
	}


	public double getMesaTradingClp() {
		return mesaTradingClp;
	}


	public void setMesaTradingClp(double mesaTradingClp) {
		this.mesaTradingClp = mesaTradingClp;
	}


	public double getMesaClientesUsd() {
		return mesaClientesUsd;
	}


	public void setMesaClientesUsd(double mesaClientesUsd) {
		this.mesaClientesUsd = mesaClientesUsd;
	}


	public double getMesaTradingUsd() {
		return mesaTradingUsd;
	}


	public void setMesaTradingUsd(double mesaTradingUsd) {
		this.mesaTradingUsd = mesaTradingUsd;
	}


	public double getTotalUsd() {
		return totalUsd;
	}


	public void setTotalUsd(double totalUsd) {
		this.totalUsd = totalUsd;
	}


	public double getTotalClp() {
		return totalClp;
	}


	public void setTotalClp(double totalClp) {
		this.totalClp = totalClp;
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
