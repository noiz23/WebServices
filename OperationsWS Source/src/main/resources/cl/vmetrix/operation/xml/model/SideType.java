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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sideType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sideType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="currencyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rateTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="yieldBasisId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="curCurrencyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notional" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rateSpread" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="frecPago" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="resetP" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fixFlt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="projectionIndex" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sideId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sideType", propOrder = {
    "currencyId",
    "rateTypeId",
    "yieldBasisId",
    "curCurrencyId",
    "type",
    "notional",
    "rate",
    "rateSpread",
    "frecPago",
    "resetP",
    "fixFlt",
    "projectionIndex"
})
public class SideType {

    protected int currencyId;
    protected int rateTypeId;
    protected int yieldBasisId;
    protected int curCurrencyId;
    @XmlElement(required = true)
    protected String type;
    protected double notional;
    protected double rate;
    protected double rateSpread;
    protected double frecPago;
    protected double resetP;
    @XmlElement(required = true)
    protected String fixFlt;
    @XmlElement(required = true)
    protected String projectionIndex;
    @XmlAttribute(name = "sideId")
    protected Integer sideId;

    /**
     * Gets the value of the currencyId property.
     * 
     */
    public int getCurrencyId() {
        return currencyId;
    }

    /**
     * Sets the value of the currencyId property.
     * 
     */
    public void setCurrencyId(int value) {
        this.currencyId = value;
    }

    /**
     * Gets the value of the rateTypeId property.
     * 
     */
    public int getRateTypeId() {
        return rateTypeId;
    }

    /**
     * Sets the value of the rateTypeId property.
     * 
     */
    public void setRateTypeId(int value) {
        this.rateTypeId = value;
    }

    /**
     * Gets the value of the yieldBasisId property.
     * 
     */
    public int getYieldBasisId() {
        return yieldBasisId;
    }

    /**
     * Sets the value of the yieldBasisId property.
     * 
     */
    public void setYieldBasisId(int value) {
        this.yieldBasisId = value;
    }

    /**
     * Gets the value of the curCurrencyId property.
     * 
     */
    public int getCurCurrencyId() {
        return curCurrencyId;
    }

    /**
     * Sets the value of the curCurrencyId property.
     * 
     */
    public void setCurCurrencyId(int value) {
        this.curCurrencyId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the notional property.
     * 
     */
    public double getNotional() {
        return notional;
    }

    /**
     * Sets the value of the notional property.
     * 
     */
    public void setNotional(double value) {
        this.notional = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     */
    public double getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     */
    public void setRate(double value) {
        this.rate = value;
    }

    /**
     * Gets the value of the rateSpread property.
     * 
     */
    public double getRateSpread() {
        return rateSpread;
    }

    /**
     * Sets the value of the rateSpread property.
     * 
     */
    public void setRateSpread(double value) {
        this.rateSpread = value;
    }

    /**
     * Gets the value of the frecPago property.
     * 
     */
    public double getFrecPago() {
        return frecPago;
    }

    /**
     * Sets the value of the frecPago property.
     * 
     */
    public void setFrecPago(double value) {
        this.frecPago = value;
    }

    /**
     * Gets the value of the resetP property.
     * 
     */
    public double getResetP() {
        return resetP;
    }

    /**
     * Sets the value of the resetP property.
     * 
     */
    public void setResetP(double value) {
        this.resetP = value;
    }

    /**
     * Gets the value of the fixFlt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixFlt() {
        return fixFlt;
    }

    /**
     * Sets the value of the fixFlt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixFlt(String value) {
        this.fixFlt = value;
    }

    /**
     * Gets the value of the projectionIndex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectionIndex() {
        return projectionIndex;
    }

    /**
     * Sets the value of the projectionIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectionIndex(String value) {
        this.projectionIndex = value;
    }

    /**
     * Gets the value of the sideId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSideId() {
        return sideId;
    }

    /**
     * Sets the value of the sideId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSideId(Integer value) {
        this.sideId = value;
    }

}
