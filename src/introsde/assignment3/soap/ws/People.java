package introsde.assignment3.soap.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import introsde.assignment3.soap.model.Activity;
import introsde.assignment3.soap.model.Person;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
	
	/*
	 * METHOD #1 readPersonList() => List<Person>
	 */
	@WebMethod(operationName="getPeopleList")
	@WebResult(name="people") 
	public List<Person> readPersonList();

	/*
	 * Method #2: readPerson(Long id) => Person
	 */
	@WebMethod(operationName="readPerson")
	@WebResult(name="person") 
	public Person readPerson(@WebParam(name="personId") Long id);
	
	/*
	 * Method #3: updatePerson(Person p) => Person 
	 */
	@WebMethod(operationName="updatePerson")
	@WebResult(name="person") 
	public Person updatePerson(@WebParam(name="persona") Person person);
	

	/*
	 * Method #4: createPerson(Person p) => Person
	 */
	@WebMethod(operationName="createPerson")
	@WebResult(name="person") 
	public Person addPerson(@WebParam(name="persona") Person person);
	

	/*
	 * Method #5: deletePerson(Long id) => int
	 */
	@WebMethod(operationName="deletePerson")
	@WebResult(name="personId") 
	public int deletePerson(@WebParam(name="person") Long id);

	/*
	 * Method #6: readPersonPreferences(Long id, String activity_type) => List<Activity>
	 */
	@WebMethod(operationName="readPersonPreferences")
	@WebResult(name="activities") 
	public List<Activity> readPersonPreferences(
			@WebParam(name="personId") Long id, 
			@WebParam(name="activityType") String activity_type);
	
	/*
	 * Method #7: readPreferences() => List<Activity>
	 */
	@WebMethod(operationName="readPreferences")
	@WebResult(name="activities") 
	public List<Activity> readPreferences();
	
	/*
	 * Method #8: readPersonPreference(Long id, Long activity_id) => Activity
	 */
	@WebMethod(operationName="readPersonPreference")
	@WebResult(name="activity") 
	public Activity readPersonPreference(
			@WebParam(name="personId") Long id, 
			@WebParam(name="activityId") Long activity_id);
	
	/*
	 * Method #9: savePersonPreference(Long id, Activity activity)
	 */
	@WebMethod(operationName="savePersonPreference")
	@WebResult(name="activity_id") 
	public void savePersonPreference(
			@WebParam(name="personId") Long id, 
			@WebParam(name="activity") Activity activity);
	
	/*
	 * Method #10: updatePersonPreferences(Long id, Activity activity) => Preference
	 */
	@WebMethod(operationName="updatePersonPreference")
	@WebResult(name="activity") 
	public Activity updatePersonPreference(
			@WebParam(name="personId") Long id, 
			@WebParam(name="activitya") Activity activity);
	
	/*
	 * Method #11 (Extra): evaluatePersonPreferences(Long id, Activity activity, int value) => Activity
	 */
	@WebMethod(operationName="evaluatePersonPreferences")
	@WebResult(name="activityId") 
	public Activity evaluatePersonPreferences(
			@WebParam(name="personId") Long id, 
			@WebParam(name="activitya") Activity activity, 
			@WebParam(name="value")int value);
	
	/*
	 * Method #12 (Extra): getBestPersonPreference(Long id) => List<Activity>
	 */
	@WebMethod(operationName="getBestPersonPreference")
	@WebResult(name="activities") 
	public List<Activity> getBestPersonPreference(
			@WebParam(name="personId") Long id);
	
}
