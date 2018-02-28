
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
	
	public Item(Float weight, int x, int y) {
		this.weight = weight;
		this.x = x;
		this.y = y;
	}
}
