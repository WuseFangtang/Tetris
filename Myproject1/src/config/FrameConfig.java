package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class FrameConfig {
	
	
	private final String title;
	private final int width;
	private final int height; 
	private final int padding;
	
	private final int border; 
	private final int windowUp; 
	private final int letterWidth;
	
	private final int windowWidth; 
	private final int windowHeight;
	
	private static List<LayerConfig> LayersConfig;
	
	public FrameConfig(Element frame){
		
		/*
		 * 获取frame一些参数
		 */
		this.border = Integer.parseInt(frame.attributeValue("border"));
		this.width = Integer.parseInt(frame.attributeValue("width"));
		this.height = Integer.parseInt(frame.attributeValue("height"));
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		this.windowHeight = Integer.parseInt(frame.attributeValue("windowHeight"));
		this.windowWidth = Integer.parseInt(frame.attributeValue("windowWidth"));
		this.letterWidth = Integer.parseInt(frame.attributeValue("letterWidth"));
		this.title = frame.attributeValue("title");
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		
		List<Element> layers = frame.elements("layer");           //注意element和elements的区别 elements返回list
        LayersConfig = new ArrayList<LayerConfig>();
		
		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(
					layer.attributeValue("className"),
					 Integer.parseInt(layer.attributeValue("x")), 
					 Integer.parseInt(layer.attributeValue("y")),
					 Integer.parseInt(layer.attributeValue("w")), 
					 Integer.parseInt(layer.attributeValue("h"))
					);
			LayersConfig.add(lc);
		}
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getBorder() {
		return border;
	}

	public int getWindowUp() {
		return windowUp;
	}

	public int getLetterWidth() {
		return letterWidth;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public static List<LayerConfig> getLayersConfig() {
		return LayersConfig;
	}
	

}
