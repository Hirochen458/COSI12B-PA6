/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is a formula one car class that will be update keep record of each 
* formula one's status
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class FormulaOne extends Car{
	
	public FormulaOne() {
		this.speed = 50;
		this.strength = 4;
		this.location = 0;
		
		this.damaged = false;
		this.finished = false;
		this.inPit = false;
		this.originalspeed = speed;
		
		this.condition = 0;
		this.numOfLap = 0;
		this.position = 0;

	}
	
	public FormulaOne(int speed, int strength) {
		// set speed in between max or min.
		setSpeed(speed);
				
		//set strength in between max or min.
		if (strength <= 3) {
			this.strength = 3;
		}
		else if(strength >= 5) {
			this.strength = 5;
		}
		else {
			this.strength = strength;
		}
	}
	
	
	public void setSpeed(int speed) {
		if (speed >= 70) {
			this.speed = 70;
		}
		else if(speed<= 30) {
			this.speed = 30;
		}
		else {
			this.speed = speed;
		}
		originalspeed = speed;
	}/*
	
	// to get the location of the car
	public double getLocation() {
		return location;
		
	}
	//to get the position in the lap
	public double getPosition() {
		return position;
	}*/
	
	//to convert the car to string.
	public String toString() {
		String sp = String.valueOf(originalspeed);
		String st = String.valueOf(strength);
		return "FormulaOne" + sp + "/" + st;
	}
}
