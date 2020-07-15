import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

	public class BaggageList {
		
		private PassengerList allPassengers;
		//instantiate a ArrayList with Baggage
		ArrayList<Baggage> baggageList = new ArrayList<Baggage>(100);
		
		public BaggageList(PassengerList passengerList) {
			allPassengers = passengerList;
		}
		
		public void add(Baggage b) {
			baggageList.add(b);
		}
		
		public void createBaggageList() {
			
			for (int i = 1; i <= 100; i++) {
				int height = ThreadLocalRandom.current().nextInt(50, 120);
				int width = ThreadLocalRandom.current().nextInt(30, 100);
				int length = ThreadLocalRandom.current().nextInt(20, 40);
				int weight = ThreadLocalRandom.current().nextInt(15,35);
				
				Baggage b = new Baggage(height, width, length, weight);
				this.add(b);
				}
		}
			
}
