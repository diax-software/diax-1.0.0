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
import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandDescription
import net.dv8tion.jda.core.entities.Message

/**
 * Created by Comportment at 22:12 on 18/05/17
 * https://github.com/Comportment | comportment@diax.me
 *
 * @author Comportment
 */
@CommandDescription(name = "skip", triggers = arrayOf("skip", "next"), description  = "Skips the currently playing song.")
class Skip : Command {

    override fun execute(message: Message, string: String) {
        val manager = GuildMusicManager.getManagerFor(message.guild)
        if (!manager.scheduler.skip()) message.channel.sendMessage(MessageUtil.basicEmbed("The current playing track could not be skipped.")).queue()
    }
}