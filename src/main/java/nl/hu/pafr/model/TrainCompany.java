package nl.hu.pafr.model;

import java.util.ArrayList;

public class TrainCompany {
	private ArrayList<Train> trains;
	private ArrayList<RollingComponentType> rcTypes;

	// Ik vraag mij nog steeds af of dit goed is.
	private TrainCompany() {

	}

	// Iets lastiger dan de train.removeRollingComponent()
	public boolean deleteTrain(String id) {
		Train t = findTrainInArrayList(id);
		if (t != null){
		ArrayList<RollingComponent> a = t.getRollingComponents();
				// Alle rollingcomponents weghalen is ook wel zo netjes.
				for (RollingComponent r : a) {
					a.remove(r);
				}
				trains.remove(t);
				return true;
			}
		return false;
		}
		

	public int getSeats(String id) {
		return findTrainInArrayList(id).getSeats();
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
		rct = null;
		return true;
	}

	// Dit is lastig wat te doen met de rollincomponents van dat type? Allemaal
	// ook weghalen?
	public final boolean deleteRollingComponentType(String name) {
		return true;

	}

	// Waarom is dit nodig bert?
	public final boolean addTrain(String TrainId, RollingComponentType rct, String wagonId) {
		Train t = new Train(TrainId, rct, wagonId);
		trains.add(t);
		t = null;
		return true;
	}

	// verzin hier iets voor want dit scheelt 5 keer code.
	public Train findTrainInArrayList(String s) {
		ArrayList<Train> a = this.trains;
		for (Train o : a) {
			if (o.getId() == s) {
				return o;
			}
		}
		return null;
	}

}
