package org.xi.adapter.player.impl;

import org.xi.adapter.player.MediaPlayer;

public class Mp4Player implements MediaPlayer {

    @Override
    public void playVlc(String fileName) {
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
