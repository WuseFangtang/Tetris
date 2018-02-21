package ui;


import java.awt.Graphics;

import java.awt.Point;


public class LayerGame extends Layer {
	
	 
	 //TODO 配置文件
	 private static int ACT_SIZE = 32;
	 
	 private static final int SIZE_ROL = 5;
	 
	 private static final int LEFT_SIDE = 0;
	 
	 
	 //TODO 硬编码
	 private static final int RIGHT_SIDE = 9;
	
	 public LayerGame(int x, int y, int w, int h) {
			super(x, y, w, h);
		}
	 
     public void paint(Graphics g){
	    	 
	        this.createWindow(g); 
	        
	             
	        //获得方块数组集合
	    	Point[] points = this.dto.getGameAct().getActPoints();
	    	
	    	//TODO 阴影关闭
	    	
	    	this.drawShadow(true, points, g);
	    	if (true){
	    		
	    	}
	    	
	    	//获得方块类型编号0-6
	        int typeCode = this.dto.getGameAct().getTypeCode();
	    	
	    	//打印方块	    	
	    	for (int i = 0; i < points.length; i++){	 
	    	     drawMapByCode(points[i].x, points[i].y, typeCode, g);	    	
			}
	    	
	    	//打印地图
	    	boolean[][] map = this.dto.getGameMap();
	    	
	    	//计算当前堆积颜色
	    	
	    	
	    	int lv = this.dto.getNowlevel(); 
	    	int imgIdx = lv % 7;
	    	//TODO 如果是输的情况 imdIdx = 8
	    	
	    	for (int x = 0; x < map.length; x++){
	    		for (int y = 0 ; y < map[x].length; y++) {
	    			if (map[x][y]){
	    		       drawMapByCode(x, y, imgIdx, g);
	    			}		 
	    		}
	    	}
	     }
     
     /*
      * 绘制阴影
      */
    private void drawShadow(boolean isShowShadow, Point[] points, Graphics g) {
    	if  (!isShowShadow) return;
    	
    	
    	int leftX = RIGHT_SIDE;
    	int rightX = LEFT_SIDE;
    	for (Point p : points){
    		leftX = p.x < leftX ? p.x : leftX;
    		rightX = p.x > rightX ?  p.x : rightX;
    	}
    	g.drawImage(Img.SHADOW,
    			   this.x + BORDER + (leftX << SIZE_ROL), 
    			   this.y + BORDER, 
    			   (rightX - leftX + 1) << SIZE_ROL, 
    			   this.h - (BORDER << 1),
    			   null);
    	
		
	}

	public void drawMapByCode (int x, int y, int drawCode, Graphics g){
    	  g.drawImage(Img.Act, 
  	    		this.x + x * ACT_SIZE + 7, 
  	    		this.y + y * ACT_SIZE + 7, 
  	    		this.x + x * ACT_SIZE + ACT_SIZE + 7, 
  	    		this.y + y * ACT_SIZE + ACT_SIZE + 7, 
  	    		(drawCode+1) * ACT_SIZE, 0, (drawCode+1) * ACT_SIZE + ACT_SIZE, ACT_SIZE, null);	
      }
}
