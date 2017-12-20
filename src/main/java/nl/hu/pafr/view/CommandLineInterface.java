package nl.hu.pafr.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;

public class CommandLineInterface extends JFrame implements Observer{

	private JPanel contentPane;
	private JTextField txtCommandLine;
	private final Action action = new SwingAction();
	private ArrayList<String> last15Commands;
	private JTextArea txtrVorigeCommandos;
	private TrainCompanyController controller;
	private DslParser parser;
	JTextArea txtrOutput;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	public CommandLineInterface(TrainCompanyController controller) {
		
		this.controller = controller;
		controller.register(this);
		this.parser = new DslParser(controller);
		last15Commands = new ArrayList<String>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtrOutput = new JTextArea();
		txtrOutput.setText("output");
		panel_6.add(txtrOutput);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtCommandLine = new JTextField();
		panel_7.add(txtCommandLine);
		txtCommandLine.setText("Command line");
		txtCommandLine.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setAction(action);
		panel_3.add(btnEnter);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		txtrVorigeCommandos = new JTextArea();
		txtrVorigeCommandos.setColumns(15);
		txtrVorigeCommandos.setText("Vorige Commando's");
		panel_1.add(txtrVorigeCommandos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea txtrTreinen = new JTextArea();
		txtrTreinen.setText("Treinen");
		panel_2.add(txtrTreinen);
		setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");

		}
		public void actionPerformed(ActionEvent e) {
			String text = txtCommandLine.getText();
			try {
				txtrOutput.setText(parser.parseDSL(text));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (last15Commands.size() < 15){
				last15Commands.add(text);
				
			}
			if (last15Commands.size() == 15){
				last15Commands.remove(1);
				last15Commands.add(1, text);
				
			} 
			text = "Vorige Commando's\n";
			for(String s : last15Commands) {
				text += s + "\n"; 
			}
			txtrVorigeCommandos.setText(text);
			System.out.println(last15Commands.toString());
		}
	}

	@Override
	public void update() {
		
	}
	
}
