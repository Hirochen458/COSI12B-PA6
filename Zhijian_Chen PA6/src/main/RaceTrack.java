/**
* Zhijian Chen
* chen5340@brandeis.edu
* 11/11/2021
* PA6
* This program is the main class that will be used hold the race match, also used to 
* check the collision, and calculate the score.
* Known Bugs: explain bugs/null pointers/etc.
*/

package main;

public class RaceTrack {
	public int tick;
	public int place;
	public int score;
	public int numOfCar1;
	public int numOfCar2;
	public int numOfCar3;
	public int totalOfNum;
	public Car[] carInTrack;
	public PitStop pitStop;
	public FinishLine finished;
	

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	
	public RaceTrack() {
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
		tick = 0;
		place = 1;
		score = 1000;
		pitStop = new PitStop();

		numOfCar1 = 0;
		numOfCar2 = 0;
		numOfCar3 = 0;
		totalOfNum = 0;
		
	}
	
	// adding only one kind of car into race-track array.
	public void setCars(Car[] car) {
		this.carInTrack = car;
		totalOfNum = carInTrack.length;
		finished = new FinishLine(totalOfNum);
		
		
	}
	
	
	//adding two kind of cars into race-track array.
	public void setCars(Car[] car1, Car[] car2) {
		this.carInTrack = new Car[car1.length + car2.length];
		for(int i = 0; i < car1.length; i++) {
			carInTrack[i] = car1[i];
			
		}
		
		for(int j = 0; j < car2.length; j++) {
			carInTrack[car1.length + j] = car2[j];
			
		}
		
		//numOfCar1 = car1.length;
		//numOfCar2 = car2.length;
		totalOfNum = carInTrack.length;
		finished = new FinishLine(totalOfNum);

	}
	
	// adding three kind of cars into race-track array
	public void setCars(Car[] car1, Car[] car2, Car[] car3) {
		this.carInTrack = new Car[car1.length + car2.length + car2.length];
		for(int i = 0; i < car1.length; i++) { //adding car1 to carInTrack
			carInTrack[i] = car1[i];
			
		}
		
		for(int j = 0; j < car2.length; j++) { // adding car2 to carInTrack
			carInTrack[car1.length + j] = car2[j];
			
		}
		
		for(int t = 0; t< car3.length; t++) {
			carInTrack[car1.length + car2.length + t] = car3[t];
			
		}
		
		//numOfCar1 = car1.length;
		//numOfCar2 = car2.length;
		//numOfCar3 = car3.length;
		totalOfNum = carInTrack.length;
		finished = new FinishLine(totalOfNum);
	}
	
	public void tick() {
		//check if there are some cars need to exit pit
		carExitPitStop();
		
		//for cars in pit stop we update their condition
		pitStop.updateCarCondition();
		
		//let's go!
		carMove();
		
		//check if car is available to get into pit stop
		if (carInTrack != null) {
			for (int i = 0; i < carInTrack.length; i++) {
				if (carInTrack[i] != null) {
					if (carInTrack[i].damaged == true && carInTrack[i].position >= 75 && (carInTrack[i].position - carInTrack[i].speed) < 75) {
						pitStop.enterPitStop(carInTrack[i]);
						logger.logEnterPit(carInTrack[i]);
						carInTrack[i] = null;
						
					}
				}
			}
		}
		
		//to update which lap the car in
		if(carInTrack != null) {
			for(int t = 0; t < carInTrack.length; t++) {
				if (carInTrack[t] != null && carInTrack[t].position >= 100) {
					carInTrack[t].position -= 100;
					carInTrack[t].numOfLap += 1;
				}
			}
		}
		
		// to check if cars are finished and remove them
		if(carInTrack != null) {
			for(int u = 0; u < carInTrack.length; u++) {
				if (carInTrack[u] != null && carInTrack[u].numOfLap >= 10) {
					finished.enterFinishLine(carInTrack[u]);
					logger.logFinish(carInTrack[u], place);
					place ++;
					carInTrack[u] = null;

				}
			}
		}
		
		checkcollision();
		
	}
	
	public void checkcollision() {
		if (carInTrack != null) {
			for(int i = 0; i < carInTrack.length; i++) {  // calling the racecars to compare. 
				for(int j = 0; j < carInTrack.length; j++) {// caling the racecars to compare.
					
					if(carInTrack[i] != null && carInTrack[j] != null) { //to aviod that race car is null (removed for track)
						
						if(carInTrack[i] != carInTrack[j]) {  // to aviod the racecar that been called is the same one
							
							if(carInTrack[i].getPosition() == carInTrack[j].getPosition()) { // check if the cars in same location
								
								if (carInTrack[i].inPit == false && carInTrack[j].inPit == false) { // aviod the situation that they are in pit
									
									if(carInTrack[i].damaged == false && carInTrack[j].damaged == false) { // check the damage situation of car
										// set damage situation to true.
										carInTrack[i].damaged = true;
										carInTrack[j].damaged = true;
										//update logger.
										//raceCarInTrack[i].damaged = true;
										logger.logDamaged(carInTrack[i]);
										logger.logDamaged(carInTrack[j]);
										//update speed after damage.
										carInTrack[i].speed = carInTrack[i].speed - carInTrack[i].strength * 5;
										carInTrack[j].speed = carInTrack[j].speed - carInTrack[j].strength * 5;
										
									}
									// if one of car is already damaged
									if (carInTrack[i].damaged == false && carInTrack[j].damaged == true) {
										carInTrack[i].damaged = true;
										logger.logDamaged(carInTrack[i]);
										carInTrack[i].speed = carInTrack[i].speed - carInTrack[i].strength * 5;
										
										
									}
									//if one another of car is already damaged
									if (carInTrack[i].damaged == true && carInTrack[j].damaged == false) {
										carInTrack[j].damaged = true;
										logger.logDamaged(carInTrack[j]);
										carInTrack[j].speed = carInTrack[j].speed - carInTrack[j].strength * 5;
										
									}
								}
							}
						}
					}
					
				}
			}
		}
	}
	
	
	public void carMove() {
		if(carInTrack != null) {
			for (int i = 0; i < carInTrack.length; i++) {
				if(carInTrack[i] != null) {
					carInTrack[i].location += carInTrack[i].speed;
					carInTrack[i].position += carInTrack[i].speed;
				}
			}
		}
	}
	
	//let cars get out of pit
	public void carExitPitStop() {
		for(int i = 0; i < pitStop.carInPit.length; i++) {
			if (pitStop.carInPit[i] != null && pitStop.carInPit[i].condition ==1) {
				logger.logExitPit(pitStop.carInPit[i]);
				pitStop.carInPit[i].speed += pitStop.carInPit[i].strength * 5;
				pitStop.carInPit[i].inPit = false;
				pitStop.carInPit[i].damaged = false;
				for (int j = 0; j < carInTrack.length; j++ ) {
					
					if (carInTrack[j] == null) {
						carInTrack[j] = pitStop.carInPit[i];
						pitStop.carInPit[i] = null;
					}
				}
			}
		}
	}
	
	public void run() {
		while(finished.finished(totalOfNum) != true) {
			logger.logNewTick();
			tick();
			tick++;
		}
		calculatorScore(tick);
	}
	
	public int calculatorScore(int ticks) {
		score = score - 20 * tick + 150 * finished.numOfRaceCar + 100 * finished.numOfFormulaOne + 200 * finished.numOfSportsCar;
		System.out.println();
		logger.logScore(score);
		return score;
	}
	

	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}

}
