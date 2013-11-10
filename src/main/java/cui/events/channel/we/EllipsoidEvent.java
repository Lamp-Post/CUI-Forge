package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.BaseEvent;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;

public class EllipsoidEvent extends BaseEvent
{
  public EllipsoidEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public EventType getEventType()
  {
    return EventType.WE_ELLIPSOID;
  }

  public void run()
  {
    int id = getInt(0);

    if (id == 0) {
      int x = getInt(1);
      int y = getInt(2);
      int z = getInt(3);
      this.controller.getWorldEditRegion().setEllipsoidCenter(x, y, z);
    } else if (id == 1) {
      double x = getDouble(1);
      double y = getDouble(2);
      double z = getDouble(3);
      this.controller.getWorldEditRegion().setEllipsoidRadii(x, y, z);
    }

    CUIDebug.getInstance().debug("Setting center/radius for ellipsoid.");
  }
}