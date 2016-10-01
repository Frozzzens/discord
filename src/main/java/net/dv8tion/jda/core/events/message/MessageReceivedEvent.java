/*
 *     Copyright 2015-2016 Austin Keener & Michael Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.dv8tion.jda.core.events.message;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.Event;

/**
 * <b><u>MessageReceivedEvent</u></b><br>
 * Fired if a Message is sent in a {@link net.dv8tion.jda.core.entities.MessageChannel MessageChannel}.<br>
 * <br>
 * Use: This event indicates that a Message is sent in either a private or guild channel. Providing a MessageChannel and Message.
 */
public class MessageReceivedEvent extends Event
{
    private final Message message;

    public MessageReceivedEvent(JDA api, long responseNumber, Message message)
    {
        super(api, responseNumber);
        this.message = message;
    }

    public Message getMessage()
    {
        return message;
    }

    public User getAuthor()
    {
        return message.getAuthor();
    }

    public Member getMember()
    {
        if (isPrivate())
            return null;

        return getGuild().getMember(getAuthor());
    }

    public boolean isPrivate()
    {
        return message.isPrivate();
    }

    public TextChannel getTextChannel()
    {
        return message.getTextChannel();
    }

    public PrivateChannel getPrivateChannel()
    {
        return message.getPrivateChannel();
    }

    public MessageChannel getChannel()
    {
        return message.getChannel();
    }

    public Guild getGuild()
    {
        return message.getGuild();
    }
}