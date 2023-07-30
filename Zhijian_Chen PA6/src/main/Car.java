/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is an abstract class that will be used by 3 car classes.
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public abstract class Car {
	public int speed;
	public int strength;
	public int originalspeed;
	public int condition;
	public double location;
	public boolean finished;
	public boolean damaged;
	public boolean inPit;
	public int numOfLap;
	public int position; //this position in every lap.
	
	public double getLocation() {
		return location;
	}
	
	public double getPosition() {
		return position;
	}
	
	public abstract String toString();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
