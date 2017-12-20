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
		//print eerst alle rcttypes
		System.out.println(t.getRCType());
		//print dan alle treaining
		System.out.println(t.getTrains());
		try {
			t.deleteTrain("Bert");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t.getRCType());
		System.out.println(t.getTrains());
		try {
			System.out.println(t.getSeats("Bert"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(t.getSeats("Mark"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
