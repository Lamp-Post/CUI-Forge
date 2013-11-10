package cui.events;

import cui.fevents.Event;
import cui.fevents.HandlerList;

public class WorldConnectEvent extends Event<WorldConnectEvent>
{
  public static final HandlerList<WorldConnectEvent> handlers = new HandlerList();

  protected String getEventName()
  {
    return "WorldConnectEvent";
  }

  protected HandlerList<WorldConnectEvent> getHandlers()
  {
    return handlers;
  }
}