package org.xi.factorymethod.factory.impl;

import org.xi.factorymethod.action.Drawable;
import org.xi.factorymethod.action.impl.Rectangle;
import org.xi.factorymethod.factory.DrawableFactory;

public class RectangleFactory implements DrawableFactory {

    @Override
    public Drawable CreateDrawable() {
        return new Rectangle();
    }
}
