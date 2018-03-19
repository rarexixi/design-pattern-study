package org.xi.abstractfactory.factory.impl;

import org.xi.abstractfactory.action.Clickable;
import org.xi.abstractfactory.action.Paintable;
import org.xi.abstractfactory.action.impl.MacButton;
import org.xi.abstractfactory.action.impl.MacPaint;
import org.xi.abstractfactory.factory.GuiFactory;

/**
 * mac 实例工厂
 */
public class MacGuiFactory implements GuiFactory {

    @Override
    public Paintable createPaint() {

        return new MacPaint();
    }

    @Override
    public Clickable createButton() {
        return new MacButton();
    }
}
