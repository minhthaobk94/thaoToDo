package main;

public class Todo {
	private int id;
	private String name;
	private Category catelogy;

	public Todo(int id, String name, Category catelogy) {
		this.id = id;
		this.name = name;
		this.catelogy = catelogy;
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

	public Category getCatelogy() {
		return catelogy;
	}

	public void setCatelogy(Category catelogy) {
		this.catelogy = catelogy;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", name=" + name + ", catelogy=" + catelogy + "]";
	}

}
