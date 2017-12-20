package nl.hu.pafr.view;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;

public class DslTrainCompanyView implements Observer{
	public DslTrainCompanyView(TrainCompanyController controller) {
		controller.register(this);
	}

	@Override
	public void update() {
		
	}
}
