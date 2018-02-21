package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import Dto.Player;

abstract public class LayerData extends Layer {
	
	// TODO 最大数据行 配置文件
	private static final int MAX_ROW = 5;
	
	//起始Y坐标
	private static int START_Y = 0;
	
	private static final int RECT_H = IMG_RECT_H + 4;
	
	//间距
	private static int SPA ;
	
	protected LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		SPA = (this.h - (IMG_RECT_H + 4) * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW; 
		
		START_Y = PADDING + Img.DB.getHeight(null) + SPA;
	}

	@Override
	abstract public void paint(Graphics g);
	
	/*
	 * 绘制所有值槽
	 * @param imgTitle 标题图片
	 * @param players 
	 * @param g
	 */
	public void showData(Image imgTitle, List<Player> players, Graphics g){

    	g.drawImage(imgTitle, this.x + PADDING, this.y + PADDING, null);

    	int nowPoint = this.dto.getNowPoint();
    	for (int i = 0; i < MAX_ROW; i++){
            
    		Player pla = players.get(i);
    		int recodePoint = pla.getPoint();
    	    double percent = (double) nowPoint / (double) pla.getPoint();
    		percent = percent > 1? 1.0 :percent;
            String strPoint = recodePoint == 0 ? null : Integer.toString(recodePoint);    	
            		this.drawRect(START_Y + i * (RECT_H + SPA), 
    				pla.getName(),strPoint , 
    				percent, g);
 
    	}

	}
}
