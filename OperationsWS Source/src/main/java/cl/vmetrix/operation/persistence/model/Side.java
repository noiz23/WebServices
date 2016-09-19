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
 * 
 * This class maps the SIDE table. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "SIDE")
public class Side {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	@Column(name = "CURRENCY_ID", nullable = true)
	protected int currencyId;
	
	
	@Column(name = "RATE_TYPE_ID", nullable = true)
    protected int rateTypeId;
    
    
	@Column(name = "YIELD_BASIS_ID", nullable = true)
    protected int yieldBasisId;
    
    
	@Column(name = "CUR_CURRENCY_ID", nullable = true)
    protected int curCurrencyId;


    
	@Column(name = "SIDE_TYPE", nullable = true)
    protected String type;
    
    
	@Column(name = "SIDE_NOTIONAL", nullable = true)
    protected double notional;
    
    
	@Column(name = "SIDE_RATE", nullable = true)
    protected double rate;
    
    
	@Column(name = "SIDE_RATE_SPREAD", nullable = true)
    protected double rateSpread;
    
    
	@Column(name = "SIDE_FREC_PAGO", nullable = true)
    protected double frecPago;
    
    
	@Column(name = "SIDE_RESET_P", nullable = true)
    protected double resetP;
   
    
	@Column(name = "SIDE_FIX_FLT", nullable = true)
    protected String fixFlt;

    
    
	@Column(name = "SIDE_PROJECTION_INDEX", nullable = true)
    protected String projectionIndex;


    
	@Column(name = "SIDE_ID", nullable = true)
    protected Integer sideId;

    
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


	public int getRateTypeId() {
		return rateTypeId;
	}


	public void setRateTypeId(int rateTypeId) {
		this.rateTypeId = rateTypeId;
	}


	public int getYieldBasisId() {
		return yieldBasisId;
	}


	public void setYieldBasisId(int yieldBasisId) {
		this.yieldBasisId = yieldBasisId;
	}


	public int getCurCurrencyId() {
		return curCurrencyId;
	}


	public void setCurCurrencyId(int curCurrencyId) {
		this.curCurrencyId = curCurrencyId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getNotional() {
		return notional;
	}


	public void setNotional(double notional) {
		this.notional = notional;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getRateSpread() {
		return rateSpread;
	}


	public void setRateSpread(double rateSpread) {
		this.rateSpread = rateSpread;
	}


	public double getFrecPago() {
		return frecPago;
	}


	public void setFrecPago(double frecPago) {
		this.frecPago = frecPago;
	}


	public double getResetP() {
		return resetP;
	}


	public void setResetP(double resetP) {
		this.resetP = resetP;
	}


	public String getFixFlt() {
		return fixFlt;
	}


	public void setFixFlt(String fixFlt) {
		this.fixFlt = fixFlt;
	}


	public String getProjectionIndex() {
		return projectionIndex;
	}


	public void setProjectionIndex(String projectionIndex) {
		this.projectionIndex = projectionIndex;
	}


	public Integer getSideId() {
		return sideId;
	}


	public void setSideId(Integer sideId) {
		this.sideId = sideId;
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
