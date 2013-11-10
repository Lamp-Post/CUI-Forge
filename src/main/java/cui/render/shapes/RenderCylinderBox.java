package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.render.points.PointCube;
import cui.util.vector.Vector3;

public class RenderCylinderBox
{
  private LineColor color;
  private double radX = 0.0D;
  private double radZ = 0.0D;
  private int minY;
  private int maxY;
  private double centerX;
  private double centerZ;

  public RenderCylinderBox(LineColor color, PointCube center, double radX, double radZ, int minY, int maxY)
  {
    this.color = color;
    this.radX = radX;
    this.radZ = radZ;
    this.minY = minY;
    this.maxY = maxY;
    this.centerX = (center.getPoint().getX() + 0.5D);
    this.centerZ = (center.getPoint().getZ() + 0.5D);
  }

  public void render(IRenderer renderer) {
    for (LineInfo tempColor : this.color.getColors()) {
      tempColor.prepareRender();

      double twoPi = 6.283185307179586D;
      for (int yBlock : new int[] { this.minY, this.maxY + 1 }) {
        renderer.startDrawing(2);
        tempColor.prepareColor();

        for (int i = 0; i <= 75; i++) {
          double tempTheta = i * twoPi / 75.0D;
          double tempX = this.radX * Math.cos(tempTheta);
          double tempZ = this.radZ * Math.sin(tempTheta);

          renderer.addVertex(this.centerX + tempX, yBlock, this.centerZ + tempZ);
        }
        renderer.finishDrawing();
      }
    }
  }
}