package org.xi.abstractfactory.action.impl;

import org.xi.abstractfactory.action.Paintable;

public class MacPaint implements Paintable {

    /**
     * 画出窗口
     */
    @Override
    public void paintWindow() {

        System.out.println("Mac Window");
    }
}
