package org.xi.abstractfactory.action.impl;

import org.xi.abstractfactory.action.Clickable;

public class WinButton implements Clickable {

    @Override
    public void click() {
        System.out.println("Win button click");
    }
}
