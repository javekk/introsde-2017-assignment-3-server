package introsde.assignment3.soap.ws;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import introsde.assignment3.soap.model.Activity;
import introsde.assignment3.soap.model.Person;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment3.soap.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {
	
	/*
	 * Method 1# readPersonList() => List<Person>
	 * should list all the people in the database (all information related to each person) in your database.
	 */
    @Override
    public List<Person> readPersonList() {
        return Person.getAll(); 
    }
	
    /*
	 * Method #2: readPerson(Long id) => Person
	 * should give all the Personal information of one Person identified by {id}.
	 */
    @Override
    public Person readPerson(Long id) {
        System.out.println("---> Reading Person by id = "+id);
        Person p = Person.getPersonById((int) (long) id);
        if (p!=null) {
            System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
        } else {
            System.out.println("---> Didn't find any Person with  id = "+id);
        }
        return p;
    }
    
    /*
	 * Method #3: updatePerson(Person p) => Person 
	 * should update the Personal information of the Person identified by {id}
	 * (e.g., only the Person's information)
	 */
    @Override
    public Person updatePerson(Person person) {
        Person.updatePerson(person);
        person = Person.getPersonById(person.getIdPerson());
        return person;
    }
    
    /*
	 * Method #4: createPerson(Person p) => Person
	 * should create a new Person and return the newly created Person with its assigned id 
	 * (if a preference is included, create also those values for the new Person).
	 */
    @Override
    public Person addPerson(Person person) {
        return Person.savePerson(person);
    }
    
    /*
	 * Method #5: deletePerson(Long id) => int
	 *  should delete the Person identified by {id} from the system
	 */
    @Override
    public int deletePerson(Long id) {
        Person p = Person.getPersonById((int)(long)id);
        if (p!=null) {
            Person.removePerson(p);
            return 0;
        } else {
            return -1;
        }
    }
    
    /*
	 * Method #6: readPersonPreferences(Long id, String activity_type) => List<Activity>
	 * should return the list of values of {activity_type} (e.g. sport) for a Person identified by {id}
	 */
	@Override
	public List<Activity> readPersonPreferences(Long id, String activity_type) {
		Person p = Person.getPersonById((int)(long)id);
		List<Activity> ret = new ArrayList<>();
		for(Activity a : p.getPreferences()) {
			if(a.getType().getTypeOf().equals(activity_type)) {
				ret.add(a);
			}
		}
		return ret;
	}
	
	 /*
	 * Method #7: readPreferences() => List<Preferences>
	 * should return the list of all preferences
	 */
	@Override
	public List<Activity> readPreferences() {
		return Activity.getAllActivities();
	}
	
	/*
	 * Method #8: readPersonPreferences(Long id, Long activity_id) => Preference
	 * should return the value identified by {activity_id} for a Person identified by {id}
	 */
	@Override
	public Activity readPersonPreference(Long id,Long activity_id) {
		return Activity.getActivityById((int)(long) activity_id);
	}
	
	/*
	 * Method #9: savePersonPreferences(Long id, Activity activity)
	 * should save a new activity object {activity} of a Person identified by {id}
	 */
	@Override
	public void savePersonPreference(Long id, Activity activity) {
		Person p = Person.getPersonById((int)(long)id);
		List<Activity> l = p.getPreferences();
		l.add(activity);
		p.setPreferences(l);
		Person.updatePerson(p);
	}


	/*
	 * Method #10: updatePersonPreferences(Long id, Activity activity) => Preference
	 * should update the activity identified with {activity.id}, related to the Person identified by {id}
	 */
	@Override
	public Activity updatePersonPreference(Long id, Activity activity) {
		Person p = Person.getPersonById((int)(long) id);
		Activity.updateActivity(activity);
		Person.updatePerson(p);
		return Activity.getActivityById(activity.getIdActivity());
	}

	
	/*
	 * Method #11 (Extra): evaluatePersonPreferences(Long id, Activity activity, int value) => Activity
	 * should update the activity identified with {activity.id}, related to the Person identified by {id} 
	 * with the value that define a specific value of preferences (8 out of 10).
	 */
	@Override
	public Activity evaluatePersonPreferences(Long id, Activity activity, int value) {
		if(value < 11 && value > 0) {
			activity.setValue(value);
			return this.updatePersonPreference(id, activity);
		}
		return activity;
	}


	/*
	 * Method #12 (Extra): getBestPersonPreference(Long id) => List<Preference>
	 * should  return the best preference (or preferences if there are more) of the Person
	 *  identified by {id}  from his/her list of preferences.
	 */
	@Override
	public List<Activity> getBestPersonPreference(Long id) {
		Person p = Person.getPersonById((int)(long) id);
		List<Activity> l = p.getPreferences();
		List<Activity> ret = new ArrayList<>();
		int curMax = 0;
		for(Activity a : l) {
			int cur = a.getValue();
			
			if(cur == curMax) {
				ret.add(a);
			}
			else if(a.getValue() > curMax) {
				ret.removeAll(ret);
				curMax = cur;
				ret.add(a);
			}
		}
		return ret;
	}
	
}