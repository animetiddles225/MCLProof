package com.example.commands;

import net.minecraft.client.*;
import net.minecraft.command.*;
import com.example.*;
import net.minecraft.util.*;

public class CommandResetTime extends CommandBase
{
    private Minecraft mc;
    
    public CommandResetTime() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getCommandName() {
        return "resettime";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/resettime";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        TimeChanger.TIME_TYPE = TimeType.VANILLA;
        sender.addChatMessage(new ChatComponentText("Now using vanilla time.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
