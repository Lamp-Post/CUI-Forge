package cui.mods.modloader;

import net.minecraft.client.entity.EntityPlayerSP;
import cui.IPlayer;
import cui.mods.notch.NotchPlayer;

public class MLPlayer extends NotchPlayer
  implements IPlayer
{
  public MLPlayer(EntityPlayerSP handle)
  {
    super(handle);
  }
}