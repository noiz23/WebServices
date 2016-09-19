/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.channels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.vmetrix.operation.createxml.object.ObjectFromXMLstg;
import cl.vmetrix.operation.persistence.OperationService;
import cl.vmetrix.operation.persistence.XmlValidator;
import cl.vmetrix.operation.persistence.model.Cashflow;
import cl.vmetrix.operation.persistence.model.EquivalenteCredito;
import cl.vmetrix.operation.persistence.model.Interest;
import cl.vmetrix.operation.persistence.model.Pricing;
import cl.vmetrix.operation.persistence.model.Profit;
import cl.vmetrix.operation.persistence.model.Side;
import cl.vmetrix.operation.persistence.model.Transaction;
import cl.vmetrix.operation.persistence.model.TransactionInfo;
import cl.vmetrix.operation.xml.model.CashFlowType;
import cl.vmetrix.operation.xml.model.EquivalenteCreditoType;
import cl.vmetrix.operation.xml.model.InterestType;
import cl.vmetrix.operation.xml.model.OperationType;
import cl.vmetrix.operation.xml.model.PricingType;
import cl.vmetrix.operation.xml.model.ProfitType;
import cl.vmetrix.operation.xml.model.SideType;
import cl.vmetrix.operation.xml.model.TransactionInfoType;
import cl.vmetrix.operation.xml.model.TransactionType;
import cl.vmetrix.webservices.channels.Channel;
import cl.vmetrix.webservices.proxy.VMWebServiceException;

/**
 * 
 * This class obtains an object from XML (string) and calls the persistence
 * functionality.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 *
 */
public class OperationCh implements Channel {

	final static Logger logger = Logger.getLogger(OperationCh.class);
	private static int origin=23;
	private static String processDate="";
	private static Long dealNum=(long) 0;
	List<CashFlowType> listCashflow;
	OperationType operation;

	@Override
	public boolean processMessage(String msg) throws VMWebServiceException {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OperationService operationService = (OperationService) context.getBean("operationService");
		logger.debug("Getting object from XML...");
		XmlValidator xmlv = new XmlValidator();
		
		try {
			if (xmlv.validateXMLstg(msg)) {
				
				
				try {
						logger.debug("XML Validation...OK!.");
						logger.debug("String XML is valid...start process...");
						operation = ObjectFromXMLstg.createOperationObj(msg);
						
				} catch (JAXBException e) {
					logger.error("JAXBException in ObjectFromXMLstg.operation", e);
					logger.error("JAXBException unmarshaller the xml: " + msg);
					throw new VMWebServiceException("Exception processing this xml: "+ msg,e);
				}catch (Exception e) {
					logger.error("Exception in ObjectFromXMLstg.operation", e);
					logger.error("Exception unmarshaller the xml: " + msg);
					throw new VMWebServiceException("Exception processing this xml: "+ msg,e);
				}

				logger.debug("Start persistent process....");
				
				origin = operation.getOrigin();
				processDate = operation.getProcessDate();
				dealNum = operation.getDealNum();

				try {
					if (operation.getCashFlow() != null	&& operation.getCashFlow().size() > 0)
						operationService.persistCashflow(mappingCasflow(operation.getCashFlow()));

					if (operation.getInterest() != null	&& operation.getInterest().size() > 0)
						operationService.persistInterest(mappingInterest(operation.getInterest()));

					operationService.persistEquivCred(mappingEquivCred(operation.getEquivalenteCredito()));

					operationService.persistPricing(mappingPricing(operation.getPricing()));

					operationService.persistProfit(mappingProfit(operation.getProfit()));

					operationService.persistSide(mappingSide(operation.getSide()));
					
					operationService.persistTranInfo(mappingTranInfo(operation.getTransactionInfo()));
					
					operationService.persistTranSaction(mappingTransaction(operation.getTransaction()));
					
				}  catch (Exception e) {
					logger.error("Exception saving operation. Could not process message", e);
					rollbackDB(operationService, operation);
					throw new VMWebServiceException("Exception processing this xml: "+ msg,e);
				}

				return true;

			} else {
				logger.debug("XML is not valid...stop process.");
				throw new VMWebServiceException("XML is not valid...stop process.");
			}
		
		} catch (Exception e) {
			logger.error("Exception processing the operation. Could not process message", e);
			throw new VMWebServiceException("Exception processing this xml: "+ msg,e);
		}finally{
			if(context!=null){
				logger.debug("Closing context..");
				context.close();
			}
			operationService = null;
			xmlv=null;
			operation=null;
			logger.debug("End persistent operation.");
		}
		
	}

