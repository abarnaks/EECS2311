package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import enamel.ScenEvents.*;
import enamel.ListToFile.*;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.List;

public class CreateWindow {

	//protected static final String ScenEvents = null;

	private JFrame frmCreateScenario;

	private JPanel buttonPanel;
	private JPanel cellButtonsPanel;
	private JPanel panelBtnAction;
	private JButton btnDeleteALine;
	private static boolean edit;
	ListToFile lfs = new ListToFile();
	Translator ftl_direct = new Translator();
	private static DefaultListModel<Object> listItems = new DefaultListModel<Object>();
	
	private static JList<Object> list;
	
	//private static ScenObjectsList sol = new ScenObjectsList();
	private static final ScenEvents se = new ScenEvents();
	private int cells;
	private int buttons;
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
		frmCreateScenario.setResizable(false);
		frmCreateScenario.setTitle("Create Scenario");
		frmCreateScenario.setBounds(100, 100, 871, 492);
		frmCreateScenario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateScenario.getContentPane().setLayout(new BoxLayout(frmCreateScenario.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmCreateScenario.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panelBtnAction = new JPanel();	//the panel to switch between main buttons and sub panels for each button action
		GridBagConstraints gbc_panelBtnAction = new GridBagConstraints();
		gbc_panelBtnAction.gridwidth = 8;
		gbc_panelBtnAction.fill = GridBagConstraints.BOTH;
		gbc_panelBtnAction.gridheight = 7;
		gbc_panelBtnAction.insets = new Insets(0, 0, 5, 0);
		gbc_panelBtnAction.gridx = 14;
		gbc_panelBtnAction.gridy = 0;
		panel.add(panelBtnAction, gbc_panelBtnAction);
		GridBagLayout gbl_panelBtnAction = new GridBagLayout();
		gbl_panelBtnAction.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBtnAction.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBtnAction.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBtnAction.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelBtnAction.setLayout(gbl_panelBtnAction);
		
		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridheight = 6;
		gbc_buttonPanel.gridwidth = 13;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 1;
		panelBtnAction.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JLabel lblGeneralActions = new JLabel("General Actions");
		GridBagConstraints gbc_lblGeneralActions = new GridBagConstraints();
		gbc_lblGeneralActions.gridwidth = 3;
		gbc_lblGeneralActions.insets = new Insets(0, 0, 5, 5);
		gbc_lblGeneralActions.gridx = 0;
		gbc_lblGeneralActions.gridy = 2;
		buttonPanel.add(lblGeneralActions, gbc_lblGeneralActions);
		lblGeneralActions.setFont(new Font("Gadugi", Font.BOLD, 13));
		
		JButton btnSentenceToRepeat = new JButton("Sentence to repeat");	//done
		btnSentenceToRepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(RepSentPanel());
			}
		});
		
		JButton btnInsertNumberOf_1 = new JButton("Insert number of cells");
		btnInsertNumberOf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(InsertCellPanel());
			}
		});
		GridBagConstraints gbc_btnInsertNumberOf_1 = new GridBagConstraints();
		gbc_btnInsertNumberOf_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertNumberOf_1.gridwidth = 3;
		gbc_btnInsertNumberOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertNumberOf_1.gridx = 0;
		gbc_btnInsertNumberOf_1.gridy = 3;
		buttonPanel.add(btnInsertNumberOf_1, gbc_btnInsertNumberOf_1);
		GridBagConstraints gbc_btnSentenceToRepeat = new GridBagConstraints();
		gbc_btnSentenceToRepeat.gridwidth = 3;
		gbc_btnSentenceToRepeat.fill = GridBagConstraints.BOTH;
		gbc_btnSentenceToRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_btnSentenceToRepeat.gridx = 4;
		gbc_btnSentenceToRepeat.gridy = 3;
		buttonPanel.add(btnSentenceToRepeat, gbc_btnSentenceToRepeat);
		
		JButton btnInsertRepeatButton = new JButton("Insert Repeat button");	//done
		btnInsertRepeatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(InsertRepeatButtonPanel());
			}
		});
		
		JButton btnInsertNumberOf = new JButton("Insert number of buttons");	//done
		btnInsertNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(InsertButtonsPanel());
			}
		});
		GridBagConstraints gbc_btnInsertNumberOf = new GridBagConstraints();
		gbc_btnInsertNumberOf.gridwidth = 3;
		gbc_btnInsertNumberOf.fill = GridBagConstraints.BOTH;
		gbc_btnInsertNumberOf.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertNumberOf.gridx = 0;
		gbc_btnInsertNumberOf.gridy = 4;
		buttonPanel.add(btnInsertNumberOf, gbc_btnInsertNumberOf);
		GridBagConstraints gbc_btnInsertRepeatButton = new GridBagConstraints();
		gbc_btnInsertRepeatButton.gridwidth = 3;
		gbc_btnInsertRepeatButton.fill = GridBagConstraints.BOTH;
		gbc_btnInsertRepeatButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertRepeatButton.gridx = 4;
		gbc_btnInsertRepeatButton.gridy = 4;
		buttonPanel.add(btnInsertRepeatButton, gbc_btnInsertRepeatButton);
		
		JButton btnInsertSkip = new JButton("Insert Skip ");
		btnInsertSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(SetSkipPanel());
			}
		});
		
		JButton btnAddaSentence = new JButton("Add a sentence");	//done
		btnAddaSentence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(AddSentPanel());
			}
		});
		GridBagConstraints gbc_btnAddaSentence = new GridBagConstraints();
		gbc_btnAddaSentence.gridwidth = 3;
		gbc_btnAddaSentence.fill = GridBagConstraints.BOTH;
		gbc_btnAddaSentence.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddaSentence.gridx = 0;
		gbc_btnAddaSentence.gridy = 5;
		buttonPanel.add(btnAddaSentence, gbc_btnAddaSentence);
		GridBagConstraints gbc_btnInsertSkip = new GridBagConstraints();
		gbc_btnInsertSkip.gridwidth = 3;
		gbc_btnInsertSkip.fill = GridBagConstraints.BOTH;
		gbc_btnInsertSkip.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertSkip.gridx = 4;
		gbc_btnInsertSkip.gridy = 5;
		buttonPanel.add(btnInsertSkip, gbc_btnInsertSkip);
		
		JButton button = new JButton("Add header to section for Skip");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(HeaderPanel());
			}
		});
		
		JButton btnPause = new JButton("Pause");	//done
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(PausePanel());		
			}
		});
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.gridwidth = 3;
		gbc_btnPause.fill = GridBagConstraints.BOTH;
		gbc_btnPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPause.gridx = 0;
		gbc_btnPause.gridy = 6;
		buttonPanel.add(btnPause, gbc_btnPause);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 3;
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 6;
		buttonPanel.add(button, gbc_button);
		
		JButton btnIndicateScenarioFor = new JButton("Indicate Scenario for User input");	//done
		btnIndicateScenarioFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserInput uin = se.new UserInput();
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), uin);
					lfs.convertToFile.set(list.getSelectedIndex(), uin.toFile());
				} else {
					listItems.addElement(uin);
					lfs.convertToFile.addElement(uin.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton btnDisplayASentence = new JButton("Display a sentence");	//done
		btnDisplayASentence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(DispSentPanel());
			}
		});
		GridBagConstraints gbc_btnDisplayASentence = new GridBagConstraints();
		gbc_btnDisplayASentence.gridwidth = 3;
		gbc_btnDisplayASentence.fill = GridBagConstraints.BOTH;
		gbc_btnDisplayASentence.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayASentence.gridx = 0;
		gbc_btnDisplayASentence.gridy = 7;
		buttonPanel.add(btnDisplayASentence, gbc_btnDisplayASentence);
		GridBagConstraints gbc_btnIndicateScenarioFor = new GridBagConstraints();
		gbc_btnIndicateScenarioFor.gridwidth = 3;
		gbc_btnIndicateScenarioFor.fill = GridBagConstraints.BOTH;
		gbc_btnIndicateScenarioFor.insets = new Insets(0, 0, 5, 5);
		gbc_btnIndicateScenarioFor.gridx = 4;
		gbc_btnIndicateScenarioFor.gridy = 7;
		buttonPanel.add(btnIndicateScenarioFor, gbc_btnIndicateScenarioFor);
		
		JButton btnResetButtonsIn = new JButton("Reset buttons in scenario");	//done
		btnResetButtonsIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetButtons rs = se.new ResetButtons();
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), rs);
					lfs.convertToFile.set(list.getSelectedIndex(), rs.toFile());
				} else {
					listItems.addElement(rs);
					lfs.convertToFile.addElement(rs.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton btnInsertSound = new JButton("Insert sound");	//done - record part to be implemented
		btnInsertSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(InsertSoundPanel());	
			}
		});
		GridBagConstraints gbc_btnInsertSound = new GridBagConstraints();
		gbc_btnInsertSound.gridwidth = 3;
		gbc_btnInsertSound.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertSound.fill = GridBagConstraints.BOTH;
		gbc_btnInsertSound.gridx = 0;
		gbc_btnInsertSound.gridy = 8;
		buttonPanel.add(btnInsertSound, gbc_btnInsertSound);
		GridBagConstraints gbc_btnResetButtonsIn = new GridBagConstraints();
		gbc_btnResetButtonsIn.gridwidth = 3;
		gbc_btnResetButtonsIn.fill = GridBagConstraints.BOTH;
		gbc_btnResetButtonsIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnResetButtonsIn.gridx = 4;
		gbc_btnResetButtonsIn.gridy = 8;
		buttonPanel.add(btnResetButtonsIn, gbc_btnResetButtonsIn);
		
		JPanel panelList = new JPanel();
		GridBagConstraints gbc_panelList = new GridBagConstraints();
		gbc_panelList.gridheight = 9;
		gbc_panelList.gridwidth = 11;
		gbc_panelList.insets = new Insets(0, 0, 5, 5);
		gbc_panelList.fill = GridBagConstraints.BOTH;
		gbc_panelList.gridx = 1;
		gbc_panelList.gridy = 1;
		panel.add(panelList, gbc_panelList);
		panelList.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelList.add(scrollPane);
		
		list = new JList<Object>();
