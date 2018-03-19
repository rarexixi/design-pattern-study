package org.xi.factorymethod.action.impl;

import org.xi.factorymethod.action.Drawable;

public class Circle implements Drawable {

    @Override
    public void draw() {
        System.out.println("draw a circle");
    }
}
