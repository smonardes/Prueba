package cl.dgac.sac.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cl.corfo.webServiceSQL.model.AdobeTexto;
import cl.corfo.webServiceSQL.services.TextoServicesWS;
import cl.dgac.sac.BaseWSTest;

public class TextosWSTest extends BaseWSTest {

	private static final Logger log = Logger.getLogger(TextosWSTest.class);
	
	private static TextoServicesWS portTextosServices;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseWSTest.setUpBeforeClass();
		
		String nameTextos = conf.getProperty("adobe.ws.name.textos");
		String serviceNameTextos = conf.getProperty("adobe.ws.service.name.textos");
				
		String wsdlTextos = serviceNameTextos + "/" + nameTextos + "?wsdl";
				
		URL wsdlLocationTextos = new URL(url + wsdlTextos);
		QName serviceQNameTextos = new QName(nameSpace, serviceNameTextos);		
		
		Service serviceTexto = Service.create(wsdlLocationTextos, serviceQNameTextos);
		portTextosServices = serviceTexto.getPort(TextoServicesWS.class);		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuscarAerolineas() {
		try {
			List<AdobeTexto> result = portTextosServices.buscarTextos(null);		
			assertNotNull(result);
			
			for (AdobeTexto texto : result) {
				log.info("Codigo: " + texto.getId());
			}			
		} catch (Exception e) {
			log.error(e.getMessage());
			fail(e.getMessage());
		}
	}	
	
}
