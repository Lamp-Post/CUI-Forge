package cui.events;

import cui.fevents.Event;
import cui.fevents.HandlerList;

public class InitialGameTickEvent extends Event<InitialGameTickEvent>
{
  public static final HandlerList<InitialGameTickEvent> handlers = new HandlerList();

  protected String getEventName()
  {
    return "InitialGameTickEvent";
  }

  protected HandlerList<InitialGameTickEvent> getHandlers()
  {
    return handlers;
  }
}