package org.xi.prototype.model;

public abstract class Shape implements Cloneable {

    public void draw() {
        System.out.println("draw a shape");
    }

    public Shape clone() {
        Shape prototype = null;
        try {
            prototype = (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
