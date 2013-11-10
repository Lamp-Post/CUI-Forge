package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.BaseEvent;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;

public class MinMaxEvent extends BaseEvent
{
  public MinMaxEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public EventType getEventType()
  {
    return EventType.WE_MINMAX;
  }

  public void run()
  {
    int min = getInt(0);
    int max = getInt(1);
    this.controller.getWorldEditRegion().setMinMax(min, max);

    CUIDebug.getInstance().debug("Expanding/contracting selection.");
  }
}