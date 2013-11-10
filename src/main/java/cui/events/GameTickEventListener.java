package cui.events;

import cui.CUIBase;
import cui.CUIDebug;
import cui.IEntity;
import cui.IMod;
import cui.IWorld;
import cui.fevents.EventManager;
import cui.fevents.Listener;

public class GameTickEventListener
  implements Listener<GameTickEvent>
{
  private CUIBase controller;
  private int entityUpdateCount = 0;
  private WorldConnectEvent connect;

  public GameTickEventListener(CUIBase controller) {
    this.controller = controller;
  }

  public void onEvent(GameTickEvent event)
  {
    boolean differentWorld = !this.controller.getMod().worldEquals(this.controller.getLastWorld());
    boolean differentPlayer = !this.controller.getMod().playerEquals(this.controller.getLastPlayer());
    if ((differentWorld) || (differentPlayer)) {
      this.controller.setLastWorld(this.controller.getMod().getCurrentWorld());
      this.controller.setLastPlayer(this.controller.getMod().getCurrentPlayer());
      this.controller.setLastEntity(this.controller.getMod().getNewEntity());

      this.controller.getLastWorld().spawnEntity(this.controller.getLastEntity());
      this.controller.getLastEntity().teleport(this.controller.getLastPlayer());

      if (!this.controller.hasGameStarted()) {
        this.controller.setGameStarted(true);
        InitialGameTickEvent initial_event = new InitialGameTickEvent();
        EventManager.callEvent(initial_event);
        CUIDebug.getInstance().debug("Initial tick event called");
      }
    }
    else if (this.entityUpdateCount > 500) {
      this.entityUpdateCount = 0;
      if (this.controller.getLastEntity() != null) {
        this.controller.getLastEntity().teleport(this.controller.getLastPlayer());
        CUIDebug.getInstance().debug("Teleporting entity to player");
      }
    } else {
      this.entityUpdateCount += 1;
    }
  }
}