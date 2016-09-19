/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.persistence;

import cl.vmetrix.operation.persistence.model.Cashflow;
import cl.vmetrix.operation.persistence.model.EquivalenteCredito;
import cl.vmetrix.operation.persistence.model.Interest;
import cl.vmetrix.operation.persistence.model.Pricing;
import cl.vmetrix.operation.persistence.model.Profit;
import cl.vmetrix.operation.persistence.model.Side;
import cl.vmetrix.operation.persistence.model.Transaction;
import cl.vmetrix.operation.persistence.model.TransactionInfo;

/**
 * This interface defines the firm of  methods to persist the operation.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 *
 */

public interface OperationDAO {
	
	void persistCashflow(Cashflow cashflow);
	void deleteCashflow(Cashflow cashflow);
	
	void persistInterest(Interest interest);
	void deleteInterest(Interest interest);
	
	void persistEquivCred(EquivalenteCredito equvCred);
	void deleteEquivCred(EquivalenteCredito equvCred);
	
	void persistPricing(Pricing pricing);
	void deletePricing(Pricing pricing);
	
	void persistProfit(Profit profit);
	void deleteProfit(Profit profit);
	
	void persistSide(Side side);
	void deleteSide(Side side);
	
	void persistTranInfo(TransactionInfo transactionInfo);
	void deleteTranInfo(TransactionInfo transactionInfo);
	
	void persistTranSaction(Transaction transaction);
	void deleteTranSaction(Transaction transaction);


}
