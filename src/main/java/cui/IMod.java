package cui;

import java.io.File;

public abstract interface IMod
{
  public abstract IPlayer getCurrentPlayer();

  public abstract IWorld getCurrentWorld();

  public abstract boolean playerEquals(IPlayer paramIPlayer);

  public abstract boolean worldEquals(IWorld paramIWorld);

  public abstract IRenderer getRenderer();

  public abstract boolean isMultiplayer();

  public abstract void sendPacket(String paramString, int paramInt, byte[] paramArrayOfByte);

  public abstract File getModFolder();

  public abstract IEntity getNewEntity();
}