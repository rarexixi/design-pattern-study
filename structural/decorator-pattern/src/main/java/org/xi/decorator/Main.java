package org.xi.decorator;

import org.xi.decorator.api.Circle;
import org.xi.decorator.api.Rectangle;
import org.xi.decorator.decorator.RedShapeDecorator;
import org.xi.decorator.decorator.ShapeDecorator;

public class Main {

    public static void main(String[] args) {

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        redCircle.draw();
        redRectangle.draw();
    }
}
