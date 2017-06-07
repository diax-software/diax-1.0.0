package me.diax.diax.listeners;

import me.diax.comportment.jdacommand.Command;
import me.diax.comportment.jdacommand.CommandHandler;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.inject.Inject;
import java.util.regex.Pattern;

/**
 * Created by Comportment on 07/06/2017 at 20:33
 * If you don't understand this, we are screwed.
 */
public class MessageListener extends ListenerAdapter {

    private final CommandHandler handler;

    @Inject
    public MessageListener(CommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //Get prefix for guild.
        String content = event.getMessage().getRawContent();
        if (!content.startsWith("<>")) {
            if (!event.getChannelType().equals(ChannelType.PRIVATE)) {
                return; //Don't need to use prefix in private messages
            }
        }
        content = content.replaceFirst(Pattern.quote("<>"), "").trim();
        Command command = handler.findCommand(content.split(" ")[0]);
        if (command == null) {
            return; //The command does not exist/is not registered
        }
        if (!command.hasAttribute("allowPrivate") && event.getChannelType().equals(ChannelType.PRIVATE)) {
            return; //The command can not be used in private messages.
        }
        handler.execute(command, event.getMessage(), content);
    }
}