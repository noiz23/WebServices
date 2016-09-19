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
 * This class maps the PRICING table. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "PRICING")
public class Pricing {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	
	@Column(name = "SIDE_ID", nullable = true)
    protected int sideId;
    
    
	@Column(name = "PRICING_MTM", nullable = true)
    protected double mtm;
    
    
	@Column(name = "PRICING_MTM_CCY", nullable = true)
    protected double mtmCcy;
    
    
	@Column(name = "PRICING_BASE_MTM", nullable = true)
    protected double baseMtm;
    
    
	@Column(name = "PRICING_BASE_MTM_USD", nullable = true)
    protected double baseMtmUsd;
    
    
	@Column(name = "PRICING_DELTA", nullable = true)
    protected double delta;
    
    
	@Column(name = "PRICING_GAMMA", nullable = true)
    protected double gamma;
    
    
	@Column(name = "PRICING_VEGA", nullable = true)
    protected double vega;
    
    
	@Column(name = "PRICING_BETA", nullable = true)
    protected double beta;
    
    
	@Column(name = "PRICING_RHO_LOCAL", nullable = true)
    protected double rhoLocal;
    
    
	@Column(name = "PRICING_RHO_FORANEA", nullable = true)
    protected double rhoForanea;
    
    
	@Column(name = "PRICING_THETA", nullable = true)
    protected double theta;
    
    
	@Column(name = "PRICING_VOLGA", nullable = true)
    protected double volga;
    
    
	@Column(name = "PRICING_PNL", nullable = true)
    protected double pnl;
    
    
	@Column(name = "PRICING_UNREALIZED_PNL", nullable = true)
    protected double unrealizedPnl;
    
    
	@Column(name = "PRICING_PNL_FX_UNREALIZED", nullable = true)
    protected double pnlFxUnrealized;
    
    
	@Column(name = "PRICING_CURRENT_CASH", nullable = true)
    protected double currentCash;
    
    
	@Column(name = "PRICING_BASE_UNREALIZED_PNL", nullable = true)
    protected double baseUnrealizedPnl;
    
    
	@Column(name = "TRANSACTION_ORIGEN", nullable = true)
    protected Integer origin;


    
	@Column(name = "TRANSACTION_DEAL_NUM", nullable = true)
    protected Long dealNum;


    
	@Column(name = "TRANSACTION_PROCESS_DATE", nullable = true)
    protected String processDate;




	public int getSideId() {
		return sideId;
	}




	public void setSideId(int sideId) {
		this.sideId = sideId;
	}




	public double getMtm() {
		return mtm;
	}




	public void setMtm(double mtm) {
		this.mtm = mtm;
	}




	public double getMtmCcy() {
		return mtmCcy;
	}




	public void setMtmCcy(double mtmCcy) {
		this.mtmCcy = mtmCcy;
	}




	public double getBaseMtm() {
		return baseMtm;
	}




	public void setBaseMtm(double baseMtm) {
		this.baseMtm = baseMtm;
	}




	public double getBaseMtmUsd() {
		return baseMtmUsd;
	}




	public void setBaseMtmUsd(double baseMtmUsd) {
		this.baseMtmUsd = baseMtmUsd;
	}




	public double getDelta() {
		return delta;
	}




	public void setDelta(double delta) {
		this.delta = delta;
	}




	public double getGamma() {
		return gamma;
	}




	public void setGamma(double gamma) {
		this.gamma = gamma;
	}




	public double getVega() {
		return vega;
	}




	public void setVega(double vega) {
		this.vega = vega;
	}




	public double getBeta() {
		return beta;
	}




	public void setBeta(double beta) {
		this.beta = beta;
	}




	public double getRhoLocal() {
		return rhoLocal;
	}




	public void setRhoLocal(double rhoLocal) {
		this.rhoLocal = rhoLocal;
	}




	public double getRhoForanea() {
		return rhoForanea;
	}




	public void setRhoForanea(double rhoForanea) {
		this.rhoForanea = rhoForanea;
	}




	public double getTheta() {
		return theta;
	}




	public void setTheta(double theta) {
		this.theta = theta;
	}




	public double getVolga() {
		return volga;
	}




	public void setVolga(double volga) {
		this.volga = volga;
	}




	public double getPnl() {
		return pnl;
	}




	public void setPnl(double pnl) {
		this.pnl = pnl;
	}




	public double getUnrealizedPnl() {
		return unrealizedPnl;
	}




	public void setUnrealizedPnl(double unrealizedPnl) {
		this.unrealizedPnl = unrealizedPnl;
	}




	public double getPnlFxUnrealized() {
		return pnlFxUnrealized;
	}




	public void setPnlFxUnrealized(double pnlFxUnrealized) {
		this.pnlFxUnrealized = pnlFxUnrealized;
	}




	public double getCurrentCash() {
		return currentCash;
	}




	public void setCurrentCash(double currentCash) {
		this.currentCash = currentCash;
	}




	public double getBaseUnrealizedPnl() {
		return baseUnrealizedPnl;
	}




	public void setBaseUnrealizedPnl(double baseUnrealizedPnl) {
		this.baseUnrealizedPnl = baseUnrealizedPnl;
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
