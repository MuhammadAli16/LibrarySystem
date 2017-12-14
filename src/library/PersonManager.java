package library;

import java.util.ArrayList;

public class PersonManager {

	private ArrayList<Person> thePeople = new ArrayList<>();
	
	public void addPerson(Person p) {
		thePeople.add(p);
	}

	public void deletePerson(Person p) {
		thePeople.remove(p);
	}

	public void updatePerson() {

	}
	
	public ArrayList<Person> getThePeople() {
		return this.thePeople;
	}
	
}
