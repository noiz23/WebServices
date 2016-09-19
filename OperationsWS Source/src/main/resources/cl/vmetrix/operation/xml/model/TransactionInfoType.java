/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.08.25 at 03:35:48 PM PYT 
//


package cl.vmetrix.operation.xml.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transactionInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="canalTransaccionalId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="medioTransactionalID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tcCosto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tcCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="paridadCosto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="paridadCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="spreadTc" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="spreadParidad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxSpotCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxForwardCosto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxForwardCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="puntosFwd" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfSpot" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfTasaCosto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfTasaMargen" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfTasaCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxSpotMargen" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxFwdMargen" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfTasaSuciaCosto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fxUfTasaSuciaCliente" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombreCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idCliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="indicadorFx" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="observaciones" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionInfoType", propOrder = {
    "canalTransaccionalId",
    "medioTransactionalID",
    "tcCosto",
    "tcCliente",
    "paridadCosto",
    "paridadCliente",
    "spreadTc",
    "spreadParidad",
    "fxSpotCliente",
    "fxForwardCosto",
    "fxForwardCliente",
    "puntosFwd",
    "fxUfSpot",
    "fxUfTasaCosto",
    "fxUfTasaMargen",
    "fxUfTasaCliente",
    "fxSpotMargen",
    "fxFwdMargen",
    "fxUfTasaSuciaCosto",
    "fxUfTasaSuciaCliente",
    "reference",
    "nombreCliente",
    "idCliente",
    "indicadorFx",
    "observaciones"
})
public class TransactionInfoType {

    protected int canalTransaccionalId;
    protected int medioTransactionalID;
    protected double tcCosto;
    protected double tcCliente;
    protected double paridadCosto;
    protected double paridadCliente;
    protected double spreadTc;
    protected double spreadParidad;
    protected double fxSpotCliente;
    protected double fxForwardCosto;
    protected double fxForwardCliente;
    protected double puntosFwd;
    protected double fxUfSpot;
    protected double fxUfTasaCosto;
    protected double fxUfTasaMargen;
    protected double fxUfTasaCliente;
    protected double fxSpotMargen;
    protected double fxFwdMargen;
    protected double fxUfTasaSuciaCosto;
    protected double fxUfTasaSuciaCliente;
    @XmlElement(required = true)
    protected String reference;
    @XmlElement(required = true)
    protected String nombreCliente;
    @XmlElement(required = true)
    protected String idCliente;
    @XmlElement(required = true)
    protected String indicadorFx;
    @XmlElement(required = true)
    protected String observaciones;

    /**
     * Gets the value of the canalTransaccionalId property.
     * 
     */
    public int getCanalTransaccionalId() {
        return canalTransaccionalId;
    }

    /**
     * Sets the value of the canalTransaccionalId property.
     * 
     */
    public void setCanalTransaccionalId(int value) {
        this.canalTransaccionalId = value;
    }

    /**
     * Gets the value of the medioTransactionalID property.
     * 
     */
    public int getMedioTransactionalID() {
        return medioTransactionalID;
    }

    /**
     * Sets the value of the medioTransactionalID property.
     * 
     */
    public void setMedioTransactionalID(int value) {
        this.medioTransactionalID = value;
    }

    /**
     * Gets the value of the tcCosto property.
     * 
     */
    public double getTcCosto() {
        return tcCosto;
    }

    /**
     * Sets the value of the tcCosto property.
     * 
     */
    public void setTcCosto(double value) {
        this.tcCosto = value;
    }

    /**
     * Gets the value of the tcCliente property.
     * 
     */
    public double getTcCliente() {
        return tcCliente;
    }

    /**
     * Sets the value of the tcCliente property.
     * 
     */
    public void setTcCliente(double value) {
        this.tcCliente = value;
    }

    /**
     * Gets the value of the paridadCosto property.
     * 
     */
    public double getParidadCosto() {
        return paridadCosto;
    }

    /**
     * Sets the value of the paridadCosto property.
     * 
     */
    public void setParidadCosto(double value) {
        this.paridadCosto = value;
    }

    /**
     * Gets the value of the paridadCliente property.
     * 
     */
    public double getParidadCliente() {
        return paridadCliente;
    }

    /**
     * Sets the value of the paridadCliente property.
     * 
     */
    public void setParidadCliente(double value) {
        this.paridadCliente = value;
    }

    /**
     * Gets the value of the spreadTc property.
     * 
     */
    public double getSpreadTc() {
        return spreadTc;
    }

    /**
     * Sets the value of the spreadTc property.
     * 
     */
    public void setSpreadTc(double value) {
        this.spreadTc = value;
    }

    /**
     * Gets the value of the spreadParidad property.
     * 
     */
    public double getSpreadParidad() {
        return spreadParidad;
    }

