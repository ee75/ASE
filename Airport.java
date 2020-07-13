import java.util.TreeSet;
import java.util.concurrent.Semaphore;
//V: Added for the OBSERVER pattern
import java.util.*; 
//V: Added for the MVC pattern. 
//import interfaces.Obsever;
//import interfaces.Subject;

public class Airport implements Subject {
	int numberOfDesks = 2;    
	
	//this acts as a "pass" to a empty desk, meaning only one thread
	//can access a desk at a time
	private Semaphore freeDesk = new Semaphore(numberOfDesks);
	
	//this is to stop the log class from closing before the simulation 
	//has finished
	boolean lastCheckinComplete = false;
	
	//creates array of no. of desks long; auto set to 0 (waiting),
	//I was thinking we could change so 1 is serving and 2 is closed
	public int[] deskStatus = new int [numberOfDesks];
	
	private Log superlogwiter;
	
	public void useloger(Log l) {
		this.superlogwiter = l;
	}
	
	public Log returnLoger() {
		//checks if the last check-in has finished before returning log
		while(!lastCheckinComplete) {
			//if not true wait a little then try again
			try {Thread.sleep(100);} 
			catch (InterruptedException e) {e.printStackTrace();}
		} 
		return this.superlogwiter;
	}

	//This class is for the actual check-in process
	class CheckIn{
		// defining which desk is in use
		public int currantDesk = 999; //999 is now an error number
		
		//To count the total number of check-ins for testing 
		int noCheckIns = 0;
		public int getC () {return this.noCheckIns;};
		
		//For the actual check in process
		public void useDesk() {	
			Thread t = Thread.currentThread();
			
			//sleep for simulation purposes
			try {t.sleep(100);} 
			catch (InterruptedException e) {e.printStackTrace();}
			
			

			// Include any check in code required for GUI.




				//for testing; we can see which desks are in use
					//System.out.println("using desk statuses "+ Arrays.toString(deskStatus));

			//increase the count of check-ins
			int n = this.noCheckIns; n++;
			this.noCheckIns = n;
			// the counting is mostly for testing purposes and can be removed
			
			//this will write a new line to the Log class
			String threadName = t.getName();
			String message = "Check-In " + noCheckIns + " (" + threadName 
					+ ") at desk " + currantDesk;
			superlogwiter.writeToLog(message);
			
			//Checks if every passenger has now checked in so we can close the 
			//class.
			if(n == PassengerList.passengerList.size()) {
			lastCheckinComplete = true;
			}
			
		}  

		//These methods are just for identifying which desk the thread will use.
		
		//This one will find the next desk which isn't in use
		public int identifyFreeDeskNo() {
			int n = 999; //error number 
			for (int i = 0; i < deskStatus.length; i++) {
				if (deskStatus[i] == 0) {
					deskStatus[i] = 1;
					n = i+1; 
					this.currantDesk = n; //System.out.println("useing desk no.:-" + n + " [" + currantDesk + "]");
					break;
				}
			}
			return n;
		}		
		//This one will mark the desk empty after use
		public void emptyIdentifiedDesknoNo(int n) {
			deskStatus[n-1] = 0; 
			this.currantDesk = 999; //System.out.println("emtied desk no.:-" + n + " [" + currantDesk + "]");
		}
	}

	//Initiates the check-in class so as many threads are running, there
	//is only one check-in process being used.
	CheckIn	checkin = new CheckIn();

	//Defines a Passenger thread
	class PassengerInQueue  implements Runnable {
		public void run(){
			String NameBRef = Thread.currentThread().getName();
			System.out.println(NameBRef + " joined queue.");

			// needs code to add passenger to returnable queue list 

			
			//Obtains "pass" for thread/passenger to use an empty desk
			try {freeDesk.acquire();} 
			catch (InterruptedException e) {e.printStackTrace();}
			
			
			// needs code to add removal of passenger from the queue list 
			
			//finds the desk no the thread/passenger will use
			int deskno = checkin.identifyFreeDeskNo(); 
			//thread/passenger does the check-in process
			checkin.useDesk();
			//thread/passenger leaves desk marking it empty
			checkin.emptyIdentifiedDesknoNo(deskno);
			//releases "pass" to be used by the next thread/passenger
			freeDesk.release();
			//can be used in testing:-
			System.out.println(NameBRef + " completed check in");
		}	
	}


	//creates running thread for every passenger in list
	public void PassengerListToQueue(){
		TreeSet<Passenger> passengerList = PassengerList.getPassengerList();
		for(Passenger p: passengerList ) {
			String plName = p.getPassengerName().getLastName();
			String pbRef = Integer.toString(p.getBookingReference());
			String NameBRef = plName + pbRef; //gives unique code 
			Thread t = new Thread(new PassengerInQueue()); 
			t.setName(NameBRef); //for simulation 
			try {t.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
			t.start();
		}
	}
	//V:
		// OBSERVER PATTERN
	// SUBJECT must be able to register, remove and notify observers
	
	/**
	 * List to hold any observers
	 */
	private List<Observer> registeredObservers = new LinkedList<Observer>();

	/**
	 * Register an observer with this subject
	 */
	public void registerObserver(Observer obs) {
		registeredObservers.add(obs);
	}

	/**
	 * De-register an observer with this subject
	 */
	public void removeObserver(Observer obs) {
		registeredObservers.remove(obs);
	}

	/**
	 * Inform all registered observers that there's been an update
	 */
	public void notifyObservers() {
		for (Observer obs : registeredObservers)
			obs.update();
	}


}
