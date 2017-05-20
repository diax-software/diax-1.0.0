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

package me.diax.comportment.commands.miscellaneous

import me.diax.comportment.jdacommand.Command
import me.diax.comportment.jdacommand.CommandAttribute
import me.diax.comportment.jdacommand.CommandDescription
import me.diax.comportment.util.MessageUtil
import net.dv8tion.jda.core.entities.Message
import net.dv8tion.jda.core.exceptions.PermissionException

/**
 * Created by Comportment at 20:45 on 15/05/17
 * https://github.com/Comportment | comportment@diax.me

 * @author Comportment
 */
@CommandDescription(name = "echo", triggers = arrayOf("echo", "repeat"), attributes = arrayOf(CommandAttribute(key = "description", value = "Echoes the arguments back into chat."), CommandAttribute(key = "allowPrivate")), args = 1)
class Echo : Command {

    override fun execute(trigger: Message, args: String) {
        try {
            trigger.delete().queue()
        } catch (ignored: PermissionException) {
        }
        try {
            trigger.channel.sendMessage(args).queue()
        } catch (e: Exception) {
            trigger.channel.sendMessage(MessageUtil.errorEmbed("I can't send nothing!")).queue()
        }
    }
}