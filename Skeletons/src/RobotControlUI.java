import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class RobotControlUI extends JFrame {

	private static final long serialVersionUID = 8075642296734150448L;

	private static final String FRAME_TITLE = "Robot Control UI";

	private JPanel robotPanel;

	private JobDataSore jobDataStore;

	private ArrayList<Robot> robots;

	public RobotControlUI(JobDataSore jobDataStore, ArrayList<Robot> robots) {
		this.jobDataStore = jobDataStore;
		this.robots = robots;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(FRAME_TITLE);
		setVisible(true);

		robotPanel = new JPanel();
		robotPanel.setLayout(new BoxLayout(robotPanel, BoxLayout.Y_AXIS));

		JPanel jobsPanel = new JPanel(new FlowLayout());
		jobsPanel.setPreferredSize(new Dimension(250, 500));

		// Finalise label text
		JLabel activeJobsLabel = new JLabel("Active Jobs");
		jobsPanel.add(activeJobsLabel);
		
		JPanel jobPanel = new JPanel();
		jobPanel.setLayout(new BoxLayout(jobPanel, BoxLayout.Y_AXIS));
		
		for(Job job : jobDataStore.getActiveJobs()) {
			
			
			
		}

		JPanel activeJobsPanel = new JPanel();
		activeJobsPanel.setPreferredSize(new Dimension(250, 250));
		activeJobsPanel.setLayout(new BoxLayout(activeJobsPanel, BoxLayout.Y_AXIS));
	
		
		
		jobsPanel.add(activeJobsPanel);
		
		// Finalise label text
		JLabel inactiveJobsLabel = new JLabel("Inactive Jobs"); // Or jobs to do
		jobsPanel.add(inactiveJobsLabel);
		
		JPanel inactiveJobsPanel = new JPanel();
		inactiveJobsPanel.setPreferredSize(new Dimension(250, 250));
		inactiveJobsPanel.setLayout(new BoxLayout(activeJobsPanel, BoxLayout.Y_AXIS));
		
		
		
		jobsPanel.add(inactiveJobsLabel);

		/*
		 * Integer i = 0; for (Robot robot : robots) {
		 * 
		 * //JLabel robotName = new JLabel(robot.getName()); JLabel robotName = new
		 * JLabel("Robot " + (i++).toString()); robotPanel.add(robotName);
		 * 
		 * JPanel buttonPanel = new JPanel(); buttonPanel.setLayout(new FlowLayout());
		 * buttonPanel.setPreferredSize(new Dimension(500,80));
		 * 
		 * 
		 * 
		 * for(Integer jobID : robots.getJobs()) {
		 * 
		 * }
		 * 
		 * System.out.println("Adding robot"); JobPanel jobPanel = new
		 * JobPanel(jobDataStore, robot.getCurrentJob()); buttonPanel.add(jobPanel);
		 * JScrollPane scrollPane = new JScrollPane(buttonPanel);
		 * scrollPane.setHorizontalScrollBarPolicy(JScrollPane.
		 * HORIZONTAL_SCROLLBAR_ALWAYS); robotPanel.add(scrollPane);
		 * 
		 * }
		 */
		add(robotPanel, BorderLayout.CENTER);

		pack();

	}

	public static void main(String[] args) {
		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.add(new Robot(new LinkedBlockingQueue<Robot.Movement>()));
		robots.add(new Robot(new LinkedBlockingQueue<Robot.Movement>()));
		RobotControlUI robotUI = new RobotControlUI(new JobDataSore(), robots);
		/*
		 * try { //String cheat = new BufferedReader(new
		 * InputStreamReader(System.in)).readLine(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	/**
	 * Prints an error to the text area using the tell() method and prints out the
	 * error to the console.
	 * 
	 * @param message
	 *            The message to be printed to the text area and console.
	 */
	public void error(String message) {
	}

}

class JobPanel extends JPanel {

	private static final long serialVersionUID = -6584237164987663902L;

	private JLabel jobLabel;

	private JButton cancelButton;

	private JobDataSore jobDataStore;

	public JobPanel(JobDataSore jobDataStore, Integer jobID) {
		this.jobDataStore = jobDataStore;
		setLayout(new BorderLayout());
		// setPreferredSize(new Dimension(100, 100));

		jobLabel = new JLabel("Job ID: " + jobID.toString());
		jobLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(jobLabel, BorderLayout.NORTH);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Send Cancel message up
				jobDataStore.cancel();
			}
		});
		add(cancelButton, BorderLayout.SOUTH);

	}

}
