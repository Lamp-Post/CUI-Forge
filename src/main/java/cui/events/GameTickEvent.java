package cui.events;

import cui.fevents.Event;
import cui.fevents.HandlerList;

public class GameTickEvent extends Event<GameTickEvent>
{
  private float partialTick;
  public static final HandlerList<GameTickEvent> handlers = new HandlerList();

  public GameTickEvent(float partialTick) {
    this.partialTick = partialTick;
  }
  
  public void setPartialTick(float partialTick) {
	    this.partialTick = partialTick;
	  }

  public float getPartialTick() {
	    return this.partialTick;
	  }

  protected String getEventName()
  {
    return "GameTickEvent";
  }

  protected HandlerList<GameTickEvent> getHandlers()
  {
    return handlers;
  }
}