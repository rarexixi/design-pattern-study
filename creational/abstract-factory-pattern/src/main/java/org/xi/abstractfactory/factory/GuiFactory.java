package org.xi.abstractfactory.factory;

import org.xi.abstractfactory.action.Paint;

public interface GuiFactory {

    /**
     *
     * @return
     */
    Paint createPaint();
}
