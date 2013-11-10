package cui.events;

import cui.fevents.Event;
import cui.fevents.HandlerList;

public class LogBlockEvent extends Event<LogBlockEvent>
{
  private String type;
  private String[] args;
  public static final HandlerList<LogBlockEvent> handlers = new HandlerList();

  public LogBlockEvent(String type, String[] args) {
    this.type = type;

    if ((args.length == 1) && (args[0].length() == 0)) {
      args = new String[0];
    }
    this.args = args;
  }

  public String[] getArgs()
  {
    return this.args;
  }

  public String getType() {
    return this.type;
  }

  protected String getEventName()
  {
    return "LogBlockEvent";
  }

  protected HandlerList<LogBlockEvent> getHandlers()
  {
    return handlers;
  }
}