package org.xi.observer.observer;

public class WorkObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("WorkObserver: " + message);
    }
}