//		list.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent mouseEvent) {
//				JList<Object> click = (JList) mouseEvent.getSource();
//				if (mouseEvent.getClickCount() == 2) {
//					int index = click.locationToIndex(mouseEvent.getPoint());
//					if (index >= 0) {
//						Object curr = click.getModel().getElementAt(index);
//						//System.out.println(curr.toString());
//						//EditItem(curr);
//					}
//				}
//			}
//		});
		scrollPane.setViewportView(list);
		
		cellButtonsPanel = new JPanel();
		GridBagConstraints gbc_cellButtonsPanel = new GridBagConstraints();
		gbc_cellButtonsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_cellButtonsPanel.gridwidth = 8;
		gbc_cellButtonsPanel.gridheight = 5;
		gbc_cellButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_cellButtonsPanel.gridx = 14;
		gbc_cellButtonsPanel.gridy = 7;
		panel.add(cellButtonsPanel, gbc_cellButtonsPanel);
		GridBagLayout gbl_cellButtonsPanel = new GridBagLayout();
		gbl_cellButtonsPanel.columnWidths = new int[]{134, 157, 0};
		gbl_cellButtonsPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_cellButtonsPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_cellButtonsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		cellButtonsPanel.setLayout(gbl_cellButtonsPanel);
		
		JButton btnClrAllCells = new JButton("Clear all cells");	//done
		btnClrAllCells.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearAllCells clrAll = se.new ClearAllCells();
				if (isEdit()) {
					listItems.set(list.getSelectedIndex(), clrAll);
					lfs.convertToFile.set(list.getSelectedIndex(), clrAll.toFile());
				} else {
					listItems.addElement(clrAll);
					lfs.convertToFile.addElement(clrAll.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Braille Cell Actions");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		cellButtonsPanel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 13));
		GridBagConstraints gbc_btnClrAllCells = new GridBagConstraints();
		gbc_btnClrAllCells.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClrAllCells.insets = new Insets(0, 0, 5, 5);
		gbc_btnClrAllCells.gridx = 0;
		gbc_btnClrAllCells.gridy = 1;
		cellButtonsPanel.add(btnClrAllCells, gbc_btnClrAllCells);
		
		JButton btnDisplayClearCell = new JButton("Display clear cell");
		btnDisplayClearCell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(ClearOneCellPanel());	
			}
		});
		
		JButton btnDisplayCellCharacter = new JButton("Display cell character");
		btnDisplayCellCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(SetCellToCharPanel());
			}
		});
		GridBagConstraints gbc_btnDisplayCellCharacter = new GridBagConstraints();
		gbc_btnDisplayCellCharacter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayCellCharacter.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisplayCellCharacter.gridx = 1;
		gbc_btnDisplayCellCharacter.gridy = 1;
		cellButtonsPanel.add(btnDisplayCellCharacter, gbc_btnDisplayCellCharacter);
		GridBagConstraints gbc_btnDisplayClearCell = new GridBagConstraints();
		gbc_btnDisplayClearCell.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayClearCell.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayClearCell.gridx = 0;
		gbc_btnDisplayClearCell.gridy = 2;
		cellButtonsPanel.add(btnDisplayClearCell, gbc_btnDisplayClearCell);
		
		JButton btnDisplayCellPins = new JButton("Display cell pins");
		btnDisplayCellPins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(SetCellToSeqPanel());	
			}
		});
		
		JButton btnRaise = new JButton("Raise single cell pin");
		btnRaise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(RaiseOneCellPinPanel());
			}
		});
		GridBagConstraints gbc_btnRaise = new GridBagConstraints();
		gbc_btnRaise.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRaise.insets = new Insets(0, 0, 5, 0);
		gbc_btnRaise.gridx = 1;
		gbc_btnRaise.gridy = 2;
		cellButtonsPanel.add(btnRaise, gbc_btnRaise);
		GridBagConstraints gbc_btnDisplayCellPins = new GridBagConstraints();
		gbc_btnDisplayCellPins.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayCellPins.insets = new Insets(0, 0, 0, 5);
		gbc_btnDisplayCellPins.gridx = 0;
		gbc_btnDisplayCellPins.gridy = 3;
		cellButtonsPanel.add(btnDisplayCellPins, gbc_btnDisplayCellPins);
		
		JButton btnSetSingleCell = new JButton("Lower single cell pin");
		btnSetSingleCell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				cellButtonsPanel.setVisible(false);
				panelBtnAction.add(LowerOneCellPinPanel());
			}
		});
		GridBagConstraints gbc_btnSetSingleCell = new GridBagConstraints();
		gbc_btnSetSingleCell.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSetSingleCell.gridx = 1;
		gbc_btnSetSingleCell.gridy = 3;
		cellButtonsPanel.add(btnSetSingleCell, gbc_btnSetSingleCell);
		
		JButton btnBacktoHome = new JButton("Back to Home ");
		btnBacktoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//need to implement message window asking whether to close without saving
				int option = JOptionPane.showConfirmDialog(null, "Return to home page without saving scenario?", "Scenario", JOptionPane.OK_CANCEL_OPTION);
				//int option = JOptionPane.showConfirmDialog(this, "Wrong Username/Password");
				if (option == JOptionPane.OK_OPTION){
					getFrmCreateScenario().setVisible(false);
					HomePage.main(null);
				} else if (option == JOptionPane.CANCEL_OPTION){
					getFrmCreateScenario().setVisible(true);
					
				}
				
			}
		});
		
		btnDeleteALine = new JButton("Delete a line");
		btnDeleteALine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = list.getSelectedIndex();
				int size = listItems.getSize();
				
				if (index < 0) {
					JOptionPane.showMessageDialog(null, "Please select line on list to delete", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					listItems.remove(index);
				
					if (size == 0) {
						btnDeleteALine.setEnabled(false);
					} else {
						if (index == listItems.getSize()) {
							//removing item in last position
							index--;
						}
						list.setSelectedIndex(index);
						list.ensureIndexIsVisible(index);
					}
				}
			}
		});
		GridBagConstraints gbc_btnDeleteALine = new GridBagConstraints();
		gbc_btnDeleteALine.gridwidth = 3;
		gbc_btnDeleteALine.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteALine.gridx = 2;
		gbc_btnDeleteALine.gridy = 11;
		panel.add(btnDeleteALine, gbc_btnDeleteALine);
		
		JButton btnEditLine = new JButton("Edit Line");
		btnEditLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list.getSelectedIndex();
				int size = listItems.getSize();
				
				if (index < 0) {
					JOptionPane.showMessageDialog(null, "Please select line on list to edit", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Object curr = listItems.getElementAt(index);
					EditItem(curr);
				}
				
//				if (size == 0) {
//					btnEditLine.setEnabled(false);
//				}	
				//make it so it is enabled only if the user selected something
			}
		});
		GridBagConstraints gbc_btnAddLine = new GridBagConstraints();
		gbc_btnAddLine.gridwidth = 3;
		gbc_btnAddLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLine.gridx = 6;
		gbc_btnAddLine.gridy = 11;
		panel.add(btnEditLine, gbc_btnAddLine);
		GridBagConstraints gbc_btnBacktoHome = new GridBagConstraints();
		gbc_btnBacktoHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBacktoHome.gridwidth = 4;
		gbc_btnBacktoHome.insets = new Insets(0, 0, 5, 5);
		gbc_btnBacktoHome.gridx = 14;
		gbc_btnBacktoHome.gridy = 12;
		panel.add(btnBacktoHome, gbc_btnBacktoHome);
		
		JButton btnSaveExit = new JButton("Save & Close File");
		btnSaveExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file = saveScenarioWindow();
				lfs.writeToFile(lfs.convertToFile, file);
			}
		});
		GridBagConstraints gbc_btnSaveExit = new GridBagConstraints();
		gbc_btnSaveExit.gridwidth = 2;
		gbc_btnSaveExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSaveExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveExit.gridx = 19;
		gbc_btnSaveExit.gridy = 12;
		panel.add(btnSaveExit, gbc_btnSaveExit);
		
		JMenuBar menuBar = new JMenuBar();
		frmCreateScenario.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSaveFile = new JMenuItem("Save File");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = saveScenarioWindow();
				lfs.writeToFile(lfs.convertToFile, file);
				getFrmCreateScenario().setVisible(false);
				HomePage.main(null);
			}
		});
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Return to Return to main menu?", "Scenario", JOptionPane.OK_CANCEL_OPTION);
				//int option = JOptionPane.showConfirmDialog(this, "Wrong Username/Password");
				if (option == JOptionPane.OK_OPTION){
					getFrmCreateScenario().setVisible(false);
					HomePage.main(null);
				} else if (option == JOptionPane.CANCEL_OPTION){
					getFrmCreateScenario().setVisible(true);	
				}
			}
		});
		mnFile.add(mntmClose);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmScenarioFormat = new JMenuItem("Scenario Format");
		mnHelp.add(mntmScenarioFormat);
		
		JMenuItem mntmHowToWrite = new JMenuItem("How to write Scenario");
		mnHelp.add(mntmHowToWrite);
		
	}

	public File saveScenarioWindow() {
		JFrame winSave = new JFrame();
		
		if (lfs.getLastDirSave() != null) {
			//when you edit and save file
			JFileChooser saveFile = new JFileChooser(lfs.lastDirSave);
			saveFile.setDialogTitle("Enter the file to save");
			int userSel = saveFile.showSaveDialog(winSave);
			
			if (userSel == JFileChooser.APPROVE_OPTION) {
				File fts = saveFile.getSelectedFile();
				lfs.lastDirSave = fts.getParent();
				return fts;
			} else {
				return null;
			}
		} else {
			JFileChooser saveFile = new JFileChooser();
			saveFile.setDialogTitle("Enter the file to save");
			int userSel = saveFile.showSaveDialog(winSave);
			
			if(userSel == JFileChooser.APPROVE_OPTION) {
				File fts = saveFile.getSelectedFile();
				lfs.lastDirSave = fts.getParent();
				return fts;
			} else {
				return null;
			}
		}
	}
	
	public static boolean isEdit() {
		return edit;
	}

	public static void setEdit(boolean edit) {
		CreateWindow.edit = edit;
	}
	
	public void EditItem(Object o) {
		setEdit(true);
		if (o.getClass() == Cells.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertCellPanel());
			//System.out.println("yes it is a cell class");
		} else if (o.getClass() == Buttons.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertButtonsPanel());
			
		} else if (o.getClass() == AddASentence.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(AddSentPanel());
			
		}  else if (o.getClass() == Pause.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(PausePanel());
			
		} else if (o.getClass() == DisplaySentence.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(DispSentPanel());
			
		} else if (o.getClass() == SentenceToRepeat.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(RepSentPanel());
			
		} else if (o.getClass() == InsertRepeatButton.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertRepeatButtonPanel());
			
		} else if (o.getClass() == SetSkipButton.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(SetSkipPanel());
			
		} else if (o.getClass() == SkipHeader.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(HeaderPanel());
			
		} else if (o.getClass() == InsertSound.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertSoundPanel());
			
		} else if (o.getClass() == InsertRepeatButton.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertRepeatButtonPanel());
			
		} else if (o.getClass() == OneCellClear.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(ClearOneCellPanel());
			
		} else if (o.getClass() == SetCharToCell.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(SetCellToCharPanel());
			
		} else if (o.getClass() == SetCellPins.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(SetCellToSeqPanel());
			
		} else if (o.getClass() == RaiseOneCellPin.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(RaiseOneCellPinPanel());
			
		} else if (o.getClass() == LowerOneCellPin.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(LowerOneCellPinPanel());
			
		} 
	}
	public JPanel InsertCellPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel cellPrompt = new JLabel("Enter the number of braille cells for this scenario:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(cellPrompt, dim);
		
		JTextField numCell = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(numCell, dim);
		
		JButton okInsCellsBtns = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okInsCellsBtns, dim);
		okInsCellsBtns.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//CellsButtons cd = se.new CellsButtons(Integer.parseInt(numCell.getText()), Integer.parseInt(numBtns.getText()));
					Cells c = se.new Cells(Integer.parseInt(numCell.getText()));
					setCells(Integer.parseInt(numCell.getText()));
				
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					//if (numCell.getText() != null) {
						listItems.set(list.getSelectedIndex(), c);
						lfs.convertToFile.set(list.getSelectedIndex(), c.toFile());
				} else {
					listItems.addElement(c);
					lfs.convertToFile.addElement(c.toFile());
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel InsertButtonsPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel btnPrompt = new JLabel("Enter the number of buttons for this scenario:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(btnPrompt, dim);
		
		JTextField numBtns = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(numBtns, dim);
		
		JButton okInsCellsBtns = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okInsCellsBtns, dim);
		okInsCellsBtns.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//CellsButtons cd = se.new CellsButtons(Integer.parseInt(numCell.getText()), Integer.parseInt(numBtns.getText()));
					Buttons b = se.new Buttons(Integer.parseInt(numBtns.getText()));
					setBtns(Integer.parseInt(numBtns.getText()));
					
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
						listItems.set(list.getSelectedIndex(), b);
						lfs.convertToFile.set(list.getSelectedIndex(), b.toFile());
					//}
				} else {
					
					listItems.addElement(b);
					lfs.convertToFile.addElement(b.toFile());
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	public JPanel AddSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel prompt = new JLabel("Enter the sentence you would like to be read on screen:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JTextField sentence = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(sentence, dim);
		
		JButton okAddSent = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okAddSent, dim);
		okAddSent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				AddASentence s = se.new AddASentence(sentence.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), s);
					lfs.convertToFile.set(list.getSelectedIndex(), s.toFile());
				} else {
					listItems.addElement(s);
					lfs.convertToFile.addElement(s.toFile());;
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel PausePanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel prompt = new JLabel("How long would you like to pause for?");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JTextField pauseInt = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(pauseInt, dim);
		
		JButton okPause = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okPause, dim);
		okPause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				Pause p = se.new Pause(Integer.parseInt(pauseInt.getText()));
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), p);
					lfs.convertToFile.set(list.getSelectedIndex(), p.toFile());
				} else {
					listItems.addElement(p);
					lfs.convertToFile.addElement(p.toFile());
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel DispSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel prompt = new JLabel("Enter the sentence you would like to display on screen:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JTextField sentence = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(sentence, dim);
		
		JButton okDispSent = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okDispSent, dim);
		okDispSent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				DisplaySentence ds = se.new DisplaySentence(sentence.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ds);
					lfs.convertToFile.set(list.getSelectedIndex(), ds.toFile());
				} else {
					listItems.addElement(ds);
					lfs.convertToFile.addElement(ds.toFile());
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel RepSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel prompt = new JLabel("Enter the sentence you would like to have repeated when a repeat button is pressed:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JTextField repSentence = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(repSentence, dim);
		
		JButton okRepSent = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okRepSent, dim);
		okRepSent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				SentenceToRepeat s = se.new SentenceToRepeat(repSentence.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), s);
					lfs.convertToFile.set(list.getSelectedIndex(), s.toFile());
				} else {
					listItems.addElement(s);
					lfs.convertToFile.addElement(s.toFile());
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel InsertRepeatButtonPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a button to set as your button to repeat phrases");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getBtns(); c++) {
			String s = "Button " + (c + 1);
			btn.addItem(s);
		}
		pPanel.add(btn);
		
		JButton okRB = new JButton("Okay");
		pPanel.add(okRB);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				JOptionPane.showMessageDialog(null, "If there is no sentence to repeat preceding this action, scenario will not repeat anything", "Warning", JOptionPane.INFORMATION_MESSAGE);
				InsertRepeatButton rb = se.new InsertRepeatButton(btn.getSelectedIndex());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), rb);
					lfs.convertToFile.set(list.getSelectedIndex(), rb.toFile());
				} else {
					listItems.addElement(rb);
					lfs.convertToFile.addElement(rb.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 5;
		dim.gridy = 2;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	//setSkip -- take time to understand what is happening
	public JPanel SetSkipPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(6,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a button to set as the button to skip to next section");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getBtns(); c++) {
			String s = "Button " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		
		JLabel prompt2 = new JLabel("Enter the header which you would like to skip to: ");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(prompt2, dim);
		
		JTextField skip = new JTextField();
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(skip, dim);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 5;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				JOptionPane.showMessageDialog(null, "Make sure this header corresponds to one of the header for valid transition in scenario", "Warning", JOptionPane.INFORMATION_MESSAGE);
				SetSkipButton ss = se.new SetSkipButton(btn.getSelectedIndex(), skip.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ss);
					lfs.convertToFile.set(list.getSelectedIndex(), ss.toFile());
				} else {
					listItems.addElement(ss);
					lfs.convertToFile.addElement(ss.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 6;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel HeaderPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel prompt = new JLabel("Name of header for this section of scenario");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JTextField sentence = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(sentence, dim);
		
		JButton okHeader = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okHeader, dim);
		okHeader.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				SkipHeader s = se.new SkipHeader(sentence.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), s);
					lfs.convertToFile.set(list.getSelectedIndex(), s.toFile());
				} else {
					listItems.addElement(s);
					lfs.convertToFile.addElement(s.toFile());;
				}
				list.setModel(listItems);
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel InsertSoundPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JButton makeSoundFile = new JButton("Record Audio");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(makeSoundFile, dim);
		makeSoundFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//player to record sound
				JOptionPane.showMessageDialog(null, "Coming Soon! With the next update, you will be able to record audio as well");
			}		
		});
		
		JButton addSound = new JButton("Add Sound File");	//done
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(addSound, dim);
		addSound.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//file chooser
				JFileChooser fc = new JFileChooser();
				fc.setFileFilter(new FileNameExtensionFilter("Sound Files", "wav", "mp3"));
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File af = fc.getSelectedFile();
					InsertSound is = se.new InsertSound(af.getName());
					if (isEdit() == true && list.getSelectedIndex() >= 0) {
						listItems.set(list.getSelectedIndex(), is);
						lfs.convertToFile.set(list.getSelectedIndex(), is.toFile());
					} else {
						listItems.addElement(is);
						lfs.convertToFile.addElement(is.toFile());
					}
					list.setModel(listItems);
					pPanel.setVisible(false);
					buttonPanel.setVisible(true);
					cellButtonsPanel.setVisible(true);
				}	
			}		
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		return pPanel;
	}
	
	public JPanel ClearOneCellPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(4,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a cell to clear");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getCells(); c++) {
			String s = "Cell " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		//pPanel.add(btn);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		//pPanel.add(okRB);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//JOptionPane.showMessageDialog(null, "If there is no sentence to repeat preceding this action, scenario will not repeat anything", "Warning", JOptionPane.INFORMATION_MESSAGE);
				OneCellClear rb = se.new OneCellClear(btn.getSelectedIndex());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), rb);
					lfs.convertToFile.set(list.getSelectedIndex(), rb.toFile());
				} else {
					listItems.addElement(rb);
					lfs.convertToFile.addElement(rb.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		
		JButton im = new JButton("View Braille Cell Image");
		dim.gridx = 8;
		dim.gridy = 1;
		pPanel.add(im, dim);
		im.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				BrailleCellImage();
			}
		});
		return pPanel;
	}
	
	public JPanel SetCellToCharPanel() {
		
//		JPanel bigPanel = new JPanel();
//		bigPanel.setLayout(new GridLayout(1,2));
//		
//		JPanel panelImage = new JPanel();	//panel to add image
//		ImageIcon braillePic = new ImageIcon("BrailleDots.png");
//		Image image = braillePic.getImage();
//		Image shrink = image.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
//		braillePic = new ImageIcon(shrink);
//		panelImage.add(new JLabel(braillePic));
		
		JPanel pPanel = new JPanel();	//panel 1 with user prompts and inputs
		pPanel.setLayout(new GridLayout(8,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a cell to assign a character");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getCells(); c++) {
			String s = "Cell " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		
		JLabel prompt2 = new JLabel("Enter the character you would like to assign to cell:");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(prompt2, dim);
		
		JTextField cha = new JTextField();
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(cha, dim);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 5;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Make sure this header corresponds to one of the header for valid transition in scenario", "Warning", JOptionPane.INFORMATION_MESSAGE);
				SetCharToCell ss = se.new SetCharToCell(btn.getSelectedIndex(), cha.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ss);
					lfs.convertToFile.set(list.getSelectedIndex(), ss.toFile());
				} else {
					listItems.addElement(ss);
					lfs.convertToFile.addElement(ss.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton goBack = new JButton("Back");
		dim.gridx = 6;
		dim.gridy = 1;
		pPanel.add(goBack, dim);
		goBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}		
		});
		
		JButton im = new JButton("View Braille Cell Image");
		dim.gridx = 8;
		dim.gridy = 1;
		pPanel.add(im, dim);
		im.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				BrailleCellImage();
			}
		});
		//bigPanel.add(pPanel);
		//bigPanel.add(panelImage);
		return pPanel;
	}
	
	public JPanel SetCellToSeqPanel() {
		
//		JPanel bigPanel = new JPanel();
//		bigPanel.setLayout(new GridLayout(1,2));
//		
//		JPanel panelImage = new JPanel();	//panel to add image
//		panelImage.setLayout(new GridLayout(2,1));	//may need to change layout
//		ImageIcon braillePic = new ImageIcon("BrailleDots.png");
//		Image image = braillePic.getImage();
//		Image shrink = image.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
//		braillePic = new ImageIcon(shrink);
//		panelImage.add(new JLabel(braillePic));
//		panelImage.add(new JPanel().add(new JLabel("Refer to the image for the order of sequence")));
		
		JPanel pPanel = new JPanel();	//panel 1 with user prompts and inputs
		pPanel.setLayout(new GridLayout(8,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a cell to assign sequence");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getCells(); c++) {
			String s = "Cell " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		
		JLabel prompt2 = new JLabel("Enter the sequence you would like to assign to cell:");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(prompt2, dim);
		
		JTextField cha = new JTextField();
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(cha, dim);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 5;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Make sure this header corresponds to one of the header for valid transition in scenario", "Warning", JOptionPane.INFORMATION_MESSAGE);
				SetCellPins ss = se.new SetCellPins(btn.getSelectedIndex(), cha.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ss);
					lfs.convertToFile.set(list.getSelectedIndex(), ss.toFile());
				} else {
					listItems.addElement(ss);
					lfs.convertToFile.addElement(ss.toFile());
				}
				list.setModel(listItems);
			}
		});
		JButton back = new JButton("back");
		dim.gridx = 6;
		dim.gridy = 1;
		pPanel.add(back, dim);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}
		});
		
		JButton im = new JButton("View Braille Cell Image");
		dim.gridx = 8;
		dim.gridy = 1;
		pPanel.add(im, dim);
		im.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				BrailleCellImage();
			}
		});
		//bigPanel.add(pPanel);
		//bigPanel.add(panelImage);
		return pPanel;
	}
	
	public JPanel RaiseOneCellPinPanel() {
		
//		JPanel bigPanel = new JPanel();
//		bigPanel.setLayout(new GridLayout(1,2));
//		
//		JPanel panelImage = new JPanel();	//panel to add image
//		panelImage.setLayout(new GridLayout(2,1));	//may need to change layout
//		ImageIcon braillePic = new ImageIcon("BrailleDots.png");
//		Image image = braillePic.getImage();
//		Image shrink = image.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
//		braillePic = new ImageIcon(shrink);
//		panelImage.add(new JLabel(braillePic));
//		panelImage.add(new JPanel().add(new JLabel("Refer to the image for the location of pins")));
//		
		JPanel pPanel = new JPanel();	//panel 1 with user prompts and inputs
		pPanel.setLayout(new GridLayout(8,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a cell to raise individual pin");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getCells(); c++) {
			String s = "Cell " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		
		JLabel prompt2 = new JLabel("Enter the pin number you would like to set:");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(prompt2, dim);
		
		JTextField cha = new JTextField();
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(cha, dim);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 5;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Make sure this header corresponds to one of the header for valid transition in scenario", "Warning", JOptionPane.INFORMATION_MESSAGE);
				RaiseOneCellPin ss = se.new RaiseOneCellPin(btn.getSelectedIndex(), cha.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ss);
					lfs.convertToFile.set(list.getSelectedIndex(), ss.toFile());
				} else {
					listItems.addElement(ss);
					lfs.convertToFile.addElement(ss.toFile());
				}
				list.setModel(listItems);
			}
		});
		
		JButton back = new JButton("back");
		dim.gridx = 6;
		dim.gridy = 1;
		pPanel.add(back, dim);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}
		});
		
		JButton im = new JButton("View Braille Cell Image");
		dim.gridx = 8;
		dim.gridy = 1;
		pPanel.add(im, dim);
		im.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				BrailleCellImage();
			}
		});
		//bigPanel.add(pPanel);
		//bigPanel.add(panelImage);
		return pPanel;
	}
	
