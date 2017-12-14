package nl.hu.pafr.model;

import java.util.ArrayList;

public class Train {
	// Final omdat id later aanpassen problemen opleveren kan.
	private final String id;
	private ArrayList<RollingComponent> rollingComponents;
	// Willen wij altijd een component in een trein? Ik zeg ja. model zei ook ja.
	// Dit is de constructor voor altijd rollingcomponent in train nu kan beide
	// nog.
	public Train(String trainId, RollingComponentType rct, String wagonid) {
		id = trainId;
		rollingComponents = new ArrayList<RollingComponent>();
		RollingComponent rc = new RollingComponent(rct, wagonid);
		rollingComponents.add(rc);
	}

	// simpele arraylist toevoeging aan het einde.
	// ik maak hier pas het object.
	public void addRollingComponentEnd(RollingComponentType t, String i) {
		RollingComponent rc = new RollingComponent(t, i);
		rollingComponents.add(rc);
	}

	// toevoeging aan de arraylist via de index let op index start op 0 zoals
	// normaal
	public void addRollingComponentPlace(RollingComponentType t, String i, int p) {
		RollingComponent rc = new RollingComponent(t, i);
		rollingComponents.add(p, rc);
	}

	// Snel geschreven en niet getest als er ergens problem zijn is het hier
	// wel.
	public boolean deleteRolingComponent(String id) {
		RollingComponent r = findRollingComponentInTrain(id);
		rollingComponents.remove(r);
		return true;
	}

	// alle get methodes volgen.
	public ArrayList<RollingComponent> getRollingComponents() {
		return rollingComponents;
	}

	public RollingComponent getRollingComponentsByIndex(int index) {
		return rollingComponents.get(index);
	}

	// Komt het voor dat wij het id weten maar het component wilen hebben?
	public RollingComponent getRollingComponentsByID(String id) {
		RollingComponent r = findRollingComponentInTrain(id);
		return r;
	}

	public String getId() {
		return id;
	}
	public RollingComponent findRollingComponentInTrain(String s) {
		ArrayList<RollingComponent> a = this.rollingComponents;
		for (RollingComponent o : a) {
			if (o.getId() == s) {
				return o;
			}

		}
		return null;
	}

	// to do bert
	// In het model heeft RollingComponent geen getseats methode de seats zitten
	// aan het component type vast.
	// Dit zou geen probleem zijn maar ik kan niet de methode van de
	// rollingcomponenttype aanroepen dus moet ik een getSeats() toevoegen
	// Maar het enige dat deze getSeats is is een doorgeefluik naar de
	// getseats() van rollingcomponenttype.
	public int getSeats() {
		int seats = 0;
		for (RollingComponent r : rollingComponents) {
			seats += r.getSeats();
		}
		return seats;
	};
}
