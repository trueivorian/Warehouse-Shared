import javax.swing.BorderFactory;
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

public class RobotControlUI extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 902776736269552333L;

	private static final String FRAME_TITLE = "Robot Control UI";

	private JPanel jobsPanel;
	
	private JPanel activeJobsPanel;
	private JScrollPane activeScrollPane;
	private JPanel activeJobsInnerPanel;
	
	private JPanel inactiveJobsPanel;
	private JScrollPane inactiveScrollPane;
	private JPanel inactiveJobsInnerPanel;
	
	private JPanel robotPanel;

	// This will be the JobAssignment class used to get information about the jobs
	// And will require certain methods to be added to the JobAssignment class
	private JobDataSore jobDataStore;

	private ArrayList<RobotPC> robots;

	public RobotControlUI(JobDataSore jobDataStore, ArrayList<RobotPC> robots) {
		this.jobDataStore = jobDataStore;
		this.robots = robots;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setPreferredSize(new Dimension(500, 500));
		setTitle(FRAME_TITLE);
		setVisible(true);

		jobsPanel = new JPanel(new FlowLayout());
		jobsPanel.setPreferredSize(new Dimension(250, 500));

		activeJobsPanel = new JPanel();
		{
			activeJobsPanel.setBorder(BorderFactory.createTitledBorder("Active Jobs"));
			activeJobsPanel.setPreferredSize(new Dimension(250, 200));
			activeJobsPanel.setLayout(new BoxLayout(activeJobsPanel, BoxLayout.Y_AXIS));
			
			activeJobsInnerPanel = new JPanel();

			activeScrollPane = new JScrollPane(activeJobsInnerPanel);
			activeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			activeJobsPanel.add(activeScrollPane);
		}
		jobsPanel.add(activeJobsPanel);

		inactiveJobsPanel = new JPanel();
		{
			inactiveJobsPanel.setBorder(BorderFactory.createTitledBorder("Inactive Jobs"));
			inactiveJobsPanel.setPreferredSize(new Dimension(250, 260));
			inactiveJobsPanel.setLayout(new BoxLayout(inactiveJobsPanel, BoxLayout.Y_AXIS));

			inactiveJobsInnerPanel = new JPanel();

			inactiveScrollPane = new JScrollPane(inactiveJobsInnerPanel);
			inactiveScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			inactiveJobsPanel.add(inactiveScrollPane);
		}
		jobsPanel.add(inactiveJobsPanel);

		add(jobsPanel, BorderLayout.WEST);

		robotPanel = new JPanel();
		{
			robotPanel.setBorder(BorderFactory.createTitledBorder("Robots"));
			robotPanel.setPreferredSize(new Dimension(245, 500));
			robotPanel.setLayout(new BoxLayout(robotPanel, BoxLayout.Y_AXIS));
		}
		
		updateUI();
		
		add(robotPanel, BorderLayout.EAST);

		pack();

	}
	
	public void updateUI() {
		
	}

	public static void main(String[] args) {
		ArrayList<RobotPC> robots = new ArrayList<RobotPC>();
		robots.add(new RobotPC(new LinkedBlockingQueue<RobotPC.Movement>()));
		robots.add(new RobotPC(new LinkedBlockingQueue<RobotPC.Movement>()));
		RobotControlUI robotUI = new RobotControlUI(new JobDataSore(), robots);

	}

	@Override
	public void run() {
	
		while(true) {
			// Maybe set a delay
			updateUI();
		}
	}
}

// Wont take the same form and more
// Will have cancel button, % complete if it is an active job and JobID
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
