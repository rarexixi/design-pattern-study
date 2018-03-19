package org.xi.abstractfactory.factory.impl;

import org.xi.abstractfactory.action.Paint;
import org.xi.abstractfactory.action.impl.WinPaint;
import org.xi.abstractfactory.factory.GuiFactory;

public class WinGuiFactory implements GuiFactory {

    /**
     * 创建Windows绘制
     * @return
     */
    @Override
    public Paint createPaint() {

        return new WinPaint();
    }
}
