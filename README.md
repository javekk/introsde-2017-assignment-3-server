# introsde-2017-assignment-3-server

## 1. Identification
* Perini Raffaele 196339
* raffaele.perini@studenti.unitn.it
* __My Server URL__: https://introsdeass3.herokuapp.com/sdelab/

## 2. Project
This is a SOAP server. The main parts of this server are People and Activities. A student can have a different number of Activities(0 to n), that be stored as the preferred activities of this student. In this server it is possible to perform all the CRUD operations for people, and manage their preferred activities.

#### 2.1. Code
The logical part of the server is divided in __model__, which is where the entities are placed, the __dao__ which handles with the entities and acts as link between model and the __resources__ which are exposed through out the system.
* __Model__: In this package are defined the classes __People__, __Activity__, __ActivityType__. Within all these classes are defined the parameters and  some useful methods for handling with them. All these are mapped in a SQLite database using the __Java Persistence Api__. The __ActivityTypes__ class is used in order to make simple handling with activityType objects, and it not mapped on the database.
* __Endpoint__: This is the Web Service Endpoint Publisher.
* __Dao__: In this package we have __PersonActivityDao__ which provides the interface to the model, whereby the classes written in the Persistence.xml.
* __WS__: The package where the are contained the classes using to get the requests and retrive the responses to/from the client.
   * The __People__ Java Class serves as a Web Service Endpoint Interface. It contains the declarations of the methods reachable from the clients.
   * The __PeopleImpl__ contains the implementations of the methods declared in the _People_ interface.


#### 2.2. Task
this server can do the following tasks both usign the __SOAP__ protocol:
 * Method __#1__, __readPersonList()__ => __List\<Person\>__: Lists all the people in the database (all information related to each person) in your database (such as name, last name, preferences, etc..).
 * Method __#2__, __readPerson(Long id)__ => __Person__:  gives all the Personal information of one Person identified by {id}.
 * Method __#3__, __updatePerson(Person p)__ => __Person__: updatea the Personal information of the Person identified by {id}.
 * Method __#4__, __createPerson(Person p)__ => __Person__: creates a new Person and returns the newly created Person with its assigned id.
 * Method __#5__, __deletePerson(Long id)__ => __int__: try to delete the Person identified by {id} from the system, returns 0 if the person has been cancelled, -1 otherwise.
 * Method __#6__, __readPersonPreferences(Long id, String activity_type)__ =>__List\<Activity\>__: returns the list of values of {activity_type} (e.g. Sport) for a Person identified by {id}.
 * Method __#7__, __readPreferences()__ => __List\<Activity\>__: returns the list of all activities.
 * Method __#8__, __readPersonPreferences(Long id, Long activity_id)__ => __Activity__: returns the value identified by {activity_id} for a Person identified by {id}.
 * Method __#9__, __savePersonPreferences(Long id, Activity activity)__ => __void__: saves a new activity object {activity} of a Person identified by {id}.
 * Method __#10__, **updatePersonPreferences(Long id, Activity activity)** => **Activity**: updates the activity identified with {activity.id}, related to the Person identified by {id}.
 * Method **#11**, **evaluatePersonPreferences(Long id, Activity activity, int value)** => **Activity**: should update the activity identified with {activity.id}, related to the Person identified by {id} with the value that define a specific value of preferences (e.g. 4 out of 5, or 8 out of 10).
 * Method **#12**, **getBestPersonPreference(Long id)** => **List\<Activity\>** :returns the best preference (or preferences if there are more) of the Person identified by {id}  from his/her list of preferences.

## 3. Execution
It is possible perform all the request above on the following heroku server

  ```
   https://introsdeass3.herokuapp.com/sdelab/
  ```
## 4. Additional Notes
