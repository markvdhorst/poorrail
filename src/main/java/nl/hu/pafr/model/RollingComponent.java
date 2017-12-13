package nl.hu.pafr.model;
// 13/12/2017 klaar
public class RollingComponent {
	// id of rolling mag niet aanpasbaar te zijn.
	private final String id;
	private final RollingComponentType rollingComponentType;
	// deze klasse is vrij simpel en heeft eigenlijk alleen maar attributen en functies om de attributen op te vragen.
	public RollingComponent(RollingComponentType t, String i) {
		id = i;
		rollingComponentType = t;
	}
	// Er zijn geen set functies omdat alles final is.
	public String getId() {
		return id;
	}

	public RollingComponentType getRollingComponentType() {
		return rollingComponentType;
	}

	public int getSeats(){
		return rollingComponentType.getSeats();
	}
}
