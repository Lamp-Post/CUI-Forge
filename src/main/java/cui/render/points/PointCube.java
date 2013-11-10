package cui.render.points;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.shapes.Render3DBox;
import cui.util.vector.Vector3;

public class PointCube
{
  private Vector3 point;
  private LineColor color = LineColor.CUBOIDPOINT1;

  public PointCube(Vector3 point) {
    this.point = point;
  }

  public PointCube(int x, int y, int z) {
    this.point = new Vector3(x, y, z);
  }

  public PointCube(double x, double y, double z) {
    this.point = new Vector3(Double.valueOf(x), Double.valueOf(y), Double.valueOf(z));
  }

  public void render(IRenderer renderer) {
    double off = 0.02999999932944775D;
    Vector3 minVec = new Vector3(Double.valueOf(off), Double.valueOf(off), Double.valueOf(off));
    Vector3 maxVec = new Vector3(Double.valueOf(off + 1.0D), Double.valueOf(off + 1.0D), Double.valueOf(off + 1.0D));

    new Render3DBox(this.color, this.point.subtract(minVec), this.point.add(maxVec)).render(renderer);
  }

  public Vector3 getPoint() {
    return this.point;
  }

  public void setPoint(Vector3 point) {
    this.point = point;
  }

  public LineColor getColor() {
    return this.color;
  }

  public void setColor(LineColor color) {
    this.color = color;
  }
}