package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import enamel.Buttons.CellsButtonsWindow;
import enamel.Buttons.PauseWindow;
import enamel.Buttons.TTSTextWindow;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Component;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CreateWindow implements ListSelectionListener {

	private JFrame frmCreateScenario;

	private JList<String> list_create;
	private DefaultListModel<String> listItems = new DefaultListModel<String>();
	
		public DefaultListModel<String> getListItems() {
			return listItems;
		}
	
		public void setListItems(DefaultListModel<String> listItems) {
			this.listItems = listItems;
		}

//		public void updateList(String[] itemsToAdd) {
//			for (int i=0; i < itemsToAdd.length; i++) {
//				listItems.addElement(itemsToAdd[i]);
//			}
//			list_create.setModel(listItems);
//		}
	//	
//	new AbstractListModel<String>() {
//		String[] values = new String[] {};
//		public int getSize() {
//			return values.length;
//		}
//		public String getElementAt(int index) {
//			return values[index];
//		}
//	}
	//private ButtonWindows bw;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateWindow window = new CreateWindow();
					window.frmCreateScenario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateScenario = new JFrame();
		frmCreateScenario.setTitle("Create Scenario");
		frmCreateScenario.setBounds(100, 100, 687, 481);
		frmCreateScenario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateScenario.getContentPane().setLayout(new BoxLayout(frmCreateScenario.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmCreateScenario.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel.gridheight = 8;
		gbc_buttonPanel.gridwidth = 8;
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 11;
		gbc_buttonPanel.gridy = 0;
		panel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnInsertSound = new JButton("Insert sound");
		btnInsertSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnResetButtonsIn = new JButton("Reset buttons in scenario");
		btnResetButtonsIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnInsertSkip = new JButton("Insert Skip ");
		btnInsertSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnInsertNumberOf = new JButton("Insert number of cells and buttons");
		btnInsertNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CellsButtonsWindow.main(null);
			}
		});
		GridBagConstraints gbc_btnInsertNumberOf = new GridBagConstraints();
		gbc_btnInsertNumberOf.fill = GridBagConstraints.BOTH;
		gbc_btnInsertNumberOf.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertNumberOf.gridx = 0;
		gbc_btnInsertNumberOf.gridy = 5;
		buttonPanel.add(btnInsertNumberOf, gbc_btnInsertNumberOf);
		
		JButton btnAddASentence = new JButton("Add a sentence");
		btnAddASentence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTSTextWindow.main(null);
			}
		});
		GridBagConstraints gbc_btnAddASentence = new GridBagConstraints();
		gbc_btnAddASentence.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddASentence.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddASentence.gridx = 0;
		gbc_btnAddASentence.gridy = 6;
		buttonPanel.add(btnAddASentence, gbc_btnAddASentence);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PauseWindow.main(null);
			}
		});
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPause.insets = new Insets(0, 0, 5, 0);
		gbc_btnPause.gridx = 0;
		gbc_btnPause.gridy = 7;
		buttonPanel.add(btnPause, gbc_btnPause);
		
		JButton btnDisplayASentence = new JButton("Display a sentence");
		GridBagConstraints gbc_btnDisplayASentence = new GridBagConstraints();
		gbc_btnDisplayASentence.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayASentence.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisplayASentence.gridx = 0;
		gbc_btnDisplayASentence.gridy = 8;
		buttonPanel.add(btnDisplayASentence, gbc_btnDisplayASentence);
		
		JButton btnSentenceToRepeat = new JButton("Sentence to repeat");
		GridBagConstraints gbc_btnSentenceToRepeat = new GridBagConstraints();
		gbc_btnSentenceToRepeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSentenceToRepeat.insets = new Insets(0, 0, 5, 0);
		gbc_btnSentenceToRepeat.gridx = 0;
		gbc_btnSentenceToRepeat.gridy = 9;
		buttonPanel.add(btnSentenceToRepeat, gbc_btnSentenceToRepeat);
		
		JButton btnInsertRepeatButton = new JButton("Insert Repeat button");
		GridBagConstraints gbc_btnInsertRepeatButton = new GridBagConstraints();
		gbc_btnInsertRepeatButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertRepeatButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertRepeatButton.gridx = 0;
		gbc_btnInsertRepeatButton.gridy = 10;
		buttonPanel.add(btnInsertRepeatButton, gbc_btnInsertRepeatButton);
		GridBagConstraints gbc_btnInsertSkip = new GridBagConstraints();
		gbc_btnInsertSkip.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertSkip.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertSkip.gridx = 0;
		gbc_btnInsertSkip.gridy = 11;
		buttonPanel.add(btnInsertSkip, gbc_btnInsertSkip);
		GridBagConstraints gbc_btnResetButtonsIn = new GridBagConstraints();
		gbc_btnResetButtonsIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResetButtonsIn.insets = new Insets(0, 0, 5, 0);
		gbc_btnResetButtonsIn.gridx = 0;
		gbc_btnResetButtonsIn.gridy = 12;
		buttonPanel.add(btnResetButtonsIn, gbc_btnResetButtonsIn);
		GridBagConstraints gbc_btnInsertSound = new GridBagConstraints();
		gbc_btnInsertSound.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertSound.insets = new Insets(0, 0, 5, 0);
		gbc_btnInsertSound.gridx = 0;
		gbc_btnInsertSound.gridy = 13;
		buttonPanel.add(btnInsertSound, gbc_btnInsertSound);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel = new JLabel("Braille Cell Actions");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 10;
		gbc_lblNewLabel.gridy = 8;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnDeleteALine = new JButton("Delete a line");
		GridBagConstraints gbc_btnDeleteALine = new GridBagConstraints();
		gbc_btnDeleteALine.gridwidth = 2;
		gbc_btnDeleteALine.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteALine.gridx = 1;
		gbc_btnDeleteALine.gridy = 9;
		panel.add(btnDeleteALine, gbc_btnDeleteALine);
		
		JButton btnNewButton_1 = new JButton("Add a line");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 9;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JPanel cellButtonsPanel = new JPanel();
		GridBagConstraints gbc_cellButtonsPanel = new GridBagConstraints();
		gbc_cellButtonsPanel.gridwidth = 11;
		gbc_cellButtonsPanel.gridheight = 5;
		gbc_cellButtonsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_cellButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_cellButtonsPanel.gridx = 8;
		gbc_cellButtonsPanel.gridy = 9;
		panel.add(cellButtonsPanel, gbc_cellButtonsPanel);
		GridBagLayout gbl_cellButtonsPanel = new GridBagLayout();
		gbl_cellButtonsPanel.columnWidths = new int[]{134, 157, 0};
		gbl_cellButtonsPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_cellButtonsPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_cellButtonsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		cellButtonsPanel.setLayout(gbl_cellButtonsPanel);
		
		JButton btnNewButton_2 = new JButton("Clear all cells");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 0;
		cellButtonsPanel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnDisplayCellCharacter = new JButton("Display cell character");
		GridBagConstraints gbc_btnDisplayCellCharacter = new GridBagConstraints();
		gbc_btnDisplayCellCharacter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayCellCharacter.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisplayCellCharacter.gridx = 1;
		gbc_btnDisplayCellCharacter.gridy = 0;
		cellButtonsPanel.add(btnDisplayCellCharacter, gbc_btnDisplayCellCharacter);
		
		JButton btnDisplayClearCell = new JButton("Display clear cell");
		GridBagConstraints gbc_btnDisplayClearCell = new GridBagConstraints();
		gbc_btnDisplayClearCell.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayClearCell.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayClearCell.gridx = 0;
		gbc_btnDisplayClearCell.gridy = 1;
		cellButtonsPanel.add(btnDisplayClearCell, gbc_btnDisplayClearCell);
		
		JButton btnRaise = new JButton("Raise single cell pin");
		GridBagConstraints gbc_btnRaise = new GridBagConstraints();
		gbc_btnRaise.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRaise.insets = new Insets(0, 0, 5, 0);
		gbc_btnRaise.gridx = 1;
		gbc_btnRaise.gridy = 1;
		cellButtonsPanel.add(btnRaise, gbc_btnRaise);
		
		JButton btnDisplayCellPins = new JButton("Display cell pins");
		GridBagConstraints gbc_btnDisplayCellPins = new GridBagConstraints();
		gbc_btnDisplayCellPins.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayCellPins.insets = new Insets(0, 0, 0, 5);
		gbc_btnDisplayCellPins.gridx = 0;
		gbc_btnDisplayCellPins.gridy = 2;
		cellButtonsPanel.add(btnDisplayCellPins, gbc_btnDisplayCellPins);
		
		JButton btnSetSingleCell = new JButton("Set single cell pin");
		GridBagConstraints gbc_btnSetSingleCell = new GridBagConstraints();
		gbc_btnSetSingleCell.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSetSingleCell.gridx = 1;
		gbc_btnSetSingleCell.gridy = 2;
		cellButtonsPanel.add(btnSetSingleCell, gbc_btnSetSingleCell);
		
		JButton btnNewButton_4 = new JButton("Back to Home ");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 2;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 13;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Save & Exit");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 13;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JMenuBar menuBar = new JMenuBar();
		frmCreateScenario.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmScenarioFormat = new JMenuItem("Scenario Format");
		mnHelp.add(mntmScenarioFormat);
		
		JMenuItem mntmHowToWrite = new JMenuItem("How to write Scenario");
		mnHelp.add(mntmHowToWrite);
		
		list_create = new JList<String>(listItems);
		//list_create.setValueIsAdjusting(false);
		list_create.addListSelectionListener(this);
		list_create.setToolTipText("List which displays the events of the scenario");
		//list_create.setModel(listItems);
		scrollPane.setViewportView(list_create);
		list_create.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_create.setSelectedIndex(0);
	}

	public JList<String> getList_create() {
		return list_create;
	}

	public void setList_create(JList<String> list_create) {
		this.list_create = list_create;
	}

	public JFrame getFrmCreateScenario() {
		return frmCreateScenario;
	}

	public void setFrmCreateScenario(JFrame frmCreateScenario) {
		this.frmCreateScenario = frmCreateScenario;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getValueIsAdjusting() == false) {
			if(list_create.getSelectedIndex() == -1) {
				
			}
		}
	}

}
