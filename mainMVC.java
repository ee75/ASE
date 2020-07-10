/**
*This class sets up the Model, View and Controller
*It may need refactoring/ CHANGING NAMES??
*/

package main;

import controllers.DeskController;
import model.Desk;
import views.DeskGUI;

public class DeskDemonstration {
  public static void main(String[] args) {
    
    //DeskModel broadcasts changes
    Desk model = new Desk();
    
    //This view displays the info, updating whenever changed
    //incorporates the GUI to change the queue speed
    DeskGUI view = new DeskGUI(model);
    
    //This controler responds when queue speed is changed in the view
    DeskController controller = new DeskController(view, model);
    
    //wait user to interact
  }
  
 }
