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

package me.diax.comportment.diax.commands.musical

import me.diax.comportment.diax.audio.GuildMusicManager
import me.diax.comportment.diax.util.MessageUtil
import me.diax.comportment.diax.util.Util
import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandDescription
import net.dv8tion.jda.core.entities.Message

/**
 * Created by Comportment at 22:20 on 18/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
@CommandDescription(name = "queue", triggers = arrayOf("queue"), description = "Gives you the queue.")
class Queue : Command {

    override fun execute(message: Message, args: String) {
        val list = StringBuilder()
        val queue = GuildMusicManager.getManagerFor(message.guild).scheduler.queue
        if (queue.isEmpty()) {
            message.channel.sendMessage(MessageUtil.basicEmbed("The queue is empty.")).queue()
            return
        }
        var i = 0
        list.append("Now playing: " + GuildMusicManager.getManagerFor(message.guild).scheduler.currentTrack.info.title).append("\n")
        for (track in queue) {
            i++
            list.append(i).append(")").append(track.info.title).append("\n")
        }
        message.channel.sendMessage(MessageUtil.basicEmbed("Here's the queue: " + Util.paste(list.toString()))).queue()
    }
}