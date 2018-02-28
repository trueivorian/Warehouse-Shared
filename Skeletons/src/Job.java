import java.util.ArrayList;
import java.util.Map.Entry;

public class Job{

	private Integer jobID;
	
	/**
	 * Stores all the items that pertain to each job.
	 */
	ArrayList<Entry<Character, Integer>> itemList = new ArrayList<Entry<Character, Integer>>();

	public Job(Integer jobID, ArrayList<Entry<Character, Integer>> itemList) {
		this.jobID = jobID;
		this.itemList = itemList;
	}
	
	public Integer getJobID() {
		return jobID;
	}
	
}