	private void rollbackDB(OperationService operationService,OperationType operation) {
		logger.debug("Deleting data..");
		if (operation.getCashFlow() != null	&& operation.getCashFlow().size() > 0)
			operationService.deleteCashflow(mappingCasflow(operation.getCashFlow()));

		if (operation.getInterest() != null	&& operation.getInterest().size() > 0)
			operationService.deleteInterest(mappingInterest(operation.getInterest()));

		operationService.deleteEquivCred(mappingEquivCred(operation.getEquivalenteCredito()));

		operationService.deletePricing(mappingPricing(operation.getPricing()));

		operationService.deleteProfit(mappingProfit(operation.getProfit()));

		operationService.deleteSide(mappingSide(operation.getSide()));
		
		operationService.deleteTranInfo(mappingTranInfo(operation.getTransactionInfo()));
		
		operationService.deleteTranSaction(mappingTransaction(operation.getTransaction()));
		
		logger.debug("All data with process date = "+processDate +" was deleted..");
	}

	/**
	 * Transforms the transaction data into persistent object, to save them in the DB.
	 * 
	 * @param transaction is the transaction data in JAXB object.
	 * @return transaction data in persistent object.
	 */
	private Transaction mappingTransaction(TransactionType transaction) {
		Transaction trs = new Transaction();
		trs.setCallPutId(transaction.getCallPutId());
		trs.setDealNum(dealNum);
		trs.setEndDate(transaction.getEndDate());
		trs.setEt(transaction.getEt());
		trs.setEtNp(transaction.getEtNp());
		trs.setFacilityId(transaction.getFacilityId());
		trs.setGroupId(transaction.getGroupId());
//		trs.setId(id);
		trs.setInstrumentId(transaction.getInstrumentId());
		trs.setModalidadPago(transaction.getModalidadPago());
		trs.setNemo(transaction.getNemo());
		trs.setOffsetTranType(transaction.getOffsetTranType());
		trs.setOrigin(origin);
		trs.setPartyId(transaction.getPartyId());
		trs.setPartySecuencia(transaction.getPartySecuencia());
		trs.setPaymentConvId(transaction.getPaymentConvId());
		trs.setPortFolio(transaction.getPortFolio());
		trs.setProcessDate(processDate);
		trs.setSerie(transaction.getSerie());
		trs.setStartDate(transaction.getStartDate());
		trs.setStatusId(transaction.getStatusId());
		trs.setStrike(transaction.getStrike());
		trs.setTirCompra(transaction.getTirCompra());
		trs.setTirMercado(transaction.getTirMercado());
		trs.setTradeDate(transaction.getTradeDate());
		trs.setTraderId(transaction.getTraderId());
		trs.setTraderName(transaction.getTraderName());
		

		return trs;
	}

	/**
	 * Transforms the "Transaction Info" data into persistent object, to save them in the DB.
	 * 
	 * @param transactionInfo is the "Transaction Info" data in JAXB object.
	 * @return "Transaction Info" data in persistent object.
	 */
	private TransactionInfo mappingTranInfo(TransactionInfoType transactionInfo) {
		TransactionInfo tranInfo = new TransactionInfo();
		tranInfo.setCanalTransaccionalId(transactionInfo.getCanalTransaccionalId());
		tranInfo.setDealNum(dealNum);
		tranInfo.setFxForwardCliente(transactionInfo.getFxForwardCliente());
		tranInfo.setFxForwardCosto(transactionInfo.getFxForwardCosto());
		tranInfo.setFxFwdMargen(transactionInfo.getFxFwdMargen());
		tranInfo.setFxSpotCliente(transactionInfo.getFxSpotCliente());
		tranInfo.setFxSpotMargen(transactionInfo.getFxFwdMargen());
		tranInfo.setFxUfSpot(transactionInfo.getFxUfSpot());
		tranInfo.setFxUfTasaCliente(transactionInfo.getFxUfTasaCliente());
		tranInfo.setFxUfTasaCosto(transactionInfo.getFxUfTasaCosto());
		tranInfo.setFxUfTasaMargen(transactionInfo.getFxUfTasaMargen());
		tranInfo.setFxUfTasaSuciaCliente(transactionInfo.getFxUfTasaSuciaCliente());
		tranInfo.setFxUfTasaSuciaCosto(transactionInfo.getFxUfTasaSuciaCosto());
//		tranInfo.setId(id);
		tranInfo.setIdCliente(transactionInfo.getIdCliente());
		tranInfo.setIndicadorFx(transactionInfo.getIndicadorFx());
		tranInfo.setNombreCliente(transactionInfo.getNombreCliente());
		tranInfo.setObservaciones(transactionInfo.getObservaciones());
		tranInfo.setOrigin(origin);
		tranInfo.setParidadCliente(transactionInfo.getParidadCliente());
		tranInfo.setParidadCosto(transactionInfo.getParidadCosto());
		tranInfo.setProcessDate(processDate);
		tranInfo.setPuntosFwd(transactionInfo.getPuntosFwd());
		tranInfo.setReference(transactionInfo.getReference());
		tranInfo.setSpreadParidad(transactionInfo.getSpreadParidad());
		tranInfo.setSpreadTc(transactionInfo.getSpreadTc());
		tranInfo.setTcCliente(transactionInfo.getTcCliente());
		tranInfo.setTcCosto(transactionInfo.getParidadCosto());
		tranInfo.setTransactionalID(transactionInfo.getCanalTransaccionalId());
		
		
		return tranInfo;
	}

