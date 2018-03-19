package org.xi.factorymethod.factory.impl;

import org.xi.factorymethod.action.Drawable;
import org.xi.factorymethod.action.impl.Square;
import org.xi.factorymethod.factory.DrawableFactory;

public class SquareFactory implements DrawableFactory {

    @Override
    public Drawable CreateDrawable() {
        return new Square();
    }
}