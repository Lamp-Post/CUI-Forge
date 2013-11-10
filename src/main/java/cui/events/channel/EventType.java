package cui.events.channel;

public enum EventType
{
  WE_SELECTION(1), 
  WE_POINT(5, 6), 
  WE_POINT2D(4, 5), 
  WE_ELLIPSOID(4), 
  WE_CYLINDER(5), 
  WE_MINMAX(2), 
  WE_UPDATE(1), 
  LB_POINTS(1);

  private final int min;
  private final int max;

  private EventType(int min, int max) { this.min = min;
    this.max = max; }

  private EventType(int paramCount)
  {
    this.min = paramCount;
    this.max = paramCount;
  }

  public int getMaxParameters() {
    return this.max;
  }

  public int getMinParameters() {
    return this.min;
  }
}