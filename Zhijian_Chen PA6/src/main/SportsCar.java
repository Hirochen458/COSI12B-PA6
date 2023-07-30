/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is a sport car class that will be used to keep track the status of each
* sport car and update those data.
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class SportsCar extends Car {
	
	public SportsCar() {
		this.speed = 30;
		this.strength = 2;
		this.location = 0;
		this.damaged = false;
		this.finished = false;
		this.inPit = false;
		this.originalspeed = speed;
		this.numOfLap = 0;
		this.condition = 0;
		//this.position = 0;

	}
	
	public SportsCar(int speed, int strength) {
        
		// set speed in between max or min.
		setSpeed(speed);
		//originalspeed = 
		
		//set strength in between max or min.
		if (strength <= 1) {
			this.strength = 1;
		}
		else if(strength >= 3) {
			this.strength = 3;
		}
		else {
			this.strength = strength;
		}
	}
	
	public void setSpeed(int speed) {
		if (speed >= 45) {
			this.speed = 45;
			originalspeed = 45;
		}
		else if(speed<= 20) {
			this.speed = 20;
			originalspeed = 20;
		}
		else {
			this.speed = speed;
			originalspeed = speed;
		}
		//originalspeed = speed;
		
	}/*
	// to get the location of the sportcar
	public double getLocation() {
		return location;
	}
	
	//to get the position in the lap
	public double getPosition() {
		return position;
	}*/
	
	//to convert the sportcar to string.
	public String toString() {
		String sp = String.valueOf(originalspeed);                                    
		String st = String.valueOf(strength);
		return "SportsCar" + sp + "/" + st;	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