	/**
	 * Transforms the side data into persistent object, to save them in the DB.
	 * 
	 * @param side is the side data in JAXB object.
	 * @return side data in persistent object.
	 */
	private List<Side> mappingSide(List<SideType> side) {
		List<Side> sideList= new ArrayList<Side>();
		
		for(SideType st: side){
				Side sd = new Side();
				sd.setCurCurrencyId(st.getCurCurrencyId());
				sd.setCurrencyId(st.getCurrencyId());
				sd.setDealNum(dealNum);
				sd.setFixFlt(st.getFixFlt());
				sd.setFrecPago(st.getFrecPago());
//				sd.setId(id);
				sd.setNotional(st.getNotional());
				sd.setOrigin(origin);
				sd.setProcessDate(processDate);
				sd.setProjectionIndex(st.getProjectionIndex());
				sd.setRate(st.getRate());
				sd.setRateSpread(st.getRateSpread());
				sd.setRateTypeId(st.getRateTypeId());
				sd.setResetP(st.getResetP());
				sd.setSideId(st.getSideId());
				sd.setType(st.getType());
				sd.setYieldBasisId(st.getYieldBasisId());
				
				sideList.add(sd);
		
		}
		
		return sideList;
	}

	/**
	 * Transforms the profit data into persistent object, to save them in the DB.
	 * 
	 * @param profit is the profit data in JAXB object.
	 * @return profit data in persistent object.
	 */
	private Profit mappingProfit(ProfitType profit) {
		Profit prf = new Profit();
		prf.setCcy(profit.getCcy());
		prf.setCurrencyId(profit.getCurrencyId());
		prf.setDealNum(dealNum);
		// prf.setId(id);
		prf.setMesaClientesCLP(profit.getMesaClientesCLP());
		prf.setMesaClientesUsd(profit.getMesaClientesUsd());
		prf.setMesaTradingClp(profit.getMesaTradingClp());
		prf.setMesaTradingUsd(profit.getMesaClientesUsd());
		prf.setOrigin(origin);
		prf.setProcessDate(processDate);
		prf.setTotalClp(profit.getTotalClp());
		prf.setTotalUsd(profit.getTotalUsd());
		prf.setValue(profit.getValue());

		return prf;
	}
	
	
	/**
	 * Transforms the pricing data into persistent object, to save them in the DB.
	 * 
	 * @param pricingList is the list of pricing data in JAXB object.
	 * @return A list of pricing in persistent object.
	 */
	private List<Pricing> mappingPricing(List<PricingType> pricingList) {
		List<Pricing> prcList = new ArrayList<Pricing>();

		for (PricingType prTy : pricingList) {
			Pricing prc = new Pricing();

			prc.setBaseMtm(prTy.getBaseMtm());
			prc.setBaseMtmUsd(prTy.getBaseMtmUsd());
			prc.setBaseUnrealizedPnl(prTy.getBaseUnrealizedPnl());
			prc.setBeta(prTy.getBeta());
			prc.setCurrentCash(prTy.getCurrentCash());
			prc.setDealNum(dealNum);
			prc.setDelta(prTy.getDelta());
			prc.setGamma(prTy.getGamma());
			prc.setMtm(prTy.getMtm());
			prc.setMtmCcy(prTy.getMtmCcy());
			prc.setOrigin(origin);
			prc.setPnl(prTy.getPnl());
			prc.setPnlFxUnrealized(prTy.getPnlFxUnrealized());
			prc.setProcessDate(processDate);
			prc.setRhoForanea(prTy.getRhoForanea());
			prc.setRhoLocal(prTy.getRhoLocal());
			prc.setSideId(prTy.getSideId());
			prc.setTheta(prTy.getTheta());
			prc.setUnrealizedPnl(prTy.getUnrealizedPnl());
			prc.setVega(prTy.getVega());
			prc.setVolga(prTy.getVolga());

			prcList.add(prc);

		}

		return prcList;
	}

