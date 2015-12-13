package com.slakke.bird.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by slakke on 2015-12-12.
 * - View layer class for handling sounds and music.
 */
public class SoundHandler {

    private static Sound[] sounds;
    private static Music[] tracks;

    //Enum for sound identifiers.
    public enum SoundID {
        JUMP(0);
        private int value;
        SoundID(int value) {
            this.value = value;
        }
    }

    //Enum for music identifiers.
    public enum TrackID {
        MAIN_THEME(0);
        private int value;
        TrackID(int value) {
            this.value = value;
        }
    }

    public SoundHandler(){
        loadContent();
    }

    /**
     * Loads all sounds and music.
     */
    public void loadContent() {
        sounds = new Sound[] {Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"))};
        tracks = new Music[] {Gdx.audio.newMusic(Gdx.files.internal("music.mp3"))};
    }

    /**
     * Method for playing sounds.
     * @param sound sound identifier (SoundID).
     * @param volume sound volume.
     */
    public static void playSound(SoundID sound, float volume){
        if (sounds != null && sound.value <= sounds.length)
            sounds[sound.value].play(volume);
    }

    /**
     * Method for playing music.
     * @param track sound identifier (SoundID).
     * @param volume sound volume.
     * @param loop states if the track should be looping.
     */
    public static void playTrack(TrackID track, float volume, boolean loop){
        if (tracks != null && track.value <= tracks.length) {
            tracks[track.value].setVolume(volume);
            tracks[track.value].setLooping(loop);
            tracks[track.value].play();
        }
    }

    /**
     * Disposes all sounds and music.
     */
    public void dispose() {
        for (Sound sound : sounds)
            sound.dispose();
        for (Music track : tracks)
            track.dispose();

        System.out.println("SoundHandler content disposed");
    }


}
