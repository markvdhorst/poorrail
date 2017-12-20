package test;

import nl.hu.pafr.model.TrainCompany;

public class Main {

	public static void main(String[] args)  {
		TrainCompany t = new TrainCompany();
		t.addRollingComponentType(0, "Bert2", true);
		try {
			t.addTrain("Bert1", "Bert2", "Bert3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(t.findTrainInArrayList("Bert1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			t.addTrain("Mark1", "Mark2", "Mark3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t.addRollingComponentType(20, "Mark2", true);

		try {
			t.addTrain("Mark1", "Mark2", "Mark3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// print eerst alle rcttypes
		System.out.println(t.getRCType());
		// print dan alle treaining
		System.out.println(t.getTrains());

		try {
			t.deleteTrain("Bert1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(t.getRCType());
		System.out.println(t.getTrains());
		try {
			System.out.println(t.getSeats("Mark1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(t.getSeats("Mark7"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			t.addRollingComponentToTrainByIndex("Mark1", "Bert", null, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