	/**
	 * Transforms the "Equivalente de Credito" data into persistent object, to save them in the DB.
	 * 
	 * @param equivalenteCredito is the "Equivalente de Credito" in JAXB object.
	 * @return A "Equivalente de Credito" in persistent object.
	 */
	private EquivalenteCredito mappingEquivCred(
			EquivalenteCreditoType equivalenteCredito) {
		EquivalenteCredito equvCred = new EquivalenteCredito();

		equvCred.setCreditoCorporativo(equivalenteCredito.getCreditoCorporativo());
		equvCred.setCreditoFactor(equivalenteCredito.getCreditoFactor());
		equvCred.setCreditoFactorInterno(equivalenteCredito
				.getCreditoFactorInterno());
		equvCred.setCreditoFactorNormativo(equivalenteCredito
				.getCreditoFactorNormativo());
		equvCred.setCreditoNormativo(equivalenteCredito.getCreditoNormativo());
		equvCred.setDealNum(dealNum);
		// equvCred.setId(id);
		equvCred.setOrigin(origin);
		equvCred.setProcessDate(processDate);

		return equvCred;
	}

	/**
	 * Transforms the Interest data into persistent object, to save them in the DB
	 * 
	 * @param interest is the list of Interest in JAXB object.
	 * @return A list o interest in persistent object.
	 */
	private List<Interest> mappingInterest(List<InterestType> interest) {
		logger.debug("Mapping Interest objects...");
		List<Interest> rpta = new ArrayList<Interest>();

		for (InterestType intType : interest) {
			Interest ints = new Interest();
			ints.setAccountingDate(intType.getAccountingDate());
			ints.setDealNum(dealNum);
			ints.setDf(intType.getDf());
			ints.setEndDate(intType.getEndDate());
			ints.setFixingDate(intType.getFixingDate());
			ints.setFixingRate(intType.getFixingRate());
			// ints.setId(id);
			ints.setInterestId(intType.getInterestId());
			ints.setNpv(intType.getNpv());
			ints.setOrigin(origin);
			ints.setPayment(intType.getPayment());
			ints.setPaymentDate(intType.getPaymentDate());
			ints.setProcessDate(processDate);
			ints.setRate(intType.getRate());
			ints.setSideId(intType.getSideId());
			ints.setStartDate(intType.getStartDate());

			rpta.add(ints);

		}

		return rpta;
	}

	/**
	 * Transforms the cashflow data into persistent object, to save them in the DB
	 * 
	 * @param listCashflow is the list of cashflow in JAXB object.
	 * @return A list o cashflow in persistent object.
	 */
	private List<Cashflow> mappingCasflow(List<CashFlowType> listCashflow) {
		logger.debug("Mapping Casflow objects...");
		List<Cashflow> rpta = new ArrayList<Cashflow>();

		for (CashFlowType csType : listCashflow) {
			Cashflow cf = new Cashflow();
			cf.setAccountingDate(csType.getAccountingDate());
			cf.setAmount(csType.getAmount());
			cf.setCashFlowId(csType.getCashFlowId());
			cf.setCashFlowTypeId(csType.getCashFlowTypeId());
			cf.setDealNum(dealNum);
			cf.setDf(csType.getDf());
			cf.setEndDate(csType.getEndDate());
			cf.setFixingDate(csType.getFixingDate());
			cf.setFixingRate(csType.getFixingRate());
			// cf.setId(id);
			cf.setNpv(csType.getNpv());
			cf.setOrigin(origin);
			cf.setProcessDate(processDate);
			cf.setSideId(csType.getSideId());
			cf.setStartDate(csType.getStartDate());

			rpta.add(cf);

		}

		return rpta;
	}

}
