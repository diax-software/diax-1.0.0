/*
 * Copyright 2017 Comportment | comportment@diax.me
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.diax.comportment.audio;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.core.audio.AudioSendHandler;

/**
 * Created by Comportment at 20:53 on 18/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
public class AudioPlayerSendHandler implements AudioSendHandler {
    private final AudioPlayer player;
    private AudioFrame lastFrame;

    public AudioPlayerSendHandler(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public boolean canProvide() {
        if (lastFrame == null) lastFrame = player.provide();
        return lastFrame != null;
    }

    @Override
    public byte[] provide20MsAudio() {
        if (lastFrame == null) lastFrame = player.provide();
        byte[] data = lastFrame != null ? lastFrame.data : null;
        lastFrame = null;
        return data;
    }

    @Override
    public boolean isOpus() {
        return true;
    }
}