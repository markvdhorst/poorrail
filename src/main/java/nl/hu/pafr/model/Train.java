package nl.hu.pafr.model;

import java.util.ArrayList;

public class Train {
	private String id;
	private ArrayList<RollingComponent> rollingComponents;

	// to do bert
	public int getSeats() {
		return 0;
	};

	public void addRollingComponentEnd(RollingComponentType t, String i) {
		RollingComponent rc = new RollingComponent(t, i);
		rollingComponents.add(rc);
	}

	public void addRollingComponentPlace(RollingComponentType t, String i, int p) {
		RollingComponent rc = new RollingComponent(t, i);
		rollingComponents.add(p, rc);
	}

	public boolean deleteRolingComponent(String id) {
		for (RollingComponent r : rollingComponents) {
			if (r.getId()==id) {
				return true;
			}
		}
		return false;
	}
}
