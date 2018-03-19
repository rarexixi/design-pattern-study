package org.xi.factorymethod.action.impl;

import org.xi.factorymethod.action.Drawable;

public class Square implements Drawable {

    @Override
    public void draw() {
        System.out.println("draw a square");
    }
}
