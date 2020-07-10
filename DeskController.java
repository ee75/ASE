package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// WE MAY NEED TO CHANGE NAMES OF CLASSES AND OBJECTS!!
//WE MAY NEED to refactor code

import model.Desk;
import views.DeskGUI;


public class DeskController {

  //GUI to allow user to control queue speed
  private DeskGUI view;
  
  // desk model has the queue
  private Desk desk;
  
  public DeskController(DeskGUI view, Desk desk) {
    this.desk = desk;
    this.view =view;
    //specify the listener for the view
    view.addSetListener(new SetListener());
  }
  
  //inner class SetListener responds when user changes queue speed
  public class SetListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      //NEED INFO FROM QUEUE 
      
    }
  }
 }
      
    
    
