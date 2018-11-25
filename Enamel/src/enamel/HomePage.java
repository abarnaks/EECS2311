package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class HomePage {

	private JFrame frmHome;
	
	//private CreateWindow cswin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.setBounds(100, 100, 399, 321);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblWelcomeToAuthoringapp = new JLabel("Welcome to AuthoringApp");
		lblWelcomeToAuthoringapp.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		frmHome.getContentPane().add(lblWelcomeToAuthoringapp, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frmHome.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 89, 0, 0, 89, 0};
		gbl_panel.rowHeights = new int[]{23, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnStartTBB = new JButton("Start TBB");
		btnStartTBB.setToolTipText("Runs the scenario file on a virtual Treasure Box Braille");
		GridBagConstraints gbc_btnStartTBB = new GridBagConstraints();
		gbc_btnStartTBB.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStartTBB.gridwidth = 3;
		gbc_btnStartTBB.insets = new Insets(0, 0, 5, 5);
		gbc_btnStartTBB.gridx = 1;
		gbc_btnStartTBB.gridy = 1;
		panel.add(btnStartTBB, gbc_btnStartTBB);
		
		JButton btnCreateNewScenario = new JButton("Create New Scenario");
		btnCreateNewScenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmHome.setVisible(false);
				CreateWindow.main(null);
			}
		});
		btnCreateNewScenario.setToolTipText("Creates a new scenario file from scratch");
		GridBagConstraints gbc_btnCreateNewScenario = new GridBagConstraints();
		gbc_btnCreateNewScenario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateNewScenario.gridwidth = 3;
		gbc_btnCreateNewScenario.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewScenario.gridx = 1;
		gbc_btnCreateNewScenario.gridy = 3;
		panel.add(btnCreateNewScenario, gbc_btnCreateNewScenario);
		
		JButton btnEditScenario = new JButton("Edit a Scenario");
		btnEditScenario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
				int selFile = fc.showOpenDialog(null);
				if (selFile == JFileChooser.APPROVE_OPTION) {
					//what are we opening?
					//separate edit window or create window with modifications??
					// have class to convert file to list
				}
			}
		});
		btnEditScenario.setToolTipText("Edits an existing scenario file");
		GridBagConstraints gbc_btnEditScenario = new GridBagConstraints();
		gbc_btnEditScenario.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditScenario.gridwidth = 3;
		gbc_btnEditScenario.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditScenario.gridx = 1;
		gbc_btnEditScenario.gridy = 5;
		panel.add(btnEditScenario, gbc_btnEditScenario);
		
		JButton btnExit = new JButton("Exit app");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHome.dispose();
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridwidth = 3;
		gbc_btnExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 7;
		panel.add(btnExit, gbc_btnExit);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
