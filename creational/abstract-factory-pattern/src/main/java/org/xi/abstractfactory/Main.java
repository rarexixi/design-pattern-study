package org.xi.abstractfactory;

import org.xi.abstractfactory.action.Clickable;
import org.xi.abstractfactory.action.Paintable;
import org.xi.abstractfactory.factory.GuiFactory;
import org.xi.abstractfactory.factory.impl.MacGuiFactory;
import org.xi.abstractfactory.factory.impl.WinGuiFactory;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String appearance = randomAppearance();

        GuiFactory factory;
        try {
            factory = FactoryProducer.getFactory(appearance);
            Paintable paint = factory.createPaint();
            paint.paintWindow();
            Clickable clickable = factory.createButton();
            clickable.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String randomAppearance() {

        String[] appearanceArray = new String[3];

        appearanceArray[0] = "Mac";
        appearanceArray[1] = "Windows";
        appearanceArray[2] = "error";

        Random random = new Random();

        int randomNumber = random.nextInt(3);

        return appearanceArray[randomNumber];
    }
}
