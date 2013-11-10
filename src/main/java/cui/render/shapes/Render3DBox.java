package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.util.vector.Vector3;

public class Render3DBox
{
  private LineColor color;
  private Vector3 first;
  private Vector3 second;

  public Render3DBox(LineColor color, Vector3 first, Vector3 second)
  {
    this.color = color;
    this.first = first;
    this.second = second;
  }

  public void render(IRenderer renderer) {
    double x1 = this.first.getX();
    double y1 = this.first.getY();
    double z1 = this.first.getZ();
    double x2 = this.second.getX();
    double y2 = this.second.getY();
    double z2 = this.second.getZ();

    for (LineInfo tempColor : this.color.getColors()) {
      tempColor.prepareRender();

      renderer.startDrawing(2);
      tempColor.prepareColor();
      renderer.addVertex(x1, y1, z1);
      renderer.addVertex(x2, y1, z1);
      renderer.addVertex(x2, y1, z2);
      renderer.addVertex(x1, y1, z2);
      renderer.finishDrawing();

      renderer.startDrawing(2);
      tempColor.prepareColor();
      renderer.addVertex(x1, y2, z1);
      renderer.addVertex(x2, y2, z1);
      renderer.addVertex(x2, y2, z2);
      renderer.addVertex(x1, y2, z2);
      renderer.finishDrawing();

      renderer.startDrawing(1);
      tempColor.prepareColor();

      renderer.addVertex(x1, y1, z1);
      renderer.addVertex(x1, y2, z1);

      renderer.addVertex(x2, y1, z1);
      renderer.addVertex(x2, y2, z1);

      renderer.addVertex(x2, y1, z2);
      renderer.addVertex(x2, y2, z2);

      renderer.addVertex(x1, y1, z2);
      renderer.addVertex(x1, y2, z2);

      renderer.finishDrawing();
    }
  }
}