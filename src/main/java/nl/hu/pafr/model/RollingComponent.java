package nl.hu.pafr.model;

public class RollingComponent {
	private String id;
	private RollingComponentType rollingComponentType;

	public RollingComponent(RollingComponentType t, String i) {
		id = i;
		rollingComponentType = t;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RollingComponentType getRollingComponentType() {
		return rollingComponentType;
	}

	public void setRollingComponentType(RollingComponentType rollingComponentType) {
		this.rollingComponentType = rollingComponentType;
	}
}
