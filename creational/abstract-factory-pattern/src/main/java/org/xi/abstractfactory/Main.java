package org.xi.abstractfactory;

import org.xi.abstractfactory.action.Paint;
import org.xi.abstractfactory.factory.GuiFactory;
import org.xi.abstractfactory.factory.impl.MacGuiFactory;
import org.xi.abstractfactory.factory.impl.WinGuiFactory;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        GuiFactory factory;

        String appearance = randomAppearance();

        if (appearance.equals("Mac")) {
            factory = new MacGuiFactory();
        } else if(appearance.equals("Windows")) {
            factory = new WinGuiFactory();
        } else {
            System.out.println("没有当前操作系统");
            return;
        }

        Paint paint = factory.createPaint();
        paint.paintButton();
        paint.paintWindow();
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
