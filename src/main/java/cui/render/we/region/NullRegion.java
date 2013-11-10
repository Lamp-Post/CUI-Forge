package cui.render.we.region;

import cui.CUIBase;

public class NullRegion extends BaseRegion
{
  public NullRegion(CUIBase controller)
  {
    super(controller);
  }

  public void render()
  {
  }

  public RegionType getType()
  {
    return RegionType.NULL;
  }
}