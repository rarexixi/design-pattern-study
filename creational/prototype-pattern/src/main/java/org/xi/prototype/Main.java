package org.xi.prototype;

import org.xi.prototype.model.Circle;
import org.xi.prototype.model.Shape;
import org.xi.prototype.model.Square;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Shape> shapeMap = new HashMap<>();
        shapeMap.put(1, new Circle());
        shapeMap.put(2, new Square());

        Shape cachedShape;

        cachedShape = shapeMap.get(1);
        Shape shape = cachedShape.clone();
        shape.draw();

        cachedShape = shapeMap.get(2);
        shape = cachedShape.clone();
        shape.draw();
    }
}
