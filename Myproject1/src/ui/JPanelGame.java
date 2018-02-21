package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import Dto.GameDto;
import config.FrameConfig;
import config.GameConfig;
import config.LayerConfig;

import control.PlayerControl;


public class JPanelGame extends JPanel{
	  	
	private List<Layer> layers = null;
	  
    private GameDto dto = null;
    
	public JPanelGame (GameDto dto) {
	      //获得游戏数据
		 this.dto = dto;
		 //初始化组件
		 this.initComponent();
	     //初始化层
		 this.initLayer();
        
	}
	
	/*
	 * 安装玩家控制器
	 */
	
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	
	/*
	 * 初始化组件
	 */
	public void initComponent(){
	    
	}
	/*
	 * 初始化层
	 */
	
    public void initLayer(){
        try {
		   //获得游戏配置
		   FrameConfig cfg = GameConfig.getFrameConfig();
		   //获得层配置
		   List<LayerConfig> LayersCfg = cfg.getLayersConfig();
		   //创建游戏层数
		   layers = new ArrayList<Layer>(LayersCfg.size());
		   //循环创建层对象 
		   for (LayerConfig Layercfg : LayersCfg){
			   //获得类对象		   
				Class<?> cls = Class.forName(Layercfg.getClassName());
				//获得构造函数
				Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				//调用构造函数创建对象
				Layer l = (Layer)ctr.newInstance(
						Layercfg.getX(),Layercfg.getY(),Layercfg.getW(),Layercfg.getH()
						);
				//设置游戏数据对象
				l.setDto(this.dto);
				//把layer对象放入集合
				layers.add(l);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Override
    public void paintComponent (Graphics g){
        //调用基类方法
    	super.paintComponent(g);
    	//循环打印
    	for (int i=0; i < layers.size(); i++){
        	//循环刷新游戏画面
    		layers.get(i).paint(g);
        }
       // 返回焦点
    	this.requestFocus();
    }
    
}
