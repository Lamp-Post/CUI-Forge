package cui.render.points;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.shapes.Render3DBox;
import cui.util.vector.Vector2;

public class PointRectangle
{
  private Vector2 point;
  private LineColor color = LineColor.POLYPOINT;

  public PointRectangle(Vector2 point) {
    this.point = point;
  }

  public PointRectangle(int x, int z) {
    this.point = new Vector2(x, z);
  }

  public void render(IRenderer renderer, int min, int max) {
    float off = 0.03F;
    Vector2 minVec = new Vector2(off, off);
    Vector2 maxVec = new Vector2(off + 1.0F, off + 1.0F);

    new Render3DBox(this.color, this.point.subtract(minVec).toVector3(min - off), this.point.add(maxVec).toVector3(max + 1 + off)).render(renderer);
  }

  public Vector2 getPoint() {
    return this.point;
  }

  public void setPoint(Vector2 point) {
    this.point = point;
  }

  public LineColor getColor() {
    return this.color;
  }

  public void setColor(LineColor color) {
    this.color = color;
  }
}