package interfaces;

/**
*The Subject part of the Observer pattern
*All classes implementing this interface must have these methods
*This allows observers to be updated about
*changes to a subject they are registered with
*/
public interface Subject {
    
    /**
    *Register an observer with this subject
    */
    public void registerObserver(Observer obs);
    
    /**
    *De-register an observer with this subject
    */
    public void removeObserver(Observer obs);
    
    /**
    *Inform all registered observers that there´s been an update
    */
    public void notifyObservers();
}
