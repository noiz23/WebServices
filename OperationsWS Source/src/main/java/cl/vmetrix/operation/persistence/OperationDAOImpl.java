/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import cl.vmetrix.operation.persistence.model.Cashflow;
import cl.vmetrix.operation.persistence.model.EquivalenteCredito;
import cl.vmetrix.operation.persistence.model.Interest;
import cl.vmetrix.operation.persistence.model.Pricing;
import cl.vmetrix.operation.persistence.model.Profit;
import cl.vmetrix.operation.persistence.model.Side;
import cl.vmetrix.operation.persistence.model.Transaction;
import cl.vmetrix.operation.persistence.model.TransactionInfo;


/**
 * This class implements the methods to persist or delete the operation, using hibernate SessionFactory.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 * 
 */
@Repository("operationDAO")
public class OperationDAOImpl implements OperationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistCashflow(Cashflow cashflow) {
		sessionFactory.getCurrentSession().persist(cashflow);
		cashflow = null;
	}

	@Override
	public void persistInterest(Interest interest) {
		sessionFactory.getCurrentSession().persist(interest);
		interest = null;

	}

	@Override
	public void persistEquivCred(EquivalenteCredito equvCred) {
		sessionFactory.getCurrentSession().persist(equvCred);
		equvCred = null;

	}

	@Override
	public void persistPricing(Pricing pricing) {
		sessionFactory.getCurrentSession().persist(pricing);
		pricing = null;

	}

	@Override
	public void persistProfit(Profit profit) {
		sessionFactory.getCurrentSession().persist(profit);
		profit = null;

	}

	@Override
	public void persistSide(Side side) {
		sessionFactory.getCurrentSession().persist(side);
		side = null;

	}

	@Override
	public void persistTranInfo(TransactionInfo transactionInfo) {
		sessionFactory.getCurrentSession().persist(transactionInfo);
		transactionInfo = null;

	}

	@Override
	public void persistTranSaction(Transaction transaction) {
		sessionFactory.getCurrentSession().persist(transaction);
		transaction = null;

	}

	/* Delete methods */

	@Override
	public void deleteCashflow(Cashflow cashflow) {
		// sessionFactory.getCurrentSession().delete(cashflow);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Cashflow where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(cashflow.getProcessDate()));

		query.executeUpdate();
		cashflow = null;
		query = null;

	}

	@Override
	public void deleteInterest(Interest interest) {
		// sessionFactory.getCurrentSession().delete(interest);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Interest where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(interest.getProcessDate()));

		query.executeUpdate();
		interest = null;
		query = null;

	}

	@Override
	public void deleteEquivCred(EquivalenteCredito equvCred) {
		// sessionFactory.getCurrentSession().delete(equvCred);
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"delete EquivalenteCredito where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(equvCred.getProcessDate()));

		query.executeUpdate();
		equvCred = null;
		query = null;

	}

	@Override
	public void deletePricing(Pricing pricing) {
		// sessionFactory.getCurrentSession().delete(pricing);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Pricing where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(pricing.getProcessDate()));

		query.executeUpdate();
		pricing = null;
		query = null;

	}

	@Override
	public void deleteProfit(Profit profit) {
		// sessionFactory.getCurrentSession().delete(profit);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Profit where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(profit.getProcessDate()));

		query.executeUpdate();
		profit = null;
		query = null;

	}

	@Override
	public void deleteSide(Side side) {
		// sessionFactory.getCurrentSession().delete(side);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Side where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(side.getProcessDate()));

		query.executeUpdate();
		side = null;
		query = null;

	}

	@Override
	public void deleteTranInfo(TransactionInfo transactionInfo) {
		// sessionFactory.getCurrentSession().delete(transactionInfo);
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"delete TransactionInfo where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date",
				String.valueOf(transactionInfo.getProcessDate()));

		query.executeUpdate();
		transactionInfo = null;
		query = null;

	}

	@Override
	public void deleteTranSaction(Transaction transaction) {
		// sessionFactory.getCurrentSession().delete(transaction);
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete Transaction where TRANSACTION_PROCESS_DATE = :date");
		query.setString("date", String.valueOf(transaction.getProcessDate()));

		query.executeUpdate();
		transaction = null;
		query = null;

	}

}
