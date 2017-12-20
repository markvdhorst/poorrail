package nl.hu.pafr.main;

import nl.hu.pafr.controller.TrainCompanyController;
import nl.hu.pafr.model.TrainCompany;
import nl.hu.pafr.view.GraphicalTrainCompanyView;

public class Main {
	public static void main(String[] args){
		//Hieronder is de basisstructuur van de code om de applicatie te starten. Deze code moet nog uitgebreid worden voordat het nuttig is.
		TrainCompany trainCompany = loadTrainCompany();
		TrainCompanyController controller = new TrainCompanyController(trainCompany);
		GraphicalTrainCompanyView view = new GraphicalTrainCompanyView(controller);
		System.out.println("test");
	}
	
	//TODO: echte methode maken voor het inladen van een traincompany, mogelijk generiek maken/gebruik laten maken van interface
	private static TrainCompany loadTrainCompany() {
		TrainCompany trainCompany = new TrainCompany();
		trainCompany.addRollingComponentType(0, "Bert", true);
		trainCompany.addTrain("Bert", "Bert", "Bert");
		trainCompany.addRollingComponentType(20, "Mark", true);
		trainCompany.addTrain("Mark", "Mark", "Mark");
		return trainCompany;
	}
}
