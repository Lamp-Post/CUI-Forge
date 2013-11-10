package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.render.points.PointCube;
import cui.util.vector.Vector3;

public class RenderCylinderGrid
{
  private LineColor color;
  private double radX = 0.0D;
  private double radZ = 0.0D;
  private int minY;
  private int maxY;
  private double centerX;
  private double centerZ;

  public RenderCylinderGrid(LineColor color, PointCube center, double radX, double radZ, int minY, int maxY)
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

      int tmaxY = this.maxY + 1;
      int tminY = this.minY;
      int posRadiusX = (int)Math.ceil(this.radX);
      int negRadiusX = (int)-Math.ceil(this.radX);
      int posRadiusZ = (int)Math.ceil(this.radZ);
      int negRadiusZ = (int)-Math.ceil(this.radZ);

      for (double tempX = negRadiusX; tempX <= posRadiusX; tempX += 1.0D) {
        double tempZ = this.radZ * Math.cos(Math.asin(tempX / this.radX));
        renderer.startDrawing(2);
        tempColor.prepareColor();

        renderer.addVertex(this.centerX + tempX, tmaxY, this.centerZ + tempZ);
        renderer.addVertex(this.centerX + tempX, tmaxY, this.centerZ - tempZ);
        renderer.addVertex(this.centerX + tempX, tminY, this.centerZ - tempZ);
        renderer.addVertex(this.centerX + tempX, tminY, this.centerZ + tempZ);

        renderer.finishDrawing();
      }

      for (double tempZ = negRadiusZ; tempZ <= posRadiusZ; tempZ += 1.0D) {
        double tempX = this.radX * Math.sin(Math.acos(tempZ / this.radZ));
        renderer.startDrawing(2);
        tempColor.prepareColor();

        renderer.addVertex(this.centerX + tempX, tmaxY, this.centerZ + tempZ);
        renderer.addVertex(this.centerX - tempX, tmaxY, this.centerZ + tempZ);
        renderer.addVertex(this.centerX - tempX, tminY, this.centerZ + tempZ);
        renderer.addVertex(this.centerX + tempX, tminY, this.centerZ + tempZ);

        renderer.finishDrawing();
      }
    }
  }
}