package cui.events.channel.we;

import cui.CUIBase;
import cui.CUIDebug;
import cui.events.channel.BaseEvent;
import cui.events.channel.EventType;
import cui.render.we.region.BaseRegion;
import cui.render.we.region.CuboidRegion;
import cui.render.we.region.CylinderRegion;
import cui.render.we.region.EllipsoidRegion;
import cui.render.we.region.NullRegion;
import cui.render.we.region.PolygonRegion;

public class SelectionEvent extends BaseEvent
{
  public SelectionEvent(CUIBase controller, String[] args)
  {
    super(controller, args);
  }

  public void run()
  {
    BaseRegion newRegion = null;
    String type = getString(0);

    if (type.equals("cuboid"))
      newRegion = new CuboidRegion(this.controller);
    else if (getString(0).equals("polygon2d"))
      newRegion = new PolygonRegion(this.controller);
    else if (getString(0).equals("ellipsoid"))
      newRegion = new EllipsoidRegion(this.controller);
    else if (getString(0).equals("cylinder"))
      newRegion = new CylinderRegion(this.controller);
    else {
      newRegion = new NullRegion(this.controller);
    }

    this.controller.setWorldEditRegion(newRegion);
    CUIDebug.getInstance().debug("Received selection event, initalizing new region instance.");
  }

  public EventType getEventType()
  {
    return EventType.WE_SELECTION;
  }
}