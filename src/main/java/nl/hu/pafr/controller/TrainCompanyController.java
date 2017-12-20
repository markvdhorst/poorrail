package nl.hu.pafr.controller;

import java.util.ArrayList;
import java.util.List;

import nl.hu.pafr.model.RollingComponentType;
import nl.hu.pafr.model.Train;
import nl.hu.pafr.model.TrainCompany;

public class TrainCompanyController implements Subject {
	private TrainCompany trainCompany;
	private List<Observer> observers;
	public TrainCompanyController(TrainCompany trainCompany){
		this.observers = new ArrayList<Observer>();
		this.trainCompany = trainCompany;
	}
	
	//Hieronder staan alle methode's die vanuit de controller doorgegeven worden aan de TrainCompany.
	//Methode's die aanpassingen maken op het model roepen de notify methode's aan om de observers te updaten
	
	public boolean deleteTrain(String id) throws Exception {
		boolean returnBoolean = trainCompany.deleteTrain(id);
		notify();
		return returnBoolean;
	}
	
	public int getSeats(String id) throws Exception {
		return trainCompany.getSeats(id);
	}
	
	public boolean addRollingComponentToTrain(String trainid, String wagonId, String rname) throws Exception {
		boolean result = trainCompany.addRollingComponentToTrain(trainid, wagonId, rname);
		notifyObservers();
		return result;
	}
	
	public boolean addRollingComponentToTrainByIndex(String trainid, String wagonId, RollingComponentType rname, int index) throws Exception {
		boolean result = trainCompany.addRollingComponentToTrainByIndex(trainid, wagonId, rname, index);
		notifyObservers();
		return result;
	}
	
	public boolean deleteRollingComponentFromTrain(String trainid, String wagonId) throws Exception {
		boolean result = trainCompany.deleteRollingComponentFromTrain(trainid, wagonId);
		notifyObservers();
		return result;
	}
	
	public final boolean addRollingComponentType(int s, String n, Boolean cd) {
		boolean result = trainCompany.addRollingComponentType(s, n, cd);
		notifyObservers();
		return result;
	}
	
	public final boolean addRollingComponentType(String n, Boolean cd) {
		boolean result = trainCompany.addRollingComponentType(n, cd);
		notifyObservers();
		return result;
	}
	
	public final boolean addTrain(String TrainId) throws Exception {
		boolean result = trainCompany.addTrain(TrainId);
		notifyObservers();
		return result;
	}
	
	public Train findTrainInArrayList(String s) throws Exception {
		return trainCompany.findTrainInArrayList(s);
	}
	
	public ArrayList<Train> getTrains(){
		return trainCompany.getTrains();
	}
	
	public ArrayList<RollingComponentType> getRCType(){
		return trainCompany.getRCType();
	}
	
	
	
	public TrainCompany getTrainCompany() {
		return trainCompany;
	}
	
	//In het gebied hieronder staan de methode's die benodigd zijn voor het subject gedeelte van het observer pattern
	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregister(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for(Observer o: observers){
			o.update();
		}
	}
}
