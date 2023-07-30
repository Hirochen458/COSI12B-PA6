/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is an Race car class that will be used to update each race car's status
* and keep record and renew the status.
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class RaceCar extends Car {
	

	public RaceCar() {
		this.speed = 40;
		this.strength = 3;
		this.location = 0;
		this.damaged = false;
		this.finished = false;
		this.inPit = false;
		this.originalspeed = speed;
		this.numOfLap = 0;
		this.condition = 0;
		//this.position = 0;

	}
	
	public RaceCar(int speed, int strength) {
        
		// set speed in between max or min.
		setSpeed(speed);
		//originalspeed = 
		
		//set strength in between max or min.
		if (strength <= 2) {
			this.strength = 2;
		}
		else if(strength >= 4) {
			this.strength = 4;
		}
		else {
			this.strength = strength;
		}
	}
	
	public void setSpeed(int speed) {
		if (speed >= 55) {
			this.speed = 55;
			originalspeed = 55;
		}
		else if(speed<= 30) {
			this.speed = 30;
			originalspeed = 30;
		}
		else {
			this.speed = speed;
			originalspeed = speed;
		}
		//originalspeed = speed;
		
	}
	/*// to get the location of the car
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
		return "RaceCar" + sp + "/" + st;	
	}
}
