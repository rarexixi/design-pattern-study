package org.xi.adapter;

import org.xi.adapter.player.AudioPlayer;
import org.xi.adapter.player.impl.Mp3Player;

public class Main {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new Mp3Player();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
