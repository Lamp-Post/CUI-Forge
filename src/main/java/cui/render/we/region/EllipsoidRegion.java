package cui.render.we.region;

import cui.CUIBase;
import cui.render.LineColor;
import cui.render.points.PointCube;
import cui.render.shapes.RenderEllipsoid;
import cui.util.vector.Vector3;

public class EllipsoidRegion extends BaseRegion
{
  private PointCube center;
  private Vector3 radii;

  public EllipsoidRegion(CUIBase controller)
  {
    super(controller);
  }

  public void render()
  {
    if ((this.center != null) && (this.radii != null)) {
      this.center.render(this.renderer);

      new RenderEllipsoid(LineColor.ELLIPSOIDGRID, this.center, this.radii).render(this.renderer);
    }
    else if (this.center != null) {
      this.center.render(this.renderer);
    }
  }

  public void setEllipsoidCenter(int x, int y, int z)
  {
    this.center = new PointCube(x, y, z);
    this.center.setColor(LineColor.ELLIPSOIDCENTER);
  }

  public void setEllipsoidRadii(double x, double y, double z)
  {
    this.radii = new Vector3(Double.valueOf(x), Double.valueOf(y), Double.valueOf(z));
  }

  public RegionType getType()
  {
    return RegionType.ELLIPSOID;
  }
}