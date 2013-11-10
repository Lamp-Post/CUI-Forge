package cui.mods.modloader;

import net.minecraft.client.multiplayer.WorldClient;
import cui.IWorld;
import cui.mods.notch.NotchWorld;

public class MLWorld extends NotchWorld
  implements IWorld
{
  public MLWorld(WorldClient handle)
  {
    super(handle);
  }
}