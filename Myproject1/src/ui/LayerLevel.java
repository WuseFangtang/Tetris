package ui;

import java.awt.Graphics;


public class LayerLevel extends Layer {

	 /*
	  * 图片居中位置
	  */
	 private static final int IMG_LV_W = Img.LEVEL.getWidth(null);
	
	 
	 public LayerLevel(int x, int y, int w, int h) {
			super(x, y, w, h);
		}
	 
	 public void paint(Graphics g){
	   	    this.createWindow(g);
	   	    //窗口标题
	   	    int centerX =  (this.w - IMG_LV_W >> 1);
	   	    g.drawImage(Img.LEVEL, this.x +centerX, this.y + PADDING, null);
	    
	        //显示等级
	   	    drawNumberLeftPad(centerX, 64, this.dto.getNowlevel(), 2, g);   
	 
	 }
}
