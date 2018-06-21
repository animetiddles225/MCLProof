package com.example.commands;

import net.minecraft.client.*;
import net.minecraft.command.*;
import com.example.*;
import net.minecraft.util.*;

public class CommandNight extends CommandBase
{
    private Minecraft mc;
    
    public CommandNight() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public String getCommandName() {
        return "night";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/night";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) {
        if (args.length > 0 && !TimeChanger.a) {
            this.mc.ingameGUI.getChatGUI().getSentMessages().remove(this.mc.ingameGUI.getChatGUI().getSentMessages().size() - 1);
        }
        try {
            if (args.length == 1 && !TimeChanger.a) {
                TimeChanger.e = Double.parseDouble(args[0]);
                return;
            }
        }
        catch (Throwable t) {}
        TimeChanger.TIME_TYPE = TimeType.NIGHT;
        sender.addChatMessage(new ChatComponentText("Time set to night.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender sender) {
        return true;
    }
}
