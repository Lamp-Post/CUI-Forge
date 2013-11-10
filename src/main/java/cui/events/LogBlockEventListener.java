package cui.events;

import cui.CUIBase;
import cui.fevents.Listener;

public class LogBlockEventListener
  implements Listener<LogBlockEvent>
{
  private CUIBase controller;

  public LogBlockEventListener(CUIBase controller)
  {
    this.controller = controller;
  }

  public void onEvent(LogBlockEvent event)
  {
  }
}