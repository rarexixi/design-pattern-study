package org.xi.abstractfactory.action.impl;

import org.xi.abstractfactory.action.Clickable;

public class MacButton implements Clickable {

    @Override
    public void click() {
        System.out.println("Mac button click");
    }
}
