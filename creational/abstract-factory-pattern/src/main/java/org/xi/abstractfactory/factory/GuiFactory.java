package org.xi.abstractfactory.factory;

import org.xi.abstractfactory.action.Clickable;
import org.xi.abstractfactory.action.Paintable;

/**
 * 抽象工厂
 * 可以是抽象类
 */
public interface GuiFactory {

    Paintable createPaint();

    Clickable createButton();
}
