package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	
	//窗口图片
	public static Image IMG = new ImageIcon ("Graphics/window/window.png").getImage();
	
	public static Image BG = new ImageIcon("Graphics/background/bg02.jpg").getImage();
	
	
	//个人签名
	public static Image SIGN = new ImageIcon("Graphics/string/sign.png").getImage();
	
	 

	 /*
	  * 等级数字
	  */
	 
	public static Image NUMBER = new ImageIcon("Graphics/string/num.png").getImage();

	public static Image POINT = new ImageIcon("Graphics/string/point.png").getImage();
	 
	public static Image RMLINE = new ImageIcon("Graphics/string/rmline.png").getImage();
	
	public static Image DB = new ImageIcon("Graphics/string/db.png").getImage();
	
	public static Image DISK = new ImageIcon("Graphics/string/disk.png").getImage();
	
	public static Image Act = new ImageIcon("Graphics/game/rect.png").getImage();
	
	
	
	 /*
	  * 标题图片
	  */
	public static Image LEVEL = new ImageIcon("Graphics/string/level.png").getImage();  
	
	public static Image SHADOW = new ImageIcon("Graphics/game/shadow.png").getImage();  
	
	 public static Image[] NEXT_ACT; 
	 
	 public static List<Image> BG_LIST;
	 
	 static {
		 //TODO 硬编码
		 //下一个方块图片
		 NEXT_ACT = new Image[7] ;
		 for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("Graphics/game/" + i + ".png").getImage();
		}	 
		//创建背景数组
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<>();
		for (File file: files){
			if (file.isDirectory()) continue;
			BG_LIST.add(new ImageIcon(file.getPath()).getImage());
		}
	 }
	
	private Img(){}
}
