package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.render.points.PointRectangle;
import cui.util.vector.Vector2;
import java.util.List;

public class Render2DBox
{
  private LineColor color;
  private List<PointRectangle> points;
  private int min;
  private int max;

  public Render2DBox(LineColor color, List<PointRectangle> points, int min, int max)
  {
    this.color = color;
    this.points = points;
    this.min = min;
    this.max = max;
  }

  public void render(IRenderer renderer) {
    double off = 0.03D;
    for (LineInfo tempColor : this.color.getColors()) {
      tempColor.prepareRender();

      renderer.startDrawing(1);
      tempColor.prepareColor();

      for (PointRectangle point : this.points) {
        if (point != null) {
          renderer.addVertex(point.getPoint().getX() + 0.5D, this.min + off, point.getPoint().getY() + 0.5D);
          renderer.addVertex(point.getPoint().getX() + 0.5D, this.max + 1 + off, point.getPoint().getY() + 0.5D);
        }
      }
      renderer.finishDrawing();
    }
  }
}