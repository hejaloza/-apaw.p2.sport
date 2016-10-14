package es.upm.miw.apiArchitectureSport.wrappers;

public class SportWrapper {
	private int id;
	private String name;

	public SportWrapper(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{\"Id\":" + id + ",\"Name\":\"" + name + "\"}";
	}

}
