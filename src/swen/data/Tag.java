package swen.data;

public class Tag {

	private long id;
	private String name;

	public Tag() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tag(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
