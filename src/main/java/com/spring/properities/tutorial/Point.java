package com.spring.properities.tutorial;

public class Point {
	private int xCord;
	private int yCord;

	public Point(int xCord, int yCord) {
		super();
		this.xCord = xCord;
		this.yCord = yCord;
	}

	public Point() {

	}

	public int getxCord() {
		return xCord;
	}

	public void setxCord(int xCord) {
		this.xCord = xCord;
	}

	public int getyCord() {
		return yCord;
	}

	public void setyCord(int yCord) {
		this.yCord = yCord;
	}

	@Override
	public String toString() {
		return "Point [xCord=" + xCord + ", yCord=" + yCord + "]";
	}

}
