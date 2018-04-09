package org.xi.observer;

import org.xi.observer.observer.LifeObserver;
import org.xi.observer.observer.Observer;
import org.xi.observer.observer.Subject;
import org.xi.observer.observer.WorkObserver;

public class Main {

    public static void main(String[] args) {

        Subject mySubject = new Subject();
        Observer lifeObserver = new LifeObserver();
        Observer workObserver = new WorkObserver();

        // register observers
        mySubject.register(lifeObserver);
        mySubject.register(workObserver);

        mySubject.notify("message 1");
        mySubject.notify("message 2");
    }
}
