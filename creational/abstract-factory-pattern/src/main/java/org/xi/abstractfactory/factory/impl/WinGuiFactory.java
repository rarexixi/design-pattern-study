package org.xi.abstractfactory.factory.impl;

import org.xi.abstractfactory.action.Clickable;
import org.xi.abstractfactory.action.Paintable;
import org.xi.abstractfactory.action.impl.WinButton;
import org.xi.abstractfactory.action.impl.WinPaint;
import org.xi.abstractfactory.factory.GuiFactory;

/**
 *  windows 实例工厂
 */
public class WinGuiFactory implements GuiFactory {

    @Override
    public Paintable createPaint() {
        return new WinPaint();
    }

    @Override
    public Clickable createButton() {
        return new WinButton();
    }
}
