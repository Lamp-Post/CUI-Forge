package cui.fevents;

public abstract interface Cancellable
{
  public abstract void setCancelled(boolean paramBoolean);

  public abstract boolean isCancelled();
}