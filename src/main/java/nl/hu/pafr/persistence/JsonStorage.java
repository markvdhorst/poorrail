package nl.hu.pafr.persistence;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;
import nl.hu.pafr.model.TrainCompany;

public class JsonStorage implements Observer {

	private TrainCompanyController controller;
	
	public JsonStorage(TrainCompanyController controller) {
		this.controller = controller;
	}
	@Override
	public void update() {
		updateFile(controller.getTrainCompany());
	}
	
	private void updateFile(TrainCompany trainCompany){
		
	}
	
}
