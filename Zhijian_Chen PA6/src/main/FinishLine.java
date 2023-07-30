/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is a class that used to keep record on which car is finished 
* and add them to corresponded array and to check if the game is finished or not
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class FinishLine {
	public int count;
	public int numOfRaceCar;
	public int numOfFormulaOne;
	public int numOfSportsCar;
	//public RaceTrack raceTrack; 
	
	public FinishLine(int totalOfNum) {
		this.count = 0;
		
	}
	
//	Check if cars is eligible to finish.
	public void enterFinishLine(Car car) {
		if(car.numOfLap >= 10) {
			car.finished = true;
			if (car instanceof RaceCar) {
				numOfRaceCar ++;
			}
			else if(car instanceof FormulaOne){
				numOfFormulaOne ++;	
			}
			else {
				numOfSportsCar ++;
			}
			count++;
		}
	}
	
	// Check if the game is over.
	public boolean finished(int totalOfNum) {
		
		if (totalOfNum == count) {
			return true;
		}
		return false;
	}
	
}

