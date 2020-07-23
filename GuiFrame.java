package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Airport;

//GuiFrame for displaying desk information.

public class GuiFrame extends JFrame {
	/* Instant Variable from FlightList, PassengerList and Airport
	 * 
	 */
    //private FlightList flightList;
    //private PassengerList passengerList;
    //private Airport airportDesk;
    //private BaggageList baggageList;
    
	
	//Create Frame & panel
		public GuiFrame(Airport model){
		
		//Set Close by default close button of window
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Gui Title
		setTitle("Airport Check-in Status" ); 
		
		//Set Queue Display Panel
		add(BorderLayout.NORTH, new QueueDisplay(model));
		//Set Desk Display Panel
		add(BorderLayout.CENTER, new DeskDisplay(model));
		//Set Flight Display Panel
		add(BorderLayout.SOUTH, new FlightDisplay(model));

	

	}

}
