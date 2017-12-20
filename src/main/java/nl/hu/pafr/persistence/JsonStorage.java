package nl.hu.pafr.persistence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import nl.hu.pafr.controller.Observer;
import nl.hu.pafr.controller.TrainCompanyController;
import nl.hu.pafr.model.TrainCompany;

public class JsonStorage implements Observer {
	private static final String filePath = "TrainCompany.json";
	private TrainCompanyController controller;
	private Gson gson;

	public JsonStorage() {
		this.gson = new Gson();
	}
	
	public TrainCompany retrieveFromFile() {
		TrainCompany trainCompany;
		try {
			trainCompany = gson.fromJson(new FileReader(filePath),TrainCompany.class);
		} catch (Exception e) {
			trainCompany = new TrainCompany();
		}
		return trainCompany;
	}
	@Override
	public void update() {
		updateFile(controller.getTrainCompany());
	}
	
	private void updateFile(TrainCompany trainCompany){
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(gson.toJson(trainCompany));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerToController(TrainCompanyController controller) {
		this.controller = controller;
	}
}
