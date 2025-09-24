package com.coloryr.allmusic.server.core.command.sub;

import com.coloryr.allmusic.server.core.AllMusic;
import com.coloryr.allmusic.server.core.command.ACommand;
import com.coloryr.allmusic.server.core.music.play.PlayMusic;
import com.coloryr.allmusic.server.core.objs.message.ARG;

public class CommandList extends ACommand {
    @Override
    public void execute(Object sender, String name, String[] args) {
        if (PlayMusic.nowPlayMusic == null || PlayMusic.nowPlayMusic.isNull()) {
            AllMusic.side.sendMessage(sender, AllMusic.getMessage().musicPlay.emptyPlayingMusic);
        } else {
            String info = AllMusic.getMessage().musicPlay.nowPlay;
            info = info.replace(ARG.musicName, PlayMusic.nowPlayMusic.getName())
                    .replace(ARG.musicAuthor, PlayMusic.nowPlayMusic.getAuthor())
                    .replace(ARG.musicAl, PlayMusic.nowPlayMusic.getAl())
                    .replace(ARG.musicAlia, PlayMusic.nowPlayMusic.getAlia())
                    .replace(ARG.player, PlayMusic.nowPlayMusic.getCall());
            AllMusic.side.sendMessage(sender, info);
        }
        if (PlayMusic.getListSize() == 0) {
            AllMusic.side.sendMessage(sender, AllMusic.getMessage().musicPlay.emptyPlay);
        } else {
            AllMusic.side.sendMessage(sender, AllMusic.getMessage().musicPlay.listMusic.head
                    .replace(ARG.count, "" + PlayMusic.getListSize()));
            AllMusic.side.sendMessage(sender, PlayMusic.getAllList());
        }
    }
}
