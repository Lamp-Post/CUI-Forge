package cui.render.we.region;

import cui.CUIBase;
import cui.render.LineColor;
import cui.render.points.PointCube;
import cui.render.shapes.RenderCylinderBox;
import cui.render.shapes.RenderCylinderCircles;
import cui.render.shapes.RenderCylinderGrid;
import cui.util.vector.Vector3;

public class CylinderRegion extends BaseRegion
{
  private PointCube center;
  private double radX = 0.0D;
  private double radZ = 0.0D;
  private int minY = 0;
  private int maxY = 0;

  public CylinderRegion(CUIBase controller) {
    super(controller);
  }

  public void render()
  {
    if (this.center != null) {
      this.center.render(this.renderer);

      int tMin = this.minY;
      int tMax = this.maxY;

      if ((this.minY == 0) || (this.maxY == 0)) {
        tMin = (int)this.center.getPoint().getY();
        tMax = (int)this.center.getPoint().getY();
      }

      new RenderCylinderCircles(LineColor.CYLINDERGRID, this.center, this.radX, this.radZ, tMin, tMax).render(this.renderer);
      new RenderCylinderGrid(LineColor.CYLINDERGRID, this.center, this.radX, this.radZ, tMin, tMax).render(this.renderer);
      new RenderCylinderBox(LineColor.CYLINDERBOX, this.center, this.radX, this.radZ, tMin, tMax).render(this.renderer);
    }
  }

  public void setCylinderCenter(int x, int y, int z)
  {
    this.center = new PointCube(x, y, z);
    this.center.setColor(LineColor.CYLINDERCENTER);
  }

  public void setCylinderRadius(double x, double z)
  {
    this.radX = x;
    this.radZ = z;
  }

  public void setMinMax(int min, int max)
  {
    this.minY = min;
    this.maxY = max;
  }

  public RegionType getType()
  {
    return RegionType.CYLINDER;
  }
}