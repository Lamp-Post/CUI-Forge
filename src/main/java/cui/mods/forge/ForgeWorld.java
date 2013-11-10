package cui.mods.forge;

import net.minecraft.client.multiplayer.WorldClient;
import cui.IWorld;
import cui.mods.notch.NotchWorld;

public class ForgeWorld extends NotchWorld
  implements IWorld
{
  public ForgeWorld(WorldClient handle)
  {
    super(handle);
  }
}