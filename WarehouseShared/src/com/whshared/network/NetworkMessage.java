package com.whshared.network;

public final class NetworkMessage {

	public static final byte REQUEST_MOVE = 0; // sent by the robot to inform server it it has completed its move and
												// needs another
	public static final byte MOVE_NORTH = 1; // tells robot to move in the appropriate direction based on the
												// direction of the robot.
	public static final byte MOVE_SOUTH = 2;
	public static final byte MOVE_EAST = 3;
	public static final byte MOVE_WEST = 4;
	public static final byte NO_MOVE = 5; // tells the robot to not make a move. It will remain in the same state
	public static final byte AWAIT_PICKUP = 6; // Tells the robot to await input from the interface to tell it it has
												// picked up the item. Robot should then request its next move for the
												// next timestep.
	public static final byte AWAIT_DROPOFF = 7; // Like await pickup, just for dropoff. Differentiated so different
												// messages/sounds can be displayed.
	public static final byte CANCEL_JOB = 8; // Informs the robot the job has been cancelled. Logically the NXT doesn't
												// need to know this, but it is so a message/sound can be played (May be
												// good for debug).
}
