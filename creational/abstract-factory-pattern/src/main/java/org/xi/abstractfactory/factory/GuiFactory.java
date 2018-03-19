package org.xi.abstractfactory.factory;

import org.xi.abstractfactory.action.Clickable;
import org.xi.abstractfactory.action.Paintable;

public interface GuiFactory {

    Paintable createPaint();

    Clickable createButton();
}
