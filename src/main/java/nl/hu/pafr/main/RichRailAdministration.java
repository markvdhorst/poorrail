package nl.hu.pafr.main;

import java.util.Scanner;

import nl.hu.pafr.controller.TrainCompanyController;
import nl.hu.pafr.model.TrainCompany;
import nl.hu.pafr.persistence.JsonStorage;
import nl.hu.pafr.view.CommandLineInterface;
import nl.hu.pafr.view.GuiTrainCompanyView;

public class RichRailAdministration {
	public static void main(String[] args){
		System.out.println("Welcome to the RichRail Train and Wagon Administration application.");
		System.out.println("To load previously saved data. Please input the number of the loading method");
		//TODO: Opties voor laden in een lijst zetten en dit gedeeltelijk automatisch laten gebeuren.
		System.out.println("0. Start without data");
		System.out.println("1. Start with test data");
		System.out.println("2. Retrieve from json file");
		Scanner consoleInput = new Scanner(System.in);
		int selectedNumber = -1;
		while(true) {
			String stringInput = consoleInput.next();
			try{
				selectedNumber = Integer.parseInt(stringInput);
				if(selectedNumber <= 2 && selectedNumber >=0) {
					break;
				}
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			}
			System.out.println("Please insert a number from the list");
		}
		System.out.println("Selected number " + selectedNumber);
		TrainCompany trainCompany;
		switch(selectedNumber) {
			case 0:
				trainCompany = new TrainCompany();
				break;
			case 1:
				try {
					trainCompany = loadTrainCompany();
				} catch (Exception e) {
					trainCompany = new TrainCompany();
				}
				break;
			case 2:
				JsonStorage storage = new JsonStorage();
				trainCompany = storage.retrieveFromFile();
				break;
			default:
				trainCompany = new TrainCompany();
		}
		//Hieronder is de basisstructuur van de code om de applicatie te starten. Deze code moet nog uitgebreid worden voordat het nuttig is.
		TrainCompanyController controller = new TrainCompanyController(trainCompany);
		JsonStorage storage = new JsonStorage();
		storage.registerToController(controller);
		controller.notifyObservers();
		System.out.println("Train data ready.");
		System.out.println("Insert a number to start an interface or insert 0 to quit.");
		System.out.println("1. Graphical User Interface");
		System.out.println("2. Command line interface");
		mainLoop:
		while(true) {
			String stringInput = consoleInput.next();
			try{
				selectedNumber = Integer.parseInt(stringInput);
				switch(selectedNumber) {
					case 0:
						break mainLoop;
					case 1:
						new GuiTrainCompanyView(controller);
						
						break;
					case 2:
						new CommandLineInterface(controller);
						break;
					default:
						System.out.println("Please insert a number from the list or insert 0 to quit.");
						System.out.println("1. Graphical User Interface");
						System.out.println("2. Command line interface");
				}
			} catch(NumberFormatException e) {
				System.out.println("Please enter a valid number from the list or insert 0 to quit.");
				System.out.println("1. Graphical User Interface");
				System.out.println("2. Command line interface");
			}
		}
		
	}
	
	//TODO: echte methode maken voor het inladen van een traincompany, mogelijk generiek maken/gebruik laten maken van interface
	private static TrainCompany loadTrainCompany() throws Exception {
		TrainCompany trainCompany = new TrainCompany();
		trainCompany.addRollingComponentType(0, "Bert");
		try {
			trainCompany.addTrain("Bert");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trainCompany.addRollingComponentType(20, "Mark");
		try {
			trainCompany.addTrain("Mark");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trainCompany;
	}
}
