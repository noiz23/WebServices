/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.persistence;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cl.vmetrix.operation.persistence.model.Cashflow;
import cl.vmetrix.operation.persistence.model.EquivalenteCredito;
import cl.vmetrix.operation.persistence.model.Interest;
import cl.vmetrix.operation.persistence.model.Pricing;
import cl.vmetrix.operation.persistence.model.Profit;
import cl.vmetrix.operation.persistence.model.Side;
import cl.vmetrix.operation.persistence.model.Transaction;
import cl.vmetrix.operation.persistence.model.TransactionInfo;

/**
 * This class OperationServiceImp implements the methods required to persist or delete an 
 * operation in the DB.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 */
@Service("operationService")
public class OperationServiceImp implements OperationService {

	final static Logger logger = Logger.getLogger(OperationServiceImp.class);
			
	 @Autowired
	 OperationDAO operationDAO;
	
	 
	@Override
	@Transactional
	public void persistCashflow(List<Cashflow> cashflow) {
		for(Cashflow data : cashflow){
			operationDAO.persistCashflow(data);
			data=null;
		
		}
		cashflow=null;

	}

	@Override
	@Transactional
	public void persistInterest(List<Interest> interestList) {
		for(Interest data : interestList){
			operationDAO.persistInterest(data);
			data=null;
		
		}
		interestList=null;
		
	}

	@Override
	@Transactional
	public void persistEquivCred(EquivalenteCredito equvCred) {
		operationDAO.persistEquivCred(equvCred);
		equvCred=null;
		
	}

	@Override
	@Transactional
	public void persistPricing(List<Pricing> pricingList) {
		for(Pricing pr: pricingList){
			operationDAO.persistPricing(pr);
			pr=null;
	}
		pricingList=null;
		
	}

	@Override
	@Transactional
	public void persistProfit(Profit profit) {
		operationDAO.persistProfit(profit);
		profit=null;
		
	}

	@Override
	@Transactional
	public void persistSide(List<Side> side) {
		for(Side sd: side){
			operationDAO.persistSide(sd);
			sd=null;
		}
		side=null;
		
		
	}

	@Override
	@Transactional
	public void persistTranInfo(TransactionInfo transactionInfo) {
		operationDAO.persistTranInfo(transactionInfo);
		transactionInfo=null;
		
	}

	@Override
	@Transactional
	public void persistTranSaction(Transaction transaction) {
		operationDAO.persistTranSaction(transaction);
		transaction=null;
		
	}
	
	/* Delete methods: */

	@Override
	@Transactional
	public void deleteCashflow(List<Cashflow> cashflow) {
		for(Cashflow data : cashflow){
			operationDAO.deleteCashflow(data);
			data=null;
		}
		cashflow=null;
		
	}

	@Override
	@Transactional
	public void deleteInterest(List<Interest> interestList) {
		for(Interest data : interestList){
			operationDAO.deleteInterest(data);
			data=null;
		}
		interestList=null;
		
	}

	@Override
	@Transactional
	public void deleteEquivCred(EquivalenteCredito equvCred) {
		operationDAO.deleteEquivCred(equvCred);
		equvCred=null;
	}

	@Override
	@Transactional
	public void deletePricing(List<Pricing> pricingList) {
		for(Pricing pr: pricingList){
			operationDAO.deletePricing(pr);
			pr=null;
	}
		pricingList=null;
		
	}

	@Override
	@Transactional
	public void deleteProfit(Profit profit) {
		operationDAO.deleteProfit(profit);
		profit=null;
		
	}

	@Override
	@Transactional
	public void deleteSide(List<Side> side) {
		for(Side sd: side){
			operationDAO.deleteSide(sd);
			sd=null;
		}
		side=null;
		
	}

	@Override
	@Transactional
	public void deleteTranInfo(TransactionInfo transactionInfo) {
		operationDAO.deleteTranInfo(transactionInfo);
		transactionInfo=null;
		
	}

	@Override
	@Transactional
	public void deleteTranSaction(Transaction transaction) {
		operationDAO.deleteTranSaction(transaction);
		transaction=null;
		
	}

}
