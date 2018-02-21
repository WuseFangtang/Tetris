package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Dto.Player;

public class DataDisk implements Data {

	private static final String FILE_PATH = "";
	
	public DataDisk(HashMap<String, String> param){
		
	}
	@Override
	public List<Player> loadData() {
		ObjectInputStream ois = null;
		List<Player> players = null;
		try {
			 ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			 players = (List<Player>) ois.readObject();
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return players;
	}

	@Override
	public void saveData(Player pla) {
		//先取出数据
		List<Player> players = this.loadData();
		
		//TODO  判断记录是否超过5条，如果超过，去掉分数最低的。
		//追加新纪录
		players.add(pla);
		//重新写入
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(players);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}
