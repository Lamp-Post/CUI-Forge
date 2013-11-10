package cui.events;

import cui.CUIBase;
import cui.events.channel.BaseEvent;
import cui.events.channel.we.CylinderEvent;
import cui.events.channel.we.EllipsoidEvent;
import cui.events.channel.we.MinMaxEvent;
import cui.events.channel.we.Point2DEvent;
import cui.events.channel.we.PointEvent;
import cui.events.channel.we.SelectionEvent;
import cui.fevents.Listener;

public class WorldEditEventListener
  implements Listener<WorldEditEvent>
{
  private CUIBase controller;

  public WorldEditEventListener(CUIBase controller)
  {
    this.controller = controller;
  }

  public void onEvent(WorldEditEvent event)
  {
    BaseEvent cuiEvent = null;
    if (event.getType().equals("s"))
    {
      cuiEvent = new SelectionEvent(this.controller, event.getArgs());
    }
    else if (event.getType().equals("p"))
    {
      cuiEvent = new PointEvent(this.controller, event.getArgs());
    }
    else if (event.getType().equals("p2"))
    {
      cuiEvent = new Point2DEvent(this.controller, event.getArgs());
    }
    else if (event.getType().equals("e"))
    {
      cuiEvent = new EllipsoidEvent(this.controller, event.getArgs());
    }
    else if (event.getType().equals("cyl"))
    {
      cuiEvent = new CylinderEvent(this.controller, event.getArgs());
    }
    else if (event.getType().equals("mm"))
    {
      cuiEvent = new MinMaxEvent(this.controller, event.getArgs());
    }
    else {
      return;
    }

    cuiEvent.doRun();
  }
}