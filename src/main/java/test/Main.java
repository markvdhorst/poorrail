package test;

import nl.hu.pafr.model.TrainCompany;

public class Main {

	public static void main(String[] args) throws Exception {
		TrainCompany t = new TrainCompany();
		t.addRollingComponentType(0, "Bert2", true);
		System.out.println(t.findTrainInArrayList("Bert1"));

		t.addTrain("Bert1", "Bert2", "Bert3");
		System.out.println(t.findTrainInArrayList("Bert1"));

		t.addTrain("Mark1", "Mark2", "Mark3");

		t.addRollingComponentType(20, "Mark2", true);

		t.addTrain("Mark1", "Mark2", "Mark3");

		// print eerst alle rcttypes
		System.out.println(t.getRCType());
		// print dan alle treaining
		System.out.println(t.getTrains());

		t.deleteTrain("Bert");

		System.out.println(t.getRCType());
		System.out.println(t.getTrains());
		System.out.println(t.getSeats("Mark1"));
		System.out.println(t.getSeats("Mark7"));

		t.addRollingComponentToTrainByIndex("Mark", "Bert", null, 0);

	}

}
