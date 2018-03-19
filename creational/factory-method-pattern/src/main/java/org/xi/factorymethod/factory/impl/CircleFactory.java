package org.xi.factorymethod.factory.impl;

import org.xi.factorymethod.action.Drawable;
import org.xi.factorymethod.action.impl.Circle;
import org.xi.factorymethod.factory.DrawableFactory;

public class CircleFactory implements DrawableFactory {

    @Override
    public Drawable CreateDrawable() {
        return new Circle();
    }
}
