package cui.render.we.region;

import cui.CUIBase;
import cui.render.LineColor;
import cui.render.points.PointCube;
import cui.render.shapes.Render3DBox;
import cui.render.shapes.Render3DGrid;
import cui.util.vector.Vector3;
import cui.util.vector.Vector3m;

public class CuboidRegion extends BaseRegion
{
  private PointCube firstPoint;
  private PointCube secondPoint;

  public CuboidRegion(CUIBase controller)
  {
    super(controller);
  }

  public void render()
  {
    if ((this.firstPoint != null) && (this.secondPoint != null)) {
      this.firstPoint.render(this.renderer);
      this.secondPoint.render(this.renderer);

      Vector3[] bounds = calcBounds();
      new Render3DBox(LineColor.CUBOIDBOX, bounds[0], bounds[1]).render(this.renderer);
      new Render3DGrid(LineColor.CUBOIDGRID, bounds[0], bounds[1]).render(this.renderer);
    }
    else if (this.firstPoint != null) {
      this.firstPoint.render(this.renderer);
    } else if (this.secondPoint != null) {
      this.secondPoint.render(this.renderer);
    }
  }

  public void setCuboidPoint(int id, int x, int y, int z)
  {
    if (id == 0) {
      this.firstPoint = new PointCube(x, y, z);
      this.firstPoint.setColor(LineColor.CUBOIDPOINT1);
    } else if (id == 1) {
      this.secondPoint = new PointCube(x, y, z);
      this.secondPoint.setColor(LineColor.CUBOIDPOINT2);
    }
  }

  private Vector3m[] calcBounds()
  {
    float off = 0.02F;
    float off1 = 1.0F + off;

    Vector3m[] out = new Vector3m[2];
    out[0] = new Vector3m(Double.valueOf(1.7976931348623157E+308D), Double.valueOf(1.7976931348623157E+308D), Double.valueOf(1.7976931348623157E+308D));
    out[1] = new Vector3m(Double.valueOf(-1.7976931348623157E+308D), Double.valueOf(-1.7976931348623157E+308D), Double.valueOf(-1.7976931348623157E+308D));

    for (PointCube point : new PointCube[] { this.firstPoint, this.secondPoint }) {
      if (point.getPoint().getX() + off1 > out[1].getX()) {
        out[1].setX(point.getPoint().getX() + off1);
      }

      if (point.getPoint().getX() - off < out[0].getX()) {
        out[0].setX(point.getPoint().getX() - off);
      }

      if (point.getPoint().getY() + off1 > out[1].getY()) {
        out[1].setY(point.getPoint().getY() + off1);
      }

      if (point.getPoint().getY() - off < out[0].getY()) {
        out[0].setY(point.getPoint().getY() - off);
      }

      if (point.getPoint().getZ() + off1 > out[1].getZ()) {
        out[1].setZ(point.getPoint().getZ() + off1);
      }

      if (point.getPoint().getZ() - off < out[0].getZ()) {
        out[0].setZ(point.getPoint().getZ() - off);
      }
    }

    return out;
  }

  public RegionType getType()
  {
    return RegionType.CUBOID;
  }
}