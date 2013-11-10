package cui.render.we.region;

import cui.CUIBase;
import cui.render.LineColor;
import cui.render.points.PointRectangle;
import cui.render.shapes.Render2DBox;
import cui.render.shapes.Render2DGrid;
import java.util.ArrayList;
import java.util.List;

public class PolygonRegion extends BaseRegion
{
  private List<PointRectangle> points = new ArrayList();
  private int min;
  private int max;

  public PolygonRegion(CUIBase controller)
  {
    super(controller);
  }

  public void render()
  {
    if (this.points == null) {
      return;
    }

    for (PointRectangle point : this.points) {
      point.render(this.renderer, this.min, this.max);
    }

    new Render2DBox(LineColor.POLYBOX, this.points, this.min, this.max).render(this.renderer);
    new Render2DGrid(LineColor.POLYGRID, this.points, this.min, this.max).render(this.renderer);
  }

  public void setMinMax(int min, int max)
  {
    this.min = min;
    this.max = max;
  }

  public void setPolygonPoint(int id, int x, int z)
  {
    PointRectangle point = new PointRectangle(x, z);
    point.setColor(LineColor.POLYPOINT);

    if (id < this.points.size()) {
      this.points.set(id, point);
    } else {
      for (int i = 0; i < id - this.points.size(); i++) {
        this.points.add(null);
      }
      this.points.add(point);
    }
  }

  public RegionType getType()
  {
    return RegionType.POLYGON;
  }
}