package org.xi.factorymethod;

import org.xi.factorymethod.action.Drawable;
import org.xi.factorymethod.factory.DrawableFactory;
import org.xi.factorymethod.factory.impl.CircleFactory;

public class Main {

    public static void main(String[] args) {

        // 这里切换时只需改变factory的实现类就行
        DrawableFactory drawableFactory = new CircleFactory();
        Drawable drawable = drawableFactory.CreateDrawable();
        drawable.draw();
    }
}
