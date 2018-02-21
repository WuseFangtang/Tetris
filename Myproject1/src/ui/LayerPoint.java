package ui;

import java.awt.Graphics;

public class LayerPoint extends Layer {
	 
	
	 //分数最大位数
	 private static final int POINT_BIT = 5;
	 
	 private static final int LEVEL_UP = 20;

	 /*
	  * 消行y坐标
	  */
	 
	 private final int rmlineY ;
	  
	 /*
	  * 分数y坐标
	  */
	 private final int pointY;
	 
	 /*
	  * 消行x坐标
	  */
	 private final int comX; 
	 
	 /*
	  * 值槽Y坐标
	  */
	 private final int expY;
	 
	 public LayerPoint(int x, int y, int w, int h) {
			super(x, y, w, h);
			
			// 初始化分数显示的X坐标
			this.comX = this.w - IMG_NUMBER_W * POINT_BIT - PADDING;
			// 初始化分数显示的Y坐标
			this.pointY = PADDING;
			// 初始化消行显示的Y坐标
			this.rmlineY = this.pointY + Img.POINT.getHeight(null) + (PADDING << 1); 
			// 初始化值槽显示的Y坐标
			this.expY = this.rmlineY + Img.RMLINE.getHeight(null) + (PADDING << 1);

		}
	 
	 public void paint(Graphics g){
	    	this.createWindow(g);
	    	
	    	//窗口标题（分数）
	    	g.drawImage(Img.POINT,  this.x + PADDING, this.y + pointY, null);
	    	this.drawNumberLeftPad(comX, pointY, this.dto.getNowPoint(), POINT_BIT, g);
	    	//窗口标题（消行）
	    	g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmlineY , null);
	    	this.drawNumberLeftPad(comX, rmlineY, this.dto.getNowRemoveLine(), POINT_BIT, g);
	    	//绘制值槽

	    	int rmLine = this.dto.getNowRemoveLine();
	    	
	    	this.drawRect(expY, "下一级", null, (double) (rmLine % LEVEL_UP) / (double) LEVEL_UP, g);
	    	
	    }
	 

}
