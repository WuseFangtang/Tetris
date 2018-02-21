package DAO;

import java.util.List;

import Dto.Player;

/*
 * 数据持久层接口
 */
public interface Data {

	/*
	 * 读取数据
	 */
	List<Player> loadData();
    
	/*
     * 存储数据
     */
	void saveData(Player players);
}
