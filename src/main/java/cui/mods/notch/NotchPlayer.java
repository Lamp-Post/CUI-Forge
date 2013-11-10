package cui.mods.notch;

import net.minecraft.client.entity.EntityPlayerSP;
import cui.IPlayer;

public class NotchPlayer extends NotchEntity
  implements IPlayer
{
  public NotchPlayer(EntityPlayerSP handle)
  {
    super(handle);
  }

  public void showChatMessage(String message) {
    getHandle().addChatMessage(message);
  }

  public EntityPlayerSP getHandle() {
    return (EntityPlayerSP)super.getHandle();
  }
}