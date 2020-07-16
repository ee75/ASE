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
		
		//Set Window Title showing the current desk 
		setTitle("Desk" );  //+ String.format("%-4s", adesk.findCurrentDesk()));

		//Set Queue Display Panel
		//setupNorthPanel();
		add(BorderLayout.NORTH, new QueueDisplay(model));
		//setupCenterPanel();
		add(BorderLayout.CENTER, new DeskDisplay(model));
		//setupSouthPanel();
		add(BorderLayout.SOUTH, new FlightDisplay(model));

	

	}
	

}
