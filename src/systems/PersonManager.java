package systems;

import java.util.ArrayList;

import library.Person;

public class PersonManager {

	private ArrayList<Person> thePeople = new ArrayList<>();

	// create an object of SingleObject
	private static PersonManager instance = new PersonManager();

	private PersonManager() {
	}

	// Get the only object available
	protected static PersonManager getInstance() {
		return instance;
	}

	
	public void addPerson(Person p) {
		thePeople.add(p);
	}

	public boolean deletePerson(int personID) {
		
		// Delete person
		for (int x = 0; x < thePeople.size(); x++){
			if (thePeople.get(x).getId() == personID){
				if (thePeople.get(x).getTaken().size() > 0){
					return false;
				} else {
					thePeople.remove(x);
					return true;
				}
			}
		}
		
		return false;
		
	}

	public void updatePerson() {

	}

	public ArrayList<Person> getThePeople() {
		return this.thePeople;
	}

	Person findPerson(int ID) {
		for (Person person : thePeople) {
			if (person.getId() == ID) {
				return person;
			}
		}
		return null;
	}

}
