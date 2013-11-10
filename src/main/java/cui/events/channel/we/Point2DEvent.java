package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;

public class Point2DEvent extends PointEvent
{
  public Point2DEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public EventType getEventType()
  {
    return EventType.WE_POINT2D;
  }

  public void run()
  {
    int id = getInt(0);
    int x = getInt(1);
    int z = getInt(2);
    int regionSize = getInt(3);
    this.controller.getWorldEditRegion().setPolygonPoint(id, x, z);

    CUIDebug.getInstance().debug("Setting point2d #" + id);
  }
}