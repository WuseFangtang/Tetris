package Dto;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

import entity.GameAct;

public class GameDto {
    
	//数据库记录
    private List<Player> dbRecode;
    
    //本地磁盘记录 
    private List<Player> diskRecode;
    
    //游戏画面已堆方块
    private boolean[][] gameMap;
    
    //正在下落方块
    private GameAct gameAct;
    
    //下一个方块显示
    private int next;
    
    //等级
    private int nowlevel;
    
    //现在分数
    private int nowPoint;
    
    //现在已消行
    private int nowRemoveLine;
    
    /*
     * 构造函数
     */
    public GameDto(){
        dtoInit();
    }
    
    /*
     * DTO 初始化
     */
    public void dtoInit () {
    	//TODO 硬编码
    	this.gameMap = new boolean[10][18];
    	//TODO 初始化所有游戏对象
    }
  
	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		setFullRecode(dbRecode);
		this.dbRecode = dbRecode;
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		setFullRecode(diskRecode);
		this.diskRecode = diskRecode;
	}
	
	private List<Player> setFullRecode(List<Player> players){
		//如果进来空，那么创建新的
		if (players== null) {
			players = new ArrayList<Player>();
		}
		//如果记录小于5，那么加到五条为止
		while (players.size() < 5){
			players.add(new Player("No Data", 0));
		}
		
		Collections.sort(players);
		return players;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(int nowlevel) {
		this.nowlevel = nowlevel;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
    
    
}
