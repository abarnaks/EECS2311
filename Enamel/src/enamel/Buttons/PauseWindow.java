package enamel.Buttons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class PauseWindow {

	private JFrame frmPause;
	private JTextField pauseTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PauseWindow window = new PauseWindow();
					window.frmPause.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PauseWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPause = new JFrame();
		frmPause.setTitle("Pause Time");
		frmPause.setBounds(100, 100, 496, 94);
		frmPause.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPause.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frmPause.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPausePrompt = new JLabel("How long would you like to pause for ? Enter a positive number.");
		GridBagConstraints gbc_lblPausePrompt = new GridBagConstraints();
		gbc_lblPausePrompt.gridwidth = 4;
		gbc_lblPausePrompt.insets = new Insets(0, 0, 5, 5);
		gbc_lblPausePrompt.gridx = 0;
		gbc_lblPausePrompt.gridy = 0;
		panel.add(lblPausePrompt, gbc_lblPausePrompt);
		
		pauseTime = new JTextField();
		pauseTime.setColumns(10);
		GridBagConstraints gbc_pauseTime = new GridBagConstraints();
		gbc_pauseTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_pauseTime.gridwidth = 4;
		gbc_pauseTime.insets = new Insets(0, 0, 5, 5);
		gbc_pauseTime.gridx = 4;
		gbc_pauseTime.gridy = 0;
		panel.add(pauseTime, gbc_pauseTime);
		
		JButton btnOk = new JButton("Okay");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridwidth = 7;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 2;
		gbc_btnOk.gridy = 1;
		panel.add(btnOk, gbc_btnOk);
	}

}
