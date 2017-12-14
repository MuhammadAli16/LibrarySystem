package library;

import java.util.ArrayList;

public class Person {
	
	private static int count = 0;

	private ArrayList<Item> taken = new ArrayList<>();
	
	private int id;
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		//this.id = id;
		this.name = name;
		this.age = age;
		
		// set id
		this.id = count++;
	}

	public ArrayList<Item> getTaken() {
		return taken;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getId() {
		return id;
	}
	
	public void takeItem(Item i){
		taken.add(i);
	}
	
	public void returnItem(Item i){
		taken.remove(i);
	}
	
	

	@Override
	public String toString() {
		return "Person [taken=" + taken + ", id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
