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

package me.diax.comportment.diax.commands.statistical

import me.diax.comportment.diax.util.MessageUtil
import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandAttribute
import me.diax.comportment.jdacommand.CommandDescription
import net.dv8tion.jda.core.entities.Message
import java.time.temporal.ChronoUnit

/**
 * Created by Comportment at 20:08 on 15/05/17
 * https://github.com/Comportment | comportment@diax.me

 * @author Comportment
 */
@CommandDescription(name = "ping", triggers = arrayOf("ping", "pang", "pong", "pung", "peng"), attributes = arrayOf(
        CommandAttribute(key = "allowPrivate")
), description = "Checks Diax's ping to you and Discord.")
class Ping : Command {

    override fun execute(message: Message, s: String) {
        message.channel.sendMessage(MessageUtil.basicEmbed("Pinging...")).queue { pinging ->
            val ping = message.creationTime.until(pinging.creationTime, ChronoUnit.MILLIS)
            pinging.editMessage(MessageUtil.basicEmbed("⏱ Response: ${ping}ms\n❤ Websocket ${message.jda.ping}ms")).queue()
        }
    }
}