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

package me.diax.comportment.commands.musical;

import me.diax.comportment.audio.GuildMusicManager
import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandAttribute
import me.diax.comportment.jdacommand.CommandDescription
import me.diax.comportment.util.MessageUtil
import net.dv8tion.jda.core.entities.Message

/**
 * Created by Comportment at 22:13 on 18/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
@CommandDescription(name = "current", triggers = arrayOf("playing", "current"), attributes = arrayOf(CommandAttribute(key = "description", value = "Shows the track card for the currently playing song.")))
class Current : Command {

    override fun execute(message: Message, string: String) {
        val card = GuildMusicManager.getManagerFor(message.guild).scheduler.currentTrack?.card ?: MessageUtil.basicEmbed("No track is playing!")
        message.channel.sendMessage(card).queue()
    }
}