package enamel.Buttons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CellsButtonsWindow {

	private JFrame cellsBtnsFrame;
	private JTextField numCells;
	private JTextField numBtns;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CellsButtonsWindow window = new CellsButtonsWindow();
					window.cellsBtnsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CellsButtonsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cellsBtnsFrame = new JFrame();
		cellsBtnsFrame.setResizable(false);
		cellsBtnsFrame.setTitle("Cells and Buttons");
		cellsBtnsFrame.setBounds(100, 100, 281, 137);
		cellsBtnsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cellsBtnsFrame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		cellsBtnsFrame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{15, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNumCells = new JLabel("Enter number of cells:     ");
		lblNumCells.setToolTipText("Enter number of braille cells to display in scenario");
		GridBagConstraints gbc_lblNumCells = new GridBagConstraints();
		gbc_lblNumCells.gridwidth = 4;
		gbc_lblNumCells.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumCells.gridx = 0;
		gbc_lblNumCells.gridy = 1;
		panel.add(lblNumCells, gbc_lblNumCells);
		
		numCells = new JTextField();
		GridBagConstraints gbc_numCells = new GridBagConstraints();
		gbc_numCells.gridwidth = 4;
		gbc_numCells.insets = new Insets(0, 0, 5, 5);
		gbc_numCells.fill = GridBagConstraints.HORIZONTAL;
		gbc_numCells.gridx = 4;
		gbc_numCells.gridy = 1;
		panel.add(numCells, gbc_numCells);
		numCells.setColumns(10);
		
		JLabel lbNumBtns = new JLabel("Enter number of buttons:");
		lbNumBtns.setToolTipText("Enter number of buttons to display in scenario");
		GridBagConstraints gbc_lbNumBtns = new GridBagConstraints();
		gbc_lbNumBtns.gridwidth = 4;
		gbc_lbNumBtns.insets = new Insets(0, 0, 5, 5);
		gbc_lbNumBtns.gridx = 0;
		gbc_lbNumBtns.gridy = 2;
		panel.add(lbNumBtns, gbc_lbNumBtns);
		
		numBtns = new JTextField();
		numBtns.setColumns(10);
		GridBagConstraints gbc_numBtns = new GridBagConstraints();
		gbc_numBtns.gridwidth = 4;
		gbc_numBtns.insets = new Insets(0, 0, 5, 5);
		gbc_numBtns.fill = GridBagConstraints.HORIZONTAL;
		gbc_numBtns.gridx = 4;
		gbc_numBtns.gridy = 2;
		panel.add(numBtns, gbc_numBtns);
		
		JButton btnOk = new JButton("Okay");
		btnOk.setToolTipText("Press okay button to add the number of cells and buttons into file");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.gridwidth = 6;
		gbc_btnOk.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 3;
		panel.add(btnOk, gbc_btnOk);
	}

}
