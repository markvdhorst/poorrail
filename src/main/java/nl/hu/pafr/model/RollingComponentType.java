package nl.hu.pafr.model;
//13/12/2017 klasse is klaar voor vandaag.
public class RollingComponentType {
	
	// dit is de enige plek waar ik twijfel of final maar dat is juist waarom het er staat.
	private final int seats;
	private  final String name;
	public RollingComponentType(int s, String n){
		seats = s;
		name = n;
	}
	// opnieuw passen wij alleen maar setters toe.
	public int getSeats() {
		return seats;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return ("printing rolling componenttype "+ seats+ " " + name);
	}

}
