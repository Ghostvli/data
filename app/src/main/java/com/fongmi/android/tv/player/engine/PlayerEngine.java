package com.fongmi.android.tv.player.engine;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.Tracks;

import com.fongmi.android.tv.bean.Track;

import java.util.Collections;
import java.util.List;

public interface PlayerEngine {

    int SOFT = 0;
    int HARD = 1;

    Player getPlayer();

    void release();

    Player rebuild(Player.Listener listener);

    int getDecode();

    void setDecode(int decode);

    boolean isHard();

    String getDecodeText();

    void start(PlaySpec spec);

    void setMetadata(MediaMetadata data);

    boolean isLive();

    boolean isVod();

    void setTrack(List<Track> tracks);

    void resetTrack();

    void setScale(int scale);

    boolean haveTrack(int type);

    Tracks getCurrentTracks();

    String getErrorMessage(PlaybackException e);

    ErrorAction handleError(PlaybackException e);

    int getPlaybackState();

    boolean isPlaying();

    long getDuration();

    long getPosition();

    void seekTo(long time);

    void play();

    void pause();

    void stop();

    void setPlaybackSpeed(float speed);

    float getSpeed();

    enum ErrorAction {
        RECOVERED,
        DECODE,
        FATAL
    }
}
