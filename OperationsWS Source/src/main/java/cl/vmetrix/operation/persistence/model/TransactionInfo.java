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
 * This class maps the TRANSACTION_INFO table.
 * To more  information about the fields of this class, read the section 4 of the user manual.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */

@Entity
@Table(name = "TRANSACTION_INFO")
public class TransactionInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	protected int id;
	
	@Column(name = "CANAL_TRANSACCIONAL_ID", nullable = true)
	protected int canalTransaccionalId;
	
	@Column(name = "MEDIO_TRANSACCIONAL_ID", nullable = true)
    protected int transactionalID;
    
	@Column(name = "TRANSACTION_INFO_TC_COSTO", nullable = true)
    protected double tcCosto;
    
	@Column(name = "TRANSACTION_INFO_TC_CLIENTE", nullable = true)
    protected double tcCliente;
    
	@Column(name = "TRANSACTION_INFO_PARIDAD_COSTO", nullable = true)
    protected double paridadCosto;
    
	@Column(name = "TRANSACTION_INFO_PARIDAD_CLIENTE", nullable = true)
    protected double paridadCliente;
    
	@Column(name = "TRANSACTION_INFO_SPREAD_TC", nullable = true)
    protected double spreadTc;
    
	@Column(name = "TRANSACTION_INFO_SPREAD_PARIDAD", nullable = true)
    protected double spreadParidad;
    
	@Column(name = "TRANSACTION_INFO_FX_SPOT_CLIENTE", nullable = true)
    protected double fxSpotCliente;
    
	@Column(name = "TRANSACTION_INFO_FX_FWD_COSTO", nullable = true)
    protected double fxForwardCosto;
    
	@Column(name = "TRANSACTION_INFO_FX_FWD_CLIENTE", nullable = true)
    protected double fxForwardCliente;
    
	@Column(name = "TRANSACTION_INFO_PUNTOS_FWD", nullable = true)
    protected double puntosFwd;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_SPOT", nullable = true)
    protected double fxUfSpot;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_TASA_COSTO", nullable = true)
    protected double fxUfTasaCosto;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_TASA_MARGEN", nullable = true)
    protected double fxUfTasaMargen;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_TASA_CLIENTE", nullable = true)
    protected double fxUfTasaCliente;
    
	@Column(name = "TRANSACTION_INFO_FX_SPOT_MARGEN", nullable = true)
    protected double fxSpotMargen;
    
	@Column(name = "TRANSACTION_INFO_FX_FWD_MARGEN", nullable = true)
    protected double fxFwdMargen;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_TASA_SUCIA_COSTO", nullable = true)
    protected double fxUfTasaSuciaCosto;
    
	@Column(name = "TRANSACTION_INFO_FX_UF_TASA_SUCIA_CLIENTE", nullable = true)
    protected double fxUfTasaSuciaCliente;

	@Column(name = "TRANSACTION_INFO_REFERENCE", nullable = true)
    protected String reference;

	@Column(name = "TRANSACTION_INFO_NOMBRE_CLIENTE", nullable = true)
    protected String nombreCliente;

	@Column(name = "TRANSACTION_INFO_ID_CLIENTE", nullable = true)
    protected String idCliente;

	@Column(name = "TRANSACTION_INFO_INDICADOR_FX", nullable = true)
    protected String indicadorFx;

	@Column(name = "TRANSACTION_INFO_OBSERVACIONES", nullable = true)
    protected String observaciones;

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

	public int getCanalTransaccionalId() {
		return canalTransaccionalId;
	}

	public void setCanalTransaccionalId(int canalTransaccionalId) {
		this.canalTransaccionalId = canalTransaccionalId;
	}

	public int getTransactionalID() {
		return transactionalID;
	}

	public void setTransactionalID(int transactionalID) {
		this.transactionalID = transactionalID;
	}

	public double getTcCosto() {
		return tcCosto;
	}

	public void setTcCosto(double tcCosto) {
		this.tcCosto = tcCosto;
	}

	public double getTcCliente() {
		return tcCliente;
	}

	public void setTcCliente(double tcCliente) {
		this.tcCliente = tcCliente;
	}

	public double getParidadCosto() {
		return paridadCosto;
	}

	public void setParidadCosto(double paridadCosto) {
		this.paridadCosto = paridadCosto;
	}

	public double getParidadCliente() {
		return paridadCliente;
	}

	public void setParidadCliente(double paridadCliente) {
		this.paridadCliente = paridadCliente;
	}

	public double getSpreadTc() {
		return spreadTc;
	}

	public void setSpreadTc(double spreadTc) {
		this.spreadTc = spreadTc;
	}

	public double getSpreadParidad() {
		return spreadParidad;
	}

	public void setSpreadParidad(double spreadParidad) {
		this.spreadParidad = spreadParidad;
	}

	public double getFxSpotCliente() {
		return fxSpotCliente;
	}

	public void setFxSpotCliente(double fxSpotCliente) {
		this.fxSpotCliente = fxSpotCliente;
	}

	public double getFxForwardCosto() {
		return fxForwardCosto;
	}

	public void setFxForwardCosto(double fxForwardCosto) {
		this.fxForwardCosto = fxForwardCosto;
	}

	public double getFxForwardCliente() {
		return fxForwardCliente;
	}

	public void setFxForwardCliente(double fxForwardCliente) {
		this.fxForwardCliente = fxForwardCliente;
	}

	public double getPuntosFwd() {
		return puntosFwd;
	}

	public void setPuntosFwd(double puntosFwd) {
		this.puntosFwd = puntosFwd;
	}

	public double getFxUfSpot() {
		return fxUfSpot;
	}

	public void setFxUfSpot(double fxUfSpot) {
		this.fxUfSpot = fxUfSpot;
	}

	public double getFxUfTasaCosto() {
		return fxUfTasaCosto;
	}

	public void setFxUfTasaCosto(double fxUfTasaCosto) {
		this.fxUfTasaCosto = fxUfTasaCosto;
	}

	public double getFxUfTasaMargen() {
		return fxUfTasaMargen;
	}

	public void setFxUfTasaMargen(double fxUfTasaMargen) {
		this.fxUfTasaMargen = fxUfTasaMargen;
	}

	public double getFxUfTasaCliente() {
		return fxUfTasaCliente;
	}

	public void setFxUfTasaCliente(double fxUfTasaCliente) {
		this.fxUfTasaCliente = fxUfTasaCliente;
	}

	public double getFxSpotMargen() {
		return fxSpotMargen;
	}

	public void setFxSpotMargen(double fxSpotMargen) {
		this.fxSpotMargen = fxSpotMargen;
	}

	public double getFxFwdMargen() {
		return fxFwdMargen;
	}

	public void setFxFwdMargen(double fxFwdMargen) {
		this.fxFwdMargen = fxFwdMargen;
	}

	public double getFxUfTasaSuciaCosto() {
		return fxUfTasaSuciaCosto;
	}

	public void setFxUfTasaSuciaCosto(double fxUfTasaSuciaCosto) {
		this.fxUfTasaSuciaCosto = fxUfTasaSuciaCosto;
	}

	public double getFxUfTasaSuciaCliente() {
		return fxUfTasaSuciaCliente;
	}

	public void setFxUfTasaSuciaCliente(double fxUfTasaSuciaCliente) {
		this.fxUfTasaSuciaCliente = fxUfTasaSuciaCliente;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getIndicadorFx() {
		return indicadorFx;
	}

	public void setIndicadorFx(String indicadorFx) {
		this.indicadorFx = indicadorFx;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
