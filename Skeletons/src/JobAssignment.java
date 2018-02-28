import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class JobAssignment {

	private final String defaultItemFileLocation = "itemFile.txt";
	private final String defaultJobFileLocation = "jobFile.txt";
	private final String defaultCancellationFileLocation = "cancellationFile.txt";

	

	public JobAssignment() {
		decodeItemCSV();
		decodeJobCSV();
		decodeCancellationCSV();
	}

	private void decodeItemCSV() {

		// File reader for the item file
		try (BufferedReader reader = new BufferedReader(new FileReader(defaultItemFileLocation))) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void decodeJobCSV() {
	

		// File reader for the job file
		try (BufferedReader reader = new BufferedReader(new FileReader(defaultJobFileLocation))) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void decodeCancellationCSV() {

		// File reader for the cancellation file
		try (BufferedReader reader = new BufferedReader(new FileReader(defaultCancellationFileLocation))) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
