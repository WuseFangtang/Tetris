package config;

import java.util.List;

import org.dom4j.Element;

public class DataConfig {

	private final DataInterfaceConfig dataA;
	private final DataInterfaceConfig dataB;
	


	public DataConfig (Element data){
		dataA = new DataInterfaceConfig(data.element("dataA"));
		dataB = new DataInterfaceConfig(data.element("dataA"));
	}	
	
	public DataInterfaceConfig getDataA() {
		return dataA;
	}

	public DataInterfaceConfig getDataB() {
		return dataB;
	}
}
