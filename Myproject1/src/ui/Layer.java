package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import Dto.GameDto;
import config.FrameConfig;
import config.GameConfig;

//绘制窗口
abstract public class Layer {
	
	
	/*
	 * 内边距
	 */
    protected static final int PADDING ;
    /*
     * 边框宽度
     */
    
    protected static final int BORDER;
    
	protected static final int LETTERWIDTH ;
	protected static final int WINDOWWIDTH ;
	protected static final int WINDOWHEIGHT ;
	static {
		 //获得游戏配置
		FrameConfig cfg = GameConfig.getFrameConfig();
		LETTERWIDTH = cfg.getLetterWidth();
		WINDOWHEIGHT = cfg.getWindowHeight();
		WINDOWWIDTH = cfg.getWindowWidth();
	    BORDER = cfg.getBorder();
	    PADDING = cfg.getPadding();
	}
	 
    protected static int IMG_NUMBER_W = Img.NUMBER.getWidth(null) / 10;
	 
    private static int IMG_NUMBER_H = Img.NUMBER.getHeight(null);
	protected static int IMGWIDTH=Img.IMG.getWidth(null);
	protected static int IMGHEIGHT=Img.IMG.getHeight(null);
	
	 /*
	  * 矩形值槽
	  */
	 
	 private static Image IMG_RECT = new ImageIcon("Graphics/window/rect.png").getImage();
	 //TODO

	 
	 
	 /*
	  * 矩形值槽高度
	  */
	 protected static final int IMG_RECT_H = IMG_RECT.getHeight(null);
	 
	 /*
	  * 矩形值槽图片宽度
	  */
	 
	 protected static final int IMG_RECT_W = IMG_RECT.getWidth(null);
	 
	 /*
	  * 矩形值槽宽度
	  */
	 
	 private static int rectW ;
	 
	 private static final Font DEF_FONT = new Font("黑体", Font.BOLD, 20);
	
	
	//窗口左上角xy坐标以及宽度和高度
	
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    
    /*
     * 游戏数据
     */
    protected GameDto dto = null;
    
    protected Layer(int x, int y, int w, int h){
    	this.x = x;
    	this.y = y;
    	this.h = h;
    	this.w = w;
    	this.rectW = this.w - (PADDING << 1);
    }
    
