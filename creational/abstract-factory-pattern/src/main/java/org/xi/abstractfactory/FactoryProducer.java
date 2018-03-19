package org.xi.abstractfactory;

import org.xi.abstractfactory.factory.GuiFactory;
import org.xi.abstractfactory.factory.impl.MacGuiFactory;
import org.xi.abstractfactory.factory.impl.WinGuiFactory;

public class FactoryProducer {

    public static GuiFactory getFactory(String appearance) throws Exception {

        GuiFactory factory = null;

        if (appearance.equals("Mac")) {
            factory = new MacGuiFactory();
        } else if (appearance.equals("Windows")) {
            factory = new WinGuiFactory();
        } else {
            throw new Exception("没有当前操作系统");
        }

        return factory;
    }
}
