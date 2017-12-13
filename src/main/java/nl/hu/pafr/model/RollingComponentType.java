package nl.hu.pafr.model;
//13/12/2017 klasse is klaar voor vandaag.
public class RollingComponentType {
	
	// dit is de enige plek waar ik twijfel of final maar dat is juist waarom het er staat.
	private final int seats;
	private  final String name;
	private final boolean canDrive;
	public RollingComponentType(int s, String n, boolean d){
		seats = s;
		name = n;
		canDrive = d;
	}
	// opnieuw passen wij alleen maar setters toe.
	public int getSeats() {
		return seats;
	}

	public String getName() {
		return name;
	}

	public boolean isCanDrive() {
		return canDrive;
	}

}
