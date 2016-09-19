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
 * This class maps the table EQUIVALENTE_CREDITO. It uses hibernate annotations.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "EQUIVALENTE_CREDITO")
public class EquivalenteCredito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	@Column(name = "EQUIVALENTE_CREDITO_CORPORATIVO", nullable = true)
    protected double creditoCorporativo;
    
	@Column(name = "EQUIVALENTE_CREDITO_NORMATIVO", nullable = true)
    protected double creditoNormativo;
    
	@Column(name = "EQUIVALENTE_CREDITO_FACTOR", nullable = true)
    protected double creditoFactor;
    
	@Column(name = "EQUIVALENTE_CREDITO_FACTOR_INTER", nullable = true)
    protected double creditoFactorInterno;
    
	@Column(name = "EQUIVALENTE_CREDITO_FACTOR_NORMATIVO", nullable = true)
    protected double creditoFactorNormativo;
    
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

	public double getCreditoCorporativo() {
		return creditoCorporativo;
	}

	public void setCreditoCorporativo(double creditoCorporativo) {
		this.creditoCorporativo = creditoCorporativo;
	}

	public double getCreditoNormativo() {
		return creditoNormativo;
	}

	public void setCreditoNormativo(double creditoNormativo) {
		this.creditoNormativo = creditoNormativo;
	}

	public double getCreditoFactor() {
		return creditoFactor;
	}

	public void setCreditoFactor(double creditoFactor) {
		this.creditoFactor = creditoFactor;
	}

	public double getCreditoFactorInterno() {
		return creditoFactorInterno;
	}

	public void setCreditoFactorInterno(double creditoFactorInterno) {
		this.creditoFactorInterno = creditoFactorInterno;
	}

	public double getCreditoFactorNormativo() {
		return creditoFactorNormativo;
	}

	public void setCreditoFactorNormativo(double creditoFactorNormativo) {
		this.creditoFactorNormativo = creditoFactorNormativo;
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
