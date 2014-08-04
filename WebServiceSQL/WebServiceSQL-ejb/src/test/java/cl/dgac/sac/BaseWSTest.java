package cl.dgac.sac;

import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseWSTest {

	private static final String CONF_FILE_NAME = "adobe_ws.properties";
	
	protected static Properties conf;
	protected static String url;
	protected static String nameSpace;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conf = new Properties();
		
		conf.load(BaseWSTest.class.getClassLoader().getResourceAsStream(CONF_FILE_NAME));
	
		url = "http://" + conf.getProperty("adobe.ws.host") + ":" + conf.getProperty("adobe.ws.port") + 
				"/" + conf.getProperty("adobe.ws.module") + "/";
				
		nameSpace = conf.getProperty("adobe.ws.namespace");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
}
