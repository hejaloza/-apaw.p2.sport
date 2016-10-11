package es.upm.miw.apiArchitectureSport.entities;


public class Sport {

    private int id;

    private String name;
    


    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
        
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

	

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + "]";
	}

}
