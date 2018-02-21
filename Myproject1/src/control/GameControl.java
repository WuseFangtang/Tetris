package control;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import DAO.Data;
import config.DataInterfaceConfig;
import config.GameConfig;
import service.GameService;
import ui.JPanelGame;
/*
 * 接受玩家键盘事件
 * 控制画面
 * 控制游戏逻辑 
 */
public class GameControl {

	/*
	 * 数据访问接口A
	 */
	private Data dataA;


	/*
	 * 数据访问接口B
	 */
	private Data dataB;
	
	/*
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/*
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
		//从数据接口A获得数据库记录
		
		//获得类对象
		
		
		this.dataA = createDataObject(GameConfig.getDataConfig().getDataA());
		//设置数据库记录到游戏
		this.gameService.setDbRecode(dataA.loadData());
		//设置本地磁盘记录
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		//设置本地磁盘记录到游戏
		this.gameService.setDiskRecode(dataB.loadData());
	}
	
	private Data createDataObject(DataInterfaceConfig cfg){
		try {
			//获得类对象
			Class<?> cls = Class.forName(cfg.getClassName());
			//获得构造器
			Constructor<?> ctr = cls.getConstructor(HashMap.class);
			//创建对象
			return (Data) ctr.newInstance(cfg.getParam());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		

	}

	/*
	 * 控制方向鍵（上）
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();		
	}
	
	/*
	 * 控制方向鍵（下）
	 */
	public void keyDown() {
	    this.gameService.keyDown();		
	    this.panelGame.repaint();	
	}
	
	/*
	 * 控制方向鍵（右）
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();	
	}

	/*
	 * 控制方向鍵（左）
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();	
	}

// =======================================测试专用===================
	public void testLevelUp() {
		this.gameService.testLevelUp();
	    this.panelGame.repaint();
	}
}
