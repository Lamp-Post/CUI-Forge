package cui.mods.forge;

import net.minecraft.client.entity.EntityPlayerSP;
import cui.IPlayer;
import cui.mods.notch.NotchPlayer;

public class ForgePlayer extends NotchPlayer
  implements IPlayer
{
  public ForgePlayer(EntityPlayerSP handle)
  {
    super(handle);
  }
}