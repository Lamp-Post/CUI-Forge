package cui.events;

import cui.CUIBase;
import cui.Updater;
import cui.fevents.Listener;
import cui.render.we.region.CuboidRegion;

public class InitialGameTickEventListener
  implements Listener<InitialGameTickEvent>
{
  private CUIBase controller;

  public InitialGameTickEventListener(CUIBase controller)
  {
    this.controller = controller;
  }

  public void onEvent(InitialGameTickEvent event)
  {
    new Updater(this.controller).start();
    this.controller.setWorldEditRegion(new CuboidRegion(this.controller));
  }
}