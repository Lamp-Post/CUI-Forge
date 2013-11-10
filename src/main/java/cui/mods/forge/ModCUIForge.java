package cui.mods.forge;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.Loader;
import cui.CUIBase;
import cui.IEntity;
import cui.IMod;
import cui.IPlayer;
import cui.IRenderer;
import cui.IWorld;
import cui.events.GameTickEvent;
import cui.events.WorldConnectEvent;
import cui.fevents.EventManager;
import cui.mods.modloader.WireEntity;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid="CUI", name="CUI", version="1.6.4")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"LBCUI", "WECUI"}, packetHandler = PacketHandler.class)
public class ModCUIForge
  implements IMod
{
  private CUIBase controller;
  private Minecraft minecraft;
  public GameTickEvent tickEvent = new GameTickEvent(0.0F);

  @Mod.Instance("CUI")
  public static ModCUIForge instance;

  @SidedProxy(clientSide="cui.mods.forge.CUIClientProxy", serverSide="cui.mods.forge.CUICommonProxy")
  public static CUIClientProxy proxy;

  @Mod.PreInit
  public void preInit(FMLPreInitializationEvent event)
  {
  }

  @Mod.Init
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();

    this.minecraft = FMLClientHandler.instance().getClient();
    
    EntityRegistry.registerGlobalEntityID(WireEntity.class, "CUI", EntityRegistry.findGlobalUniqueEntityId());
    TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
    
    this.controller = new CUIBase(this);
  }

  @Mod.PostInit
  public void postInit(FMLPostInitializationEvent event) {
  }

  public IPlayer getCurrentPlayer() {
    return new ForgePlayer(getPlayer());
  }

  public IWorld getCurrentWorld() {
    return new ForgeWorld(getWorld());
  }

  public boolean playerEquals(IPlayer player) {
    if (!(player instanceof ForgePlayer)) {
      return false;
    }
    ForgePlayer fplayer = (ForgePlayer)player;
    return fplayer.getHandle() == getPlayer();
  }

  public boolean worldEquals(IWorld world)
  {
    if (!(world instanceof ForgeWorld)) {
      return false;
    }
    ForgeWorld fworld = (ForgeWorld)world;
    return fworld.getHandle() == getWorld();
  }

  public IRenderer getRenderer()
  {
    return new ForgeRenderer();
  }

  public boolean isMultiplayer() {
    return !this.minecraft.isSingleplayer();
  }

  public void sendPacket(String name, int size, byte[] bytes) {
	Packet250CustomPayload packet = new Packet250CustomPayload();
    packet.channel = name;
    packet.length = size;
    packet.data = bytes;
    FMLClientHandler.instance().sendPacket(packet);
  }

  public File getModFolder() {
    return Loader.instance().getConfigDir();
  }

  public IEntity getNewEntity() {
    return new ForgeEntity(new WireEntity(getWorld()));
  }

  protected WorldClient getWorld() {
    return this.minecraft.theWorld;
  }

  protected EntityPlayerSP getPlayer() {
    return this.minecraft.thePlayer;
  }
}