package nl.hu.pafr.model;

import java.util.ArrayList;

public class TrainCompany {
	private ArrayList<Train> trains;
	private ArrayList<RollingComponentType> rcTypes;

	public TrainCompany() {
		rcTypes = new ArrayList<RollingComponentType>();
		trains = new ArrayList<Train>();
	}

	// Iets lastiger dan de train.removeRollingComponent()
	public boolean deleteTrain(String id) throws Exception {
		Train t = findTrainInArrayList(id);
		if (t != null) {
			trains.remove(t);
			return true;
		}
		return false;
	}

	public int getSeats(String id) throws Exception {
		Train i = findTrainInArrayList(id);
		return i.getSeats();
	}

	// Het type moet al bestaan.
	public boolean addRollingComponentToTrain(String trainid, String wagonId, String rname) throws Exception {
		RollingComponentType rtype;
		for (RollingComponentType r : rcTypes) {
			if (r.getName().equals(rname)) {
				rtype = r;
				for (Train t : trains) {
					if (t.getId().equals(trainid)) {
						t.addRollingComponentEnd(rtype, wagonId);
						return true;
					}
				}
			}

		}
		return false;
	}

	// Zelfde als hierboven
	public boolean addRollingComponentToTrainByIndex(String trainid, String wagonId, RollingComponentType rname,
			int index) throws Exception {
		Train t = findTrainInArrayList(trainid);
		if (t != null) {
			t.addRollingComponentPlace(rname, wagonId, index);
			return true;
		}
		return false;
	}

	public boolean deleteRollingComponentFromTrain(String trainid, String wagonId) throws Exception {
		Train t = findTrainInArrayList(trainid);
		if (t != null) {
			boolean del = t.deleteRolingComponent(wagonId);
			return del;
		}
		return false;
	}

	public final boolean addRollingComponentType(int s, String n) {
		for(RollingComponentType type : rcTypes) {
			if(type.getName().equals(n)) {
				return false;
			}
		}
		RollingComponentType rct = new RollingComponentType(s, n);
		rcTypes.add(rct);
		return true;
	}

	// geen int ingeven is 20 seats
	public final boolean addRollingComponentType(String n) {
		return addRollingComponentType(20, n);
	}

	// Waarom is dit nodig bert?
	public final boolean addTrain(String TrainId){
		try {
			Train a = findTrainInArrayList(TrainId);
		} catch (Exception e) {

			Train t = new Train(TrainId);
			trains.add(t);
			return true;
		}
		return false;
		
	}

	// verzin hier iets voor want dit scheelt 5 keer code.
	public Train findTrainInArrayList(String s) throws Exception {
		ArrayList<Train> a = this.trains;
		for (Train o : a) {
			if (o.getId().equals(s)) {
				return o;
			}
		}
		throw new Exception("Trein niet gevonden");
	}

	public ArrayList<Train> getTrains() {
		return this.trains;
	}

	public ArrayList<RollingComponentType> getRCType() {
		return this.rcTypes;
	}
}