public JPanel LowerOneCellPinPanel() {
		
//		JPanel bigPanel = new JPanel();
//		bigPanel.setLayout(new GridLayout(1,2));
//		
//		JPanel panelImage = new JPanel();	//panel to add image
//		panelImage.setLayout(new GridLayout(2,1));	//may need to change layout
//		ImageIcon braillePic = new ImageIcon("BrailleDots.png");
//		Image image = braillePic.getImage();
//		Image shrink = image.getScaledInstance(110, 120, java.awt.Image.SCALE_SMOOTH);
//		braillePic = new ImageIcon(shrink);
//		panelImage.add(new JLabel(braillePic));
//		panelImage.add(new JPanel().add(new JLabel("Refer to the image for the location of pins")));
//		
		JPanel pPanel = new JPanel();	//panel 1 with user prompts and inputs
		pPanel.setLayout(new GridLayout(8,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		JLabel prompt = new JLabel("Choose a cell to lower individual pin");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(prompt, dim);
		
		JComboBox<String> btn = new JComboBox<String>();
		//List<Integer> temp = new List<Integer>();
		for (int c = 0; c < getCells(); c++) {
			String s = "Cell " + (c + 1);
			btn.addItem(s);
		}
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(btn, dim);
		
		JLabel prompt2 = new JLabel("Enter the pin number you would like to set:");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(prompt2, dim);
		
		JTextField cha = new JTextField();
		dim.gridx = 4;
		dim.gridy = 1;
		pPanel.add(cha, dim);
		
		JButton okRB = new JButton("Okay");
		dim.gridx = 5;
		dim.gridy = 1;
		pPanel.add(okRB, dim);
		okRB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
				//JOptionPane.showMessageDialog(null, "Make sure this header corresponds to one of the header for valid transition in scenario", "Warning", JOptionPane.INFORMATION_MESSAGE);
				LowerOneCellPin ss = se.new LowerOneCellPin(btn.getSelectedIndex(), cha.getText());
				if (isEdit() == true && list.getSelectedIndex() >= 0) {
					listItems.set(list.getSelectedIndex(), ss);
					lfs.convertToFile.set(list.getSelectedIndex(), ss.toFile());
				} else {
					listItems.addElement(ss);
					lfs.convertToFile.addElement(ss.toFile());
				}
				list.setModel(listItems);
			}
		});
		JButton back = new JButton("back");
		dim.gridx = 6;
		dim.gridy = 1;
		pPanel.add(back, dim);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				pPanel.setVisible(false);
				buttonPanel.setVisible(true);
				cellButtonsPanel.setVisible(true);
			}
		});
		
		JButton im = new JButton("View Braille Cell Image");
		dim.gridx = 8;
		dim.gridy = 1;
		pPanel.add(im, dim);
		im.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				BrailleCellImage();
			}
		});
		//bigPanel.add(pPanel);
		//bigPanel.add(panelImage);
		return pPanel;
	}

	public void BrailleCellImage() {
		JFrame imFrm = new JFrame("8 pin Braille Cell Image");
		
		JPanel panelImage = new JPanel();	//panel to add image
		panelImage.setLayout(new GridLayout(3,1));	//may need to change layout
		ImageIcon braillePic = new ImageIcon("BrailleDots.png");
		Image image = braillePic.getImage();
		Image shrink = image.getScaledInstance(120, 130, java.awt.Image.SCALE_SMOOTH);
		braillePic = new ImageIcon(shrink);
		panelImage.add(new JLabel(braillePic));
		panelImage.add(new JPanel().add(new JLabel("Refer to this image for the location of pins")));
		panelImage.add(new JPanel().add(new JLabel("For each individual pin, use 1 in sequence to raise it and 0 to lower it")));
		imFrm.getContentPane().add(panelImage);
		
		imFrm.pack();
		imFrm.setVisible(true);
		//return imFrm;
	}
	
	public JFrame getFrmCreateScenario() {
		return frmCreateScenario;
	}

	public void setFrmCreateScenario(JFrame frmCreateScenario) {
		this.frmCreateScenario = frmCreateScenario;
	}
	
	public int getCells() {
		return cells;
	}
	
	public void setCells(int editCells) {
		this.cells = editCells;
	}
	
	public int getBtns() {
		return buttons;
	}
	
	public void setBtns(int editBtns) {
		this.buttons = editBtns;
	}
}
