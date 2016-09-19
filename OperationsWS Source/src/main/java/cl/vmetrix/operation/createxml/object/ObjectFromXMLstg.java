/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package cl.vmetrix.operation.createxml.object;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.Logger;
import cl.vmetrix.operation.xml.model.OperationType;

/**
 * This class is used to create objects from Strings (XML).
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 *
 */
public class ObjectFromXMLstg {
	final static Logger logger = Logger.getLogger(ObjectFromXMLstg.class);
	
	/**
	 * The method createOperationObj, returns the corresponding  OperationType object from
	 * the String g (XML).
	 * 
	 * @param g is the XML in String format
	 * 
	 * @return an object type OperationType that represents the g XML String.
	 * 
	 * @throws JAXBException
	 */
	public static OperationType createOperationObj(String g) throws JAXBException{
		JAXBContext jc;
		OperationType operacion = null;
		try {
			jc = JAXBContext.newInstance(OperationType.class);
		
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		StreamSource streamSource = new StreamSource(new StringReader(g));
		JAXBElement<OperationType> je = unmarshaller.unmarshal(streamSource,OperationType.class);
		operacion = (OperationType) je.getValue();
		
		} catch (JAXBException e) {
			logger.error("JAXBException in ObjectFromXMLstg.operationObj", e);
			logger.error("Excepton unmarshaller the xml: "+ g);
			throw new JAXBException(e);
		}
		
		return operacion;
		
	}

}
