package org.xi.abstractfactory.action.impl;

import org.xi.abstractfactory.action.Paint;

public class MacPaint implements Paint {

    /**
     * 画出Mac按钮
     */
    @Override
    public void paintButton() {

        System.out.println("Mac Button");
    }

    /**
     * 画出窗口
     */
    @Override
    public void paintWindow() {

        System.out.println("Mac Window");
    }
}
