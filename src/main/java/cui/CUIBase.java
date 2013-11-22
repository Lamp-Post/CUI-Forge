package cui;

import cui.config.CUIConfiguration;
import cui.events.GameTickEvent;
import cui.events.GameTickEventListener;
import cui.events.InitialGameTickEvent;
import cui.events.InitialGameTickEventListener;
import cui.events.LogBlockEvent;
import cui.events.LogBlockEventListener;
import cui.events.WorldConnectEvent;
import cui.events.WorldConnectEventListener;
import cui.events.WorldEditEvent;
import cui.events.WorldEditEventListener;
import cui.events.WorldRenderEvent;
import cui.events.WorldRenderEventListener;
import cui.fevents.EventManager;
import cui.fevents.HandlerList;
import cui.fevents.Order;
import cui.render.we.region.BaseRegion;
import cui.render.we.region.CuboidRegion;
import java.util.ArrayList;

public class CUIBase
{
  public static final String VERSION = "1.6.4";
  public static final String MCVERSION = "1.6.4";
  public static final int weProtocolVersion = 2;
  public static final int lbProtocolVersion = 1;
  private IMod mod;
  private IWorld lastWorld;
  private IPlayer lastPlayer;
  private IEntity lastEntity;
  private boolean gameStarted = false;
  private CUIConfiguration configuration;
  private BaseRegion worldEditRegion;
  public boolean isCalled = false;
  public EventManager eventManager;

  public CUIBase(IMod mod)
  {
    this.mod = mod;
    this.configuration = new CUIConfiguration(mod.getModFolder());

    CUIProfiler.setEnabled(this.configuration.isDebugMode());
    CUIDebug.setInstance(this, mod.getModFolder());

    GameTickEvent.handlers.register(new GameTickEventListener(this), Order.Default);
    InitialGameTickEvent.handlers.register(new InitialGameTickEventListener(this), Order.Default);

    LogBlockEvent.handlers.register(new LogBlockEventListener(this), Order.Default);
    WorldEditEvent.handlers.register(new WorldEditEventListener(this), Order.Default);

    WorldConnectEvent.handlers.register(new WorldConnectEventListener(this), Order.Default);
    WorldRenderEvent.handlers.register(new WorldRenderEventListener(this), Order.Default);

    Runtime.getRuntime().addShutdownHook(new Thread()
    {
      public void run() {
        if (!CUIBase.this.configuration.isDebugMode()) {
          return;
        }
        ArrayList<String> profileOut = CUIProfiler.debug();
        for (String out : profileOut)
          CUIDebug.getInstance().debug(out);
      }
    });
    this.worldEditRegion = new CuboidRegion(this);
  }

  public IEntity getLastEntity() {
    return this.lastEntity;
  }

  public void setLastEntity(IEntity lastEntity) {
    this.lastEntity = lastEntity;
  }

  public IPlayer getLastPlayer() {
    return this.lastPlayer;
  }

  public void setLastPlayer(IPlayer lastPlayer) {
    this.lastPlayer = lastPlayer;
  }

  public IWorld getLastWorld() {
    return this.lastWorld;
  }

  public void setLastWorld(IWorld lastWorld) {
    this.lastWorld = lastWorld;
  }

  public IMod getMod() {
    return this.mod;
  }

  public boolean hasGameStarted() {
    return this.gameStarted;
  }

  public void setGameStarted(boolean gameStarted) {
    this.gameStarted = gameStarted;
  }

  public CUIConfiguration getConfiguration() {
    return this.configuration;
  }

  public BaseRegion getWorldEditRegion() {
    return this.worldEditRegion;
  }

  public void setWorldEditRegion(BaseRegion worldEditRegion) {
    this.worldEditRegion = worldEditRegion;
  }
  public EventManager getEventManager() {
	return eventManager;
	  
  }
}