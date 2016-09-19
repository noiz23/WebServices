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
import cl.vmetrix.operation.persistence.model.Cashflow;
import cl.vmetrix.operation.persistence.model.EquivalenteCredito;
import cl.vmetrix.operation.persistence.model.Interest;
import cl.vmetrix.operation.persistence.model.Pricing;
import cl.vmetrix.operation.persistence.model.Profit;
import cl.vmetrix.operation.persistence.model.Side;
import cl.vmetrix.operation.persistence.model.Transaction;
import cl.vmetrix.operation.persistence.model.TransactionInfo;

/**
 * The interface OperationService has the firm of the methods to 
 * persist or delete operations in the DB.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 */
public interface OperationService {
	/**
	 * Save the cashflow data of the operation in the Table CASHFLOW of the DB.
	 * @param cashflowList is the list of cashflows to save in  the DB.  
	 */
	void persistCashflow(List<Cashflow> cashflowList);
	
	/**
	 * Delete the cashflow data of the operation from Table CASHFLOW of the DB.
	 * @param cashflowList is the list of cashflows to delete from  the DB.  
	 */
	void deleteCashflow(List<Cashflow>  cashflowList);
	
	
	/**
	 * Save the interest data of the operation in the Table INTEREST of the DB.
	 * @param interestList is the list of interest to save in  the DB.  
	 */
	void persistInterest(List<Interest> interestList);
	
	/**
	 * Delete the interest data of the operation from Table INTEREST of the DB.
	 * @param interestList is the list of interest to delete from DB.  
	 */
	void deleteInterest(List<Interest> interestList);
	
	
	/**
	 * Save the "equivalente credito"  data of the operation in the Table EQUIVALENTE_CREDITO of the DB.
	 * @param equvCred is the Equivalente_credito data to save in  the DB.  
	 */
	void persistEquivCred(EquivalenteCredito equvCred);
	
	/**
	 * Delete the "equivalente credito" data of the operation from Table EQUIVALENTE_CREDITO of the DB.
	 * @param equvCred is the Equivalente_credito data to delete from DB.  
	 */
	void deleteEquivCred(EquivalenteCredito equvCred);
	
	
	/**
	 * Save the pricing  data of the operation in the Table PRICING of the DB.
	 * @param pricing is the Pricing data to save in  the DB.  
	 */
	void persistPricing(List<Pricing> pricing);
	
	/**
	 * Delete the pricing data of the operation from Table PRICING of the DB.
	 * @param pricing is the Pricing data to delete from DB.  
	 */
	void deletePricing(List<Pricing> pricing);
	
	
	/**
	 * Save the profit  data of the operation in the Table PROFIT of the DB.
	 * @param profit is the Profit data to save in  the DB.  
	 */
	void persistProfit(Profit profit);
	
	/**
	 * Delete the profit data of the operation in the Table PROFIT from DB.
	 * @param profit is the profit data to delete from DB.  
	 */
	void deleteProfit(Profit profit);
	
	
	/**
	 * Save the side  data of the operation in the Table SIDE of the DB.
	 * @param side is the  list of data to save in  the DB.  
	 */
	void persistSide(List<Side> side);
	
	/**
	 * Delete the side data of the operation from Table SIDE of the DB.
	 * @param side is the list of  data to delete from  the DB.  
	 */
	void deleteSide(List<Side>  side);
	
	
	/**
	 * Save the "transactio info"  data of the operation in the Table TRANSACTION_INFO of the DB.
	 * @param transactionInfo is the  data to save in  the DB.  
	 */
	void persistTranInfo(TransactionInfo transactionInfo);
	/**
	 * Delete the "transactio info" data of the operation from Table TRANSACTION_INFO in the DB.
	 * @param transactionInfo is the  data to delete from  the DB. 
	 */
	void deleteTranInfo(TransactionInfo transactionInfo);
	
	
	/**
	 * Save the transaction  data of the operation in the Table TRANSACTIONT of the DB.
	 * @param transaction is the  data to save in  the DB.  
	 */
	void persistTranSaction(Transaction transaction);
	/**
	 * Delete the transaction data of the operation from Table TRANSACTIONT in the DB.
	 * @param transaction is the  data to delete from  the DB. 
	 */
	void deleteTranSaction(Transaction transaction);	
	
}
