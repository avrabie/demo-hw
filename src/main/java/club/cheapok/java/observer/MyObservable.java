package club.cheapok.java.observer;

public interface MyObservable {
    public void addObserver(Observer observer);
    public void notifyObservers(Object obj);
}
