import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;

public class Robot implements Runnable, ButtonListener{
	
	public static final int NORTH = 0;
	public static final int EAST = 90;
	public static final int SOUTH = 180;
	public static final int WEST = 270;
	
	public enum Movement{
		FORWARD, LEFT, RIGHT, BACKWARD
	}
	

	/**
	 * Store the Queue of directions to be performed, which has the .
	 */
	private BlockingQueue<Movement> movementQueue;
	
	/** 
	 * Set to true to cancel the current job in progress.
	 */
	private boolean cancelJob = false;
	
	/**
	 * Current direction is degrees.
	 */
	private Integer currentDirection;
	
	/**
	 * Takes in the blocking queue from the 
	 * @param movementQueue
	 */
	public Robot(BlockingQueue<Movement> movementQueue) {
		this.movementQueue = movementQueue;
	}
	
	@Override
	public void run() {
		
		/*
		 * Add A button listener thread that can listen for button presses
		 */
		
		while(true) {
			try {
				Movement nextMovement = movementQueue.take();
				
				// Check direction isn't null
				if(nextMovement == null) {
					/*
					 * Report Error
					 */
					// Go back to the beginning of the loop
					continue; // or break
				}
				
				/*
				 * Code here for implementing movement
				 */
				
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * Set to a value NORTH (0), EAST (90), SOUTH (180), WEST (270)
	 * @param direction The direction to set
	 */
	public void setDirectionCurrent(Integer direction) {
		currentDirection = direction;
	}
	
	public boolean checkJobRunning() {
		return !cancelJob;
	}
	
	@Override
	public void buttonPressed(Button b) {
		if(Button.ESCAPE.isDown()) {
			cancelJob = true;
		}
		
	}

	@Override
	public void buttonReleased(Button b) {}
	
}
