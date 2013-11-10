package cui.render.we.region;

import cui.CUIBase;
import cui.IMod;
import cui.IRenderer;

public abstract class BaseRegion
{
  protected CUIBase controller;
  protected IRenderer renderer;

  public BaseRegion(CUIBase controller)
  {
    this.controller = controller;
    this.renderer = controller.getMod().getRenderer();
  }

  public abstract void render();

  public void setCuboidPoint(int id, int x, int y, int z)
  {
  }

  public void setPolygonPoint(int id, int x, int z)
  {
  }

  public void setEllipsoidCenter(int x, int y, int z)
  {
  }

  public void setEllipsoidRadii(double x, double y, double z)
  {
  }

  public void setMinMax(int min, int max)
  {
  }

  public void setCylinderCenter(int x, int y, int z)
  {
  }

  public void setCylinderRadius(double x, double z)
  {
  }

  public abstract RegionType getType();
}