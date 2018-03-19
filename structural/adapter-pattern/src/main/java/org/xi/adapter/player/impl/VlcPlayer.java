package org.xi.adapter.player.impl;

import org.xi.adapter.player.MediaPlayer;

public class VlcPlayer implements MediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
    }
}
