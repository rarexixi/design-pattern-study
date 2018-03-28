package org.xi.bridge;

import org.xi.bridge.api.GreenCircle;
import org.xi.bridge.api.RedCircle;
import org.xi.bridge.bridge.Circle;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(10, 20, 10, new GreenCircle());
        circle.draw();
        circle = new Circle(30, 50, 10, new RedCircle());
        circle.draw();
    }
}
