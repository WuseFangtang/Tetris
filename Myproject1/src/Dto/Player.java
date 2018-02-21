package Dto;

import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {

	private String Name;
	private int Point;
	public Player(String name, int point) {
		super();
		Name = name;
		Point = point;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	@Override
	public int compareTo(Player pla) {
		return pla.Point - this.Point;
	}
	
}
