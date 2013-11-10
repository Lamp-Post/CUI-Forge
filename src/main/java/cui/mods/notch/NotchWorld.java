package cui.mods.notch;

import net.minecraft.client.multiplayer.WorldClient;
import cui.CUIDebug;
import cui.IEntity;
import cui.IWorld;

public class NotchWorld
  implements IWorld
{
  private WorldClient handle;

  public NotchWorld(WorldClient handle)
  {
    this.handle = handle;
  }

  public void spawnEntity(IEntity entity) {
    if ((entity instanceof NotchEntity)) {
      this.handle.spawnEntityInWorld(((NotchEntity)entity).getHandle());
      CUIDebug.getInstance().debug("Entity spawned");
    }
  }

  public WorldClient getHandle() {
    return this.handle;
  }
}