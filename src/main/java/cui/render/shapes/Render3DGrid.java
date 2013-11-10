package cui.render.shapes;

import cui.IRenderer;
import cui.render.LineColor;
import cui.render.LineInfo;
import cui.util.vector.Vector3;

public class Render3DGrid
{
  private LineColor color;
  private Vector3 first;
  private Vector3 second;

  public Render3DGrid(LineColor color, Vector3 first, Vector3 second)
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

      renderer.startDrawing(1);
      tempColor.prepareColor();

      double offsetSize = 1.0D;

      double z = z2;
      double y = y1;
      int msize = 150;
      if (y2 - y / offsetSize < msize) {
        for (double yoff = 0.0D; yoff + y <= y2; yoff += offsetSize) {
          renderer.addVertex(x1, y + yoff, z);
          renderer.addVertex(x2, y + yoff, z);
        }

      }

      z = z1;
      if (y2 - y / offsetSize < msize) {
        for (double yoff = 0.0D; yoff + y <= y2; yoff += offsetSize) {
          renderer.addVertex(x1, y + yoff, z);
          renderer.addVertex(x2, y + yoff, z);
        }

      }

      double x = x1;
      if (y2 - y / offsetSize < msize) {
        for (double yoff = 0.0D; yoff + y <= y2; yoff += offsetSize) {
          renderer.addVertex(x, y + yoff, z1);
          renderer.addVertex(x, y + yoff, z2);
        }

      }

      x = x2;
      if (y2 - y / offsetSize < msize) {
        for (double yoff = 0.0D; yoff + y <= y2; yoff += offsetSize) {
          renderer.addVertex(x, y + yoff, z1);
          renderer.addVertex(x, y + yoff, z2);
        }

      }

      x = x1;
      z = z1;
      if (x2 - x / offsetSize < msize) {
        for (double xoff = 0.0D; xoff + x <= x2; xoff += offsetSize) {
          renderer.addVertex(x + xoff, y1, z);
          renderer.addVertex(x + xoff, y2, z);
        }
      }

      z = z2;
      if (x2 - x / offsetSize < msize) {
        for (double xoff = 0.0D; xoff + x <= x2; xoff += offsetSize) {
          renderer.addVertex(x + xoff, y1, z);
          renderer.addVertex(x + xoff, y2, z);
        }
      }

      y = y2;
      if (x2 - x / offsetSize < msize) {
        for (double xoff = 0.0D; xoff + x <= x2; xoff += offsetSize) {
          renderer.addVertex(x + xoff, y, z1);
          renderer.addVertex(x + xoff, y, z2);
        }
      }

      y = y1;
      if (x2 - x / offsetSize < msize) {
        for (double xoff = 0.0D; xoff + x <= x2; xoff += offsetSize) {
          renderer.addVertex(x + xoff, y, z1);
          renderer.addVertex(x + xoff, y, z2);
        }

      }

      z = z1;
      y = y1;
      if (z2 - z / offsetSize < msize) {
        for (double zoff = 0.0D; zoff + z <= z2; zoff += offsetSize) {
          renderer.addVertex(x1, y, z + zoff);
          renderer.addVertex(x2, y, z + zoff);
        }
      }

      y = y2;
      if (z2 - z / offsetSize < msize) {
        for (double zoff = 0.0D; zoff + z <= z2; zoff += offsetSize) {
          renderer.addVertex(x1, y, z + zoff);
          renderer.addVertex(x2, y, z + zoff);
        }
      }

      x = x2;
      if (z2 - z / offsetSize < msize) {
        for (double zoff = 0.0D; zoff + z <= z2; zoff += offsetSize) {
          renderer.addVertex(x, y1, z + zoff);
          renderer.addVertex(x, y2, z + zoff);
        }
      }

      x = x1;
      if (z2 - z / offsetSize < msize) {
        for (double zoff = 0.0D; zoff + z <= z2; zoff += offsetSize) {
          renderer.addVertex(x, y1, z + zoff);
          renderer.addVertex(x, y2, z + zoff);
        }
      }

      renderer.finishDrawing();
    }
  }
}