    /**
     * Sets the value of the spreadParidad property.
     * 
     */
    public void setSpreadParidad(double value) {
        this.spreadParidad = value;
    }

    /**
     * Gets the value of the fxSpotCliente property.
     * 
     */
    public double getFxSpotCliente() {
        return fxSpotCliente;
    }

    /**
     * Sets the value of the fxSpotCliente property.
     * 
     */
    public void setFxSpotCliente(double value) {
        this.fxSpotCliente = value;
    }

    /**
     * Gets the value of the fxForwardCosto property.
     * 
     */
    public double getFxForwardCosto() {
        return fxForwardCosto;
    }

    /**
     * Sets the value of the fxForwardCosto property.
     * 
     */
    public void setFxForwardCosto(double value) {
        this.fxForwardCosto = value;
    }

    /**
     * Gets the value of the fxForwardCliente property.
     * 
     */
    public double getFxForwardCliente() {
        return fxForwardCliente;
    }

    /**
     * Sets the value of the fxForwardCliente property.
     * 
     */
    public void setFxForwardCliente(double value) {
        this.fxForwardCliente = value;
    }

    /**
     * Gets the value of the puntosFwd property.
     * 
     */
    public double getPuntosFwd() {
        return puntosFwd;
    }

    /**
     * Sets the value of the puntosFwd property.
     * 
     */
    public void setPuntosFwd(double value) {
        this.puntosFwd = value;
    }

    /**
     * Gets the value of the fxUfSpot property.
     * 
     */
    public double getFxUfSpot() {
        return fxUfSpot;
    }

    /**
     * Sets the value of the fxUfSpot property.
     * 
     */
    public void setFxUfSpot(double value) {
        this.fxUfSpot = value;
    }

    /**
     * Gets the value of the fxUfTasaCosto property.
     * 
     */
    public double getFxUfTasaCosto() {
        return fxUfTasaCosto;
    }

    /**
     * Sets the value of the fxUfTasaCosto property.
     * 
     */
    public void setFxUfTasaCosto(double value) {
        this.fxUfTasaCosto = value;
    }

    /**
     * Gets the value of the fxUfTasaMargen property.
     * 
     */
    public double getFxUfTasaMargen() {
        return fxUfTasaMargen;
    }

    /**
     * Sets the value of the fxUfTasaMargen property.
     * 
     */
    public void setFxUfTasaMargen(double value) {
        this.fxUfTasaMargen = value;
    }

    /**
     * Gets the value of the fxUfTasaCliente property.
     * 
     */
    public double getFxUfTasaCliente() {
        return fxUfTasaCliente;
    }

    /**
     * Sets the value of the fxUfTasaCliente property.
     * 
     */
    public void setFxUfTasaCliente(double value) {
        this.fxUfTasaCliente = value;
    }

    /**
     * Gets the value of the fxSpotMargen property.
     * 
     */
    public double getFxSpotMargen() {
        return fxSpotMargen;
    }

    /**
     * Sets the value of the fxSpotMargen property.
     * 
     */
    public void setFxSpotMargen(double value) {
        this.fxSpotMargen = value;
    }

    /**
     * Gets the value of the fxFwdMargen property.
     * 
     */
    public double getFxFwdMargen() {
        return fxFwdMargen;
    }

    /**
     * Sets the value of the fxFwdMargen property.
     * 
     */
    public void setFxFwdMargen(double value) {
        this.fxFwdMargen = value;
    }

    /**
     * Gets the value of the fxUfTasaSuciaCosto property.
     * 
     */
    public double getFxUfTasaSuciaCosto() {
        return fxUfTasaSuciaCosto;
    }

    /**
     * Sets the value of the fxUfTasaSuciaCosto property.
     * 
     */
    public void setFxUfTasaSuciaCosto(double value) {
        this.fxUfTasaSuciaCosto = value;
    }

    /**
     * Gets the value of the fxUfTasaSuciaCliente property.
     * 
     */
    public double getFxUfTasaSuciaCliente() {
        return fxUfTasaSuciaCliente;
    }

    /**
     * Sets the value of the fxUfTasaSuciaCliente property.
     * 
     */
    public void setFxUfTasaSuciaCliente(double value) {
        this.fxUfTasaSuciaCliente = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the nombreCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Sets the value of the nombreCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreCliente(String value) {
        this.nombreCliente = value;
    }

    /**
     * Gets the value of the idCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Sets the value of the idCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCliente(String value) {
        this.idCliente = value;
    }

    /**
     * Gets the value of the indicadorFx property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorFx() {
        return indicadorFx;
    }

    /**
     * Sets the value of the indicadorFx property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorFx(String value) {
        this.indicadorFx = value;
    }

    /**
     * Gets the value of the observaciones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Sets the value of the observaciones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

}
