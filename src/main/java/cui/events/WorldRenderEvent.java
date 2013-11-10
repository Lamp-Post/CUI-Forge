package cui.events;

import cui.fevents.Event;
import cui.fevents.HandlerList;

public class WorldRenderEvent extends Event<WorldRenderEvent>
{
  protected float partialTick = 0.0F;
  public static final HandlerList<WorldRenderEvent> handlers = new HandlerList();

  public void setPartialTick(float partialTick) {
    this.partialTick = partialTick;
  }
  public float getPartialTick() {
    return this.partialTick;
  }

  protected String getEventName()
  {
    return "WorldRenderEvent";
  }

  protected HandlerList<WorldRenderEvent> getHandlers()
  {
    return handlers;
  }
}