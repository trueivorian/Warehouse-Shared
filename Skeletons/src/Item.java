
public class Item {
	
	/**
	 * The character that represents the item
	 */
	//private final Character itemName; // Will be stored as the key of the item in a hash map
	
	/**
	 * Reward for successfully moving the item.
	 */
	private Float reward;
	/**
	 * The weight of the item.
	 */
	private Float weight;
	
	/**
	 * x co-ordinate of the item.
	 */
	private int x;
	/**
	 * y co-ordinate of the item.
	 */
	private int y;
	
	public Item(int x, int y, Float weight, Float reward) {
		this.weight = weight;
		this.reward = reward;
		this.x = x;
		this.y = y;
	}
}
