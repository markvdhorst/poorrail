package nl.hu.pafr.controller;

import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.model.TrainCompany;

public class TrainCompanyController implements Subject {
	private TrainCompany trainCompany;
	private List<Observer> observers;
	public TrainCompanyController(){
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		observers.remove(o);
	}

	@Override
	public void Notify() {
		for(Observer o: observers){
			o.update();
		}
	}
}
