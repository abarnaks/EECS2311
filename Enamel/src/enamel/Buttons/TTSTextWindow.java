package enamel.Buttons;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import enamel.CreateWindow;

import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TTSTextWindow {

	private JFrame frmTextToSpeech;
	private JTextField textField;
	private JButton btnOkay;
	
	private ArrayList<String> ttsTxt;
	private CreateWindow cw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTSTextWindow window = new TTSTextWindow();
					window.frmTextToSpeech.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TTSTextWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTextToSpeech = new JFrame();
		frmTextToSpeech.setTitle("Text to Speech - Text");
		frmTextToSpeech.setResizable(false);
		frmTextToSpeech.setBounds(100, 100, 350, 114);
		frmTextToSpeech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextToSpeech.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmTextToSpeech.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTtsPrompt = new JLabel("Enter sentence to be read to audience");
		GridBagConstraints gbc_lblTtsPrompt = new GridBagConstraints();
		gbc_lblTtsPrompt.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtsPrompt.gridx = 1;
		gbc_lblTtsPrompt.gridy = 0;
		panel.add(lblTtsPrompt, gbc_lblTtsPrompt);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnOkay = new JButton("Okay");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int index = cw.getList_create().getSelectedIndex();
				
				//simply add to end of list
				cw.getListItems().addElement(textField.getText());
				
				cw.getList_create().setSelectedIndex(cw.getList_create().getLastVisibleIndex());
				cw.getList_create().ensureIndexIsVisible(cw.getList_create().getLastVisibleIndex());
			}
		});
		btnOkay.setActionCommand("Okay");
	//	btnOkay.addActionListener(new OkayListener());
		GridBagConstraints gbc_btnOkay = new GridBagConstraints();
		gbc_btnOkay.insets = new Insets(0, 0, 0, 5);
		gbc_btnOkay.gridx = 1;
		gbc_btnOkay.gridy = 2;
		panel.add(btnOkay, gbc_btnOkay);
	}

//	class OkayListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			int index = cw.getList_create().getSelectedIndex();
//			if (index == -1) {
//				index = 0;
//			} else {
//				index++;	
//			}
//			//simply add to end of list
//			cw.getListItems().addElement(textField.getText());
//			
//			cw.getList_create().setSelectedIndex(index);
//			cw.getList_create().ensureIndexIsVisible(index);
//		}
//	}
	
}
