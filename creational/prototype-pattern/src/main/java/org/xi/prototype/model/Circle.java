package org.xi.prototype.model;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println(this + " draw a circle");
    }
}
