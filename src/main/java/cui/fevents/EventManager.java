package cui.fevents;

import java.io.PrintStream;

public class EventManager
{
  public static <TEvent extends Event<TEvent>> void callEvent(TEvent event)
  {
    HandlerList handlerlist = event.getHandlers();
    handlerlist.bake();

    Listener[][] handlers = handlerlist.handlers;
    int[] handlerids = handlerlist.handlerids;

    for (int arrayidx = 0; arrayidx < handlers.length; arrayidx++)
    {
      if ((!event.isCancelled()) || ((handlerids[arrayidx] & 0x1) != 0))
      {
        for (int handler = 0; handler < handlers[arrayidx].length; handler++)
          try {
            handlers[arrayidx][handler].onEvent(event);
          } catch (Throwable t) {
            System.err.println("Error while passing event " + event);
            t.printStackTrace();
          }
      }
    }
  }
}