    //绘制窗口用
    protected void createWindow (Graphics g) {
    	         
          //左上
          g.drawImage(Img.IMG, x, y, x+WINDOWWIDTH, y+WINDOWHEIGHT, 0, 0, WINDOWWIDTH, WINDOWHEIGHT, null);
          //中上
          g.drawImage(Img.IMG, x+WINDOWWIDTH, y, x+w-WINDOWWIDTH, y+WINDOWHEIGHT, WINDOWWIDTH, 0, IMGWIDTH-WINDOWWIDTH, WINDOWHEIGHT, null);
          //右上
          g.drawImage(Img.IMG, x+w-WINDOWWIDTH, y, x+w, y+WINDOWHEIGHT, IMGWIDTH-WINDOWWIDTH, 0, IMGWIDTH, WINDOWHEIGHT, null);
          //左中
          g.drawImage(Img.IMG, x, y+WINDOWHEIGHT, x+WINDOWWIDTH, y+h-WINDOWHEIGHT, 0, WINDOWHEIGHT, WINDOWWIDTH, IMGHEIGHT-WINDOWHEIGHT, null);
          //正中
          g.drawImage(Img.IMG, x+WINDOWWIDTH, y+WINDOWHEIGHT, x+w-WINDOWWIDTH, y+h-WINDOWHEIGHT, WINDOWWIDTH, WINDOWHEIGHT, IMGWIDTH-WINDOWWIDTH, IMGHEIGHT-WINDOWHEIGHT, null);
          //右中
          g.drawImage(Img.IMG, x+w-WINDOWWIDTH, y+WINDOWHEIGHT, x+w, y+h-WINDOWHEIGHT, IMGWIDTH-WINDOWWIDTH, WINDOWHEIGHT, IMGWIDTH, IMGHEIGHT-WINDOWHEIGHT, null);
          //左下
          g.drawImage(Img.IMG, x, y+h-WINDOWHEIGHT, x+WINDOWWIDTH, y+h, 0, IMGHEIGHT-WINDOWHEIGHT, WINDOWWIDTH, IMGHEIGHT, null);
          //中下
          g.drawImage(Img.IMG, x+WINDOWWIDTH, y+h-WINDOWHEIGHT, x+w-WINDOWWIDTH, y+h, WINDOWWIDTH, IMGHEIGHT-WINDOWHEIGHT, IMGWIDTH-WINDOWWIDTH, IMGHEIGHT, null);
          //右下
          g.drawImage(Img.IMG, x+w-WINDOWWIDTH, y+h-WINDOWHEIGHT, x+w, y+h, IMGWIDTH-WINDOWWIDTH, IMGHEIGHT-WINDOWHEIGHT, IMGWIDTH, IMGHEIGHT, null);

    }
	 /*
	  * 显示数字
	  * 
	  * @param x 左上角坐标
	  * @param y 左上角坐标
	  * @param num 数字
	  * @param bitCount 数字位数
	  * @param g 画笔
	  * 
	  */
	 protected void drawNumberLeftPad(int x, int y, int num, int maxBit, Graphics g) {
		 //把number中每一位取出
		 //要打印的数字转化为字符串
		 String strNum = Integer.toString(num);
		 //循环绘制数字右对齐
		 for (int i=0; i < maxBit; i++){
			 //判断是否满足绘制条件
			 int idx = i - maxBit + strNum.length();
			 //获得数字在字符串的下标
			 if (maxBit - i <= strNum.length()){
				 //把数字number中每一位取出
				 int bit = strNum.charAt(idx) - '0';
				 //绘制数字
			 g.drawImage(Img.NUMBER,
					 this.x + x + IMG_NUMBER_W * i, this.y + y, 
					 this.x + x + IMG_NUMBER_W * (i+1), this.y + y + IMG_NUMBER_H, 
					 bit * IMG_NUMBER_W, 0, (bit + 1) * IMG_NUMBER_W, IMG_NUMBER_H, null); 
			 }
			
		}
		
	 }
	 
	 //绘制值槽
	 
	 /*
	  * @param y      绘制矩形左上角初始y坐标
	  * @param title  矩形内填充字符串
	  * @param number 绘制数值
	  * @value     
	  *  maxValue  值槽比
	  */
	 
	 protected void drawRect( int y, String title, String number, double percent, Graphics g){
		 
		    //各种值初始化
		    int rect_x = this.x + PADDING;
		    int rect_y = this.y + y;
	        //绘制背景
	    	g.setColor(Color.BLACK);
	    	g.fillRect(rect_x , rect_y, this.rectW, IMG_RECT_H + 4);
	    	g.setColor(Color.WHITE);
	    	g.fillRect(rect_x + 1 , rect_y + 1 , this.rectW - 2, IMG_RECT_H + 2);
	    	g.setColor(Color.BLACK);
	    	g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4 , IMG_RECT_H );

	        
	        //求出宽度
	    	int w = (int) (percent * (this.rectW-4));
	    	//求出颜色
	    	int subIdx = (int) (percent * IMG_RECT_W) - 1;
	    	g.drawImage(IMG_RECT, 
	    			rect_x + 2, rect_y + 2, 
	    			rect_x + 2 + w , rect_y + 2 + IMG_RECT_H, 
	    			subIdx, 0, subIdx + 1, IMG_RECT_H, 
	    			null);
	    	g.setColor(Color.white);
	    	g.setFont(DEF_FONT);
	    	g.drawString(title, rect_x + 4, rect_y + 22);
	    	if (number != null){
	    		g.drawString(number, rect_x + 232, rect_y + 22);
	    	}
		 }
	 /*
	  * 正中绘图
	  */
	 
	 protected void drawImageAtCenter(Image Img, Graphics g){
		 int imgW = Img.getWidth(null);
		 int imgH = Img.getHeight(null);
		 int imgX = this.x + (this.w - imgW >> 1);
		 int imgY = this.y + (this.h - imgH >> 1);
		 g.drawImage(Img, imgX, imgY, null);
     }	 
   
   
    public void setDto(GameDto dto) {
		this.dto = dto;
	}
    
     //刷新游戏具体内容
    abstract public void paint (Graphics g);
}
