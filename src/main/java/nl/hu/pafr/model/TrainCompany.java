package nl.hu.pafr.model;

import java.util.ArrayList;
import java.util.Objects;

public class TrainCompany {
	private ArrayList<Train> trains;
	private ArrayList<RollingComponentType> rcTypes;

	// Ik vraag mij nog steeds af of dit goed is.
	private TrainCompany() {

	}

	// Iets lastiger dan de train.removeRollingComponent()
	public boolean deleteTrain(String id) {
		for (Train t : trains) {
			if (t.getId() == id) {
				ArrayList<RollingComponent> a = t.getRollingComponents();
				// Alle rollingcomponents weghalen is ook wel zo netjes.
				for (RollingComponent r : a) {
					a.remove(r);
				}
				a = null;
				trains.remove(t);
				t = null;
				return true;
			}
		}
		return false;
	}



public int getSeats(String id) {
		for (Train t : trains) {
			if (t.getId() == id) {
				return t.getSeats();
			}
		}
		// Als wij dit aanroepen maar de trein niet bestaat heb je dus 0
		// stoelen???
		return 0;
	}

	// Maken wij hier een wagon aan? Of moet je wagon al bestaan? Hebben wij ook
	// niet het type nodig?
	// Morgen naar kijken.
	public boolean addRollingComponentToTrain(String trainid, String wagonId, RollingComponentType rname) {
		for (Train t : trains) {
			if (t.getId() == trainid) {
				t.addRollingComponentEnd(rname, wagonId);
				return true;
			}
		}
		return false;
	}

	// Zelfde als hierboven
	public boolean addRollingComponentToTrainByIndex(String trainid, String wagonId, RollingComponentType rname,
			int index) {
		for (Train t : trains) {
			if (t.getId() == trainid) {
				t.addRollingComponentPlace(rname, wagonId, index);
				return true;
			}
		}
		return false;
	}

	public boolean deleteRollingComponentFromTrain(String trainid, String wagonId) {
		for (Train t : trains) {
			if (t.getId() == trainid) {
				t.deleteRolingComponent(wagonId);
				return true;
			}
		}
		return false;
	}

	public final boolean addRollingComponentType(int s, String n, Boolean cd){
		RollingComponentType rct = new RollingComponentType(s, n, cd);
		rcTypes.add(rct);
		rct = null;
		return true;
	}
	//Dit is lastig wat te doen met de rollincomponents van dat type? Allemaal ook weghalen?
	public final boolean deleteRollingComponentType(String name){
		return true;
		
	}

	// Waarom is dit nodig bert?
	public final boolean addTrain(String TrainId, RollingComponentType rct, String wagonId) {
		Train t = new Train(TrainId, rct, wagonId);
		trains.add(t);
		t = null;
		return true;
	}
	
	//verzin hier iets voor want dit scheelt 5 keer code.
	public static Object findStringInArrayList(String s, ArrayList a){
		for (Object o: a){
			if (o.getId() == s){
				return o;
			}
		}
	}
}
