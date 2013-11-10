package cui.mods.forge;

import java.nio.charset.Charset;
import java.util.EnumSet;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.World;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cui.CUIBase;
import cui.IEntity;
import cui.Updater;
import cui.events.GameTickEvent;
import cui.events.InitialGameTickEvent;
import cui.events.WorldConnectEvent;
import cui.events.WorldRenderEvent;
import cui.fevents.EventManager;
import cui.render.we.region.CuboidRegion;

public class ClientTickHandler implements ITickHandler
{
	  private GameTickEvent tickEvent = new GameTickEvent(0.0F);
	
    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {}

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData)
    {
        if (type.equals(EnumSet.of(TickType.RENDER)))
        {
        	float ti = 0;
            onRenderTick(ti);
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null)
            {
                onTickInGUI(guiscreen);
            } else {
                onTickInGame();
            }
        }
    }

	@Override
    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
    }

    @Override
    public String getLabel() { return null; }


    public void onRenderTick(float ti)
    {
    }

    public void onTickInGUI(GuiScreen guiscreen)
    {
    }

    public void onTickInGame()
    {
        EventManager.callEvent(this.tickEvent);
    	WorldConnectEvent event2 = new WorldConnectEvent();
    	EventManager.callEvent(event2);
    }
}