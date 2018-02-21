package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.FrameConfig;
import config.GameConfig;

public class JFramegame extends JFrame{
     
	 
	 public JFramegame(JPanelGame panelGame) {
		 
		 //获得游戏配置
		 FrameConfig cfg = GameConfig.getFrameConfig();
		 //设置标题
		 this.setTitle(cfg.getTitle());
		 //关闭窗口结束运行
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //设置窗口大小
		 this.setSize(cfg.getWidth(), cfg.getHeight());
		 //不允许用户改变窗口大小
		 this.setResizable(false);
		 //设置居中
		 
		 Toolkit toolkit = Toolkit.getDefaultToolkit();
		 Dimension screen = toolkit.getScreenSize();
		 int w = screen.width;
		 int h = screen.height;
		 
		 this.setLocation((w-this.getWidth())/2, (h-this.getHeight())/2-cfg.getWindowUp());
		 
		 //设置Panel
		 this.setContentPane(panelGame);
		 //默认窗口显示
		 this.setVisible(true);
	 }
}
