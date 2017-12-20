package nl.hu.pafr.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;
import nl.hu.pafr.model.TrainCompany;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class GuiTrainCompanyView extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField addTrainText;
	private JTextField addTypeText;
	private TrainCompanyController controller;
	private final Action addTrain = new SwingAction();
	private final Action selectTrain = new SwingAction_1();
	private final Action deleteTrain = new SwingAction_2();
	private final Action SelectWagon = new SwingAction_3();
	private final Action DeleteWagon = new SwingAction_4();
	/**
	 * Create the frame.
	 */
	public GuiTrainCompanyView(TrainCompanyController controller) {
		initGUI();
		this.controller = controller;
		controller.register(this);
		updateView(controller.getTrainCompany());
	}
	
	private void updateView(TrainCompany trainCompany) {
		// TODO Auto-generated method stub
		
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 940, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{880, 0};
		gbl_contentPane.rowHeights = new int[] {388, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel drawPanel = new JPanel();
		drawPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_drawPanel = new GridBagConstraints();
		gbc_drawPanel.fill = GridBagConstraints.BOTH;
		gbc_drawPanel.insets = new Insets(0, 0, 5, 0);
		gbc_drawPanel.gridx = 0;
		gbc_drawPanel.gridy = 0;
		contentPane.add(drawPanel, gbc_drawPanel);
		
		JPanel actionPanel = new JPanel();
		GridBagConstraints gbc_actionPanel = new GridBagConstraints();
		gbc_actionPanel.fill = GridBagConstraints.BOTH;
		gbc_actionPanel.gridx = 0;
		gbc_actionPanel.gridy = 1;
		contentPane.add(actionPanel, gbc_actionPanel);
		actionPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftPanel = new JPanel();
		actionPanel.add(leftPanel);
		leftPanel.setLayout(new GridLayout(5, 3, 5, 2));
		
		JLabel addTrainLabel = new JLabel("Add train:");
		addTrainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(addTrainLabel);
		
		addTrainText = new JTextField();
		leftPanel.add(addTrainText);
		addTrainText.setColumns(10);
		
		JButton addTrainButton = new JButton("Add");
		addTrainButton.setAction(addTrain);
		leftPanel.add(addTrainButton);
		
		JLabel trainSelectionLabel = new JLabel("Trains:");
		trainSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(trainSelectionLabel);
		
		JComboBox trainSelectionBox = new JComboBox();
		leftPanel.add(trainSelectionBox);
		
		JButton trainSelectionButton = new JButton("Select");
		trainSelectionButton.setAction(selectTrain);
		leftPanel.add(trainSelectionButton);
		
		JLabel selectedTrainLabel = new JLabel("Selected Train:");
		selectedTrainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(selectedTrainLabel);
		
		JLabel selectedTrainText = new JLabel("");
		leftPanel.add(selectedTrainText);
		
		JButton deleteTrainButton = new JButton("Delete train");
		deleteTrainButton.setAction(deleteTrain);
		leftPanel.add(deleteTrainButton);
		
		JLabel wagonSelectionLabel = new JLabel("Wagons in selected train:");
		wagonSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(wagonSelectionLabel);
		
		JComboBox wagonSelectionBox = new JComboBox();
		leftPanel.add(wagonSelectionBox);
		
		JButton selectWagonButton = new JButton("Select");
		selectWagonButton.setAction(SelectWagon);
		leftPanel.add(selectWagonButton);
		
		JLabel selectedWagonLabel = new JLabel("Selected wagon:");
		selectedWagonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(selectedWagonLabel);
		
		JLabel selectedWagonText = new JLabel("");
		leftPanel.add(selectedWagonText);
		
		JButton deleteWagonButton = new JButton("Delete wagon");
		deleteWagonButton.setAction(DeleteWagon);
		leftPanel.add(deleteWagonButton);
		
		JPanel rightPanel = new JPanel();
		actionPanel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(5, 3, 5, 2));
		
		JLabel addTypeLabel = new JLabel("Add type:");
		addTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(addTypeLabel);
		
		addTypeText = new JTextField();
		addTypeText.setColumns(10);
		rightPanel.add(addTypeText);
		
		JButton addTypeButton = new JButton("Add");
		rightPanel.add(addTypeButton);
		
		JLabel typeSelectionLabel = new JLabel("Types:");
		typeSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(typeSelectionLabel);
		
		JComboBox typeSelectionBox = new JComboBox();
		rightPanel.add(typeSelectionBox);
		
		JButton typeSelectionButton = new JButton("Select");
		rightPanel.add(typeSelectionButton);
		
		JLabel selectedTypeLabel = new JLabel("Selected Type:");
		selectedTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(selectedTypeLabel);
		
		JLabel selectedTypeText = new JLabel("");
		rightPanel.add(selectedTypeText);
		
		JButton deleteTypeButton = new JButton("Delete Type");
		rightPanel.add(deleteTypeButton);
		
		JButton addBehindButton = new JButton("Add behind selected");
		rightPanel.add(addBehindButton);
		
		JButton addAtEnd = new JButton("Add at end of train");
		rightPanel.add(addAtEnd);
		this.setVisible(true);
	}

	@Override
	public void update() {
		updateView(controller.getTrainCompany());
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add Train");
			putValue(SHORT_DESCRIPTION, "Adds a train");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				controller.addTrain(addTrainText.getText());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Select Train");
			putValue(SHORT_DESCRIPTION, "Selects the train");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Delete Train");
			putValue(SHORT_DESCRIPTION, "Deletes the selected train");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Select Wagon");
			putValue(SHORT_DESCRIPTION, "Selects the wagon");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Delete Wagon");
			putValue(SHORT_DESCRIPTION, "Deletes the selected wagon.");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
