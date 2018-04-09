package org.xi.observer.observer;

public class LifeObserver implements Observer {

    @Override
    public void update(String message) {

        System.out.println("LifeObserver: " + message);
    }
}
