package nl.hu.pafr.view;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;

public class GraphicalTrainCompanyView implements Observer{
	public GraphicalTrainCompanyView(TrainCompanyController controller) {
		controller.register(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
