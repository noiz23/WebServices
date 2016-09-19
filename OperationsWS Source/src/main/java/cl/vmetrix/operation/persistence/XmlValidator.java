/*******************************************************************************
 * Copyright (c) 2016 VMetrix SPA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package cl.vmetrix.operation.persistence;


import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.List;
import java.io.*;
import java.util.LinkedList;

/**
 * This class validates a string XML against XSD schema.
 * 
 * @author REcheverri
 * @version 1.0 30/08/2016
 *
 */
public class XmlValidator {
	final static Logger logger = Logger.getLogger(XmlValidator.class);
	
//	public static void main(String[] args) throws Exception {
	
	/**
	 * The method validatorXMLstg determinate if the String XML is correct. 
	 * @return a boolean (true or false) to indicate if the XML is correct.
	 * @param xml is the String XML to validate against XSD Schema
	 * @throws SAXException
	 * @throws IOException
	 */
	
	public boolean  validateXMLstg(String xml) throws SAXException, IOException{
	String rpta ="";
	
	boolean validation = true;
		try {
						
			xml = new String(xml.getBytes("UTF-8"));
			
//			System.out.println("---> XML in UTF-8: "+ xml);
			// convert String into InputStream
			InputStream is = new ByteArrayInputStream(xml.getBytes());

			Source xmlFile = new StreamSource(is);//new File("C:/XML/424437.xml"));
			
			// XSD schema
			String schemea = getFileSchema("operationSchema.xsd");
			
			InputStream sch = new ByteArrayInputStream(schemea.getBytes());
			
			Source schemaFile = new StreamSource(sch);//new File("main/resources/Operation.xsd"));

			// Preparing the schema
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaFile);

			// Validator creation
			Validator validator = schema.newValidator();

			// DException handle of validator
			final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
			validator.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception)
						throws SAXException {
					exceptions.add(exception);
				}

				@Override
				public void fatalError(SAXParseException exception)
						throws SAXException {
					exceptions.add(exception);
				}

				@Override
				public void error(SAXParseException exception)
						throws SAXException {
					exceptions.add(exception);
				}
			});

			// XML validation
			validator.validate(xmlFile);

			// Validation result. If there are errors, detailed the exact position in the XML  and the error
			if (exceptions.size() == 0) {
				rpta="XML IS VALID";
			} else {
				validation = false;
				StringBuffer sb = new StringBuffer();
				sb.append("XML IS INVALID");
				sb.append("\n");
				sb.append("NUMBER OF ERRORS: " + exceptions.size());
				sb.append("\n");
				for (int i = 0; i < exceptions.size(); i++) {
					i = i + 1;
					sb.append("Error # " + i + ":");
					sb.append("\n");
					i = i - 1;
					sb.append("    - Line: "+ ((SAXParseException) exceptions.get(i)).getLineNumber());
					sb.append("\n");
					sb.append("    - Column: "	+ ((SAXParseException) exceptions.get(i)).getColumnNumber());
					sb.append("\n");
					sb.append("    - Error message: "+ ((Throwable) exceptions.get(i)).getLocalizedMessage());
					sb.append("\n");
					sb.append("------------------------------");
				}
				rpta = sb.toString();
				logger.debug(rpta);
				
			}
		} catch (SAXException e) {
			logger.error("SAXException in XML validator: ",e);
			logger.debug(rpta);
			throw new SAXException(e);
		} catch (IOException e) {
			logger.error("IOException in XML validator: ", e);
			logger.debug(rpta);
			throw new IOException(e);
		}
		
		return validation;
	}
	
	/*
	 * The method getFileSchema look for the xsd file in the 
	 * resources carpet of the project.
	 * 
	 * @parameter fileName is the name of the .xsd file.
	 * @return the content of the .xsd file in String format.
	 * @throws IOException
	 */
	 private String getFileSchema(String fileName) throws IOException{

		  String result = "";

		  ClassLoader classLoader = getClass().getClassLoader();
		  try {
			result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
		  } catch (IOException e) {
			throw new IOException(e);
		  }

		  return result;

	  }
}
