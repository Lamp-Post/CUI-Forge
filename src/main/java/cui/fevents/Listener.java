package cui.fevents;

public abstract interface Listener<TEvent extends Event<TEvent>>
{
  public abstract void onEvent(TEvent paramTEvent);
}