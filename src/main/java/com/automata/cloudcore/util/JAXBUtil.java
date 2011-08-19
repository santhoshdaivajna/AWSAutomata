package com.automata.cloudcore.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import com.automata.cloudcore.constants.Constants;
import com.automata.cloudcore.xmlbindings.Automata;

public class JAXBUtil {

	public static Automata unmarshall(String fileName) throws JAXBException,
			FileNotFoundException {

		Automata automata = null;
		JAXBContext context = null;
		Unmarshaller unmarshaller = null;
		FileInputStream fileInputStream = null;
		JAXBElement<Automata> automataElement = null;

		context = JAXBContext.newInstance(Constants.XML_BINDINGS_PACKAGENAME);
		// System.out.println(jc.toString());
		unmarshaller = context.createUnmarshaller();
		// unmarshaller.setSchema(SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema").newSchema(new
		// File("Automata.xsd")));
		// unmarshaller.setEventHandler(new
		// javax.xml.bind.helpers.DefaultValidationEventHandler());
		fileInputStream = new FileInputStream(fileName);
		automataElement = (JAXBElement<Automata>) unmarshaller
				.unmarshal(fileInputStream);
		if (automataElement != null) {
			automata = automataElement.getValue();
		}
		return automata;
	}

	public static void marshall(Object obj) throws JAXBException {

		Marshaller marshaller;
		JAXBContext context = null;
		JAXBElement<Automata> automataElement = null;

		context = JAXBContext.newInstance(Constants.XML_BINDINGS_PACKAGENAME);
		marshaller = context.createMarshaller();
		automataElement = new JAXBElement<Automata>(new QName("",
				"automata"), Automata.class, (Automata) obj);
		marshaller.marshal(automataElement, System.out);
	}
	
	public static String marshallAsString( JAXBContext pContext, Object obj)
	throws JAXBException {

		java.io.StringWriter sw = new StringWriter();

		Marshaller marshaller = pContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(new JAXBElement<Automata>( new QName("", "automata"), Automata.class, (Automata)obj ), sw);

		return sw.toString();
	}
}
