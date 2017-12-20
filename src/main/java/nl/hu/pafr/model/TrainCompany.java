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
	public boolean deleteTrain(String id) {
		Train t = findTrainInArrayList(id);
		if (t != null) {
			ArrayList<RollingComponent> a = t.getRollingComponents();
			// Alle rollingcomponents weghalen is ook wel zo netjes.
			// Not to self: Ik maar de lijst niet aanpassen dus hoe doe ik dit.
			a.clear();
			trains.remove(t);
			return true;
		}
		return false;
	}

	public int getSeats(String id) {
		Train i = findTrainInArrayList(id);
		if (i != null) {
			return i.getSeats();
		}
		return 0;
	}

	// Het type moet al bestaan.
	public boolean addRollingComponentToTrain(String trainid, String wagonId, RollingComponentType rname)
			throws Exception {
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
		Train t = findTrainInArrayList(trainid);
		if (t != null) {
			t.addRollingComponentPlace(rname, wagonId, index);
			return true;
		}
		return false;
	}

	public boolean deleteRollingComponentFromTrain(String trainid, String wagonId) {
		Train t = findTrainInArrayList(trainid);
		if (t != null) {
			boolean del = t.deleteRolingComponent(wagonId);
			return del;
		}
		return false;
	}

	public final boolean addRollingComponentType(int s, String n, Boolean cd) {
		RollingComponentType rct = new RollingComponentType(s, n, cd);
		rcTypes.add(rct);
		return true;
	}

	// geen int ingeven is 20 seats
	public final boolean addRollingComponentType(String n, Boolean cd) {
		return addRollingComponentType(20, n, cd);
	}

	// Waarom is dit nodig bert?
	public final boolean addTrain(String TrainId, String name, String wagonId) throws Exception {
		Train a = findTrainInArrayList(TrainId);
		if (a == null) {
			for (RollingComponentType rct : this.rcTypes) {
				if (rct.getName().equals(name)) {
					Train t = new Train(TrainId, rct, wagonId);
					trains.add(t);
					return true;
				}
			}

		} else {
			throw new Exception("Train id is al gebruikt");
		}
		return false;
	}

	// verzin hier iets voor want dit scheelt 5 keer code.
	public Train findTrainInArrayList(String s) {
		ArrayList<Train> a = this.trains;
		for (Train o : a) {
			if (o.getId().equals(s)) {
				return o;
			}
		}
		return null;
	}

	public ArrayList<Train> getTrains() {
		return this.trains;
	}

	public ArrayList<RollingComponentType> getRCType() {
		return this.rcTypes;
	}
}
