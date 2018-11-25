package enamel;

import java.awt.EventQueue;

import javax.swing.JFrame;

import enamel.ScenEvents.*;
import enamel.ListToFile.*;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
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

public class CreateWindow {

	//protected static final String ScenEvents = null;

	private JFrame frmCreateScenario;

	private JPanel buttonPanel;
	private JPanel panelBtnAction;
	private JButton btnDeleteALine;
	private static boolean edit;
	ListToFile lfs = new ListToFile();
	private static DefaultListModel<Object> listItems = new DefaultListModel<Object>();
	
	private static JList<Object> list;
	
	//private static ScenObjectsList sol = new ScenObjectsList();
	private static final ScenEvents se = new ScenEvents();
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
		frmCreateScenario.setBounds(100, 100, 816, 489);
		frmCreateScenario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateScenario.getContentPane().setLayout(new BoxLayout(frmCreateScenario.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frmCreateScenario.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panelBtnAction = new JPanel();	//the panel to switch between main buttons and sub panels for each button action
		GridBagConstraints gbc_panelBtnAction = new GridBagConstraints();
		gbc_panelBtnAction.gridwidth = 5;
		gbc_panelBtnAction.fill = GridBagConstraints.BOTH;
		gbc_panelBtnAction.gridheight = 9;
		gbc_panelBtnAction.insets = new Insets(0, 0, 5, 5);
		gbc_panelBtnAction.gridx = 8;
		gbc_panelBtnAction.gridy = 0;
		panel.add(panelBtnAction, gbc_panelBtnAction);
		GridBagLayout gbl_panelBtnAction = new GridBagLayout();
		gbl_panelBtnAction.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBtnAction.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBtnAction.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBtnAction.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelBtnAction.setLayout(gbl_panelBtnAction);
		
		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridheight = 7;
		gbc_buttonPanel.gridwidth = 8;
		gbc_buttonPanel.insets = new Insets(0, 0, 0, 5);
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 0;
		panelBtnAction.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnInsertSound = new JButton("Insert sound");	//done - record part to be implemented
		btnInsertSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(InsertSoundPanel());	
			}
		});
		
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
		
		JButton btnInsertSkip = new JButton("Insert Skip ");
		btnInsertSkip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnPause = new JButton("Pause");	//done
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(PausePanel());		
			}
		});
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPause.gridx = 0;
		gbc_btnPause.gridy = 4;
		buttonPanel.add(btnPause, gbc_btnPause);
		
		JButton btnInsertNumberOf = new JButton("Insert number of cells and buttons");	//done
		btnInsertNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(InsertCellButtonsPanel());
			}
		});
		GridBagConstraints gbc_btnInsertNumberOf = new GridBagConstraints();
		gbc_btnInsertNumberOf.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertNumberOf.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertNumberOf.gridx = 0;
		gbc_btnInsertNumberOf.gridy = 1;
		buttonPanel.add(btnInsertNumberOf, gbc_btnInsertNumberOf);
		
		JButton btnAddaSentence = new JButton("Add a sentence");	//done
		btnAddaSentence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(AddSentPanel());
			}
		});
		GridBagConstraints gbc_btnAddaSentence = new GridBagConstraints();
		gbc_btnAddaSentence.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddaSentence.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddaSentence.gridx = 0;
		gbc_btnAddaSentence.gridy = 3;
		buttonPanel.add(btnAddaSentence, gbc_btnAddaSentence);
		
		JButton btnDisplayASentence = new JButton("Display a sentence");	//done
		btnDisplayASentence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(DispSentPanel());
			}
		});
		GridBagConstraints gbc_btnDisplayASentence = new GridBagConstraints();
		gbc_btnDisplayASentence.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisplayASentence.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisplayASentence.gridx = 0;
		gbc_btnDisplayASentence.gridy = 5;
		buttonPanel.add(btnDisplayASentence, gbc_btnDisplayASentence);
		
		JButton btnSentenceToRepeat = new JButton("Sentence to repeat");	//done
		btnSentenceToRepeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setVisible(false);
				panelBtnAction.add(RepSentPanel());
			}
		});
		GridBagConstraints gbc_btnSentenceToRepeat = new GridBagConstraints();
		gbc_btnSentenceToRepeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSentenceToRepeat.insets = new Insets(0, 0, 5, 5);
		gbc_btnSentenceToRepeat.gridx = 0;
		gbc_btnSentenceToRepeat.gridy = 6;
		buttonPanel.add(btnSentenceToRepeat, gbc_btnSentenceToRepeat);
		
		JButton btnInsertRepeatButton = new JButton("Insert Repeat button");
		GridBagConstraints gbc_btnInsertRepeatButton = new GridBagConstraints();
		gbc_btnInsertRepeatButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertRepeatButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertRepeatButton.gridx = 0;
		gbc_btnInsertRepeatButton.gridy = 7;
		buttonPanel.add(btnInsertRepeatButton, gbc_btnInsertRepeatButton);
		GridBagConstraints gbc_btnInsertSkip = new GridBagConstraints();
		gbc_btnInsertSkip.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertSkip.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertSkip.gridx = 0;
		gbc_btnInsertSkip.gridy = 8;
		buttonPanel.add(btnInsertSkip, gbc_btnInsertSkip);
		GridBagConstraints gbc_btnResetButtonsIn = new GridBagConstraints();
		gbc_btnResetButtonsIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnResetButtonsIn.insets = new Insets(0, 0, 5, 5);
		gbc_btnResetButtonsIn.gridx = 0;
		gbc_btnResetButtonsIn.gridy = 9;
		buttonPanel.add(btnResetButtonsIn, gbc_btnResetButtonsIn);
		GridBagConstraints gbc_btnInsertSound = new GridBagConstraints();
		gbc_btnInsertSound.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsertSound.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsertSound.gridx = 0;
		gbc_btnInsertSound.gridy = 10;
		buttonPanel.add(btnInsertSound, gbc_btnInsertSound);
		
		JPanel panelList = new JPanel();
		GridBagConstraints gbc_panelList = new GridBagConstraints();
		gbc_panelList.gridheight = 10;
		gbc_panelList.gridwidth = 6;
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
		
		
		JLabel lblNewLabel = new JLabel("Braille Cell Actions");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 8;
		gbc_lblNewLabel.gridy = 10;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel cellButtonsPanel = new JPanel();
		GridBagConstraints gbc_cellButtonsPanel = new GridBagConstraints();
		gbc_cellButtonsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_cellButtonsPanel.gridwidth = 4;
		gbc_cellButtonsPanel.gridheight = 3;
		gbc_cellButtonsPanel.fill = GridBagConstraints.BOTH;
		gbc_cellButtonsPanel.gridx = 8;
		gbc_cellButtonsPanel.gridy = 11;
		panel.add(cellButtonsPanel, gbc_cellButtonsPanel);
		GridBagLayout gbl_cellButtonsPanel = new GridBagLayout();
		gbl_cellButtonsPanel.columnWidths = new int[]{134, 157, 0};
		gbl_cellButtonsPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_cellButtonsPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_cellButtonsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_btnClrAllCells = new GridBagConstraints();
		gbc_btnClrAllCells.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnClrAllCells.insets = new Insets(0, 0, 5, 5);
		gbc_btnClrAllCells.gridx = 0;
		gbc_btnClrAllCells.gridy = 0;
		cellButtonsPanel.add(btnClrAllCells, gbc_btnClrAllCells);
		
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
		gbc_btnDeleteALine.gridx = 1;
		gbc_btnDeleteALine.gridy = 12;
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
				
				if (size == 0) {
					btnEditLine.setEnabled(false);
				}	
				//make it so it is enabled only if the user selected something
			}
		});
		GridBagConstraints gbc_btnAddLine = new GridBagConstraints();
		gbc_btnAddLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddLine.gridx = 4;
		gbc_btnAddLine.gridy = 12;
		panel.add(btnEditLine, gbc_btnAddLine);
		
		JButton btnBacktoHome = new JButton("Back to Home ");
		btnBacktoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrmCreateScenario().setVisible(false);
				//need to implement message window asking whether to close without saving
				HomePage.main(null);
			}
		});
		GridBagConstraints gbc_btnBacktoHome = new GridBagConstraints();
		gbc_btnBacktoHome.gridwidth = 3;
		gbc_btnBacktoHome.insets = new Insets(0, 0, 5, 5);
		gbc_btnBacktoHome.gridx = 1;
		gbc_btnBacktoHome.gridy = 13;
		panel.add(btnBacktoHome, gbc_btnBacktoHome);
		
		JButton btnSaveExit = new JButton("Save & Exit");
		GridBagConstraints gbc_btnSaveExit = new GridBagConstraints();
		gbc_btnSaveExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveExit.gridx = 4;
		gbc_btnSaveExit.gridy = 13;
		panel.add(btnSaveExit, gbc_btnSaveExit);
		
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
		
	}
	
	public static boolean isEdit() {
		return edit;
	}

	public static void setEdit(boolean edit) {
		CreateWindow.edit = edit;
	}
	
	public void EditItem(Object o) {
		setEdit(true);
		if (o.getClass() == CellsButtons.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertCellButtonsPanel());
			//System.out.println("yes it is a cell class");
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
		}
		
		if (o.getClass() == InsertSound.class) {
			buttonPanel.setVisible(false);
			panelBtnAction.add(InsertSoundPanel());
		}
	}
	public JPanel InsertCellButtonsPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(6,1));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JLabel cellPrompt = new JLabel("Enter the number of braille cells for this scenario:");
		dim.gridx = 1;
		dim.gridy = 1;
		pPanel.add(cellPrompt, dim);
		
		JTextField numCell = new JTextField();
		dim.gridx = 2;
		dim.gridy = 1;
		pPanel.add(numCell, dim);
		
		JLabel btnPrompt = new JLabel("Enter the number of buttons for this scenario:");
		dim.gridx = 3;
		dim.gridy = 1;
		pPanel.add(btnPrompt, dim);
		
		JTextField numBtns = new JTextField();
		dim.gridx = 4;
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
				CellsButtons cd = se.new CellsButtons(Integer.parseInt(numCell.getText()), Integer.parseInt(numBtns.getText()));
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), cd);
				} else {
					listItems.addElement(cd);
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	public JPanel AddSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(3,1));
		
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
				AddASentence s = se.new AddASentence(sentence.getText());
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), s);
				} else {
					listItems.addElement(s);
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	public JPanel PausePanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(3,1));
		
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
				Pause p = se.new Pause(Integer.parseInt(pauseInt.getText()));
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), p);
				} else {
					listItems.addElement(p);
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	public JPanel DispSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(3,1));
		
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
				DisplaySentence ds = se.new DisplaySentence(sentence.getText());
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), ds);
				} else {
					listItems.addElement(ds);
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	public JPanel RepSentPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(3,1));
		
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
				SentenceToRepeat s = se.new SentenceToRepeat(repSentence.getText());
				if (isEdit() == true) {
					listItems.set(list.getSelectedIndex(), s);
				} else {
					listItems.addElement(s);
				}
				list.setModel(listItems);
			}		
		});
		return pPanel;
	}
	
	//to be implemented --- unsure of what the requirement is here
	public JPanel InsertRepeatButtonPanel() {
		JPanel pPanel = new JPanel();
		
		return pPanel;
	}
	
	//setSkip -- take time to understand what is happening
	public JPanel SetSkipPanel() {
		JPanel pPanel = new JPanel();
		
		return pPanel;
	}
	
	public JPanel InsertSoundPanel() {
		JPanel pPanel = new JPanel();
		pPanel.setLayout(new GridLayout(6,2));
		
		GridBagConstraints dim = new GridBagConstraints();
		
		JButton makeSoundFile = new JButton("Record Audio");
		dim.gridx = 1;
		dim.gridy = 2;
		pPanel.add(makeSoundFile, dim);
		makeSoundFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//player to record sound
			}		
		});
		
		JButton addSound = new JButton("Add Sound File");	//done
		dim.gridx = 3;
		dim.gridy = 2;
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
					InsertSound is = se.new InsertSound(af);
					if (isEdit() == true) {
						listItems.set(list.getSelectedIndex(), is);
					} else {
						listItems.addElement(is);
					}
					list.setModel(listItems);
					pPanel.setVisible(false);
					buttonPanel.setVisible(true);
				}	
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
			}		
		});
		return pPanel;
	}
	public JFrame getFrmCreateScenario() {
		return frmCreateScenario;
	}

	public void setFrmCreateScenario(JFrame frmCreateScenario) {
		this.frmCreateScenario = frmCreateScenario;
	}
	
}
