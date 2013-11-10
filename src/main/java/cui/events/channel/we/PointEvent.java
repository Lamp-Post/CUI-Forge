package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.BaseEvent;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;

public class PointEvent extends BaseEvent
{
  public PointEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public EventType getEventType()
  {
    return EventType.WE_POINT;
  }

  public void run()
  {
    int id = getInt(0);
    int x = getInt(1);
    int y = getInt(2);
    int z = getInt(3);

    this.controller.getWorldEditRegion().setCuboidPoint(id, x, y, z);
    CUIDebug.getInstance().debug("Setting point #" + id);
  }
}