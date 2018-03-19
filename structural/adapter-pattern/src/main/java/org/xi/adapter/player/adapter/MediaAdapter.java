package org.xi.adapter.player.adapter;

import org.xi.adapter.player.AudioPlayer;
import org.xi.adapter.player.MediaPlayer;
import org.xi.adapter.player.impl.Mp4Player;
import org.xi.adapter.player.impl.VlcPlayer;

public class MediaAdapter implements AudioPlayer {

    public MediaAdapter(String audioType){
        if(audioType.equalsIgnoreCase("vlc") ){
            advancedMusicPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    MediaPlayer advancedMusicPlayer;

    @Override
    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMusicPlayer.playVlc(fileName);
        }else if(audioType.equalsIgnoreCase("mp4")){
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
