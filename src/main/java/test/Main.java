package test;


import nl.hu.pafr.model.TrainCompany;

public class Main {

	public static void main(String[] args) {
		TrainCompany t = new TrainCompany();
		t.addRollingComponentType(0, "Bert", true);
		t.addTrain("Bert", "Bert", "Bert");
		t.addTrain("Mark", "Mark", "Mark");
		t.addRollingComponentType(20, "Mark", true);
		t.addTrain("Mark", "Mark", "Mark");
		System.out.println(t.getRCType());
		System.out.println(t.getTrains());
		t.deleteTrain("Bert");
		System.out.println(t.getRCType());
		System.out.println(t.getTrains());
		System.out.println(t.getSeats("Bert"));
		System.out.println(t.getSeats("Mark"));
	}

}
