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
import nl.hu.pafr.model.RollingComponent;
import nl.hu.pafr.model.RollingComponentType;
import nl.hu.pafr.model.Train;
import nl.hu.pafr.model.TrainCompany;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class GuiTrainCompanyView extends JFrame implements Observer {

	private JPanel contentPane;
	private JTextField addTrainText;
	private JTextField addTypeText;
	private JTextField addWagonText;
	private JComboBox<Train> trainSelectionBox;
	private JComboBox<RollingComponent> wagonSelectionBox;
	private JComboBox<RollingComponentType> typeSelectionBox;
	
	private TrainCompanyController controller;
	
	private Train selectedTrain = null;
	private JLabel selectedTrainText;
	
	private RollingComponent selectedWagon = null;
	private JLabel selectedWagonText;
	
	private RollingComponentType selectedType= null;
	private JLabel selectedTypeText;
	
	private final Action addTrain = new SwingAction();
	private final Action selectTrain = new SwingAction_1();
	private final Action deleteTrain = new SwingAction_2();
	private final Action selectWagon = new SwingAction_3();
	private final Action deleteWagon = new SwingAction_4();
	private JTextField addTypeSeats;
	private final Action addType = new SwingAction_5();
	private final Action selectType = new SwingAction_6();
	private final Action addEnd = new SwingAction_9();
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
		selectedTrain = null;
		selectedTrainText.setText("");
		
		selectedWagon = null;
		selectedWagonText.setText("");
		
		selectedType = null;
		selectedTypeText.setText("");
				
		
		trainSelectionBox.removeAllItems();
		for(Train t : trainCompany.getTrains()) {
			trainSelectionBox.addItem(t);
		}
		wagonSelectionBox.removeAllItems();
		typeSelectionBox.removeAllItems();
		for(RollingComponentType type: trainCompany.getRCType()) {
			typeSelectionBox.addItem(type);
		}
	}
	
	private void drawTrains() {
		
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
		
		trainSelectionBox = new JComboBox<Train>();
		leftPanel.add(trainSelectionBox);
		
		JButton trainSelectionButton = new JButton("Select");
		trainSelectionButton.setAction(selectTrain);
		leftPanel.add(trainSelectionButton);
		
		JLabel selectedTrainLabel = new JLabel("Selected Train:");
		selectedTrainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(selectedTrainLabel);
		
		selectedTrainText = new JLabel("");
		leftPanel.add(selectedTrainText);
		
		JButton deleteTrainButton = new JButton("Delete train");
		deleteTrainButton.setAction(deleteTrain);
		leftPanel.add(deleteTrainButton);
		
		JLabel wagonSelectionLabel = new JLabel("Wagons in selected train:");
		wagonSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(wagonSelectionLabel);
		
		wagonSelectionBox = new JComboBox<RollingComponent>();
		leftPanel.add(wagonSelectionBox);
		
		JButton selectWagonButton = new JButton("Select");
		selectWagonButton.setAction(selectWagon);
		leftPanel.add(selectWagonButton);
		
		JLabel selectedWagonLabel = new JLabel("Selected wagon:");
		selectedWagonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(selectedWagonLabel);
		
		selectedWagonText = new JLabel("");
		leftPanel.add(selectedWagonText);
		
		JButton deleteWagonButton = new JButton("Delete wagon");
		deleteWagonButton.setAction(deleteWagon);
		leftPanel.add(deleteWagonButton);
		
		JPanel rightPanel = new JPanel();
		actionPanel.add(rightPanel);
		rightPanel.setLayout(new GridLayout(5, 3, 5, 2));
		
		JLabel addTypeLabel = new JLabel("Type name:");
		addTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(addTypeLabel);
		
		addTypeText = new JTextField();
		addTypeText.setColumns(10);
		rightPanel.add(addTypeText);
		
		JLabel lblNewLabel = new JLabel("");
		rightPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number of seats:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(lblNewLabel_1);
		
		addTypeSeats = new JTextField();
		rightPanel.add(addTypeSeats);
		addTypeSeats.setColumns(10);
		
		JButton addTypeButton = new JButton("Add");
		addTypeButton.setAction(addType);
		rightPanel.add(addTypeButton);
		
		JLabel typeSelectionLabel = new JLabel("Types:");
		typeSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(typeSelectionLabel);
		
		typeSelectionBox = new JComboBox<RollingComponentType>();
		rightPanel.add(typeSelectionBox);
		
		JButton typeSelectionButton = new JButton("Select");
		typeSelectionButton.setAction(selectType);
		rightPanel.add(typeSelectionButton);
		
		JLabel selectedTypeLabel = new JLabel("Selected Type:");
		selectedTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(selectedTypeLabel);
		
		selectedTypeText = new JLabel("");
		rightPanel.add(selectedTypeText);
		
		JButton addAtEnd = new JButton("Add at end of train");
		addAtEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		rightPanel.add(lblNewLabel_2);
		
		JLabel addWagonLabel = new JLabel("Wagon name:");
		addWagonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(addWagonLabel);
		
		addWagonText = new JTextField();
		addWagonText.setEditable(true);
		addWagonText.setEnabled(true);
		addWagonText.setText("");
		rightPanel.add(addWagonText);
		addWagonText.setColumns(10);
		addAtEnd.setAction(addEnd);
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
			selectedTrain = (Train) trainSelectionBox.getSelectedItem();
			selectedTrainText.setText(selectedTrain.getId());
			wagonSelectionBox.removeAllItems();
			for(RollingComponent c : selectedTrain.getRollingComponents()) {
				wagonSelectionBox.addItem(c);
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Delete Train");
			putValue(SHORT_DESCRIPTION, "Deletes the selected train");
		}
		public void actionPerformed(ActionEvent e) {
			if(selectedTrain != null) {
				try {
					controller.deleteTrain(selectedTrain.getId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Select Wagon");
			putValue(SHORT_DESCRIPTION, "Selects the wagon");
		}
		public void actionPerformed(ActionEvent e) {
			selectedWagon = (RollingComponent) wagonSelectionBox.getSelectedItem();
			selectedWagonText.setText(selectedWagon.getId());
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Delete Wagon");
			putValue(SHORT_DESCRIPTION, "Deletes the selected wagon.");
		}
		public void actionPerformed(ActionEvent e) {
			if(selectedTrain != null && selectedWagon != null) {
				try {
					controller.deleteRollingComponentFromTrain(selectedTrain.getId(), selectedWagon.getId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Add Type");
			putValue(SHORT_DESCRIPTION, "Adds a type");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				controller.addRollingComponentType(Integer.parseInt(addTypeSeats.getText()), addTypeText.getText());
			} catch (NumberFormatException exception) {
				
			}
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "Select Type");
			putValue(SHORT_DESCRIPTION, "Selects a type");
		}
		public void actionPerformed(ActionEvent e) {
			selectedType = (RollingComponentType) typeSelectionBox.getSelectedItem();
			selectedTypeText.setText(selectedType.getName());
		}
	}

	private class SwingAction_9 extends AbstractAction {
		public SwingAction_9() {
			putValue(NAME, "Add to Train");
			putValue(SHORT_DESCRIPTION, "Adds a wagon at the end of the train");
		}
		public void actionPerformed(ActionEvent e) {
			if(selectedTrain != null && selectedType != null) {
				try {
					controller.addRollingComponentToTrain(selectedTrain.getId(), addWagonText.getText() , selectedType.getName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	}
}
