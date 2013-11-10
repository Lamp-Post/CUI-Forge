package cui.mods.forge;

import net.minecraft.entity.Entity;
import cui.IEntity;
import cui.mods.notch.NotchEntity;

public class ForgeEntity extends NotchEntity
  implements IEntity
{
  public ForgeEntity(Entity handle)
  {
    super(handle);
  }
}