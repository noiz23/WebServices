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
 * <p>Java class for interestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="interestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sideId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paymentDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fixingDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accountingDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="payment" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="npv" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fixingRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="df" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="interestId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "interestType", propOrder = {
    "sideId",
    "startDate",
    "endDate",
    "paymentDate",
    "fixingDate",
    "accountingDate",
    "rate",
    "payment",
    "npv",
    "fixingRate",
    "df"
})
public class InterestType {

    protected int sideId;
    @XmlElement(required = true)
    protected String startDate;
    @XmlElement(required = true)
    protected String endDate;
    @XmlElement(required = true)
    protected String paymentDate;
    @XmlElement(required = true)
    protected String fixingDate;
    @XmlElement(required = true)
    protected String accountingDate;
    protected double rate;
    protected double payment;
    protected double npv;
    protected double fixingRate;
    protected double df;
    @XmlAttribute(name = "interestId")
    protected Integer interestId;

    /**
     * Gets the value of the sideId property.
     * 
     */
    public int getSideId() {
        return sideId;
    }

    /**
     * Sets the value of the sideId property.
     * 
     */
    public void setSideId(int value) {
        this.sideId = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the paymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets the value of the paymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDate(String value) {
        this.paymentDate = value;
    }

    /**
     * Gets the value of the fixingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFixingDate() {
        return fixingDate;
    }

    /**
     * Sets the value of the fixingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFixingDate(String value) {
        this.fixingDate = value;
    }

    /**
     * Gets the value of the accountingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountingDate() {
        return accountingDate;
    }

    /**
     * Sets the value of the accountingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountingDate(String value) {
        this.accountingDate = value;
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
     * Gets the value of the payment property.
     * 
     */
    public double getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     */
    public void setPayment(double value) {
        this.payment = value;
    }

    /**
     * Gets the value of the npv property.
     * 
     */
    public double getNpv() {
        return npv;
    }

    /**
     * Sets the value of the npv property.
     * 
     */
    public void setNpv(double value) {
        this.npv = value;
    }

    /**
     * Gets the value of the fixingRate property.
     * 
     */
    public double getFixingRate() {
        return fixingRate;
    }

    /**
     * Sets the value of the fixingRate property.
     * 
     */
    public void setFixingRate(double value) {
        this.fixingRate = value;
    }

    /**
     * Gets the value of the df property.
     * 
     */
    public double getDf() {
        return df;
    }

    /**
     * Sets the value of the df property.
     * 
     */
    public void setDf(double value) {
        this.df = value;
    }

    /**
     * Gets the value of the interestId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInterestId() {
        return interestId;
    }

    /**
     * Sets the value of the interestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInterestId(Integer value) {
        this.interestId = value;
    }

}
