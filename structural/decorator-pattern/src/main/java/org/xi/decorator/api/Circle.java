package org.xi.decorator.api;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: circle");
    }
}
