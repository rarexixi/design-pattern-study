package org.xi.proxy.proxy;

import org.xi.proxy.api.Image;
import org.xi.proxy.api.RealImage;

public class ProxyImage implements Image {

    private RealImage image = null;
    private String filename;

    public ProxyImage(final String filename) {
        this.filename = filename;
    }

    public void displayImage() {
        if (image == null) {
            image = new RealImage(filename);
        }
        image.displayImage();
    }
}
