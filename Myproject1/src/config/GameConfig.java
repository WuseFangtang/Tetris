package config;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/*
 * 游戏配置器
 */

public class GameConfig {

	private static FrameConfig FRAME_CONFIG= null;
	
	private static DataConfig DATA_CONFIG = null;
	
	private static SystemConfig SYSTEM_CONFIG = null;
	
	static{
		
		try {
			SAXReader reader = new SAXReader(); //XML读取器
			Document doc = reader.read("config/cfg.xml"); //获得整个cfg.xml文件
			Element game = doc.getRootElement(); //拿到game标签体里所有东西
			
			//创建对象
			FRAME_CONFIG = new FrameConfig(game.element("frame"));
			
			//创建数据对象
			DATA_CONFIG = new DataConfig(game.element("system"));
			
			//创建系统对象
			SYSTEM_CONFIG = new SystemConfig(game.element("data"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*
	 * 构造器私有化
	 */
	 
	private GameConfig(){
		
	}
	
	
	/*
	 * 获得窗口配置
	 */
	public static FrameConfig getFrameConfig(){
		return FRAME_CONFIG;
	}
	
	/*
	 * 获得系统配置
	 */
	
	public static SystemConfig getSystemConfig(){
		return SYSTEM_CONFIG;
	}
	
	/*
	 * 获得数据配置
	 */
	public static DataConfig getDataConfig(){
		return DATA_CONFIG;
	}
}
