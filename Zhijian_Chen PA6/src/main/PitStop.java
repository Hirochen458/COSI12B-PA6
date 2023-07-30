/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is an pit stop class that will be used keep record of cars in pit stop
* and update their condition to in order to let them back to race track.
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class PitStop {
	public Car[] carInPit;
	
	public PitStop() {
		this.carInPit = new Car[10];
	}
	// for cars in pit we update their condition in pit
	public void updateCarCondition() {
		for(int i = 0; i < carInPit.length; i++) {
			if(carInPit[i] != null && carInPit[i].condition > 0) {
				carInPit[i].condition -= 1;
			}
		}
	}
	// let cars enter pitstop
	public void enterPitStop(Car car) {
		car.inPit = true;
		car.condition = 2;
		car.position = 75;
		
		for(int i = 0; i < carInPit.length; i++) {
			if(carInPit[i] == null) {
				carInPit[i] = car;
				break;
			}
		}
	}
	
	
/*	
	public RaceCar[] raceCarInPit;
	public FormulaOne[] formulaOneInPit;
	public RaceTrack raceTrack;

	public PitStop() {
		this.raceCarInPit = new RaceCar [10];
		this.formulaOneInPit = new FormulaOne [10];
		//raceTrack = new RaceTrack();
		
		
	}
	// for cars in pit we update their condition in pit
	public void updateCarCondition() {
		// changing the cars' conditions who are  in pit.
		for (int i = 0; i < raceCarInPit.length; i++) {
			if(raceCarInPit[i] != null && raceCarInPit[i].condition > 0) {
				raceCarInPit[i].condition -= 1;
			}
		}
	}
	// for formulas in pit we update their condition in pit.
	public void updateFormulaCondition() {
		// changing the formulas' conditions who are  in pit.
		for (int i = 0; i < formulaOneInPit.length; i++) {
			if(formulaOneInPit[i] != null && formulaOneInPit[i].condition > 0) {
				formulaOneInPit[i].condition -= 1;
			}
		}
	}
	// let cars enter pitstop
	public void enterPitStop(RaceCar carInPit) { 
        // preparing for adding new cars.
		carInPit.inPit = true;
		carInPit.condition = 2;
		carInPit.location = 75;
		
		// adding new cars for the array.
		for (int i = 0; i < raceCarInPit.length; i++) {
			if(raceCarInPit[i] == null) {
				raceCarInPit[i] = carInPit;
				break;
				//raceTrack.raceCarInTrack[i] = null;
			}
		}
		
	}
	// let formulas enter pitstop
	public void enterPitStop(FormulaOne formulaInPit) { 
        // preparing for adding new formula.
		formulaInPit.inPit = true;
		formulaInPit.condition = 2;
		formulaInPit.location = 75;
		
		
		// adding new formulas for the array.
		for (int i = 0; i < formulaOneInPit.length; i++) {
			if(formulaOneInPit[i] == null) {
				formulaOneInPit[i] = formulaInPit;
				break;
				//raceTrack.formulaOneInTrack[i] = null;
			}
		}
		
	}
	/*public void carExitPitStop(RaceCar car) {
		
		for(int i = 0; i < raceCarInPit.length; i++) {
			if (car.condition == 0) {
				for (int j = 0; j < RaceTrack.raceCarInTrack.length; j++) {
				    
					
				}
			}
		}
	}*/
	
	
	
}
