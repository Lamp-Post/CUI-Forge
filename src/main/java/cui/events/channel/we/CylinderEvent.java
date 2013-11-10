package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.BaseEvent;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;

public class CylinderEvent extends BaseEvent
{
  public CylinderEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public EventType getEventType()
  {
    return EventType.WE_CYLINDER;
  }

  public void run()
  {
    int x = getInt(0);
    int y = getInt(1);
    int z = getInt(2);
    double radX = getDouble(3);
    double radZ = getDouble(4);

    this.controller.getWorldEditRegion().setCylinderCenter(x, y, z);
    this.controller.getWorldEditRegion().setCylinderRadius(radX, radZ);

    CUIDebug.getInstance().debug("Setting center/radius for cylinder event");
  }
}