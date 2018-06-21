package com.example.commands;

import net.minecraft.client.*;
import net.minecraft.command.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.math.*;
import com.example.*;

public class CommandFastTime extends CommandBase
{
    private Minecraft mc;
    
    public CommandFastTime() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getCommandName() {
        return "fasttime";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/fasttime <multiplier>";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        if (args.length == 0) {
            sender.addChatMessage(new ChatComponentText("Please use /fasttime <multiplier>!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
            return;
        }
        final double multiplier = NumberUtils.toDouble(args[0], -1.0);
        if (multiplier < 0.0) {
            sender.addChatMessage(new ChatComponentText("Invalid multiplier!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
            return;
        }
        TimeChanger.TIME_TYPE = TimeType.FAST;
        TimeChanger.fastTimeMultiplier = multiplier;
        sender.addChatMessage(new ChatComponentText("Time set to fast (" + multiplier + ").").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
