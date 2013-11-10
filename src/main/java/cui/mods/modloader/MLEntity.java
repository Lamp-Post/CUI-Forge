package cui.mods.modloader;

import net.minecraft.entity.Entity;
import cui.IEntity;
import cui.mods.notch.NotchEntity;

public class MLEntity extends NotchEntity
  implements IEntity
{
  public MLEntity(Entity handle)
  {
    super(handle);
  }
}