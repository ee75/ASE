public class Manager {
	
	private PassengerList allPassengers;
	private FlightList allFlights;
	private Airport airport;
	private Log logwrite;
	
	public Manager() {
		allPassengers = new PassengerList();
		allFlights = new FlightList(allPassengers);
		airport = new Airport();
		logwrite = new Log();
		//Vanesa added:
		queueDisplay = new QueueDisplay(airport);
		deskDisplay = new DeskDisplay(airport);
		flightDisplay = new FlightDisplay(airport);
	}
    
	public void run() {
		logwrite.start();
		allFlights.readFile("Flight_mock.csv");
		allPassengers.readFile("Passenger_mock.csv");
		airport.useloger(logwrite);
		airport.PassengerListToQueue();		
		airport.returnLoger().closeLog();
	}
}
