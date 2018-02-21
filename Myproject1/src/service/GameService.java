package service;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import Dto.GameDto;
import Dto.Player;
import entity.GameAct;

public class GameService {
    
	/*
     *   
     */
	private GameDto dto;
	
	/*
	 * 随机数生成器
	 */
	private Random random = new Random();
	
	private static final int MAX_TYPE = 6;
	
	public GameService(GameDto dto) {
	   this.dto = dto;
	   GameAct act = new GameAct(random.nextInt(MAX_TYPE));
	   dto.setGameAct(act);
	}
	/*
	 * 控制方向鍵（上）
	 */
	public void keyUp() {
	   //TODO 旋转
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	/*
	 * 控制方向鍵（下）
	 */
	public void keyDown() {
	   if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap()))
	   {
		  return;
	   }	
	   //获得地图对象
	   boolean[][] map = this.dto.getGameMap();
	   //获得方块对象
	   Point[] act = this.dto.getGameAct().getActPoints();
	   //将方块堆积到地图数组
	   for (int i = 0; i < act.length; i++){
		   map[act[i].x][act[i].y] = true;
	   }
	   // TODO 判断是否可以消行
	   // TODO    消行操作
	   // TODO    算分操作
	   // TODO   是否升级
	   // TODO      升级
	  
	   this.dto.getGameAct().init(this.dto.getNext());
	   
	   // 随机生成下一个方块
	   this.dto.setNext(random.nextInt(MAX_TYPE));
	   
	}
	
	/*
	 * 控制方向鍵（右）
	 */
	public void keyRight() {
		this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
	}

	/*
	 * 控制方向鍵（左）
	 */
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());	
	}
	
	// TODO ================================测试专用方法============================
	public void testLevelUp() {
		int point = this.dto.getNowPoint();
		int rmLine = this.dto.getNowRemoveLine();
		int lv = this.dto.getNowlevel();
		
		point += 10;
		rmLine ++;
		
		if (rmLine % 20 == 0){
			lv ++;
		}
		this.dto.setNowPoint(point);
		this.dto.setNowlevel(lv);
		this.dto.setNowRemoveLine(rmLine);
	}
	
	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
	}
}
