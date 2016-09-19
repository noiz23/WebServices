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
 * This class maps the INTEREST table. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */
@Entity
@Table(name = "INTEREST")
public class Interest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	@Column(name = "SIDE_ID", nullable = true)
	protected int sideId;
	
	@Column(name = "INTEREST_START_DATE", nullable = true)
    protected String startDate;

	@Column(name = "INTEREST_END_DATE", nullable = true)
    protected String endDate;

	@Column(name = "INTEREST_PAYMENT_DATE", nullable = true)
    protected String paymentDate;

	@Column(name = "INTEREST_FIXING_DATE", nullable = true)
    protected String fixingDate;

	@Column(name = "INTEREST_ACCOUNTING_DATE", nullable = true)
    protected String accountingDate;
	
	@Column(name = "INTEREST_RATE", nullable = true)
    protected double rate;
	
	@Column(name = "INTEREST_PAYMENT", nullable = true)
    protected double payment;
	
	@Column(name = "INTEREST_NPV", nullable = true)
    protected double npv;
	
	@Column(name = "INTEREST_FIXING_RATE", nullable = true)
    protected double fixingRate;
	
	@Column(name = "INTEREST_DF", nullable = true)
    protected double df;
    
    @Column(name = "INTEREST_ID", nullable = false)
    protected Integer interestId;

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

	public int getSideId() {
		return sideId;
	}

	public void setSideId(int sideId) {
		this.sideId = sideId;
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

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getFixingDate() {
		return fixingDate;
	}

	public void setFixingDate(String fixingDate) {
		this.fixingDate = fixingDate;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getNpv() {
		return npv;
	}

	public void setNpv(double npv) {
		this.npv = npv;
	}

	public double getFixingRate() {
		return fixingRate;
	}

	public void setFixingRate(double fixingRate) {
		this.fixingRate = fixingRate;
	}

	public double getDf() {
		return df;
	}

	public void setDf(double df) {
		this.df = df;
	}

	public Integer getInterestId() {
		return interestId;
	}

	public void setInterestId(Integer interestId) {
		this.interestId = interestId;
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
