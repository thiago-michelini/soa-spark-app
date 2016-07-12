package org.soaspark.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.soaspark.main.Application;

@Singleton
public class JAXBUtil {

	private static JAXBContext ctx;
	private static Marshaller marshaller;
	private static Unmarshaller unmarshaller;
	
	private JAXBUtil() {
		inicializarJAXBContexto();
	}
	
	private void inicializarJAXBContexto() {
		if (null != ctx || (null == Application.POJOsJAXB || Application.POJOsJAXB.isEmpty()))
			return;
		
		try {
			Class<?>[] arr = {};
			ctx = JAXBContextFactory.createContext(Application.POJOsJAXB.toArray(arr), null);
	
			marshaller = ctx.createMarshaller();
			marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
			
			unmarshaller = ctx.createUnmarshaller();
			unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
			unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
	
	public synchronized <T> T unmarshaller(String json, Class<T> clazz) throws JAXBException {
		StreamSource ss = new StreamSource(new StringReader(json));
		return unmarshaller.unmarshal(ss, clazz).getValue();
	}
	
	public synchronized String marshaller(Object jaxbElement) throws JAXBException {
		StringWriter sw = new StringWriter();
		marshaller.marshal(jaxbElement, sw);
		return sw.toString();
	}
	
}
