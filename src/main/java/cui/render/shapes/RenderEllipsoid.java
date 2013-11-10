package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.render.points.PointCube;
import cui.util.vector.Vector3;

public class RenderEllipsoid
{
  private LineColor color;
  private PointCube center;
  private Vector3 radii;
  private static final double twoPi = 6.283185307179586D;
  private double centerX;
  private double centerY;
  private double centerZ;

  public RenderEllipsoid(LineColor color, PointCube center, Vector3 radii)
  {
    this.color = color;
    this.center = center;
    this.radii = radii;
    this.centerX = (center.getPoint().getX() + 0.5D);
    this.centerY = (center.getPoint().getY() + 0.5D);
    this.centerZ = (center.getPoint().getZ() + 0.5D);
  }

  public void render(IRenderer renderer) {
    for (LineInfo tempColor : this.color.getColors()) {
      tempColor.prepareRender();
      drawXZPlane(renderer, tempColor);
      drawYZPlane(renderer, tempColor);
      drawXYPlane(renderer, tempColor);
    }
  }

  private void drawXZPlane(IRenderer renderer, LineInfo color) {
    int yRad = (int)Math.floor(this.radii.getY());
    for (int yBlock = -yRad; yBlock < yRad; yBlock++) {
      renderer.startDrawing(2);
      color.prepareColor();

      for (int i = 0; i <= 40; i++) {
        double tempTheta = i * 6.283185307179586D / 40.0D;
        double tempX = this.radii.getX() * Math.cos(tempTheta) * Math.cos(Math.asin(yBlock / this.radii.getY()));
        double tempZ = this.radii.getZ() * Math.sin(tempTheta) * Math.cos(Math.asin(yBlock / this.radii.getY()));

        renderer.addVertex(this.centerX + tempX, this.centerY + yBlock, this.centerZ + tempZ);
      }
      renderer.finishDrawing();
    }

    renderer.startDrawing(2);
    color.prepareColor();

    for (int i = 0; i <= 40; i++) {
      double tempTheta = i * 6.283185307179586D / 40.0D;
      double tempX = this.radii.getX() * Math.cos(tempTheta);
      double tempZ = this.radii.getZ() * Math.sin(tempTheta);

      renderer.addVertex(this.centerX + tempX, this.centerY, this.centerZ + tempZ);
    }
    renderer.finishDrawing();
  }

  private void drawYZPlane(IRenderer renderer, LineInfo color) {
    int xRad = (int)Math.floor(this.radii.getX());
    for (int xBlock = -xRad; xBlock < xRad; xBlock++) {
      renderer.startDrawing(2);
      color.prepareColor();

      for (int i = 0; i <= 40; i++) {
        double tempTheta = i * 6.283185307179586D / 40.0D;
        double tempY = this.radii.getY() * Math.cos(tempTheta) * Math.sin(Math.acos(xBlock / this.radii.getX()));
        double tempZ = this.radii.getZ() * Math.sin(tempTheta) * Math.sin(Math.acos(xBlock / this.radii.getX()));

        renderer.addVertex(this.centerX + xBlock, this.centerY + tempY, this.centerZ + tempZ);
      }
      renderer.finishDrawing();
    }

    renderer.startDrawing(2);
    color.prepareColor();

    for (int i = 0; i <= 40; i++) {
      double tempTheta = i * 6.283185307179586D / 40.0D;
      double tempY = this.radii.getY() * Math.cos(tempTheta);
      double tempZ = this.radii.getZ() * Math.sin(tempTheta);

      renderer.addVertex(this.centerX, this.centerY + tempY, this.centerZ + tempZ);
    }
    renderer.finishDrawing();
  }

  private void drawXYPlane(IRenderer renderer, LineInfo color) {
    int zRad = (int)Math.floor(this.radii.getZ());
    for (int zBlock = -zRad; zBlock < zRad; zBlock++) {
      renderer.startDrawing(2);
      color.prepareColor();

      for (int i = 0; i <= 40; i++) {
        double tempTheta = i * 6.283185307179586D / 40.0D;
        double tempX = this.radii.getX() * Math.sin(tempTheta) * Math.sin(Math.acos(zBlock / this.radii.getZ()));
        double tempY = this.radii.getY() * Math.cos(tempTheta) * Math.sin(Math.acos(zBlock / this.radii.getZ()));

        renderer.addVertex(this.centerX + tempX, this.centerY + tempY, this.centerZ + zBlock);
      }
      renderer.finishDrawing();
    }

    renderer.startDrawing(2);
    color.prepareColor();

    for (int i = 0; i <= 40; i++) {
      double tempTheta = i * 6.283185307179586D / 40.0D;
      double tempX = this.radii.getX() * Math.cos(tempTheta);
      double tempY = this.radii.getY() * Math.sin(tempTheta);

      renderer.addVertex(this.centerX + tempX, this.centerY + tempY, this.centerZ);
    }
    renderer.finishDrawing();
  }
}