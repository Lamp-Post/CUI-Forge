package cui.mods.notch;

import net.minecraft.entity.Entity;
import cui.IEntity;

public class NotchEntity
  implements IEntity
{
  private Entity handle;

  public NotchEntity(Entity handle)
  {
    this.handle = handle;
  }

  public double getX() {
    return this.handle.posX;
  }

  public double getY() {
    return this.handle.posY;
  }

  public double getZ() {
    return this.handle.posZ;
  }

  public double getXGuess(double tick) {
    return this.handle.lastTickPosX + (getX() - this.handle.lastTickPosX) * tick;
  }

  public double getYGuess(double tick) {
    return this.handle.lastTickPosY + (getY() - this.handle.lastTickPosY) * tick;
  }

  public double getZGuess(double tick) {
    return this.handle.lastTickPosZ + (getZ() - this.handle.lastTickPosZ) * tick;
  }

  public void teleport(double x, double y, double z) {
    this.handle.moveEntity(x, y, z);
  }

  public void teleport(IEntity entity) {
    this.handle.moveEntity(entity.getX(), entity.getY(), entity.getZ());
  }

  public Entity getHandle() {
    return this.handle;
  }
}