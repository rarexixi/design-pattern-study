package org.xi.abstractfactory.factory.impl;

import org.xi.abstractfactory.action.Paint;
import org.xi.abstractfactory.action.impl.MacPaint;
import org.xi.abstractfactory.factory.GuiFactory;

public class MacGuiFactory implements GuiFactory {

    /**
     * 创建Mac绘制
     * @return
     */
    @Override
    public Paint createPaint() {

        return new MacPaint();
    }
}
