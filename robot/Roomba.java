package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/TestWorld2.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 9, 7);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba= new Robot(7,6,North,100);

	// You will need to add many variables!!


	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(1);


		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */


		// the line below causes a null pointer exception
		// what is that and why are we getting it?

		//set the roomba initial moving direction (East))
		roomba.turnLeft();
		roomba.turnLeft();
		roomba.turnLeft();

		boolean done = false;
		int totalBeepersPicked = 0; 
		int totalSquaredMoved = 0;
		int i = 0;
		int maxNbeepersInAPile = Integer.MIN_VALUE;
		int minNbeepersInAPile = Integer.MAX_VALUE;

		while(!done) 
		{
			while(roomba.frontIsClear()) 
			{
				i = 0;
				while (roomba.nextToABeeper()) 
				{
					totalBeepersPicked++;
					roomba.pickBeeper();
					i++;
				}
				if (i > 0 && i > maxNbeepersInAPile)
				{
					maxNbeepersInAPile = i;
				}
				if (i > 0 && i < minNbeepersInAPile)
				{
					minNbeepersInAPile = i;
				}				
				roomba.move();
				totalSquaredMoved++;
			}

			if (roomba.facingEast()) 
			{
				roomba.turnLeft();
				if (roomba.frontIsClear()) 
				{
					roomba.move();
					totalSquaredMoved++;
					roomba.turnLeft();
				}
				else 
				{
					done = true;
				}
			}
			else 
			{
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				if (roomba.frontIsClear()) 
				{
					roomba.move();
					totalSquaredMoved++;
					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();
				}
				else 
				{
					done = true;
				}
			}

			if (done) 
			{
				//check if the last position has any beepers or not
				i = 0;
				while (roomba.nextToABeeper()) 
				{
					totalBeepersPicked++;
					roomba.pickBeeper();
					i++;
				}
				if (i > maxNbeepersInAPile)
				{
					maxNbeepersInAPile = i;
				}				
				if (i > 0 && i < minNbeepersInAPile)
				{
					minNbeepersInAPile = i;
				}
			}
		}
		
		System.out.println("Roomba total moves : " + totalSquaredMoved);
		System.out.println("Max number of beepers in a pile : " + maxNbeepersInAPile);
		System.out.println("Min number of beepers in a pile : " + minNbeepersInAPile);

        // This method should return the total number of beepers cleaned up.
		return totalBeepersPicked;
	}
}
