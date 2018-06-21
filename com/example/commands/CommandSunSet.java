package com.example.commands;

import net.minecraft.client.*;
import net.minecraft.command.*;
import com.example.*;
import net.minecraft.util.*;

public class CommandSunSet extends CommandBase
{
    private Minecraft mc;
    
    public CommandSunSet() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getCommandName() {
        return "sunset";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/sunset";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        TimeChanger.TIME_TYPE = TimeType.SUNSET;
        sender.addChatMessage(new ChatComponentText("Time set to sunset.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
