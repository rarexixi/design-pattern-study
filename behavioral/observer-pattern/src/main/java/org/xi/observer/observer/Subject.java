package org.xi.observer.observer;

import java.util.HashSet;
import java.util.Set;

public class Subject {

    private Set<Observer> observerSet;

    public Subject() {
        this.observerSet = new HashSet<>();
    }

    public void register(Observer observer)
    {
        if (!observerSet.contains(observer))
        {
            observerSet.add(observer);
        }
    }

    public void deregister(Observer observer)
    {
        if (observerSet.contains(observer))
        {
            observerSet.remove(observer);
        }
    }

    public void notify(String message)
    {
        for (Observer observer : observerSet)
        {
            observer.update(message);
        }
    }
}
